# Version Blacklist - 版本黑名单

## 说明

本项目的版本黑名单，列出了本项目的版本黑名单，请注意避免使用这些版本。

列入黑名单的版本，可能是因为以下原因：

- 该版本存在严重的 Bug，可能会导致核心功能无法正常使用。
- 该版本存在严重的 Bug，可能会导致数据丢失、数据错误等严重后果。

## 设计目的

该黑名单旨在帮助开发人员快速识别各版本中已知的问题点，明确受影响的模块与典型触发场景，从而做出基于事实的用/避决策与迁移安排，
而不是简单地“一刀切”禁用某一版本。

## 如何使用

黑名单不是绝对禁用清单。遇到被列入黑名单的版本时，应当基于“问题原因—是否命中—影响面”的原则进行研判：

- 是否直接或间接使用了被提及的模块/类。
- 业务中是否存在与“原因”描述相符的顺序敏感或易触发场景。
- 是否已出现与问题相符的日志告警、数据核对失败或线上异常案例。

若未使用黑名单中提及的问题代码部分，或经过验证不命中触发条件，则仍然可以继续使用该版本；若命中或存在较大不确定性，
建议参考对应编号“详细原因”章节末尾的迁移建议执行升级或规避方案，并充分做回归与灰度验证。

请注意：迁移建议仅针对对应编号的问题，所推荐版本可能仍存在其他风险。请继续核查该推荐版本是否仍在黑名单中；
若仍在黑名单中，请持续研判并迭代升级，直至风险可接受或升级至未被列入黑名单的版本。

## 版本黑名单

| 编号                                         | 大版本 | 起始版本 | 结束版本 | 原因                                                                        |
|----------------------------------------------|--------|----------|----------|-----------------------------------------------------------------------------|
| [BLACKLIST-20260812.1](#BLACKLIST-202608121) | 1.0.x  | 1.0.0.a  | 1.0.4.a  | 多个来源服务的同名数据表元数据被 Hibernate 合并，实体及外键可能映射到错误表 |
| [BLACKLIST-20260806.2](#BLACKLIST-202608062) | 1.0.x  | 1.0.0.a  | 1.0.1.a  | Dubbo 连接配置键命名与项目统一约定不一致，外部配置可能无法生效              |
| [BLACKLIST-20260806.1](#BLACKLIST-202608061) | 1.0.x  | 1.0.0.a  | 1.0.1.a  | `TablePrefixResolver` 包前缀映射数据错误，buddy 服务数据表名可能未正确隔离  |

## 详细原因

### BLACKLIST-20260812.1

原因：聚合节点通过 `EntityNameMappingRules` 生成动态 ORM XML，为不同来源服务的实体设置隔离后的 JPA 实体名称；
但修复前未在该阶段覆写实体主表名称，而是由 `PackagePrefixTableNameIntegrator`
在 Hibernate 完成实体与数据表元数据绑定后，再依据实体包名为数据表追加来源服务前缀。
当多个来源服务的实体声明了相同的原始表名时，Hibernate 会先将这些实体绑定到同一个 `Table` 元数据对象，
随后 Integrator 只能反复改写该共享对象的名称，无法再恢复各来源服务之间的数据表隔离。
已验证 buddy、notify、rbacds 服务的 `HibernateUser` 均声明原始表名 `tbl_user`，
错误版本下三个实体最终全部映射到 `tbl_rbacds_user`；buddy 与 notify 服务中引用用户表的外键也随之错误指向
`tbl_rbacds_user`，可能造成跨服务错误读写或数据库结构异常。

- 受影响模块/类：
  - `com.dwarfeng.essentials.sdk.hibernate.EntityNameMappingRules`
  - `com.dwarfeng.essentials.sdk.hibernate.EntityNameMetadataSourcesFactoryBean`
  - `com.dwarfeng.essentials.sdk.hibernate.PackagePrefixTableNameIntegrator`
  - `com.dwarfeng.essentials.sdk.hibernate.TablePrefixResolver`
  - `com.dwarfeng.buddy.impl.bean.entity.HibernateUser`
  - `com.dwarfeng.notify.impl.bean.entity.HibernateUser`
  - `com.dwarfeng.rbacds.impl.bean.entity.HibernateUser`
- 典型触发条件：
  - 使用 1.0.0.a 至 1.0.4.a 版本启动聚合节点并构建 Hibernate SessionFactory；
  - 两个或以上来源服务的实体被装配到同一个 SessionFactory；
  - 不同来源服务中存在声明了相同原始表名的实体，如 buddy、notify、rbacds 服务的 `tbl_user`。
- 典型症状：
  - 某来源服务的实体实际访问另一个来源服务的数据表，查询结果异常或数据被写入错误表；
  - 实体关联生成的外键指向错误的服务表，导致关联查询、数据写入或约束检查失败；
  - Hibernate 建表或表结构校验时出现字段、索引、唯一键、外键不匹配等异常；
  - 多个实体的字段集合被合并到同一表元数据后，可能产生未知列、缺失列等 SQL 异常，或静默破坏数据隔离。
- 影响范围：
  - 所有将多个来源服务实体装配到同一 Hibernate SessionFactory 的聚合节点。
  - 所有跨来源服务同名的原始数据表均可能受影响，不限于已确认的 buddy、notify、rbacds 用户表。

迁移建议：升级至 1.1.0.a 及以上版本。

### BLACKLIST-20260806.2

原因：`dwarfeng-essentials-node-all-he` 模块的 classpath 资源 `dubbo/connection.properties`
将 Dubbo 连接配置键命名为 `dwarfeng.essentials.dubbo.*`，缺少项目统一命名空间所要求的 `com.` 前缀。
`spring/application-context-dubbo.xml` 与 `properties-mapping/mapping-*.properties` 在修复前同样引用该错误前缀。
项目其它配置域（curator、database、redis、datamark、telqos 等）均使用 `com.dwarfeng.essentials.*` 前缀，
外部 `conf/dubbo/connection.properties` 也按此约定配置；
错误版本下外部配置键与 classpath 占位符键名不同，
导致外部配置的注册中心地址、协议端口/host、provider/consumer group 等无法覆盖 classpath 默认值（如 `your-host-here`），
Dubbo 注册与发现可能失败。

- 受影响模块/类：
  - `dwarfeng-essentials-node-all-he/src/main/resources/dubbo/connection.properties`
  - `dwarfeng-essentials-node-all-he/src/main/resources/spring/application-context-dubbo.xml`
  - `dwarfeng-essentials-node-all-he/src/main/resources/properties-mapping/mapping-acckeeper.properties`
  - `dwarfeng-essentials-node-all-he/src/main/resources/properties-mapping/mapping-buddy.properties`
  - `dwarfeng-essentials-node-all-he/src/main/resources/properties-mapping/mapping-notify.properties`
  - `dwarfeng-essentials-node-all-he/src/main/resources/properties-mapping/mapping-rbacds.properties`
  - `dwarfeng-essentials-node-all-he/src/main/resources/properties-mapping/mapping-settingrepo.properties`
- 典型触发条件：
  - 使用 1.0.0.a 或 1.0.1.a 版本部署节点；
  - 通过外部 `conf/dubbo/connection.properties` 配置真实注册中心地址、协议端口或 group；
  - Spring 上下文加载 `application-context-dubbo.xml` 并解析 Dubbo 占位符。
- 典型症状：
  - 外部 conf 中配置的 Dubbo 注册中心地址未生效，服务仍尝试连接 `your-host-here`；
  - Dubbo 服务注册失败、consumer 无法发现 provider，或 Hessian 协议端口绑定异常；
  - provider group 被解析为空字符串或错误值，导致 RPC 调用分组不匹配。
- 影响范围：
  - 所有通过 Dubbo/Hessian 暴露或消费的 acckeeper、rbacds、buddy、settingrepo、notify 服务。
  - 不直接依赖 Dubbo RPC 的本地调用与 Telqos 命令不受影响。

迁移建议：升级至 1.0.2.a 及以上版本。

### BLACKLIST-20260806.1

原因：`com.dwarfeng.essentials.sdk.hibernate.TablePrefixResolver` 中，
包前缀映射 `PACKAGE_PREFIX_MAP`缺失 `com.dwarfeng.buddy.` → `tbl_buddy_` 的映射，
同时残留了 buddy 源服务旧包名的错误映射 `com.jiermt.hr.` → `tbl_hr_`。
`PackagePrefixTableNameIntegrator` 在 Hibernate 元数据构建阶段会依据该映射为各来源服务的实体主表名追加服务级前缀；
buddy 包名下的实体因无法命中任何映射，其表名不会被改写为 `tbl_buddy_*`，
而是保留原始的 `tbl_user`、`tbl_profile`、`tbl_avatar_info`、`tbl_notification` 等名称，落入未隔离的公共表命名空间。
这会导致 buddy 相关数据库表名与项目预期的命名空间隔离设计不符，可能访问到错误的表或在目标 schema 中报表不存在的错误。

- 受影响模块/类：
  - `com.dwarfeng.essentials.sdk.hibernate.TablePrefixResolver`
  - `com.dwarfeng.essentials.sdk.hibernate.PackagePrefixTableNameIntegrator`
  - `com.dwarfeng.buddy.impl.bean.entity.HibernateUser`
  - `com.dwarfeng.buddy.impl.bean.entity.HibernateProfile`
  - `com.dwarfeng.buddy.impl.bean.entity.HibernateAvatarInfo`
  - `com.dwarfeng.buddy.impl.bean.entity.HibernateNotification`
- 典型触发条件：
  - 使用 1.0.0.a 或 1.0.1.a 版本启动节点并完成 Hibernate SessionFactory 构建；
  - buddy 服务相关实体（用户、资料、头像信息、通知等）参与 Hibernate 元数据绑定；
  - 数据库 schema 按 `tbl_buddy_*` 前缀建表，或目标库中已存在其它同名非 buddy 表。
- 典型症状：
  - 启动日志或运行时 SQL 中出现表不存在（实际表名与预期不符）的异常；
  - buddy 相关功能的数据库读写失败、返回空结果或命中错误表；
  - 若目标 schema 中已存在同名表，可能静默地读写非 buddy 数据，造成数据隔离破坏。
- 影响范围：
  - 所有依赖 buddy 服务实体进行 Hibernate 持久化的功能。
  - 其它来源服务实体不受影响（acckeeper、rbacds、settingrepo、notify 的映射正确）。

迁移建议：升级至 1.0.2.a 及以上版本。

## 注意事项

- 黑名单用于风险提示，并非强制禁用。是否升级或规避，应以是否命中“详细原因”所述的模块与场景为依据。
- 建议遵循生产变更流程：评估 -> 测试 -> 灰度 -> 观测 -> 全量，过程中启用充分的日志与指标监控。
- 如发现新问题或修复版本，请同步更新本黑名单与变更记录，保持信息一致性。

# ChangeLog

## Release_1.3.2_20261028_build_A

### 功能构建

- 依赖升级。
  - 升级 `settingrepo` 依赖版本为 `3.1.0.a` 以应用其新功能。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.3.1_20261018_build_A

### 功能构建

- Wiki 更新。
  - docs/wiki/zh-CN/ConfDirectory.md。

- 依赖升级。
  - 升级 `settingrepo` 依赖版本为 `3.0.4.a` 以应用其新功能。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.3.0_20261016_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/InstallToCentos.md。

- 应用新的异常码编号规则。
  - 将工具组件与聚合微服务的异常码分段，聚合微服务异常码从 `50000` 起递增。

- 依赖升级。
  - 升级 `settingrepo` 依赖版本为 `3.0.3.a` 以应用其新功能。

### Bug 修复

- 修复部分 `*.properties` 文件中错误的配置。
  - `dwarfeng-essentials-node-minimal-he` 模块下的 curator/latch-path.properties。

- 修复节点异常映射及异常码偏移配置中缺失的工具组件异常映射。
  - dwarfeng-tmpstg。
  - dcti。
  - dwarfeng-dct。

### 功能移除

- (无)

---

## Release_1.2.2_20261008_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/CompileBySource.md。

- 依赖升级。
  - 升级 `spring-messaging` 依赖版本为 `5.3.39` 以规避漏洞。
  - 升级 `spring-oxm` 依赖版本为 `5.3.39` 以规避漏洞。
  - 升级 `jackson` 依赖版本为 `2.21.7` 以规避漏洞。
  - 升级 `logic-engine` 依赖版本为 `1.2.0.a` 以应用其新功能。
  - 升级 `audit` 依赖版本为 `1.3.0.a` 以规避漏洞。

- 优化文件格式。
  - 优化 `*.properties` 文件的格式。
  - 优化 `application-context-*.xml` 文件的格式。

### Bug 修复

- 修复部分 `application-context-*.xml` 文件中缺失的配置。
  - application-context-dubbo.xml。

- 修复部分 `*.properties` 文件中错误的配置。
  - curator/latch-path.properties。

- 修复部分 `opt-*.xml` 文件中错误的配置。
  - opt-logicengine-pusher.xml。

### 功能移除

- (无)

---

## Release_1.2.1_20260927_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/ConfDirectory.md。

- 依赖升级。
  - 升级 `audit` 依赖版本为 `1.2.1.a` 以应用其新功能。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.2.0_20260919_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/SystemRequirements.md。

- 新增 `dwarfeng-essentials-node-minimal-he` 模块。
  - 该模块作为精简节点，保留 `acckeeper`、`rbacds`、`buddy`、`settingrepo`、`notify` 和 `audit` 服务。

- 扩展单体服务聚合范围。
  - 新增 `logic-engine`、`audit`、`fileio`、`voucher` 服务的 Maven 坐标与运行时装配。
  - 补充新增服务的启动流程、配置资源及运行隔离映射。

- 新增基于来源服务包前缀的 Spring Bean 自动装配候选隔离能力。
  - 支持聚合运行时按来源服务前缀解析 `@Qualifier` Bean。
  - 在 `dwarfeng-essentials-node-all-he` 中装配对应的 BeanFactory 后置处理配置。

- `dwarfeng-essentials-sdk` 子模块类优化注释、文档注释格式、代码换行格式。
  - com.dwarfeng.essentials.sdk.datamark.PackagePrefixListenerResolver。

- 依赖升级。
  - 升级 `subgrade` 依赖版本为 `1.9.0.a` 以规避漏洞。
  - 升级 `jackson` 依赖版本为 `2.21.5` 以规避漏洞。
  - 升级 `dwarfeng-datamark` 依赖版本为 `2.2.1.a` 以规避漏洞。

- 优化文件格式。
  - 优化 `application-context-*.xml` 文件的格式。

### Bug 修复

- 修复部分配置文件中的错误配置。
  - dwarfeng-essentials-node/dwarfeng-essentials-node-all-he/src/assembly/assembly.xml。

### 功能移除

- (无)

---

## Release_1.1.0_20260812_build_A

### 功能构建

- Wiki 更新。
  - docs/wiki/zh-CN/VersionBlacklist.md。

- `dwarfeng-essentials-sdk` 子模块类优化注释、文档注释格式、代码换行格式。
  - com.dwarfeng.essentials.sdk.hibernate.EntityNameMetadataSourcesFactoryBean。
  - com.dwarfeng.essentials.sdk.hibernate.TablePrefixResolver。

- 依赖升级。
  - 升级 `fastjson` 依赖版本为 `1.2.84` 以规避漏洞。

### Bug 修复

- 修复多个来源服务的实体映射到同名数据表时，Hibernate 合并表元数据的问题。

### 功能移除

- (无)

---

## Release_1.0.4_20260807_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh_CN/UsingTelqos.md。

- Wiki 更新。
  - docs/wiki/zh-CN/ShellScripts.md。

- `dwarfeng-essentials-sdk` 子模块类优化注释、文档注释格式、代码换行格式。
  - com.dwarfeng.essentials.sdk.hibernate.EntityNameMappingRules。
  - com.dwarfeng.essentials.sdk.hibernate.EntityNameMetadataSourcesFactoryBean。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.0.3_20260807_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/ShellScripts.md。
  - docs/wiki/zh-CN/BatchScripts.md。

- 优化部分启停脚本的文件格式。
  - dwarfeng-essentials-start.bat。
  - dwarfeng-essentials-start.sh。
  - dwarfeng-essentials-stop.sh。

- 优化文件格式。
  - 优化 `log4j2.xml` 文件的格式。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.0.2_20260806_build_A

### 功能构建

- Wiki 更新。
  - docs/wiki/zh-CN/VersionBlacklist.md。

- `dwarfeng-essentials-node-all-he` 子模块类优化注释、文档注释格式、代码换行格式。
  - com.dwarfeng.essentials.node.all.he.configuration.SettingrepoCacheConfiguration。

- `dwarfeng-essentials-sdk` 子模块类优化注释、文档注释格式、代码换行格式。
  - com.dwarfeng.essentials.sdk.hibernate.EntityNameMappingRules。

- 优化部分启停脚本的文件格式。
  - dwarfeng-essentials-start.bat。

- 优化文件格式。
  - 优化 `*.properties` 文件的格式。
  - 优化 `application-context-*.xml` 文件的格式。
  - 优化 `pom.xml` 文件的格式。

### Bug 修复

- 修复 `dwarfeng-essentials-node-all-he` 模块中部分配置文件中的配置键错误。
  - dubbo/connection.properties。

- 修复 `dwarfeng-essentials-sdk` 模块中部分代码中的数据错误。
  - com.dwarfeng.essentials.sdk.hibernate.TablePrefixResolver。

### 功能移除

- (无)

---

## Release_1.0.1_20260806_build_A

### 功能构建

- Wiki 编写。
  - docs/wiki/zh-CN/VersionBlacklist.md。

- 优化文件格式。
  - 优化 `*.properties` 文件的格式。

### Bug 修复

- (无)

### 功能移除

- (无)

---

## Release_1.0.0_20260805_build_A

### 功能构建

- 更新 README.md。

- Wiki 编写。
  - 构建 wiki 目录结构。
  - docs/wiki/en-US/Contents.md。
  - docs/wiki/en-US/Introduction.md。
  - docs/wiki/zh-CN/Contents.md。
  - docs/wiki/zh-CN/Introduction.md。

- 完成 `dwarfeng-essentials-distribute` 模块，打包测试通过。

- 完成 `dwarfeng-essentials-node-all-he` 模块，启动测试通过。

- 项目结构建立，清理测试通过。

### Bug 修复

- (无)

### 功能移除

- (无)

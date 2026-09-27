# ConfDirectory - 配置目录

## 总览

本项目的配置文件位于 `conf/` 目录下，包括：

```text
conf
│
├─acckeeper
│     clean.properties
│     derive.properties
│     launcher.properties
│     login.properties
│     lskgen.properties
│     purge.properties
│     push.properties
│     register.properties
│     reset.properties
│
├─audit
│     audit-record.properties
│     consume.properties
│     inspection-dispatcher.properties
│     inspection-driver.properties
│     inspection-receiver.properties
│     inspection-task.properties
│     launcher.properties
│     purge.properties
│     push.properties
│     reset.properties
│
├─curator
│     connection.properties
│     latch-path.properties
│     mutex-prefix.properties
│
├─database
│     connection.properties
│     performance.properties
│
├─datamark
│     settings.properties
│
├─dubbo
│     connection.properties
│
├─essentials
│     background.properties
│     exception.properties
│
├─fileio
│     launcher.properties
│     purge.properties
│     push.properties
│     read.properties
│     reset.properties
│     task.properties
│
├─ftp
│     connection.properties
│     path.properties
│
├─logging
│     README.md
│     settings.xml
│     settings-ref-linux.xml
│     settings-ref-windows.xml
│
├─logic-engine
│     consume.properties
│     dispatch.properties
│     driver.properties
│     launcher.properties
│     purge.properties
│     push.properties
│     receive.properties
│     reset.properties
│     task.properties
│
├─notify
│     launcher.properties
│     purge.properties
│     push.properties
│     reset.properties
│
├─rbacds
│     launcher.properties
│     local-cache.properties
│     push.properties
│     reset.properties
│
├─redis
│     connection.properties
│     prefix-acckeeper.properties
│     prefix-audit.properties
│     prefix-buddy.properties
│     prefix-fileio.properties
│     prefix-logicengine.properties
│     prefix-notify.properties
│     prefix-rbacds.properties
│     prefix-settingrepo.properties
│     prefix-voucher.properties
│     timeout-acckeeper.properties
│     timeout-audit.properties
│     timeout-buddy.properties
│     timeout-fileio.properties
│     timeout-logicengine.properties
│     timeout-notify.properties
│     timeout-rbacds.properties
│     timeout-settingrepo.properties
│     timeout-voucher.properties
│
├─settingrepo
│     iahn.properties
│     image-thumbnail.properties
│     launcher.properties
│     navigation.properties
│     push.properties
│     reset.properties
│
├─telqos
│     connection.properties
│
├─tmpstg
│     settings.properties
│
└─voucher
      cleanup.properties
      launcher.properties
      push.properties
      reset.properties
```

鉴于大部分配置文件的配置项中都有详细的注释，此处将展示默认的配置，并重点说明一些必须要修改的配置项，
省略的部分将会使用 `etc...` 进行标注。

本项目是 1 型构型的合并项目，聚合了 acckeeper、rbacds、buddy、settingrepo、notify、logicengine、audit、
fileio、voucher 等多个来源服务的功能，因此 `conf/` 目录下共有 18 个配置文件目录、88 个配置文件，
其中项目级的配置位于 `essentials` 目录下，其余目录则分别对应各个来源服务以及公用的基础组件。

文档中展示的配置均为默认值，其中的主机地址、账号、密码等敏感信息使用 `your-host-here`、`your-username-here`、
`your-password-here` 等占位符表示，您需要在部署时将这些占位符替换为实际值。此外，少数配置项使用了通用的默认值，
例如数据库用户名默认为 `root`，同样需要根据实际情况修改。

## acckeeper 目录

| 文件名              | 说明                         |
|---------------------|------------------------------|
| clean.properties    | 过期登录状态清理的配置文件   |
| derive.properties   | 登录状态派生服务的配置文件   |
| launcher.properties | 启动器配置文件               |
| login.properties    | 登录服务的配置文件           |
| lskgen.properties   | 登录状态主键生成器的配置文件 |
| purge.properties    | 清除服务的配置文件           |
| push.properties     | 推送服务配置文件             |
| register.properties | 注册服务的配置文件           |
| reset.properties    | 重置服务配置文件             |

### clean.properties

过期登录状态清理的配置文件。

```properties
# 过期登录状态清理的 CRON 表达式
com.dwarfeng.essentials.acckeeper.clean.expired_login_state.cron=0 15 0/1 * * *
```

### derive.properties

登录状态派生服务的配置文件。

```properties
# 动态派生的过期时长。
com.dwarfeng.essentials.acckeeper.acckeeper.derive.dynamic.expire_duration=600000
```

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置保护器支持。
com.dwarfeng.essentials.acckeeper.launcher.reset_protector_support=true
#
# 程序启动完成后，上线清理的延时时间。
# 有些数据仓库以及清理器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即上线清理服务。
# 该参数小于 0，意味着程序不主动上线清理服务，需要手动上线。
com.dwarfeng.essentials.acckeeper.launcher.online_clean_delay=3000
# 程序启动完成后，启动清理的延时时间。
# 有些数据仓库以及清理器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动清理服务。
# 该参数小于 0，意味着程序不主动启动清理服务，需要手动启动。
com.dwarfeng.essentials.acckeeper.launcher.enable_clean_delay=3500
#
# 程序启动完成后，启动重置的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.acckeeper.launcher.start_reset_delay=30000
#
# 程序启动完成后，上线清除的延时时间。
# 有些数据仓库以及清除器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即上线清除服务。
# 该参数小于 0，意味着程序不主动上线清除服务，需要手动上线。
com.dwarfeng.essentials.acckeeper.launcher.online_purge_delay=4000
# 程序启动完成后，启动清除的延时时间。
# 有些数据仓库以及清除器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动清除服务。
# 该参数小于 0，意味着程序不主动启动清除服务，需要手动启动。
com.dwarfeng.essentials.acckeeper.launcher.enable_purge_delay=4500
```

该配置文件决定了服务被运行后，哪些功能将会自动被执行。任何没有自动执行的功能模块，均可以通过服务的 Telqos
系统随时进行启用。

### login.properties

登录服务的配置文件。

```properties
# 动态登录的过期时长。
com.dwarfeng.essentials.acckeeper.acckeeper.login.dynamic.expire_duration=600000
```

### lskgen.properties

登录状态主键生成器的配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的登录状态主键生成器类型。
# 目前该项目支持的登录状态主键生成器类型有:
#   uuid: UUID 登录状态主键生成器。
#   randx: 随机字符串登录状态主键生成器。
#   snowflake: Snowflake 登录状态主键生成器（已废弃，仅用于兼容旧格式）。
#
# 对于一个具体的项目，很可能只用一个登录状态主键生成器。此时希望加载
# 登录状态主键生成器时只加载需要的那个，其余的登录状态主键生成器不加载。这个需求
# 可以通过编辑 opt/opt-lsk-generator.xml 实现。
com.dwarfeng.essentials.acckeeper.lskgen.type=uuid
#
###################################################
#                      uuid                       #
###################################################
# uuid 登录状态主键生成器没有额外配置项。
#
###################################################
#                      randx                      #
###################################################
# randx 登录状态主键生成器生成的登录状态主键的长度。
com.dwarfeng.essentials.acckeeper.lskgen.randx.length=128
#
###################################################
#                    snowflake                    #
###################################################
# snowflake 登录状态主键生成器已被废弃，仅用于兼容旧的登录状态主键格式。
# Snowflake ID 基于时间戳和机器 ID 生成，容易被推测，存在安全风险。
# 建议使用 uuid 或 randx 生成器。
# snowflake 登录状态主键生成器没有额外配置项。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-acckeeper-lskgen.xml`，
决定项目中需要使用哪种登录状态主键生成器。您只需要修改使用的登录状态主键生成器的配置。

### purge.properties

清除服务的配置文件。

```properties
# 清除任务的保留时长（毫秒）。
# 发生日期距离当前系统日期超过该时长的数据将被清除。
# 如果设置为 0 或负数，清除计划将不启动。
com.dwarfeng.essentials.acckeeper.purge.retention_duration=17280000000
# 清除任务的执行周期（Cron 表达式）。
com.dwarfeng.essentials.acckeeper.purge.task_cron=0 0 2 * * ?
# 清除任务的最大分页大小。
# 每次查询待清除数据时的最大数量。
com.dwarfeng.essentials.acckeeper.purge.max_page_size=1000
# 清除任务的最大删除数量。
# 单次清除任务最多删除的数据条数。
com.dwarfeng.essentials.acckeeper.purge.max_deletion_size=10000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   log: 将时间格式化后打印至日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时希望加载
# 推送器时只加载需要的那个，其余的推送器不加载。这个需求
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.acckeeper.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.acckeeper.pusher.multi.delegate_types=drain
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.acckeeper.pusher.log.log_level=INFO
```

### register.properties

注册服务的配置文件。

```properties
# 用户注册时加密密码时盐生成的复杂度，值越高，安全性越强，但是速度越慢。最高为 30。
com.dwarfeng.essentials.acckeeper.register.password.salt_log_rounds=10
# 用户注册时使用的默认保护器类型。
com.dwarfeng.essentials.acckeeper.register.default_protector.type=do_nothing_protector
# 用户注册时使用的默认保护器参数。
com.dwarfeng.essentials.acckeeper.register.default_protector.param=
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 重置器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.acckeeper.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.acckeeper.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.acckeeper.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 重置器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-acckeeper-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

## audit 目录

| 文件名                           | 说明                     |
|----------------------------------|--------------------------|
| audit-record.properties          | 审计记录服务的配置文件   |
| consume.properties               | 消费服务配置文件         |
| inspection-dispatcher.properties | 自动审计调度器的配置文件 |
| inspection-driver.properties     | 自动审计驱动器的配置文件 |
| inspection-receiver.properties   | 自动审计接收器的配置文件 |
| inspection-task.properties       | 自动审计任务的配置文件   |
| launcher.properties              | 启动器配置文件           |
| purge.properties                 | 清除服务的配置文件       |
| push.properties                  | 推送服务配置文件         |
| reset.properties                 | 重置服务配置文件         |

### audit-record.properties

审计记录服务的配置文件。

```properties
#---------------------------------报警配置----------------------------------------
# 当审计记录消费者中的待消费元素超过缓存上限指定比例后，向日志中输入警告信息。
com.dwarfeng.essentials.audit.audit_record.threshold.warn=0.8
#
#---------------------------------配置说明----------------------------------------
# 当审计记录消费者线程数：线程数越大，处理的能力越强，服务器负荷越重。
# com.dwarfeng.audit.audit_record.consumer_thread=1
#
# 缓存大小：缓存越大抗波动能力越强，数据实时性越低。
# 当缓存被占满时，会导致记录者阻塞。
# 数据占满缓存这一现象是需要尽力避免的，程序将在缓存占用量超过指定值的时候发出警报提示。
# com.dwarfeng.audit.audit_record.buffer_size=1000
#
#---------------------------------配置内容----------------------------------------
com.dwarfeng.essentials.audit.audit_record.consumer_thread=1
com.dwarfeng.essentials.audit.audit_record.buffer_size=1000
```

### consume.properties

消费服务配置文件。

```properties
#---------------------------------报警配置----------------------------------------
# 当消费者中的待消费元素超过缓存上限指定比例后，向日志中输入警告信息。
com.dwarfeng.essentials.audit.consume.threshold.warn=0.8
#
#---------------------------------配置说明----------------------------------------
# 消费者线程数：线程数越大，处理的能力越强，服务器负荷越重。
# com.dwarfeng.audit.consume.xxx.consumer_thread=1
#
# 缓存大小：缓存越大抗波动能力越强，数据实时性越低。
# 当缓存被占满时，会导致消费者阻塞。
# 数据占满缓存这一现象是需要尽力避免的，程序将在缓存占用量超过指定值的时候发出警报示。
# com.dwarfeng.audit.consume.xxx.buffer_size=1000
#
# 批处理个数：缓存的数量到达批处理个数之前，数据不会被消费，消费线程阻塞；到达批处理个数之后，这批数据将被立刻消费。
# 部分桥接器批处理数据时具有速度加成（如数据库的批量插入），
# 在这种情况下，批处理个数越多，平均每个元素消费速度越快，但由于积攒批量所需的时间变长，数据实时性降低。
# 该值小于等于 0 时意味着禁用批处理功能，只要缓存中有数据就立刻消费，数据实时性最高，但服务器负荷也最高。
# com.dwarfeng.audit.consume.xxx.batch_size=100
#
# 最大空闲时间：为了防止数据生产速度过慢时，数据在缓存中长期等待这种现象的发生，
# 可以设置一个最大空闲时间，当缓存中数据的等待时间超过这个值时，即使数据量没有达到批处理个数，也立刻将这些数据消费掉。
# 该值的单位是毫秒，数值越低，数据实时性越高，服务器负荷越高。
# 该值小于等于 0 时意味着禁用最大空闲时间检查，在最坏的情况下，此种设置会导致少于批处理个数的元素无限期的在缓存中等待。
# com.dwarfeng.audit.consume.xxx.max_idle_time=1000
#
#---------------------------------审计记录持久侧消费者----------------------------------------
com.dwarfeng.essentials.audit.consume.audit_record.consumer_thread=4
com.dwarfeng.essentials.audit.consume.audit_record.buffer_size=1000
com.dwarfeng.essentials.audit.consume.audit_record.batch_size=100
com.dwarfeng.essentials.audit.consume.audit_record.max_idle_time=1000
#
#---------------------------------自动审计接收消费者----------------------------------------
com.dwarfeng.essentials.audit.consume.inspection_receive.consumer_thread=4
com.dwarfeng.essentials.audit.consume.inspection_receive.buffer_size=10
com.dwarfeng.essentials.audit.consume.inspection_receive.batch_size=1
com.dwarfeng.essentials.audit.consume.inspection_receive.max_idle_time=1000
```

本配置中的参数直接决定了消费服务的性能，您需要根据您的实际情况进行调整。

为了更加直观的观察调整后的效果，本服务提供了关于消费服务的 telnet 指令，您可以使用指令在 telnet 运维系统中动态修改参数，
并观察修改后的效果。在运维系统中的更改重启后会失效，因此，当您将参数调整到满意的程度后，您需要将参数修改到配置文件中。

### inspection-dispatcher.properties

自动审计调度器的配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的自动审计调度器类型。
# 目前该项目支持的自动审计调度器类型有:
#   drain: 丢弃所有调度请求并记录日志的调度器，用于测试和调试。
#   injvm: 虚拟机内部调度器，用于单节点服务。
#   kafka: 基于 Kafka 实现的调度器，利用 Kafka 消费组机制实现多个接收节点的负载均衡。
#   dubbo: 基于 Dubbo 实现的调度器，利用服务提供者机制实现多个接收节点的负载均衡。
#
# 对于一个具体的项目，很可能只使用一个调度器。此时如果希望程序加载时只加载一个调度器，可以通过编辑
# opt/opt-inspection-dispatcher.xml 文件实现。
com.dwarfeng.essentials.audit.inspection_dispatcher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 调度器没有任何配置。
#
###################################################
#                      injvm                      #
###################################################
# injvm 调度器没有任何配置。
#
###################################################
#                      kafka                      #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 生产者与服务器的确认模式，可选值为: 0、1、all。
#   0: 生产者不等待服务器确认，继续发送下一条消息。
#   1: 生产者等待首领副本确认，继续发送下一条消息。
#   all: 生产者等待服务器及其所有同步副本确认，继续发送下一条消息。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.acks=all
# 发送失败重试次数，acks 设置为 0 时不生效。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.retries=3
# 生产者在发送批处理前等待更多消息加入批处理的时间，单位为毫秒。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.linger=10
# 生产者可用于缓冲待发送记录的内存总量，单位为字节。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.buffer_memory=40960
# 同一分区发送批次的目标大小，单位为字节。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.batch_size=4096
# Kafka 事务 ID 前缀，同一 Kafka 集群中的不同应用实例应使用不同前缀。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.transaction_prefix=audit.inspection_dispatcher.
# 负载均衡策略，可选值为: default、round_robin、random。
#   default: 使用 Kafka 生产者默认分区策略。
#   round_robin: 按当前主题分区列表轮询发送。
#   random: 从当前主题分区列表中随机选择分区发送。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.load_balance_mode=default
# 刷新主题分区信息的间隔时间，单位为毫秒。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.partition_check_interval=30000
# 执行调度时向 Kafka 发送消息的主题，应与 Kafka 接收器监听的主题保持一致。
com.dwarfeng.essentials.audit.inspection_dispatcher.kafka.topic.dispatch=audit-inspection-dispatch
#
###################################################
#                      dubbo                      #
###################################################
# dubbo 调度器没有任何独立配置，使用 dubbo/connection.properties 中的注册中心和提供者分组配置。
```

### inspection-driver.properties

自动审计驱动器的配置文件。

```properties
###################################################
#                      cron                       #
###################################################
# Cron 驱动没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# FixedDelay 驱动没有任何配置。
#
###################################################
#                    fixed_rate                   #
###################################################
# FixedRate 驱动没有任何配置。
#
###################################################
#                    kafka.dcti                   #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 会话的超时限制: 如果 consumer 在这段时间内没有发送心跳信息，一次 rebalance 将会产生。
# 该值必须在[group.min.session.timeout.ms, group.max.session.timeout.ms]范围内，默认: 10000。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.session_timeout_ms=10000
# 新的 group 加入 topic 时，从什么位置开始消费。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.auto_offset_reset=latest
# 监听器启用的消费者的线程数。
# 每一个线程都会启动一个 KafkaConsumer，每个 KafkaConsumer 都会占用一个 partition。
# 程序分布式部署时，所有节点的线程数之和应该小于等于 topic 的 partition 数。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.concurrency=2
# 监听器调用 KafkaConsumer.poll(Duration) 方法的超时时间，如果超过这个时间还没有拉取到数据，则返回空列表。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.poll_timeout=3000
# 监听器的 id，每一个节点的监听器 id 都应与该节点的其它 kafka 监听器的 id 不同。
# 该设置会覆盖 kafka 的 group.id 设置，因此无需设置 group.id。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.listener_id=audit.inspection_driver.dcti
# 监听器的目标 topic。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.listener_topic=dcti.data_info
# 监听器的最大拉取数据量。当拉取到的数据量达到这个值时，会立即返回，不会等待 poll_timeout。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.max_poll_records=100
# 监听器的最大拉取间隔。如果当前时间距离监听器上一次拉取数据的时间超过了这个值，一次 rebalance 将会产生。
com.dwarfeng.essentials.audit.inspection_driver.kafka.dcti.max_poll_interval_ms=300000
```

### inspection-receiver.properties

自动审计接收器的配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的自动审计接收器类型。
# 目前该项目支持的自动审计接收器类型有:
#   do_nothing: 什么也不做的接收器，用于测试。
#   injvm: 虚拟机内部接收器，用于单节点服务。
#   kafka: 基于 Kafka 实现的接收器，用于多个节点的负载均衡。
#   dubbo: 基于 Dubbo 实现的接收器，用于多个节点的负载均衡。
com.dwarfeng.essentials.audit.inspection_receiver.type=do_nothing
#
###################################################
#                      kafka                      #
###################################################
com.dwarfeng.essentials.audit.inspection_receiver.kafka.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
com.dwarfeng.essentials.audit.inspection_receiver.kafka.session_timeout_ms=10000
com.dwarfeng.essentials.audit.inspection_receiver.kafka.auto_offset_reset=latest
com.dwarfeng.essentials.audit.inspection_receiver.kafka.concurrency=1
com.dwarfeng.essentials.audit.inspection_receiver.kafka.poll_timeout=3000
com.dwarfeng.essentials.audit.inspection_receiver.kafka.listener_id=audit.inspection_receiver
com.dwarfeng.essentials.audit.inspection_receiver.kafka.listener_topic=audit-inspection-dispatch
com.dwarfeng.essentials.audit.inspection_receiver.kafka.max_poll_records=100
com.dwarfeng.essentials.audit.inspection_receiver.kafka.max_poll_interval_ms=300000
#
###################################################
#                      dubbo                      #
###################################################
com.dwarfeng.essentials.audit.inspection_receiver.dubbo.provider.group=
```

### inspection-task.properties

自动审计任务的配置文件。

```properties
# 自动审计任务的超时时间。
com.dwarfeng.essentials.audit.inspection_task.expire_timeout=3600000
# 自动审计任务心跳死亡的全局超时时间。
com.dwarfeng.essentials.audit.inspection_task.die_timeout=3600000
# 自动审计任务心跳周期。
com.dwarfeng.essentials.audit.inspection_task.beat_interval=10000
# 自动审计任务过期检查周期。
com.dwarfeng.essentials.audit.inspection_task.check.expire_check.cron=0 */1 * * * *
# 自动审计任务死亡检查周期。
com.dwarfeng.essentials.audit.inspection_task.check.die_check.cron=0 */1 * * * *
```

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置审计器支持。
com.dwarfeng.essentials.audit.launcher.reset_inspector_support=true
# 程序启动完成后，是否重置自动审计驱动器支持。
com.dwarfeng.essentials.audit.launcher.reset_inspection_driver_support=true
#
# 程序启动完成后，启动审计记录功能的延时时间。
# 该参数等于 0，意味着启动后立即开启审计记录服务。
# 该参数小于 0，意味着程序不主动开启审计记录服务，需要手动开启。
com.dwarfeng.essentials.audit.launcher.start_audit_record_delay=3000
#
# 程序启动完成后，启动重置服务的延时时间。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要通过 Telqos 手动启动。
com.dwarfeng.essentials.audit.launcher.start_reset_delay=30000
#
# 程序启动完成后，上线自动审计任务检查服务的延时时间。
# 该参数等于 0，意味着启动后立即上线自动审计任务检查服务。
# 该参数小于 0，意味着程序不主动上线自动审计任务检查服务，需要手动上线。
com.dwarfeng.essentials.audit.launcher.online_inspection_task_check_delay=3000
# 程序启动完成后，启动自动审计任务检查服务的延时时间。
# 该参数等于 0，意味着启动后立即启动自动审计任务检查服务。
# 该参数小于 0，意味着程序不主动启动自动审计任务检查服务，需要手动启动。
com.dwarfeng.essentials.audit.launcher.enable_inspection_task_check_delay=3500
#
# 程序启动完成后，启动自动审计接收服务的延时时间。
# 该参数等于 0，意味着启动后立即启动自动审计接收服务。
# 该参数小于 0，意味着程序不主动启动自动审计接收服务，需要手动启动。
com.dwarfeng.essentials.audit.launcher.start_inspection_receiver_delay=4000
#
# 程序启动完成后，上线自动审计主管服务的延时时间。
# 该参数等于 0，意味着启动后立即上线自动审计主管服务。
# 该参数小于 0，意味着程序不主动上线自动审计主管服务，需要手动上线。
com.dwarfeng.essentials.audit.launcher.online_inspection_supervise_delay=4500
# 程序启动完成后，启动自动审计主管服务的延时时间。
# 该参数等于 0，意味着启动后立即启动自动审计主管服务。
# 该参数小于 0，意味着程序不主动启动自动审计主管服务，需要手动启动。
com.dwarfeng.essentials.audit.launcher.enable_inspection_supervise_delay=5000
#
# 程序启动完成后，上线清除服务的延时时间。
# 该参数等于 0，意味着启动后立即上线清除服务。
# 该参数小于 0，意味着程序不主动上线清除服务，需要手动上线。
com.dwarfeng.essentials.audit.launcher.online_purge_delay=5500
# 程序启动完成后，启动清除服务的延时时间。
# 该参数等于 0，意味着启动后立即启动清除服务。
# 该参数小于 0，意味着程序不主动启动清除服务，需要手动启动。
com.dwarfeng.essentials.audit.launcher.enable_purge_delay=6000
```

该配置文件决定了服务被运行后，哪些功能将会自动被执行。任何没有自动执行的功能模块，均可以通过服务的 Telqos
系统随时进行启用。

### purge.properties

清除服务的配置文件。

```properties
###################################################
#                      purge                      #
###################################################
# 清除任务的保留时长，单位为毫秒。
# 小于等于 0 时不启动清除计划。
com.dwarfeng.essentials.audit.purge.retention_duration=0
# 清除任务的 Cron 执行周期。
com.dwarfeng.essentials.audit.purge.task_cron=0 0/5 * * * *
# 单次分页查询的最大数据量。
com.dwarfeng.essentials.audit.purge.max_page_size=100
# 单次清除任务允许删除的最大数据量。
com.dwarfeng.essentials.audit.purge.max_deletion_size=1000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   kafka.native: 使用原生数据的基于 Kafka 消息队列的推送器。
#   log: 将消息输出到日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时如果希望程序加载时只加载一个推送器，可以通过编辑
# opt/opt-pusher.xml 文件实现。
com.dwarfeng.essentials.audit.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.audit.pusher.multi.delegate_types=drain
#
###################################################
#                   kafka.native                  #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.audit.pusher.kafka.native.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 生产者与服务器的确认模式，可选值为: 0, 1, all。
com.dwarfeng.essentials.audit.pusher.kafka.native.acks=all
# 发送失败重试次数，acks 设置为 0 时不生效。
com.dwarfeng.essentials.audit.pusher.kafka.native.retries=3
# 生产者在发送批处理之前等待更多消息加入批处理的时间，单位为毫秒。
com.dwarfeng.essentials.audit.pusher.kafka.native.linger=10
# 生产者可用于缓存待发送记录的内存总量，单位为字节。
com.dwarfeng.essentials.audit.pusher.kafka.native.buffer_memory=40960
# 同一分区发送批次的目标大小，单位为字节。
com.dwarfeng.essentials.audit.pusher.kafka.native.batch_size=4096
# Kafka 事务 ID 前缀，同一 Kafka 集群中的不同应用实例应使用不同前缀。
com.dwarfeng.essentials.audit.pusher.kafka.native.transaction_prefix=audit.pusher.
# 审核记录重置事件对应的 Kafka 主题。
com.dwarfeng.essentials.audit.pusher.kafka.native.topic.audit_record_reset=audit.pusher.audit_record_reset
# 自动审计主管重置事件对应的 Kafka 主题。
com.dwarfeng.essentials.audit.pusher.kafka.native.topic.inspection_supervise_reset=\
  audit.pusher.inspection_supervise_reset
# etc...
#
###################################################
#                       log                       #
###################################################
# 推送日志的等级，可选值为 TRACE、DEBUG、INFO、WARN、ERROR。
com.dwarfeng.essentials.audit.pusher.log.log_level=INFO
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-audit-pusher.xml`，
决定项目中需要使用哪种推送器。您只需要修改使用的推送器的配置。

### reset.properties

重置服务配置文件。

```properties
###################################################
#                   fixed_delay                   #
###################################################
# 重置的时间间隔。
com.dwarfeng.essentials.audit.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的时间间隔。
com.dwarfeng.essentials.audit.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.audit.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 重置器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-audit-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

## curator 目录

| 文件名                  | 说明                     |
|-------------------------|--------------------------|
| connection.properties   | Curator 连接配置         |
| latch-path.properties   | Curator 领导者锁路径配置 |
| mutex-prefix.properties | Curator 互斥锁前缀配置   |

### connection.properties

Curator 连接配置。

```properties
# 连接字符，即 zookeeper 地址。
com.dwarfeng.essentials.curator.connect.connect_string=your-host-here:2181
# 会话超时时间。
com.dwarfeng.essentials.curator.connect.session_timeout=60000
# 连接超时时间。
com.dwarfeng.essentials.curator.connect.connection_timeout=15000
# 第一次重试时的间隔时间，每重试一次，间隔时间都会指数增加，直到最大的间隔时间。
com.dwarfeng.essentials.curator.retry_policy.base_sleep_time=1000
# 最大重试次数。
com.dwarfeng.essentials.curator.retry_policy.max_retries=10
# 单次重试最大的间隔时间。
com.dwarfeng.essentials.curator.retry_policy.max_sleep=60000
```

Curator 连接配置文件，包括 Zookeeper 连接地址，超时时间，重试策略。

### latch-path.properties

Curator 领导者锁路径配置。

```properties
# region acckeeper curator/latch-path.properties
# 清理服务的领导者锁存的路径。
com.dwarfeng.acckeeper.curator.latch_path.clean.leader_latch=/acckeeper/clean/leader_latch
# 清除服务的领导者锁存的路径。
com.dwarfeng.acckeeper.curator.latch_path.purge.leader_latch=/acckeeper/purge/leader_latch
# endregion
# region notify curator/latch-path.properties
# 清除服务的领导者锁存的路径。
com.dwarfeng.notify.curator.latch_path.purge.leader_latch=/acckeeper/purge/leader_latch
# endregion
# region logicengine curator/latch-path.properties
# 任务检查服务的领导者锁路径。
com.dwarfeng.logicengine.curator.latch_path.task_check.leader_latch=/logic_engine/task_check/leader_latch
# 主管服务的领导者锁路径。
com.dwarfeng.logicengine.curator.latch_path.supervise.leader_latch=/logic_engine/supervise/leader_latch
# 清除服务的领导者锁路径。
com.dwarfeng.logicengine.curator.latch_path.purge.leader_latch=/logic_engine/purge/leader_latch
# endregion
# region audit curator/latch-path.properties
# 任务检查服务的领导者锁路径。
com.dwarfeng.audit.curator.latch_path.task_check.leader_latch=/audit/inspection_task_check/leader_latch
# 自动审计主管服务的领导者锁路径。
com.dwarfeng.audit.curator.latch_path.supervise.leader_latch=/audit/supervise/leader_latch
# 清除服务的领导者锁路径。
com.dwarfeng.audit.curator.latch_path.purge.leader_latch=/audit/purge/leader_latch
# endregion
# region fileio curator/latch-path.properties
# 驱动服务的领导者锁存的路径。
com.dwarfeng.fileio.curator.latch_path.expire_check.leader_latch=/fileio/expire_check/leader_latch
# 清除处理器的领导者锁存储的路径。
com.dwarfeng.fileio.curator.latch_path.purge.leader_latch=/fileio/purge/leader_latch
# endregion
# region voucher curator/latch-path.properties
# 清理作业的领导者锁存的路径。
com.dwarfeng.voucher.curator.latch_path.cleanup.leader_latch=/voucher/cleanup/leader_latch
# endregion
```

该配置文件为各个来源服务的领导者选举（leader latch）定义了 Zookeeper 路径，路径以 `/服务名/功能名/leader_latch`
的形式组织，以保证不同服务的领导者选举互不干扰。

如果您在本机上部署了多个项目，每个项目中都使用本服务，那么需要为每个项目配置不同的领导者锁路径，
以避免项目之间不必要的互斥。

需要特别注意的是，`com.dwarfeng.notify.curator.latch_path.purge.leader_latch` 项的路径为
`/acckeeper/purge/leader_latch`，与 `com.dwarfeng.acckeeper.curator.latch_path.purge.leader_latch` 的路径重复。
本项目对此保持既有配置，未作调整。

### mutex-prefix.properties

Curator 互斥锁前缀配置。

```properties
# region voucher curator/mutex-prefix.properties
# 设置凭证锁的路径的前缀。
com.dwarfeng.voucher.curator.mutex_prefix.voucher_lock=/voucher/voucher_lock/
# endregion
```

该配置文件为服务中按主键加锁的互斥锁定义 Zookeeper 路径前缀。互斥锁的实际路径由该前缀与主键拼接而成，
因此前缀必须以 `/` 结尾。

## database 目录

| 文件名                 | 说明               |
|------------------------|--------------------|
| connection.properties  | 数据库连接配置文件 |
| performance.properties | 数据库性能配置文件 |

### connection.properties

数据库连接配置文件，除了标准的数据库配置四要素之外，还包括 Hibernate 的方言配置。

```properties
com.dwarfeng.essentials.jdbc.driver=com.mysql.cj.jdbc.Driver
com.dwarfeng.essentials.jdbc.url=\
  jdbc:mysql://your-host-here:3306/essentials?serverTimezone=Asia/Shanghai&autoReconnect=true
com.dwarfeng.essentials.jdbc.username=root
com.dwarfeng.essentials.jdbc.password=your-password-here
com.dwarfeng.essentials.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

该项目是 1 型构型的合并项目，因此使用独立的数据库 schema，默认 schema 名称为 `essentials`。
您需要将 `com.dwarfeng.essentials.jdbc.url` 配置为部署环境中数据库的地址与 schema，
并修改 `com.dwarfeng.essentials.jdbc.username`、`com.dwarfeng.essentials.jdbc.password` 的值。

如果使用 MySQL 之外的数据库，您还需要修改 `com.dwarfeng.essentials.jdbc.driver` 与
`com.dwarfeng.essentials.hibernate.dialect` 的值。

### performance.properties

数据库性能配置文件，使用默认值即可，或按照实际情况进行修改。

```properties
# 数据库的批量写入量，设置激进的值以提高数据库的写入效率。
com.dwarfeng.essentials.hibernate.jdbc.batch_size=100
# 数据库的批量抓取量，设置激进的值以提高数据库的读取效率。
com.dwarfeng.essentials.hibernate.jdbc.fetch_size=50
# 连接池最大活动连接数量
com.dwarfeng.essentials.data_source.max_active=20
# 连接池最小空闲连接数量
com.dwarfeng.essentials.data_source.min_idle=0
```

## datamark 目录

| 文件名              | 说明               |
|---------------------|--------------------|
| settings.properties | 数据标记的配置文件 |

### settings.properties

数据标记的配置文件。

数据标记是本项目的一个运维与安全机制，它使用 `dwarfeng-datamark` 实现，其主要的功能是在重要数据插入/更改时，
向数据库特定的数据标记字段写入特定值，
这个特定值被记录在 `dwarfeng-datamark` 中的 `resource` 中 - 可以是 spring 框架支持的任何资源类型，
支持运行时修改，并对前端完全不可见。

运维人员可以用这个机制降低运维的工作量 - 尤其是从测试环境向正式环境迁移数据时，也可以用这个机制进行数据非法篡改的检测与取证。

```properties
#----------------------------------------配置说明----------------------------------------
# 数据标记资源的 URL，格式参考 Spring 资源路径。
# com.dwarfeng.essentials.datamark.xxx.resource_url=classpath:datamark/default.storage
# 数据标记资源的字符集。
# com.dwarfeng.essentials.datamark.xxx.resource_charset=UTF-8
# 数据标记服务是否允许更新。
# com.dwarfeng.essentials.datamark.xxx.update_allowed=true
#
#----------------------------------------Acckeeper.Account----------------------------------------
com.dwarfeng.essentials.datamark.acckeeper.account.resource_url=classpath:datamark/default.storage
com.dwarfeng.essentials.datamark.acckeeper.account.resource_charset=UTF-8
com.dwarfeng.essentials.datamark.acckeeper.account.update_allowed=true
#
# etc...
```

本项目为需要数据标记的实体分别定义了资源 URL、字符集与是否允许更新三个配置项，共涉及 9 个来源服务、
30 个资源段，具体如下：

| 服务        | 资源段                                                                                 |
|-------------|----------------------------------------------------------------------------------------|
| acckeeper   | Account、Protector                                                                     |
| rbacds      | User、Role、Pexp、Permission、PermissionGroup、Scope                                   |
| buddy       | User                                                                                   |
| settingrepo | SettingCategory、SettingNode                                                           |
| notify      | NotifySetting、Sender、Topic、User                                                     |
| logicengine | Section、State、DriverInfo、GuarderInfo、PerformerInfo                                 |
| audit       | AuditCategory、AuditPropertyIndicator、Inspection、InspectionDriverInfo、InspectorInfo |
| fileio      | ExportTaskSetting、ImportTaskSetting、User                                             |
| voucher     | VoucherCategory、CheckerInfo                                                           |

## dubbo 目录

| 文件名                | 说明               |
|-----------------------|--------------------|
| connection.properties | Dubbo 连接配置文件 |

### connection.properties

Dubbo 连接配置文件。

```properties
com.dwarfeng.essentials.dubbo.registry.zookeeper.address=zookeeper://your-host-here:2181
com.dwarfeng.essentials.dubbo.registry.zookeeper.timeout=3000
com.dwarfeng.essentials.dubbo.protocol.dubbo.port=20000
com.dwarfeng.essentials.dubbo.protocol.dubbo.host=your-host-here
com.dwarfeng.essentials.dubbo.protocol.hessian.port=30000
com.dwarfeng.essentials.dubbo.provider.acckeeper.group=
com.dwarfeng.essentials.dubbo.provider.rbacds.group=
com.dwarfeng.essentials.dubbo.provider.buddy.group=
com.dwarfeng.essentials.dubbo.provider.settingrepo.group=
com.dwarfeng.essentials.dubbo.provider.notify.group=
com.dwarfeng.essentials.dubbo.provider.logicengine.group=
com.dwarfeng.essentials.dubbo.provider.audit.group=
com.dwarfeng.essentials.dubbo.provider.fileio.group=
com.dwarfeng.essentials.dubbo.provider.voucher.group=
com.dwarfeng.essentials.dubbo.consumer.snowflake.group=
```

其中，`com.dwarfeng.essentials.dubbo.registry.zookeeper.address` 需要配置为 ZooKeeper 的地址，
`com.dwarfeng.essentials.dubbo.protocol.dubbo.host` 需要配置为本机的 IP 地址。

如果您需要在本机启动多个实例，那么需要为每个实例配置不同的 `com.dwarfeng.essentials.dubbo.protocol.dubbo.port` 与
`com.dwarfeng.essentials.dubbo.protocol.hessian.port`。

本项目聚合了多个来源服务，因此 provider group 按照来源服务分别配置。如果您在本机上部署了多个项目，
每个项目中都使用了本项目聚合的服务，那么需要为每个项目配置不同的 provider group，以避免微服务错误的调用。

## essentials 目录

| 文件名                | 说明                                       |
|-----------------------|--------------------------------------------|
| background.properties | 后台服务配置文件，包括线程池的线程数及其它 |
| exception.properties  | ServiceException 的异常代码的偏移量配置    |

### background.properties

后台服务配置文件，包括线程池的线程数及其它。

```properties
# 任务执行器的线程池数量范围。
com.dwarfeng.essentials.executor.pool_size=30-50
# 任务执行器的队列容量。
com.dwarfeng.essentials.executor.queue_capacity=100
# 任务执行器的保活时间（秒）。
com.dwarfeng.essentials.executor.keep_alive=120
# 计划执行器的线程池数量范围。
com.dwarfeng.essentials.scheduler.pool_size=10
```

本项目聚合了多个来源服务，各来源服务原有的任务执行器与计划执行器被合并为统一的执行器，其线程池容量按照各来源服务的配置取并集，
因此默认值大于单一来源服务。

### exception.properties

ServiceException 的异常代码的偏移量配置。

```properties
# essentials 工程自身的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset=1000
# essentials 工程中 subgrade 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.subgrade=0
# essentials 工程中 spring-telqos 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.spring_telqos=2000
# essentials 工程中 spring-terminator 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.spring_terminator=3000
# essentials 工程中 dwarfeng-datamark 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.dwarfeng_datamark=4000
# essentials 工程中 dwarfeng-ftp 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.dwarfeng_ftp=5000
# essentials 工程中 acckeeper 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.acckeeper=6000
# essentials 工程中 rbacds 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.rbacds=7000
# essentials 工程中 buddy 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.buddy=8000
# essentials 工程中 settingrepo 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.settingrepo=9000
# essentials 工程中 notify 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.notify=10000
# essentials 工程中 logicengine 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.logicengine=11000
# essentials 工程中 audit 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.audit=12000
# essentials 工程中 fileio 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.fileio=13000
# essentials 工程中 voucher 的异常代码偏移量。
com.dwarfeng.essentials.essentials.exception_code_offset.voucher=14000
```

Subgrade 框架中，会将微服务抛出的异常映射为 `ServiceException`，每个 `ServiceException` 都有一个异常代码，
用于标识异常的类型。

本项目聚合了多个来源服务，因此为每个来源服务分别配置了异常代码偏移量，
以免不同的来源服务生成异常代码相同的 `ServiceException`。

## fileio 目录

| 文件名              | 说明                                     |
|---------------------|------------------------------------------|
| launcher.properties | 启动器配置文件                           |
| purge.properties    | 清除服务的配置文件                       |
| push.properties     | 推送服务配置文件                         |
| read.properties     | 读取服务配置文件                         |
| reset.properties    | 重置服务配置文件                         |
| task.properties     | 导入/导出任务的配置文件                  |

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置导出器的支持。
com.dwarfeng.essentials.fileio.launcher.reset_exporter_support=true
#
# 程序启动完成后，是否重置导入器的支持。
com.dwarfeng.essentials.fileio.launcher.reset_importer_support=true
#
# 程序启动完成后，是否重置读取器的支持。
com.dwarfeng.essentials.fileio.launcher.reset_reader_support=true
#
# 程序启动完成后，是否重置写入器的支持。
com.dwarfeng.essentials.fileio.launcher.reset_writer_support=true
#
# 程序启动完成后，启动重置的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于0，意味着启动后立即启动重置服务。
# 该参数小于0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.fileio.launcher.start_reset_delay=30000
#
# 程序启动完成后，上线任务检查的延时时间。
# 有些数据仓库以及任务检查器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于0，意味着启动后立即上线任务检查服务。
# 该参数小于0，意味着程序不主动上线任务检查服务，需要手动上线。
com.dwarfeng.essentials.fileio.launcher.online_task_check_delay=3000
#
# 程序启动完成后，启动任务检查的延时时间。
# 有些数据仓库以及任务检查器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于0，意味着启动后立即启动任务检查服务。
# 该参数小于0，意味着程序不主动启动任务检查服务，需要手动启动。
com.dwarfeng.essentials.fileio.launcher.enable_task_check_delay=3500
#
# 程序启动完成后，上线清除的延时时间。
# 有些数据仓库以及清除处理器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于0，意味着启动后立即上线清除服务。
# 该参数小于0，意味着程序不主动上线清除服务，需要手动上线。
com.dwarfeng.essentials.fileio.launcher.online_purge_delay=4000
#
# 程序启动完成后，启动清除的延时时间。
# 有些数据仓库以及清除处理器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于0，意味着启动后立即启动清除服务。
# 该参数小于0，意味着程序不主动启动清除服务，需要手动启动。
com.dwarfeng.essentials.fileio.launcher.enable_purge_delay=4500
```

### purge.properties

清除服务的配置文件。

```properties
# 清除任务的保留时长（毫秒）。
# 结束日期距离当前系统日期超过该时长的历史数据将被清除。
# 如果设置为 0 或负数，清除计划将不启动。
com.dwarfeng.essentials.fileio.purge.retention_duration=17280000000
# 清除任务的执行周期（Cron 表达式）。
com.dwarfeng.essentials.fileio.purge.task_cron=0 0 2 * * ?
# 清除任务的最大分页大小。
# 每次查询待清除数据时的最大数量。
com.dwarfeng.essentials.fileio.purge.max_page_size=1000
# 清除任务的最大删除数量。
# 单次清除任务最多删除的数据条数。
com.dwarfeng.essentials.fileio.purge.max_deletion_size=10000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   kafka.native: 使用原生数据的基于Kafka消息队列的推送器。
#   log: 将消息输出到日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时如果希望程序加载时只加载一个推送器，可以通过编辑
# opt/opt-push.xml 文件实现。
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.fileio.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.fileio.pusher.multi.delegate_types=kafka.native
#
###################################################
#                   kafka.native                  #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.fileio.pusher.kafka.native.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 连接属性。
com.dwarfeng.essentials.fileio.pusher.kafka.native.acks=all
# 发送失败重试次数。
com.dwarfeng.essentials.fileio.pusher.kafka.native.retries=3
com.dwarfeng.essentials.fileio.pusher.kafka.native.linger=10
# 批处理缓冲区大小。
com.dwarfeng.essentials.fileio.pusher.kafka.native.buffer_memory=40960
# 批处理条数：当多个记录被发送到同一个分区时，生产者会尝试将记录合并到更少的请求中。这有助于客户端和服务器的性能。
com.dwarfeng.essentials.fileio.pusher.kafka.native.batch_size=4096
# Kafka事务的前缀。
com.dwarfeng.essentials.fileio.pusher.kafka.native.transaction_prefix=fileio.pusher.
# 导出重置时向 Kafka 发送消息的主题。
com.dwarfeng.essentials.fileio.pusher.kafka.native.topic.export_reset=fileio.pusher.export_reset
# 导入重置时向 Kafka 发送消息的主题。
com.dwarfeng.essentials.fileio.pusher.kafka.native.topic.import_reset=fileio.pusher.import_reset
# etc...
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.fileio.pusher.log.log_level=INFO
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-fileio-pusher.xml`，
决定项目中需要使用哪种推送器。您只需要修改使用的推送器的配置。

### read.properties

读取服务配置文件。

```properties
###################################################
#                      spls                       #
###################################################
# Subgrade PresetLookupService 读取器的 fastjson 值解析器 autoType 的白名单。
com.dwarfeng.essentials.fileio.reader.spls.args_resolver.fastjson.auto_type_accepts=\
  com.dwarfeng.subgrade.stack.bean.key.ByteIdKey,com.dwarfeng.subgrade.stack.bean.key.DenseUuidKey,com.dwarfeng.subgrade.stack.bean.key.IntegerIdKey,com.dwarfeng.subgrade.stack.bean.key.LongIdKey,com.dwarfeng.subgrade.stack.bean.key.StringIdKey,com.dwarfeng.subgrade.stack.bean.key.UuidKey
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 推送器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.fileio.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.fileio.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.fileio.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 推送器没有任何配置。
```

### task.properties

导入/导出任务的配置文件。

```properties
# 导出任务过期的超时时间。
com.dwarfeng.essentials.fileio.task.export.expire_timeout=3600000
# 导出任务死亡的超时时间。
com.dwarfeng.essentials.fileio.task.export.dead_timeout=3600000
# 导出任务的心跳间隔。
com.dwarfeng.essentials.fileio.task.export.beat_interval=10000
# 导人任务的超时时间。
com.dwarfeng.essentials.fileio.task.import.expire_timeout=3600000
# 导入任务死亡的超时时间。
com.dwarfeng.essentials.fileio.task.import.dead_timeout=3600000
# 导入任务的心跳间隔。
com.dwarfeng.essentials.fileio.task.import.beat_interval=10000
#
# 任务超时检查的cron表达式。
com.dwarfeng.essentials.fileio.task.check.expire_check.cron=0 * * * * ?
# 任务死亡检查的cron表达式。
com.dwarfeng.essentials.fileio.task.check.dead_check.cron=0 * * * * ?
```

## ftp 目录

| 文件名                | 说明             |
|-----------------------|------------------|
| connection.properties | FTP 连接配置文件 |
| path.properties       | FTP 路径配置文件 |

### connection.properties

FTP 连接配置文件。

```properties
# FTP 的主机名称。
com.dwarfeng.essentials.ftp.host=your-host-here
# FTP 的端口号。
com.dwarfeng.essentials.ftp.port=21
# FTP 的登录用户名。
com.dwarfeng.essentials.ftp.username=your-username-here
# FTP 的登录密码。
com.dwarfeng.essentials.ftp.password=your-password-here
# FTP 的服务点字符集。
com.dwarfeng.essentials.ftp.server_charset=UTF-8
# FTP 的连接超时时长（毫秒）。
com.dwarfeng.essentials.ftp.connect_timeout=5000
# FTP 的 noop 指令周期。
# 该值需要小于 com.dwarfeng.essentials.ftp.connect_timeout。
com.dwarfeng.essentials.ftp.noop_interval=4000
# FTP 的缓冲区大小。
com.dwarfeng.essentials.ftp.buffer_size=4096
# FTP 的临时文件目录。
com.dwarfeng.essentials.ftp.temporary_file_directory_path=temp
# FTP 临时文件的前缀。
com.dwarfeng.essentials.ftp.temporary_file_prefix=ftp-
# FTP 临时文件的后缀。
com.dwarfeng.essentials.ftp.temporary_file_suffix=.tmp
# FTP 文件拷贝功能的内存缓冲区大小。
com.dwarfeng.essentials.ftp.file_copy_memory_buffer_size=4096
# FTP 的数据连接模式。
com.dwarfeng.essentials.ftp.data_connection_mode=0
# FTP 的数据超时时间。
com.dwarfeng.essentials.ftp.data_timeout=3000
# FTP 远程主动数据连接模式下的服务主机地址。
com.dwarfeng.essentials.ftp.active_remote_data_connection_mode_server_host=your-host-here
# FTP 远程主动数据连接模式下的服务端口。
com.dwarfeng.essentials.ftp.active_remote_data_connection_mode_server_port=20
```

本项目使用 FTP 服务器存储头像、图片、文件等二进制资源，您需要将
`com.dwarfeng.essentials.ftp.host`、`com.dwarfeng.essentials.ftp.username`、
`com.dwarfeng.essentials.ftp.password` 配置为部署环境中 FTP 服务器的相关值。

### path.properties

FTP 路径配置文件。

```properties
# FTP 根路径。
#   该服务的所有文件都将存储在该路径下。
#   如果该路径包含多级目录，请使用 / 分隔，分隔符不能出现在路径的首尾。
#   解析绝对路径时会对路径的前后空字符（whitespace）进行修剪（trim）。
#   正例：
#     essentials/buddy
#     essentials/buddy/node-1
#   反例：
#     /essentials/buddy
#     essentials/buddy/node-1/
#
#----------------------------------------Buddy----------------------------------------
com.dwarfeng.essentials.ftp.root_path.buddy=essentials/buddy
#
#----------------------------------------Settingrepo----------------------------------------
com.dwarfeng.essentials.ftp.root_path.settingrepo=essentials/settingrepo
#
#----------------------------------------Fileio----------------------------------------
com.dwarfeng.essentials.ftp.root_path.fileio=essentials/fileio
```

如果您在本机上部署了多个项目，并且这些项目共用一个 FTP 服务器，那么需要为每个项目配置不同的根路径，
以避免不同项目的文件相互覆盖。

## logging 目录

| 文件名                   | 说明                                 |
|--------------------------|--------------------------------------|
| README.md                | 说明文件                             |
| settings.xml             | 日志配置的配置文件                   |
| settings-ref-linux.xml   | Linux 系统中日志配置的配置参考文件   |
| settings-ref-windows.xml | Windows 系统中日志配置的配置参考文件 |

### README.md

日志配置目录的说明文件。该文件说明了 `settings.xml` 与 `settings-ref-*.xml` 的区别，同时提供了一些配置经验。

### settings.xml

日志配置及其参考文件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <properties>
        <!--############################################### Console ###############################################-->
        <!-- 控制台输出文本的编码 -->
        <property name="console.encoding">UTF-8</property>
        <!-- 控制台输出的日志级别 -->
        <property name="console.level">INFO</property>
        <!--############################################# Rolling file ############################################-->
        <!-- 滚动文件的目录 -->
        <property name="rolling_file.dir">logs</property>
        <!-- 滚动文件的编码 -->
        <property name="rolling_file.encoding">UTF-8</property>
        <!-- 滚动文件的触发间隔（小时） -->
        <property name="rolling_file.triggering.interval">1</property>
        <!-- 滚动文件的触发大小 -->
        <property name="rolling_file.triggering.size">40MB</property>
        <!-- 滚动文件的最大数量 -->
        <property name="rolling_file.rollover.max">100</property>
        <!-- 滚动文件的删除时间 -->
        <property name="rolling_file.rollover.delete_age">7D</property>
    </properties>

    <Appenders>
        <!--############################################### Console ###############################################-->
        <Console name="std.console" target="SYSTEM_OUT" follow="true">
            <ThresholdFilter level="${console.level}" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="[%d{DEFAULT}] [%p] [%t] [%c{1.}]: %m%n" charset="${console.encoding}"/>
        </Console>
        <Async name="sync.console">
            <AppenderRef ref="std.console"/>
        </Async>
        <!--############################################# Rolling file ############################################-->
        <RollingFile
                name="std.debug.rolling_file" fileName="${rolling_file.dir}/debug.log"
                filePattern="${rolling_file.dir}/%d{yyyy-MM}/debug-%d{MM-dd-yyyy}-%i.log.gz"
        >
            <ThresholdFilter level="DEBUG" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="[%d{DEFAULT}] [%p] [%t] [%c{1.}]: %m%n" charset="${rolling_file.encoding}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="${rolling_file.triggering.interval}" modulate="true"/>
                <SizeBasedTriggeringPolicy size="${rolling_file.triggering.size}"/>
            </Policies>
            <DefaultRolloverStrategy max="${rolling_file.rollover.max}">
                <Delete basePath="${rolling_file.dir}" maxDepth="2">
                    <IfFileName glob="*/*debug*.log.gz"/>
                    <IfLastModified age="${rolling_file.rollover.delete_age}"/>
                </Delete>
            </DefaultRolloverStrategy>
        </RollingFile>
        <!-- etc... -->
    </Appenders>

    <Loggers>
        <!--############################################# Root logger #############################################-->
        <Root level="ALL">
            <appender-ref ref="sync.console"/>
            <appender-ref ref="sync.debug.rolling_file"/>
            <appender-ref ref="sync.info.rolling_file"/>
            <appender-ref ref="sync.warn.rolling_file"/>
            <appender-ref ref="sync.error.rolling_file"/>
        </Root>
    </Loggers>
</Configuration>
```

需要注意的是，日志配置 **必须** 定义在 `settings.xml` 中才能生效，所有的 `settings-ref-xxx.xml` 都是参考文件，
在这些文件中进行任何配置的修改 **均不会生效**。

常用的做法是，针对不同的操作系统，将参考文件中的内容直接复制到 `settings.xml` 中，随后对 `settings.xml` 中的内容进行修改。

- 如果服务运行一天产生的日志超过了配置上限，可上调 `rolling_file.rollover.max` 参数。
- 如果存在等保需求，日志至少需要保留 6 个月，需要调整 `rolling_file.rollover.delete_age` 参数至 `200D`。

### settings-ref-linux.xml

Linux 系统中的日志配置参考文件。相对于默认的 `settings.xml`，该参考文件将滚动日志目录配置为
`/var/log/dwarfeng-essentials`。

### settings-ref-windows.xml

Windows 系统中的日志配置参考文件。相对于默认的 `settings.xml`，该参考文件将控制台输出文本的编码配置为 `GBK`。

## logic-engine 目录

| 文件名                | 说明                 |
|-----------------------|----------------------|
| consume.properties    | 消费服务配置文件     |
| dispatch.properties   | 调度器的配置文件     |
| driver.properties     | 驱动器的配置文件     |
| launcher.properties   | 启动器配置文件       |
| purge.properties      | 清除服务的配置文件   |
| push.properties       | 推送服务配置文件     |
| receive.properties    | 接收器的配置文件     |
| reset.properties      | 重置服务配置文件     |
| task.properties       | 任务的配置文件       |

### consume.properties

消费服务配置文件。

```properties
# 当消费者中的待消费元素超过缓存上限指定比例后，向日志中输入警告信息。
com.dwarfeng.essentials.logicengine.consume.threshold.warn=0.8
# 消费者线程数：线程数越大，处理的能力越强，服务器负荷越重。
com.dwarfeng.essentials.logicengine.consume.consumer_thread=1
# 缓存大小：缓存越大抗波动能力越强，数据实时性越低。
# 当缓存被占满时，会导致消费者阻塞，此时如果 rpc 的超时设置不当，容易引起数据重复提交或者丢失的问题。
# 数据占满缓存这一现象是需要尽力避免的，程序将在缓存占用量超过指定值的时候发出警报。
com.dwarfeng.essentials.logicengine.consume.buffer_size=1000
```

### dispatch.properties

调度器的配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的调度器类型。
# 目前该项目支持的调度器类型有:
#   drain: 丢弃所有调度请求并记录日志的调度器，用于测试和调试。
#   injvm: 虚拟机内部调度器，用于单节点服务。
#   kafka: 基于 Kafka 实现的调度器，利用 Kafka 消费组机制实现多个接收节点的负载均衡。
#   dubbo: 基于 Dubbo 实现的调度器，利用服务提供者机制实现多个接收节点的负载均衡。
#
# 对于一个具体的项目，很可能只使用一个调度器。此时如果希望程序加载时只加载一个调度器，可以通过编辑
# opt/opt-dispatcher.xml 文件实现。
com.dwarfeng.essentials.logicengine.dispatcher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 调度器没有任何配置。
#
###################################################
#                      injvm                      #
###################################################
# injvm 调度器没有任何配置。
#
###################################################
#                      kafka                      #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 生产者与服务器的确认模式，可选值为: 0、1、all。
#   0: 生产者不等待服务器确认，继续发送下一条消息。
#   1: 生产者等待首领副本确认，继续发送下一条消息。
#   all: 生产者等待服务器及其所有同步副本确认，继续发送下一条消息。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.acks=all
# 发送失败重试次数，acks 设置为 0 时不生效。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.retries=3
# 生产者在发送批处理前等待更多消息加入批处理的时间，单位为毫秒。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.linger=10
# 生产者可用于缓冲待发送记录的内存总量，单位为字节。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.buffer_memory=40960
# 同一分区发送批次的目标大小，单位为字节。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.batch_size=4096
# Kafka 事务 ID 前缀，同一 Kafka 集群中的不同应用实例应使用不同前缀。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.transaction_prefix=logic_engine.dispatcher.
# 负载均衡策略，可选值为: default、round_robin、random。
#   default: 使用 Kafka 生产者默认分区策略。
#   round_robin: 按当前主题分区列表轮询发送。
#   random: 从当前主题分区列表中随机选择分区发送。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.load_balance_mode=default
# 刷新主题分区信息的间隔时间，单位为毫秒。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.partition_check_interval=30000
# 执行调度时向 Kafka 发送消息的主题，应与 Kafka 接收器监听的主题保持一致。
com.dwarfeng.essentials.logicengine.dispatcher.kafka.topic.dispatch=logic_engine.dispatcher.dispatch
#
###################################################
#                      dubbo                      #
###################################################
# dubbo 调度器没有任何独立配置，使用 dubbo/connection.properties 中的注册中心和提供者分组配置。
```

### driver.properties

驱动器的配置文件。

```properties
###################################################
#                      cron                       #
###################################################
# Cron 驱动没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# FixedDelay 驱动没有任何配置。
#
###################################################
#                    fixed_rate                   #
###################################################
# FixedRate 驱动没有任何配置。
#
###################################################
#                    kafka.dcti                   #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 会话的超时限制: 如果 consumer 在这段时间内没有发送心跳信息，一次 rebalance 将会产生。
# 该值必须在[group.min.session.timeout.ms, group.max.session.timeout.ms]范围内，默认: 10000。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.session_timeout_ms=10000
# 新的 group 加入 topic 时，从什么位置开始消费。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.auto_offset_reset=latest
# 监听器启用的消费者的线程数。
# 每一个线程都会启动一个 KafkaConsumer，每个 KafkaConsumer 都会占用一个 partition。
# 程序分布式部署时，所有节点的线程数之和应该小于等于 topic 的 partition 数。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.concurrency=2
# 监听器调用 KafkaConsumer.poll(Duration) 方法的超时时间，如果超过这个时间还没有拉取到数据，则返回空列表。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.poll_timeout=3000
# 监听器的 id，每一个节点的监听器 id 都应与该节点的其它 kafka 监听器的 id 不同。
# 该设置会覆盖 kafka 的 group.id 设置，因此无需设置 group.id。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.listener_id=logicengine.driver.dcti
# 监听器的目标 topic。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.listener_topic=dcti.data_info
# 监听器的最大拉取数据量。当拉取到的数据量达到这个值时，会立即返回，不会等待 poll_timeout。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.max_poll_records=100
# 监听器的最大拉取间隔。如果当前时间距离监听器上一次拉取数据的时间超过了这个值，一次 rebalance 将会产生。
com.dwarfeng.essentials.logicengine.driver.kafka.dcti.max_poll_interval_ms=300000
```

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置执行器支持。
com.dwarfeng.essentials.logicengine.launcher.reset_performer_support=true
#
# 程序启动完成后，是否重置守卫器支持。
com.dwarfeng.essentials.logicengine.launcher.reset_guarder_support=true
#
# 程序启动完成后，是否重置驱动器支持。
com.dwarfeng.essentials.logicengine.launcher.reset_driver_support=true
#
# 程序启动完成后，上线任务检查的延时时间。
# 有些数据仓库以及任务检查器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即上线任务检查服务。
# 该参数小于 0，意味着程序不主动上线任务检查服务，需要手动上线。
com.dwarfeng.essentials.logicengine.launcher.online_task_check_delay=3000
# 程序启动完成后，启动任务检查的延时时间。
# 有些数据仓库以及任务检查器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动任务检查服务。
# 该参数小于 0，意味着程序不主动启动任务检查服务，需要手动启动。
com.dwarfeng.essentials.logicengine.launcher.enable_task_check_delay=3500
#
# 程序启动完成后，启动接收的延时时间。
# 有些数据仓库以及接收处理器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动接收服务。
# 该参数小于 0，意味着程序不主动启动接收服务，需要手动启动。
com.dwarfeng.essentials.logicengine.launcher.start_receive_delay=4000
#
# 程序启动完成后，上线主管的延时时间。
# 该参数等于 0，意味着启动后立即上线主管服务。
# 该参数小于 0，意味着程序不主动上线主管服务，需要手动上线。
com.dwarfeng.essentials.logicengine.launcher.online_supervise_delay=4500
# 程序启动完成后，启动主管的延时时间。
# 该参数等于 0，意味着启动后立即启动主管服务。
# 该参数小于 0，意味着程序不主动启动主管服务，需要手动启动。
com.dwarfeng.essentials.logicengine.launcher.enable_supervise_delay=5000
#
# 程序启动完成后，上线清除服务的延时时间。
# 该参数等于 0，意味着启动后立即上线清除服务。
# 该参数小于 0，意味着程序不主动上线清除服务，需要手动上线。
com.dwarfeng.essentials.logicengine.launcher.online_purge_delay=5500
# 程序启动完成后，启动清除服务的延时时间。
# 该参数等于 0，意味着启动后立即启动清除服务。
# 该参数小于 0，意味着程序不主动启动清除服务，需要手动启动。
com.dwarfeng.essentials.logicengine.launcher.enable_purge_delay=6000
#
# 程序启动完成后，启动重置服务的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善地处理这些数据源和重置器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.logicengine.launcher.start_reset_delay=30000
```

### purge.properties

清除服务的配置文件。

```properties
# 清除任务的保留时长（毫秒）。
# 发生日期距离当前系统日期超过该时长的历史数据将被清除。
# 如果设置为 0 或负数，清除计划将不启动。
com.dwarfeng.essentials.logicengine.purge.retention_duration=17280000000
# 清除任务的执行周期（Cron 表达式）。
com.dwarfeng.essentials.logicengine.purge.task_cron=0 0 2 * * ?
# 清除任务的最大分页大小。
# 每次查询待清除数据时的最大数量。
com.dwarfeng.essentials.logicengine.purge.max_page_size=1000
# 清除任务的最大删除数量。
# 单次清除任务最多删除的数据条数。
com.dwarfeng.essentials.logicengine.purge.max_deletion_size=10000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 丢弃所有推送事件的推送器，用于不需要对外推送的场景。
#   log: 将推送事件输出至日志的推送器，用于测试和调试。
#   multi: 将推送事件依次发送给多个代理推送器。
#   kafka.native: 使用独立 Kafka 生产者发送推送事件的推送器。
#
# 对于一个具体的项目，很可能只使用一个推送器。此时如果希望程序加载时只加载一个推送器，可以通过编辑
# opt/opt-pusher.xml 文件实现。
com.dwarfeng.essentials.logicengine.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理推送器类型，多个推送器之间以逗号分隔。
com.dwarfeng.essentials.logicengine.pusher.multi.delegate_types=drain
#
###################################################
#                   kafka.native                  #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 生产者与服务器的确认模式，可选值为: 0、1、all。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.acks=all
# 发送失败重试次数，acks 设置为 0 时不生效。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.retries=3
# 生产者在发送批处理前等待更多消息加入批处理的时间，单位为毫秒。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.linger=10
# 生产者可用于缓冲待发送记录的内存总量，单位为字节。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.buffer_memory=40960
# 同一分区发送批次的目标大小，单位为字节。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.batch_size=4096
# Kafka 事务 ID 前缀，同一 Kafka 集群中的不同应用实例应使用不同前缀。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.transaction_prefix=logic_engine.pusher.
# 各类推送事件对应的 Kafka 主题。
com.dwarfeng.essentials.logicengine.pusher.kafka.native.topic.task_finished=logic_engine.pusher.task_finished
com.dwarfeng.essentials.logicengine.pusher.kafka.native.topic.task_failed=logic_engine.pusher.task_failed
# etc...
#
###################################################
#                       log                       #
###################################################
# 推送日志的等级，可选值为 TRACE、DEBUG、INFO、WARN、ERROR。
com.dwarfeng.essentials.logicengine.pusher.log.log_level=INFO
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-logicengine-pusher.xml`，
决定项目中需要使用哪种推送器。您只需要修改使用的推送器的配置。

### receive.properties

接收器的配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的接收器类型。
# 目前该项目支持的接收器类型有:
#   do_nothing: 什么也不做的接收器，用于测试。
#   injvm: 虚拟机内部接收器，用于单节点服务。
#   kafka: 基于 Kafka 实现的接收器，利用 Kafka 的消费者机制实现多个接收节点的负载均衡。
#   dubbo: 基于 Dubbo 实现的接收器，利用 Dubbo 的服务提供者机制实现多个接收节点的负载均衡。
#
# 对于一个具体的项目，很可能只用一个接收器。此时如果希望程序加载时只加载一个接收器，可以通过编辑
# opt/opt-receiver.xml 文件实现。
com.dwarfeng.essentials.logicengine.receiver.type=do_nothing
#
###################################################
#                   do_nothing                    #
###################################################
# do_nothing 接收器没有任何配置。
#
###################################################
#                      injvm                      #
###################################################
# injvm 接收器没有任何配置。
#
###################################################
#                      kafka                      #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.logicengine.receiver.kafka.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 会话的超时限制: 如果 consumer 在这段时间内没有发送心跳信息，一次 rebalance 将会产生。
# 该值必须在[group.min.session.timeout.ms, group.max.session.timeout.ms]范围内，默认: 10000。
com.dwarfeng.essentials.logicengine.receiver.kafka.session_timeout_ms=10000
# 新的 group 加入 topic 时，从什么位置开始消费。
com.dwarfeng.essentials.logicengine.receiver.kafka.auto_offset_reset=latest
# 监听器启用的消费者的线程数。
# 每一个线程都会启动一个 KafkaConsumer，每个 KafkaConsumer 都会占用一个 partition。
# 程序分布式部署时，所有节点的线程数之和应该小于等于 topic 的 partition 数。
com.dwarfeng.essentials.logicengine.receiver.kafka.concurrency=1
# 监听器调用 KafkaConsumer.poll(Duration) 方法的超时时间，如果超过这个时间还没有拉取到数据，则返回空列表。
com.dwarfeng.essentials.logicengine.receiver.kafka.poll_timeout=3000
# 监听器的 id，每一个节点的监听器 id 都应与该节点的其它 kafka 监听器的 id 不同。
com.dwarfeng.essentials.logicengine.receiver.kafka.listener_id=logic_engine.receiver
# 监听器的目标 topic。
com.dwarfeng.essentials.logicengine.receiver.kafka.listener_topic=logic_engine.dispatcher.dispatch
# 监听器的最大拉取数据量。当拉取到的数据量达到这个值时，会立即返回，不会等待 poll_timeout。
com.dwarfeng.essentials.logicengine.receiver.kafka.max_poll_records=100
# 监听器的最大拉取间隔。如果当前时间距离监听器上一次拉取数据的时间超过了这个值，一次 rebalance 将会产生。
com.dwarfeng.essentials.logicengine.receiver.kafka.max_poll_interval_ms=300000
#
###################################################
#                      dubbo                      #
###################################################
# dubbo 接收器没有任何配置。
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 重置器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.logicengine.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.logicengine.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.logicengine.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 重置器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-logicengine-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

### task.properties

任务的配置文件。

```properties
# 任务心跳死亡的全局超时时间。
com.dwarfeng.essentials.logicengine.task.die_timeout=3600000
# 任务心跳周期。
com.dwarfeng.essentials.logicengine.task.beat_interval=10000
#
# 任务过期检查 cron 表达式。
com.dwarfeng.essentials.logicengine.task.check.expire_check.cron=0 * * * * ?
# 任务死亡检查 cron 表达式。
com.dwarfeng.essentials.logicengine.task.check.die_check.cron=0 * * * * ?
```

## notify 目录

| 文件名              | 说明               |
|---------------------|--------------------|
| launcher.properties | 启动器配置文件     |
| purge.properties    | 清除服务的配置文件 |
| push.properties     | 推送服务配置文件   |
| reset.properties    | 重置服务配置文件   |

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置路由器支持。
com.dwarfeng.essentials.notify.launcher.reset_router_support=true
# 程序启动完成后，是否重置发送器支持。
com.dwarfeng.essentials.notify.launcher.reset_sender_support=true
# 程序启动完成后，是否重置调度器支持。
com.dwarfeng.essentials.notify.launcher.reset_dispatcher_support=true
# 程序启动完成后，启动重置的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.notify.launcher.start_reset_delay=30000
#
# 程序启动完成后，上线清除的延时时间。
# 有些数据仓库以及清除器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即上线清除服务。
# 该参数小于 0，意味着程序不主动上线清除服务，需要手动上线。
com.dwarfeng.essentials.notify.launcher.online_purge_delay=4000
# 程序启动完成后，启动清除的延时时间。
# 有些数据仓库以及清除器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动清除服务。
# 该参数小于 0，意味着程序不主动启动清除服务，需要手动启动。
com.dwarfeng.essentials.notify.launcher.enable_purge_delay=4500
```

### purge.properties

清除服务的配置文件。

```properties
# 清除任务的保留时长（毫秒）。
# 发生日期距离当前系统日期超过该时长的数据将被清除。
# 如果设置为 0 或负数，清除计划将不启动。
com.dwarfeng.essentials.notify.purge.retention_duration=17280000000
# 清除任务的执行周期（Cron 表达式）。
com.dwarfeng.essentials.notify.purge.task_cron=0 0 2 * * ?
# 清除任务的最大分页大小。
# 每次查询待清除数据时的最大数量。
com.dwarfeng.essentials.notify.purge.max_page_size=1000
# 清除任务的最大删除数量。
# 单次清除任务最多删除的数据条数。
com.dwarfeng.essentials.notify.purge.max_deletion_size=10000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   log: 将时间格式化后打印至日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时希望加载
# 推送器时只加载需要的那个，其余的推送器不加载。这个需求
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.notify.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.notify.pusher.multi.delegate_types=drain
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.notify.pusher.log.log_level=INFO
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 推送器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.notify.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.notify.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.notify.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      kafka                      #
###################################################
# Broker 集群。
com.dwarfeng.essentials.notify.resetter.kafka.bootstrap_servers=your-host-here:9092
# 会话的超时限制：如果 consumer 在这段时间内没有发送心跳信息，则认为其已经挂掉，一次 rebalance 将会产生。
# 该值必须在[group.min.session.timeout.ms, group.max.session.timeout.ms]范围内，默认：10000。
com.dwarfeng.essentials.notify.resetter.kafka.session_timeout_ms=10000
# 监听器的 id（不同实例的监听器的 id 必须不同！）。
com.dwarfeng.essentials.notify.resetter.kafka.listener_id=notify.01
# topic 各分区都存在已提交的 offset 时，从 offset 后开始消费；只要有一个分区不存在已提交的 offset，则抛出异常。
com.dwarfeng.essentials.notify.resetter.kafka.auto_offset_reset=latest
# dcti.kafka 消费者的线程数。
com.dwarfeng.essentials.notify.resetter.kafka.concurrency=1
# dcti.kafka 消费者调用 poll 方法的超时时间。
com.dwarfeng.essentials.notify.resetter.kafka.poll_timeout=3000
# 监听器的最大拉取数据量。
com.dwarfeng.essentials.notify.resetter.kafka.max_poll_records=100
# 监听器的最大拉取间隔。
com.dwarfeng.essentials.notify.resetter.kafka.max_poll_interval_ms=1000
# 监听 Topic。
com.dwarfeng.essentials.notify.resetter.kafka.topic=notify.reset
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 推送器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-notify-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

## rbacds 目录

| 文件名                 | 说明             |
|------------------------|------------------|
| launcher.properties    | 启动器配置文件   |
| local-cache.properties | 本地缓存配置文件 |
| push.properties        | 推送服务配置文件 |
| reset.properties       | 重置服务配置文件 |

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置过滤器支持。
com.dwarfeng.essentials.rbacds.launcher.reset_filter_support=true
#
# 程序启动完成后，启动重置的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.rbacds.launcher.start_reset_delay=30000
```

### local-cache.properties

本地缓存配置文件。

```properties
# 权限分析用户分析结果本地缓存的 ttl，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.permission_user_analysis.ttl=3600000
# 权限分析用户分析结果本地缓存的清理间隔，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.permission_user_analysis.cleanup_interval=600000
#
# 用户权限分析结果本地缓存的 ttl，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.scoped_user_permission_analysis.ttl=3600000
# 用户权限分析结果本地缓存的清理间隔，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.scoped_user_permission_analysis.cleanup_interval=600000
#
# 用户权限分析结果本地缓存的 ttl，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.user_role_analysis.ttl=3600000
# 用户权限分析结果本地缓存的清理间隔，单位为毫秒。
com.dwarfeng.essentials.rbacds.local_cache.user_role_analysis.cleanup_interval=600000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   log: 将消息输出到日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时如果希望程序加载时只加载一个推送器，可以通过编辑
# opt/opt-push.xml 文件实现。
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.rbacds.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.rbacds.pusher.multi.delegate_types=log
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.rbacds.pusher.log.log_level=INFO
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 重置器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.rbacds.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.rbacds.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.rbacds.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 重置器没有任何配置。
```

## redis 目录

| 文件名                         | 说明                                         |
|--------------------------------|----------------------------------------------|
| connection.properties          | Redis 连接配置                               |
| prefix-acckeeper.properties    | acckeeper 服务 9 个实体的缓存主键前缀配置    |
| prefix-audit.properties        | audit 服务 14 个实体的缓存主键前缀配置       |
| prefix-buddy.properties        | buddy 服务 4 个实体的缓存主键前缀配置        |
| prefix-fileio.properties       | fileio 服务 21 个实体的缓存主键前缀配置      |
| prefix-logicengine.properties  | logicengine 服务 11 个实体的缓存主键前缀配置 |
| prefix-notify.properties       | notify 服务 14 个实体的缓存主键前缀配置      |
| prefix-rbacds.properties       | rbacds 服务 8 个实体的缓存主键前缀配置       |
| prefix-settingrepo.properties  | settingrepo 服务 19 个实体的缓存主键前缀配置 |
| prefix-voucher.properties      | voucher 服务 6 个实体的缓存主键前缀配置      |
| timeout-acckeeper.properties   | acckeeper 服务 9 个实体的缓存超时配置        |
| timeout-audit.properties       | audit 服务 14 个实体的缓存超时配置           |
| timeout-buddy.properties       | buddy 服务 4 个实体的缓存超时配置            |
| timeout-fileio.properties      | fileio 服务 21 个实体的缓存超时配置          |
| timeout-logicengine.properties | logicengine 服务 11 个实体的缓存超时配置     |
| timeout-notify.properties      | notify 服务 14 个实体的缓存超时配置          |
| timeout-rbacds.properties      | rbacds 服务 9 个实体的缓存超时配置           |
| timeout-settingrepo.properties | settingrepo 服务 19 个实体的缓存超时配置     |
| timeout-voucher.properties     | voucher 服务 6 个实体的缓存超时配置          |

本项目聚合了多个来源服务，因此原有的单一 `prefix.properties` 与 `timeout.properties` 被拆分为
每个来源服务各一份的配置文件：`prefix-<服务别名>.properties` 与 `timeout-<服务别名>.properties`。

### connection.properties

Redis 连接配置文件。

```properties
# ip 地址。
com.dwarfeng.essentials.redis.hostName=your-host-here
# 端口号。
com.dwarfeng.essentials.redis.port=6379
# 如果有密码。
com.dwarfeng.essentials.redis.password=your-password-here
# 客户端超时时间单位是毫秒 默认是 2000。
com.dwarfeng.essentials.redis.timeout=10000
# 最大空闲数。
com.dwarfeng.essentials.redis.maxIdle=300
# 连接池的最大数据库连接数。设为 0 表示无限制，如果是 jedis 2.4 以后用 redis.maxTotal。
# com.dwarfeng.essentials.redis.maxActive=600
# 控制一个 pool 可分配多少个 jedis 实例，用来替换上面的 redis.maxActive，如果是 jedis 2.4 以后用该属性。
com.dwarfeng.essentials.redis.maxTotal=1000
# 最大建立连接等待时间。如果超过此时间将接到异常。设为-1 表示无限制。
com.dwarfeng.essentials.redis.maxWaitMillis=1000
# 连接的最小空闲时间 默认 1800000 毫秒(30 分钟)。
com.dwarfeng.essentials.redis.minEvictableIdleTimeMillis=300000
# 每次释放连接的最大数目，默认 3。
com.dwarfeng.essentials.redis.numTestsPerEvictionRun=1024
# 逐出扫描的时间间隔(毫秒) 如果为负数，则不运行逐出线程， 默认 -1。
com.dwarfeng.essentials.redis.timeBetweenEvictionRunsMillis=30000
# 是否在从池中取出连接前进行检验，如果检验失败，则从池中去除连接并尝试取出另一个。
com.dwarfeng.essentials.redis.testOnBorrow=true
# 在空闲时检查有效性， 默认 false。
com.dwarfeng.essentials.redis.testWhileIdle=true
```

### prefix-acckeeper.properties

acc keeper 服务的实体缓存主键前缀配置，共 9 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 用户对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.acckeeper.account=com.dwarfeng.acckeeper.entity.account.
# 登录状态对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.acckeeper.login_state=com.dwarfeng.acckeeper.entity.login_state.
# etc...
```

### prefix-audit.properties

audit 服务的实体缓存主键前缀配置，共 14 个实体。需要注意的是，该文件的写法与其它服务不同：
其中 4 个审计实体使用 `com.dwarfeng.essentials.cache.prefix.entity.audit.*` 键，另外 10 个自动审计相关实体
使用未加项目前缀的 `cache.prefix.entity.*` 键，键值也相对简短。

```properties
#------------------------------------------------------------------------------------
# 缓存键前缀配置。
#------------------------------------------------------------------------------------
# 审计类别的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.audit.audit_category=com.dwarfeng.audit.entity.audit_category.
# 审计属性指示器的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.audit.audit_property_indicator=\
  com.dwarfeng.audit.entity.audit_property_indicator.
# etc...
```

### prefix-buddy.properties

buddy 服务的实体缓存主键前缀配置，共 4 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 头像信息的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.buddy.avatar_info=com.dwarfeng.buddy.entity.avatar_info.
# 通知的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.buddy.notification=com.dwarfeng.buddy.entity.notification.
# etc...
```

### prefix-fileio.properties

fileio 服务的实体缓存主键前缀配置，共 21 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 导出配置对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.fileio.export_conf=com.dwarfeng.fileio.entity.export_conf.
# 导出器信息对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.fileio.exporter_info=com.dwarfeng.fileio.entity.exporter_info.
# etc...
```

### prefix-logicengine.properties

logicengine 服务的实体缓存主键前缀配置，共 11 个实体。

```properties
#------------------------------------------------------------------------------------
# 缓存键前缀配置。
#------------------------------------------------------------------------------------
# 部件缓存键前缀。
com.dwarfeng.essentials.cache.prefix.entity.logicengine.section=com.dwarfeng.logicengine.entity.section.
# 状态缓存键前缀。
com.dwarfeng.essentials.cache.prefix.entity.logicengine.state=com.dwarfeng.logicengine.entity.state.
# etc...
```

### prefix-notify.properties

notify 服务的实体缓存主键前缀配置，共 14 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 用户对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.notify.user=com.dwarfeng.notify.entity.user.
# 路由器信息对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.notify.router_info=com.dwarfeng.notify.entity.router_info.
# etc...
```

### prefix-rbacds.properties

rbacds 服务的实体缓存主键前缀配置，共 8 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 用户对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.rbacds.user=com.dwarfeng.rbacds.entity.user.
# 角色对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.rbacds.role=com.dwarfeng.rbacds.entity.role.
# etc...
```

### prefix-settingrepo.properties

settingrepo 服务的实体缓存主键前缀配置，共 19 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 格式化器支持对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.settingrepo.formatter_support=\
  com.dwarfeng.settingrepo.entity.formatter_support.
# 设置类别对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.settingrepo.setting_category=\
  com.dwarfeng.settingrepo.entity.setting_category.
# etc...
```

### prefix-voucher.properties

voucher 服务的实体缓存主键前缀配置，共 6 个实体。

```properties
#------------------------------------------------------------------------------------
#  缓存时实体的键的格式
#------------------------------------------------------------------------------------
# 检查器信息对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.voucher.checker_info=com.dwarfeng.voucher.entity.checker_info.
# 检查器支持对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.voucher.checker_support=com.dwarfeng.voucher.entity.checker_support.
# etc...
```

Redis 利用这些配置文件，为缓存的主键添加前缀，以示区分。

如果您的项目包含其它使用 Redis 的模块，您可以修改这些配置文件，以避免不同项目的同名实体前缀冲突，相互覆盖。

一个典型的前缀更改方式是在前缀的头部添加项目的名称，如：

```properties
# 用户对象的主键格式。
com.dwarfeng.essentials.cache.prefix.entity.acckeeper.account=essentials.acckeeper.entity.account.
```

### timeout-acckeeper.properties

acc keeper 服务的实体缓存超时配置，共 9 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 用户对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.acckeeper.account=3600000
# 登录状态对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.acckeeper.login_state=3600000
# etc...
```

### timeout-audit.properties

audit 服务的实体缓存超时配置，共 14 个实体。与 `prefix-audit.properties` 相同，该文件中 4 个审计实体使用
`com.dwarfeng.essentials.cache.timeout.entity.audit.*` 键，另外 10 个自动审计相关实体使用未加项目前缀的
`cache.timeout.entity.*` 键。

```properties
#------------------------------------------------------------------------------------
# 缓存超时配置。
#------------------------------------------------------------------------------------
# 审计类别对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.audit.audit_category=3600000
# 审计属性指示器对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.audit.audit_property_indicator=3600000
# etc...
```

### timeout-buddy.properties

buddy 服务的实体缓存超时配置，共 4 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 头像信息对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.buddy.avatar_info=3600000
# 通知对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.buddy.notification=3600000
# etc...
```

### timeout-fileio.properties

fileio 服务的实体缓存超时配置，共 21 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 导出配置对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.fileio.export_conf=3600000
# 导出器信息对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.fileio.exporter_info=3600000
# etc...
```

### timeout-logicengine.properties

logicengine 服务的实体缓存超时配置，共 11 个实体。

```properties
#------------------------------------------------------------------------------------
# 缓存超时配置。
#------------------------------------------------------------------------------------
# 部件对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.logicengine.section=3600000
# 状态对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.logicengine.state=3600000
# etc...
```

### timeout-notify.properties

notify 服务的实体缓存超时配置，共 14 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 用户对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.notify.user=3600000
# 路由器信息对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.notify.router_info=3600000
# etc...
```

### timeout-rbacds.properties

rbacds 服务的实体缓存超时配置，共 9 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 用户对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.rbacds.user=3600000
# 角色对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.rbacds.role=3600000
# etc...
```

### timeout-settingrepo.properties

settingrepo 服务的实体缓存超时配置，共 19 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 格式化器支持对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.settingrepo.formatter_support=3600000
# 设置类别对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.settingrepo.setting_category=3600000
# etc...
```

### timeout-voucher.properties

voucher 服务的实体缓存超时配置，共 6 个实体。

```properties
#------------------------------------------------------------------------------------
#  实体缓存时的超时时间
#------------------------------------------------------------------------------------
# 检查器信息对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.voucher.checker_info=3600000
# 检查器支持对象缓存的超时时间。
com.dwarfeng.essentials.cache.timeout.entity.voucher.checker_support=3600000
# etc...
```

如果您希望缓存更快或更慢地过期，您可以修改这些配置文件。

## settingrepo 目录

| 文件名                     | 说明                 |
|----------------------------|----------------------|
| iahn.properties            | 国际化节点的配置文件 |
| image-thumbnail.properties | 图片缩略图的配置文件 |
| launcher.properties        | 启动器配置文件       |
| navigation.properties      | 导航节点的配置文件   |
| push.properties            | 推送服务配置文件     |
| reset.properties           | 重置服务配置文件     |

### iahn.properties

国际化节点的配置文件。

```properties
# 国际化节点地区映射缓存的前缀。
com.dwarfeng.essentials.settingrepo.iahn.cache.prefix.locale_map=com.dwarfeng.settingrepo.iahn.cache.locale_map.
# 国际化节点地区映射缓存的超时时间。
com.dwarfeng.essentials.settingrepo.iahn.cache.timeout.locale_map=3600000
#
# 国际化节点消息映射缓存的前缀。
com.dwarfeng.essentials.settingrepo.iahn.cache.prefix.message_map=com.dwarfeng.settingrepo.iahn.cache.message_map.
# 国际化节点消息映射缓存的超时时间。
com.dwarfeng.essentials.settingrepo.iahn.cache.timeout.message_map=3600000
```

### image-thumbnail.properties

图片缩略图的配置文件。

```properties
# 图片缩略图的宽度。
com.dwarfeng.essentials.settingrepo.image_thumbnail.width=980
# 图片缩略图的高度。
com.dwarfeng.essentials.settingrepo.image_thumbnail.height=540
# 图片缩略图的质量。
com.dwarfeng.essentials.settingrepo.image_thumbnail.quality=0.5
# 图片缩略图的输出格式。
com.dwarfeng.essentials.settingrepo.image_thumbnail.output_format=jpg
```

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置格式化器支持。
com.dwarfeng.essentials.settingrepo.launcher.reset_formatter_support=true
# 程序启动完成后，启动重置的延时时间。
# 有些数据仓库以及重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些数据源和推送器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.settingrepo.launcher.start_reset_delay=30000
```

### navigation.properties

导航节点的配置文件。

```properties
# 导航节点查询结果缓存的前缀。
com.dwarfeng.essentials.settingrepo.navigation.cache.prefix.inspect_result=\
  com.dwarfeng.settingrepo.navigation.cache.inspect_result.
# 导航节点查询结果缓存的超时时间。
com.dwarfeng.essentials.settingrepo.navigation.cache.timeout.inspect_result=3600000
#
# 导航节点索引格式化的起始值。
com.dwarfeng.essentials.settingrepo.navigation.format.start_index=10
# 导航节点索引格式化的步长。
com.dwarfeng.essentials.settingrepo.navigation.format.index_step=10
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   log: 将时间格式化后打印至日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时希望加载
# 推送器时只加载需要的那个，其余的推送器不加载。这个需求
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.settingrepo.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.settingrepo.pusher.multi.delegate_types=drain
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.settingrepo.pusher.log.log_level=INFO
```

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 重置器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.settingrepo.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.settingrepo.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.settingrepo.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      kafka                      #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.settingrepo.resetter.kafka.bootstrap_servers=your-host-here:9092
# 会话的超时限制: 如果 consumer 在这段时间内没有发送心跳信息，一次 rebalance 将会产生。
# 该值必须在[group.min.session.timeout.ms, group.max.session.timeout.ms]范围内，默认: 10000。
com.dwarfeng.essentials.settingrepo.resetter.kafka.session_timeout_ms=10000
# 监听器的 id，每一个节点的监听器 id 都应与该节点的其它 kafka 监听器的 id 不同。
# 该设置会覆盖 kafka 的 group.id 设置，因此无需设置 group.id。
# 不同实例的监听器的 id 必须不同。
com.dwarfeng.essentials.settingrepo.resetter.kafka.listener_id=settingrepo.01
# 新的 group 加入 topic 时，从什么位置开始消费。
com.dwarfeng.essentials.settingrepo.resetter.kafka.auto_offset_reset=latest
# 监听器启用的消费者的线程数。
# 每一个线程都会启动一个 KafkaConsumer，每个 KafkaConsumer 都会占用一个 partition。
# 程序分布式部署时，所有节点的线程数之和应该小于等于 topic 的 partition 数。
com.dwarfeng.essentials.settingrepo.resetter.kafka.concurrency=1
# 监听器调用 KafkaConsumer.poll(Duration) 方法的超时时间，如果超过这个时间还没有拉取到数据，则返回空列表。
com.dwarfeng.essentials.settingrepo.resetter.kafka.poll_timeout=3000
# 监听器的最大拉取数据量。当拉取到的数据量达到这个值时，会立即返回，不会等待 poll_timeout。
com.dwarfeng.essentials.settingrepo.resetter.kafka.max_poll_records=100
# 监听器的最大拉取间隔。如果当前时间距离监听器上一次拉取数据的时间超过了这个值，一次 rebalance 将会产生。
com.dwarfeng.essentials.settingrepo.resetter.kafka.max_poll_interval_ms=1000
# 监听器的目标 topic。
com.dwarfeng.essentials.settingrepo.resetter.kafka.topic=settingrepo.reset
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 重置器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-settingrepo-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

## telqos 目录

| 文件名                | 说明     |
|-----------------------|----------|
| connection.properties | 连接配置 |

### connection.properties

Telqos 连接配置文件。

```properties
# Telnet 端口。
com.dwarfeng.essentials.telqos.port=23
# 字符集。
com.dwarfeng.essentials.telqos.charset=UTF-8
# 白名单表达式。
com.dwarfeng.essentials.telqos.whitelist_regex=
# 黑名单表达式。
com.dwarfeng.essentials.telqos.blacklist_regex=
```

如果您的项目中有多个包含 Telqos 模块的服务，您应该修改 `com.dwarfeng.essentials.telqos.port` 的值，以避免端口冲突。

请根据操作系统的默认字符集，修改 `com.dwarfeng.essentials.telqos.charset` 的值，以避免乱码。一般情况下，
Windows 系统的默认字符集为 `GBK`，Linux 系统的默认字符集为 `UTF-8`。

如果您希望限制 Telqos 的使用范围，您可以修改 `com.dwarfeng.essentials.telqos.whitelist_regex` 和
`com.dwarfeng.essentials.telqos.blacklist_regex` 的值。

## tmpstg 目录

| 文件名              | 说明                 |
|---------------------|----------------------|
| settings.properties | 临时存储的配置文件   |

### settings.properties

临时存储的配置文件，用于 fileio 服务的临时文件存储。

```properties
# 临时文件目录路径。
com.dwarfeng.essentials.fileio.tmpstg.temporary_file_directory_path=temp
# 临时文件前缀。
com.dwarfeng.essentials.fileio.tmpstg.temporary_file_prefix=tmpstg-
# 临时文件后缀。
com.dwarfeng.essentials.fileio.tmpstg.temporary_file_suffix=.tmp
# 单个存储的最大缓冲区大小。
com.dwarfeng.essentials.fileio.tmpstg.max_buffer_size_per_storage=2048
# 总的最大缓冲区大小。
com.dwarfeng.essentials.fileio.tmpstg.max_buffer_size_total=1048576
# 清理已经释放的缓冲区的间隔。
com.dwarfeng.essentials.fileio.tmpstg.clear_disposed_interval=300000
# 检查内存的间隔。
com.dwarfeng.essentials.fileio.tmpstg.check_memory_interval=60000
```

`com.dwarfeng.essentials.fileio.tmpstg.temporary_file_directory_path` 为临时文件的目录，默认值为项目根目录下的
`temp` 目录。单次导入/导出过程中占用的临时空间由 `max_buffer_size_per_storage` 与 `max_buffer_size_total` 控制，
如果导入/导出的数据量较大，您可以适当上调这两个参数。

## voucher 目录

| 文件名              | 说明               |
|---------------------|--------------------|
| cleanup.properties  | 清理作业的配置文件 |
| launcher.properties | 启动器配置文件     |
| push.properties     | 推送服务配置文件   |
| reset.properties    | 重置服务配置文件   |

### cleanup.properties

清理作业的配置文件。

```properties
#清理作业执行的 CRON 表达式。
com.dwarfeng.essentials.voucher.cleanup.cron=0 15 0/15 * * *
```

### launcher.properties

启动器配置文件，决定了启动时的一些行为。

```properties
# 程序启动完成后，是否重置检查器支持。
com.dwarfeng.essentials.voucher.launcher.reset_checker_support=true
#
# 程序启动完成后，上线清理的延时时间。
# 清理服务在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理清理服务。
# 该参数等于 0，意味着启动后立即上线清理服务。
# 该参数小于 0，意味着程序不主动上线清理服务，需要手动上线。
com.dwarfeng.essentials.voucher.launcher.online_cleanup_delay=3000
# 程序启动完成后，启动清理的延时时间。
# 清理服务在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理清理服务。
# 该参数等于 0，意味着启动后立即启动清理服务。
# 该参数小于 0，意味着程序不主动启动清理服务，需要手动启动。
com.dwarfeng.essentials.voucher.launcher.enable_cleanup_delay=3500
#
# 程序启动完成后，启动重置的延时时间。
# 有些重置器在启动后可能会需要一些时间进行自身的初始化，调整该参数以妥善的处理这些重置器。
# 该参数等于 0，意味着启动后立即启动重置服务。
# 该参数小于 0，意味着程序不主动启动重置服务，需要手动启动。
com.dwarfeng.essentials.voucher.launcher.start_reset_delay=30000
```

### push.properties

推送服务配置文件。

```properties
###################################################
#                     global                      #
###################################################
# 当前的推送器类型。
# 目前该项目支持的推送器类型有:
#   drain: 简单的丢弃掉所有消息的推送器。
#   multi: 同时将消息推送给所有代理的多重推送器。
#   kafka.native: 使用原生数据的基于 Kafka 消息队列的推送器。
#   log: 将消息输出到日志中的推送器。
#
# 对于一个具体的项目，很可能只用一个推送器。此时如果希望程序加载时只加载一个推送器，可以通过编辑
# opt/opt-push.xml 文件实现。
# 可以通过编辑 application-context-scan.xml 实现。
com.dwarfeng.essentials.voucher.pusher.type=drain
#
###################################################
#                      drain                      #
###################################################
# drain 推送器没有任何配置。
#
###################################################
#                      multi                      #
###################################################
# 代理的推送器，推送器之间以逗号分隔。
com.dwarfeng.essentials.voucher.pusher.multi.delegate_types=kafka.native
#
###################################################
#                   kafka.native                  #
###################################################
# 引导服务器集群。
com.dwarfeng.essentials.voucher.pusher.kafka.native.bootstrap_servers=\
  your-host-here:9092,your-host-here:9092,your-host-here:9092
# 连接属性。
com.dwarfeng.essentials.voucher.pusher.kafka.native.acks=all
# 发送失败重试次数。
com.dwarfeng.essentials.voucher.pusher.kafka.native.retries=3
com.dwarfeng.essentials.voucher.pusher.kafka.native.linger=10
# 批处理缓冲区大小。
com.dwarfeng.essentials.voucher.pusher.kafka.native.buffer_memory=40960
# 批处理条数：当多个记录被发送到同一个分区时，生产者会尝试将记录合并到更少的请求中。这有助于客户端和服务器的性能。
com.dwarfeng.essentials.voucher.pusher.kafka.native.batch_size=4096
# Kafka 事务的前缀。
com.dwarfeng.essentials.voucher.pusher.kafka.native.transaction_prefix=voucher.pusher.
# 检查重置时向 Kafka 发送消息的主题。
com.dwarfeng.essentials.voucher.pusher.kafka.native.topic.check_reset=voucher.pusher.filtered_updated
#
###################################################
#                       log                       #
###################################################
# 记录日志的等级，由低到高依次是 TRACE, DEBUG, INFO, WARN, ERROR。
com.dwarfeng.essentials.voucher.pusher.log.log_level=INFO
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-voucher-pusher.xml`，
决定项目中需要使用哪种推送器。您只需要修改使用的推送器的配置。

### reset.properties

重置服务配置文件。

```properties
###################################################
#                      never                      #
###################################################
# Never 推送器没有任何配置。
#
###################################################
#                   fixed_delay                   #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.voucher.resetter.fixed_delay.delay=43200000
#
###################################################
#                   fixed_rate                    #
###################################################
# 重置的间隔。
com.dwarfeng.essentials.voucher.resetter.fixed_rate.rate=43200000
#
###################################################
#                      cron                       #
###################################################
# 执行重置的 CRON 表达式。
com.dwarfeng.essentials.voucher.resetter.cron.cron=0 0 1 * * *
#
###################################################
#                      dubbo                      #
###################################################
# Dubbo 推送器没有任何配置。
```

您不必对所有的配置项进行配置。在项目第一次启动之前，您需要修改 `opt/opt-voucher-resetter.xml`，
决定项目中需要使用哪种重置器。您只需要修改使用的重置器的配置。

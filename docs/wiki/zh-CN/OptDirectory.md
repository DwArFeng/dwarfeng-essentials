# Opt Directory - 可选配置目录

## 总览

本项目的可选配置位于 `opt/` 目录下，包括：

```text
opt
├─ opt-acckeeper-lskgen.xml
├─ opt-acckeeper-protector.xml
├─ opt-acckeeper-pusher.xml
├─ opt-acckeeper-resetter.xml
├─ opt-audit-inspection-dispatcher.xml
├─ opt-audit-inspection-driver.xml
├─ opt-audit-inspection-receiver.xml
├─ opt-audit-inspector.xml
├─ opt-audit-pusher.xml
├─ opt-audit-resetter.xml
├─ opt-fileio-exporter-csv.xml
├─ opt-fileio-exporter-dct.xml
├─ opt-fileio-exporter-excel.xml
├─ opt-fileio-exporter.xml
├─ opt-fileio-importer-dct.xml
├─ opt-fileio-importer.xml
├─ opt-fileio-pusher.xml
├─ opt-fileio-reader-jdbc.xml
├─ opt-fileio-reader-spls.xml
├─ opt-fileio-reader.xml
├─ opt-fileio-resetter.xml
├─ opt-fileio-writer.xml
├─ opt-logicengine-dispatcher.xml
├─ opt-logicengine-driver.xml
├─ opt-logicengine-guarder.xml
├─ opt-logicengine-performer.xml
├─ opt-logicengine-pusher.xml
├─ opt-logicengine-receiver.xml
├─ opt-logicengine-resetter.xml
├─ opt-notify-dispatcher.xml
├─ opt-notify-pusher.xml
├─ opt-notify-resetter.xml
├─ opt-notify-router.xml
├─ opt-notify-sender.xml
├─ opt-rbacds-filter.xml
├─ opt-rbacds-pusher.xml
├─ opt-rbacds-resetter.xml
├─ opt-settingrepo-formatter.xml
├─ opt-settingrepo-pusher.xml
├─ opt-settingrepo-resetter.xml
├─ opt-settingrepo-warmup-driver.xml
├─ opt-voucher-checker.xml
├─ opt-voucher-pusher.xml
├─ opt-voucher-resetter.xml
```

所有的可选配置都为每个单独的可选项提供了加载配置，默认是注释的，如果用户需要使用某个可选项，
只需要将其对应的配置项取消注释即可。

## 默认可选配置文件

此处按来源分组展示默认的可选配置文件。

## acckeeper

### opt-acckeeper-lskgen.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.acckeeper.impl.handler.lskgen"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 UuidLoginStateKeyGenerator -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.acckeeper.impl.handler.lskgen.UuidLoginStateKeyGenerator"
        />
        -->

        <!-- 加载 RandxLoginStateKeyGenerator -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.acckeeper.impl.handler.lskgen.RandxLoginStateKeyGenerator"
        />
        -->

        <!-- 加载 SnowflakeLoginStateKeyGenerator（已废弃，仅用于兼容旧格式） -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.acckeeper.impl.handler.lskgen.SnowflakeLoginStateKeyGenerator"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-acckeeper-protector.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.acckeeper.impl.handler.protector"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DoNothingProtector -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.protector.DoNothingProtectorRegistry"
        />
        -->

        <!-- 加载 PasswordProtector -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.protector.PasswordProtectorRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-acckeeper-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.acckeeper.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.pusher.MultiPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-acckeeper-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.acckeeper.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.resetter.NeverResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.acckeeper.impl.handler.resetter.DubboResetter"
        />
        -->
    </context:component-scan>
</beans>
```

## audit

### opt-audit-inspection-dispatcher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描自动审计调度器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.inspdispatcher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainInspectionDispatcher。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdispatcher.DrainInspectionDispatcher"
        />
        -->

        <!-- 加载 InjvmInspectionDispatcher。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdispatcher.InjvmInspectionDispatcher"
        />
        -->

        <!-- 加载 KafkaInspectionDispatcher。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdispatcher.KafkaInspectionDispatcher"
        />
        -->

        <!-- 加载 DubboInspectionDispatcher。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdispatcher.DubboInspectionDispatcher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-audit-inspection-driver.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描自动审计驱动器实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.inspdriver"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 CronInspectionDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.CronInspectionDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.CronInspectionDriverSupporter"
        />
        -->

        <!-- 加载 DctiKafkaInspectionDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.DctiKafkaInspectionDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.DctiKafkaInspectionDriverSupporter"
        />
        -->

        <!-- 加载 FixedDelayInspectionDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.FixedDelayInspectionDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.FixedDelayInspectionDriverSupporter"
        />
        -->

        <!-- 加载 FixedRateInspectionDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.FixedRateInspectionDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspdriver.FixedRateInspectionDriverSupporter"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-audit-inspection-receiver.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描自动审计接收器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.inspreceiver"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DoNothingInspectionReceiver。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspreceiver.DoNothingInspectionReceiver"
        />
        -->

        <!-- 加载 InjvmInspectionReceiver。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspreceiver.InjvmInspectionReceiver"
        />
        -->

        <!-- 加载 KafkaInspectionReceiver。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspreceiver.KafkaInspectionReceiver"
        />
        -->

        <!-- 加载 DubboInspectionReceiver。 -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.audit.impl.handler.inspreceiver.DubboInspectionReceiver"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-audit-inspector.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 GroovyInspector -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.inspector"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-audit-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描推送器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.pusher.MultiPusher"
        />
        -->

        <!-- 加载 NativeKafkaPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.pusher.NativeKafkaPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-audit-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描重置器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.audit.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.resetter.NeverResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.audit.impl.handler.resetter.DubboResetter"
        />
        -->
    </context:component-scan>
</beans>
```

## fileio

### opt-fileio-exporter-csv.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:util="http://www.springframework.org/schema/util"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd"
>

    <!--
            本配置文件为 CsvExporter 的 DCT 值序列化器提供必要的 ValueCodingHandler 等 bean。
            如果需要使用 DCT 值序列化器，请同时在 opt-exporter.xml 中启用 CsvExporter，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            可以在下方的参数中直接赋值，也可以使用 value placeholder 进行占位，
            并将真正的配置值以 properties 文件的形式放在 confext 目录中。

            如一个 ValueCodingHandler 不满足使用需求（如不同 CSV 导出模板需要使用不同的数据类型），
            应该将下方的 bean 定义复制多份，分配不同的 id，为 ApplicationContext 提供多个 bean。
            CsvExporter 通过参数中的 value_serializer_bean_name 指定使用的 ValueSerializer Bean。
            复制配置时，应同时复制 ValueCodingHandler 与 DctValueSerializer 的 bean 定义，并为二者分配不同的 id，
            然后将 value_serializer_bean_name 设置为对应 DctValueSerializer Bean 的名称。

            ValueCodingHandler 相关 bean 说明：
            ValueCodingHandler 用于将数据编码为 dct 协议格式，默认支持的值类型包括：
            Boolean、Byte、Short、Integer、Long、Float、Double、BigDecimal、BigInteger、Character、String、
            Date、LocalDateTime、Serializable。
            可以通过调整 csvExporterRegistry.dctValueSerialize.valueCodecs 列表中的 bean 定义来调整支持的值类型。
    -->
    <!--
    <util:list id="csvExporterRegistry.dctValueSerialize.valueCodecs">
        <bean class="com.dwarfeng.dct.impl.handler.vc.BooleanValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ByteValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ShortValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.IntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.LongValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.FloatValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.DoubleValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigDecimalValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigIntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.CharacterValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.StringValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.DateValueCodec"/>
        <bean class="com.dwarfeng.fileio.impl.handler.exporter.csv.vs.dct.LocalDateTimeCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.SerializableValueCodec"/>
    </util:list>
    <bean
            id="csvExporterRegistry.dctValueSerialize.valueCodingHandler"
            class="com.dwarfeng.fileio.impl.handler.DctValueCodingHandlerUtil"
            factory-method="newValueCodingHandler"
    >
        <constructor-arg name="valueCodecs" ref="csvExporterRegistry.dctValueSerialize.valueCodecs"/>
    </bean>
    <bean
            id="csvExporterRegistry.dctValueSerializer"
            class="com.dwarfeng.fileio.impl.handler.exporter.csv.vs.DctValueSerializer"
    >
        <constructor-arg name="name" value="dct"/>
        <constructor-arg
                name="valueCodingHandler" ref="csvExporterRegistry.dctValueSerialize.valueCodingHandler"
        />
    </bean>
    -->
</beans>
```

### opt-fileio-exporter-dct.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:util="http://www.springframework.org/schema/util"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd"
>

    <!--
            本配置文件为 DctExporter 提供必要的 ValueCodingHandler 等 bean。
            如果需要使用 DctExporter，请同时在 opt-exporter.xml 中启用 DctExporter，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            可以在下方的参数中直接赋值，也可以使用 value placeholder 进行占位，
            并将真正的配置值以 properties 文件的形式放在 confext 目录中。

            如一个 ValueCodingHandler 不满足使用需求（如不同导出模板需要使用不同的数据类型），
            应该将下方的 bean 定义复制多份，分配不同的 id，为 ApplicationContext 提供多个 bean。
            DctExporter 通过参数中的 value_coding_handler_bean_name 指定使用的 ValueCodingHandler Bean；
            使用其它 id 时，应将该参数设置为对应的 Bean 名称。

            ValueCodingHandler 相关 bean 说明：
            ValueCodingHandler 用于将数据编码为 dct 协议格式，默认支持的值类型包括：
            Boolean、Byte、Short、Integer、Long、Float、Double、BigDecimal、BigInteger、Character、String。
            可以通过调整 dctExporterRegistry.valueCodecs 列表中的 bean 定义来调整支持的值类型。
    -->
    <!--
    <util:list id="dctExporterRegistry.valueCodecs">
        <bean class="com.dwarfeng.dct.impl.handler.vc.BooleanValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ByteValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ShortValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.IntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.LongValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.FloatValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.DoubleValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigDecimalValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigIntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.CharacterValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.StringValueCodec"/>
    </util:list>
    <bean
            id="dctExporterRegistry.valueCodingHandler"
            class="com.dwarfeng.fileio.impl.handler.DctValueCodingHandlerUtil"
            factory-method="newValueCodingHandler"
    >
        <constructor-arg name="valueCodecs" ref="dctExporterRegistry.valueCodecs"/>
    </bean>
    -->
</beans>
```

### opt-fileio-exporter-excel.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!--
            本配置文件为 ExcelExporter 提供可选的 ValueMapper Bean。
            如果需要使用 ExcelExporter，请同时在 opt-exporter.xml 中启用 ExcelExporter，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            可以在下方的 Bean 定义中直接调整实现类，也可以使用 value placeholder 进行占位，
            并将真正的配置值以 properties 文件的形式放在 confext 目录中。

            ValueMapper Bean 的名称由 value_mapper_bean_name 参数直接引用。
            ValueMapper 的 Bean 必须实现 com.dwarfeng.fileio.impl.handler.exporter.excel.ValueMapper 接口。
            每个列配置可以选择不同的 ValueMapper，同一个 ValueMapper 也可以被多个列重复使用。

            如一个 ValueMapper 不满足使用需求（如相同数据需要以不同格式写入多个工作簿），
            应该将下方的 Bean 定义复制多份，分配不同的 id，并在 value_mapper_bean_name 中指定对应的 Bean 名称。
            如果复制的是自定义实现，应确保每个 Bean 的配置语义清晰；尽量保证 Mapper 的实现类使用无参构造器。

            通用 ValueMapper 说明：
            generalBooleanValueMapper: 将值转换为 Boolean。
            generalCalendarValueMapper: 将值转换为 Calendar。
            generalDateValueMapper: 将值转换为 Date。
            generalDoubleValueMapper: 将值转换为 Double。
            generalLocalDateValueMapper: 将值转换为 LocalDate。
            generalLocalDateTimeValueMapper: 将值转换为 LocalDateTime。
            generalStringValueMapper: 将值转换为 String。

            列类型与 ValueMapper 的目标类型应保持一致，以避免 POI 写入单元格时发生类型转换异常。
    -->
    <!--
    <bean
            id="excelExporterRegistry.valueMapper.generalBooleanValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralBooleanValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalCalendarValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralCalendarValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalDateValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralDateValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalDoubleValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralDoubleValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalLocalDateValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralLocalDateValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalLocalDateTimeValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralLocalDateTimeValueMapper"
    />
    <bean
            id="excelExporterRegistry.valueMapper.generalStringValueMapper"
            class="com.dwarfeng.fileio.impl.handler.exporter.excel.vm.GeneralStringValueMapper"
    />
    -->
</beans>
```

### opt-fileio-exporter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 DctExporter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.exporter.dct"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 CsvExporter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.exporter.csv"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 ExcelExporter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.exporter.excel"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 LogExporter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.exporter.log"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-fileio-importer-dct.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:util="http://www.springframework.org/schema/util"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd"
>

    <!--
            本配置文件为 DctImporter 提供必要的 ValueCodingHandler 等 bean。
            如果需要使用 DctImporter，请同时在 opt-importer.xml 中启用 DctImporter，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            可以在下方的参数中直接赋值，也可以使用 value placeholder 进行占位，
            并将真正的配置值以 properties 文件的形式放在 confext 目录中。

            如一个 ValueCodingHandler 不满足使用需求（如不同导入模板需要使用不同的数据类型），
            应该将下方的 bean 定义复制多份，分配不同的 id，为 ApplicationContext 提供多个 bean。
            DctImporter 通过参数中的 value_coding_handler_bean_name 指定使用的 ValueCodingHandler Bean；
            使用其它 id 时，应将该参数设置为对应的 Bean 名称。

            ValueCodingHandler 相关 bean 说明：
            ValueCodingHandler 用于将 dct 协议格式的数据解码为 Java 对象，默认支持的值类型包括：
            Boolean、Byte、Short、Integer、Long、Float、Double、BigDecimal、BigInteger、Character、String。
            可以通过调整 dctImporterRegistry.valueCodecs 列表中的 bean 定义来调整支持的值类型。
    -->
    <!--
    <util:list id="dctImporterRegistry.valueCodecs">
        <bean class="com.dwarfeng.dct.impl.handler.vc.BooleanValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ByteValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ShortValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.IntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.LongValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.FloatValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.DoubleValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigDecimalValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigIntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.CharacterValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.StringValueCodec"/>
    </util:list>
    <bean
            id="dctImporterRegistry.valueCodingHandler"
            class="com.dwarfeng.fileio.impl.handler.DctValueCodingHandlerUtil"
            factory-method="newValueCodingHandler"
    >
        <constructor-arg name="valueCodecs" ref="dctImporterRegistry.valueCodecs"/>
    </bean>
    -->
</beans>
```

### opt-fileio-importer.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 DctImporter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.importer.dct"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-fileio-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.pusher.MultiPusher"
        />
        -->

        <!-- 加载 NativeKafkaPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.pusher.NativeKafkaPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-fileio-reader-jdbc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:util="http://www.springframework.org/schema/util"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd"
>

    <!--
            本配置文件为 JdbcReader 提供必要的 ValueCodingHandler 等 bean。
            如果需要使用 JdbcReader，请同时在 opt-reader.xml 中启用 JdbcReader，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            可以在下方的参数中直接赋值，也可以使用 value placeholder 进行占位，
            并将真正的配置值以 properties 文件的形式放在 confext 目录中。

            如一个 ValueCodingHandler 不满足使用需求（如不同 JDBC 数据源返回不同的数据类型），
            应该将下方的 bean 定义复制多份，分配不同的 id，为 ApplicationContext 提供多个 bean。
            JdbcReader 通过参数中的 value_coding_handler_bean_name 指定使用的 ValueCodingHandler Bean；
            使用其它 id 时，应将该参数设置为对应的 Bean 名称。

            ValueCodingHandler 相关 bean 说明：
            ValueCodingHandler 用于将 JDBC 查询结果中的 dct 协议格式数据解码为 Java 对象，默认支持的值类型包括：
            Boolean、Byte、Short、Integer、Long、Float、Double、BigDecimal、BigInteger、Character、String。
            可以通过调整 jdbcReaderRegistry.valueCodecs 列表中的 bean 定义来调整支持的值类型。
    -->
    <!--
    <util:list id="jdbcReaderRegistry.valueCodecs">
        <bean class="com.dwarfeng.dct.impl.handler.vc.BooleanValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ByteValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.ShortValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.IntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.LongValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.FloatValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.DoubleValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigDecimalValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.BigIntegerValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.CharacterValueCodec"/>
        <bean class="com.dwarfeng.dct.impl.handler.vc.StringValueCodec"/>
    </util:list>
    <bean
            id="jdbcReaderRegistry.valueCodingHandler"
            class="com.dwarfeng.fileio.impl.handler.DctValueCodingHandlerUtil"
            factory-method="newValueCodingHandler"
    >
        <constructor-arg name="valueCodecs" ref="jdbcReaderRegistry.valueCodecs"/>
    </bean>
    -->
</beans>
```

### opt-fileio-reader-spls.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!--
            本配置文件为 SplsReader 提供可选的 ArgsResolver Bean。
            如果需要使用 SplsReader，请同时在 opt-reader.xml 中启用 SplsReader，
            并取消下方配置的注释，然后按照实际情况对下方参数进行配置。

            ArgsResolver Bean 的名称由 args_resolver_bean_name 参数直接引用。
            ArgsResolver 的 Bean 必须实现 com.dwarfeng.fileio.impl.handler.reader.spls.ArgsResolver 接口。
            同一个 ArgsResolver 可以被多个读取任务重复使用。

            如一个 ArgsResolver 不满足使用需求（如不同元数据参数需要采用不同编码格式），
            应该将下方的 Bean 定义复制多份，分配不同的 id，并在 args_resolver_bean_name 中指定对应的 Bean 名称。
            自定义解析器应确保能够安全处理元数据中的参数字符串，并明确限制可接受的数据类型。

            FastJsonArgsResolver 说明：
            FastJsonArgsResolver 使用 Fastjson 将元数据中的 JSON 数组解析为对象数组。
            auto_type_accepts 参数配置在 fileio/read.properties 中，使用逗号分隔允许反序列化的类或包前缀。
            该解析器启用了 Fastjson AutoType 支持；应仅配置受信任的最小类集合，避免反序列化不可信类型。
    -->
    <!--
    <bean
            id="splsReaderRegistry.argsResolver.fastJsonArgsResolver"
            class="com.dwarfeng.fileio.impl.handler.reader.spls.ar.FastJsonArgsResolver"
    />
    -->
</beans>
```

### opt-fileio-reader.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 MockReader -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.reader.mock"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 JdbcReader -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.reader.jdbc"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 SelsReader -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.reader.sels"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 SplsReader -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.reader.spls"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 FilterReader -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.reader.filter"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-fileio-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.resetter.DubboResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.fileio.impl.handler.resetter.NeverResetter"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-fileio-writer.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 LogWriter -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.fileio.impl.handler.writer.log"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

## logicengine

### opt-logicengine-dispatcher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描调度器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.dispatcher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.dispatcher.DrainDispatcher"
        />
        -->

        <!-- 加载 InjvmDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.dispatcher.InjvmDispatcher"
        />
        -->

        <!-- 加载 KafkaDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.dispatcher.KafkaDispatcher"
        />
        -->

        <!-- 加载 DubboDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.dispatcher.DubboDispatcher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-logicengine-driver.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.driver"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 CronDriver -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.CronDriverProvider"
        />
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.CronDriverSupporter"
        />
        -->

        <!-- 加载 DctiKafkaDriver -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.DctiKafkaDriverProvider"
        />
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.DctiKafkaDriverSupporter"
        />
        -->

        <!-- 加载 FixedDelayDriver -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.FixedDelayDriverProvider"
        />
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.FixedDelayDriverSupporter"
        />
        -->

        <!-- 加载 FixedRateDriver -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.FixedRateDriverProvider"
        />
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.driver.FixedRateDriverSupporter"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-logicengine-guarder.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 AlwaysGuarder -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.guarder.always"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 GroovyGuarder -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.guarder.groovy"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 CompareGuarder -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.guarder.compare"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-logicengine-performer.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<!--suppress SpringFacetInspection, XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 加载 GroovyPerformer -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.performer.groovy"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 CmdPerformer -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.performer.cmd"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 AnchorMessagePerformer -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.performer.anchmsg"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->

    <!-- 加载 TaskEventPerformer -->
    <!--
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.performer.tskevt"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    />
    -->
</beans>
```

### opt-logicengine-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描推送器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.pusher.MultiPusher"
        />
        -->

        <!-- 加载 NativeKafkaPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.pusher.NativeKafkaPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-logicengine-receiver.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描接收器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.receiver"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DoNothingReceiver。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.receiver.DoNothingReceiver"
        />
        -->

        <!-- 加载 InjvmReceiver。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.receiver.InjvmReceiver"
        />
        -->

        <!-- 加载 KafkaReceiver。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.receiver.KafkaReceiver"
        />
        -->

        <!-- 加载 DubboReceiver。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.receiver.DubboReceiver"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-logicengine-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描重置器的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.logicengine.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 NeverResetter。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.resetter.NeverResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 CronResetter。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter。 -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.logicengine.impl.handler.resetter.DubboResetter"
        />
        -->
    </context:component-scan>
</beans>
```

## notify

### opt-notify-dispatcher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.notify.impl.handler.dispatcher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 EmptyDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.dispatcher.EmptyDispatcherRegistry"
        />
        -->

        <!-- 加载 EntireDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.dispatcher.EntireDispatcherRegistry"
        />
        -->

        <!-- 加载 GroovyDispatcher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.dispatcher.GroovyDispatcherRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-notify-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.notify.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.pusher.MultiPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-notify-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.notify.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.NeverResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 KafkaResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.KafkaResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.resetter.DubboResetter"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-notify-router.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.notify.impl.handler.router"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 EmptyRouter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.router.EmptyRouterRegistry"
        />
        -->

        <!-- 加载 EntireRouter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.router.EntireRouterRegistry"
        />
        -->

        <!-- 加载 StaticRouter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.router.StaticRouterRegistry"
        />
        -->

        <!-- 加载 IdentityRouter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.router.IdentityRouterRegistry"
        />
        -->

        <!-- 加载 GroovyRouter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.router.GroovyRouterRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-notify-sender.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.notify.impl.handler.sender"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 LogSender -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.sender.LogSenderRegistry"
        />
        -->

        <!-- 加载 GroovySender -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.sender.GroovySenderRegistry"
        />
        -->

        <!-- 加载 DrainSender -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.notify.impl.handler.sender.DrainSenderRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

## rbacds

### opt-rbacds-filter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.rbacds.impl.handler.filter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DirectSubGroupFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.DirectSubGroupFilterRegistry"
        />
        -->

        <!-- 加载 ExactFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.ExactFilterRegistry"
        />
        -->

        <!-- 加载 IdPrefixFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.IdPrefixFilterRegistry"
        />
        -->

        <!-- 加载 IdRegexFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.IdRegexFilterRegistry"
        />
        -->

        <!-- 加载 NameRegexFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.NameRegexFilterRegistry"
        />
        -->

        <!-- 加载 NestedSubGroupFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.NestedSubGroupFilterRegistry"
        />
        -->

        <!-- 加载 LevelFilterRegistry -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.rbacds.impl.handler.filter.LevelFilterRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-rbacds-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.rbacds.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.pusher.MultiPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-rbacds-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.rbacds.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.resetter.DubboResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.rbacds.impl.handler.resetter.NeverResetter"
        />
        -->
    </context:component-scan>
</beans>
```

## settingrepo

### opt-settingrepo-formatter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.settingrepo.impl.handler.formatter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 GroovyFormatter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.formatter.GroovyFormatterRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-settingrepo-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.settingrepo.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.pusher.MultiPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-settingrepo-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.settingrepo.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.NeverResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 KafkaResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.KafkaResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.settingrepo.impl.handler.resetter.DubboResetter"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-settingrepo-warmup-driver.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan base-package="com.dwarfeng.settingrepo.impl.handler.wudriver" use-default-filters="false">
        <!-- 加载 CronWarmupDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.CronWarmupDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.CronWarmupDriverSupporter"
        />
        -->

        <!-- 加载 FixedDelayWarmupDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.FixedDelayWarmupDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.FixedDelayWarmupDriverSupporter"
        />
        -->

        <!-- 加载 FixedRateWarmupDriver -->
        <!--
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.FixedRateWarmupDriverProvider"
        />
        <context:include-filter
                type="assignable"
                expression="com.dwarfeng.settingrepo.impl.handler.wudriver.FixedRateWarmupDriverSupporter"
        />
        -->
    </context:component-scan>
</beans>
```

## voucher

### opt-voucher-checker.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.voucher.impl.handler.checker"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 GroovyChecker -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.checker.GroovyCheckerRegistry"
        />
        -->

        <!-- 加载 SingleUseChecker -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.checker.SingleUseCheckerRegistry"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-voucher-pusher.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.voucher.impl.handler.pusher"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 DrainPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.pusher.DrainPusher"
        />
        -->

        <!-- 加载 LogPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.pusher.LogPusher"
        />
        -->

        <!-- 加载 MultiPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.pusher.MultiPusher"
        />
        -->

        <!-- 加载 NativeKafkaPusher -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.pusher.NativeKafkaPusher"
        />
        -->
    </context:component-scan>
</beans>
```

### opt-voucher-resetter.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 以下注释用于抑制 idea 中 .md 的警告，实际并无错误，在使用时可以连同本注释一起删除。 -->
<!--suppress SpringXmlModelInspection -->
<!--suppress SpringFacetInspection -->
<!--suppress XmlUnusedNamespaceDeclaration -->
<beans
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!-- 扫描 handler 的实现包。 -->
    <context:component-scan
            base-package="com.dwarfeng.voucher.impl.handler.resetter"
            use-default-filters="false"
            name-generator="com.dwarfeng.essentials.sdk.spring.CanonicalNameBeanNameGenerator"
    >
        <!-- 加载 CronResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.resetter.CronResetter"
        />
        -->

        <!-- 加载 DubboResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.resetter.DubboResetter"
        />
        -->

        <!-- 加载 FixedDelayResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.resetter.FixedDelayResetter"
        />
        -->

        <!-- 加载 FixedRateResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.resetter.FixedRateResetter"
        />
        -->

        <!-- 加载 NeverResetter -->
        <!--
        <context:include-filter
                type="assignable" expression="com.dwarfeng.voucher.impl.handler.resetter.NeverResetter"
        />
        -->
    </context:component-scan>
</beans>
```

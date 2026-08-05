package com.dwarfeng.essentials.sdk.hibernate;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数据表前缀解析器。
 *
 * <p>
 * 该解析器根据实体类所在包名，将数据表名称转换到对应来源服务的表命名空间。多个来源服务的实体被装配到同一个 {@code SessionFactory} 时，
 * 可借此隔离同名数据表。转换过程中会保留已经带有任一系统前缀的表名，并在追加来源服务前缀前移除通用的 {@code tbl_} 前缀。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class TablePrefixResolver {

    private static final Map<String, String> PACKAGE_PREFIX_MAP = new LinkedHashMap<>();

    static {
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.acckeeper.", "tbl_acckeeper_");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.rbacds.", "tbl_rbacds_");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.settingrepo.", "tbl_settingrepo_");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.notify.", "tbl_notify_");
        PACKAGE_PREFIX_MAP.put("com.jiermt.hr.", "tbl_hr_");
    }

    private TablePrefixResolver() {
        throw new IllegalStateException("Illegal instantiation");
    }

    public static String resolveTableName(String className, String tableName) {
        if (className == null || tableName == null) {
            return tableName;
        }
        for (String tablePrefix : PACKAGE_PREFIX_MAP.values()) {
            if (tableName.startsWith(tablePrefix)) {
                return tableName;
            }
        }
        for (Map.Entry<String, String> entry : PACKAGE_PREFIX_MAP.entrySet()) {
            if (className.startsWith(entry.getKey())) {
                String normalizedTableName = tableName.startsWith("tbl_") ? tableName.substring(4) : tableName;
                return entry.getValue() + normalizedTableName;
            }
        }
        return tableName;
    }

    public static Map<String, String> packagePrefixMap() {
        return Collections.unmodifiableMap(PACKAGE_PREFIX_MAP);
    }
}

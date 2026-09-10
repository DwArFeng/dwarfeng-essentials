package com.dwarfeng.essentials.sdk.datamark;

import com.dwarfeng.datamark.stack.exception.ListenerResolverException;
import com.dwarfeng.datamark.stack.resolve.ListenerResolveInfo;
import com.dwarfeng.datamark.stack.resolve.ListenerResolver;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于实体类包名前缀解析数据标记处理器名称的监听器解析器。
 *
 * <p>
 * 聚合运行时可能同时装配多个来源服务中名称相同的数据标记处理器。
 * 该解析器根据实体类的全限定名识别来源服务，并在声明的处理器名称前追加服务前缀，
 * 从而将不同来源服务的处理器名称隔离到各自的命名空间中。<br>
 * 无法匹配来源服务时，保留声明的处理器名称。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PackagePrefixListenerResolver implements ListenerResolver {

    public static final ListenerResolver INSTANCE = new PackagePrefixListenerResolver();
    private static final Map<String, String> PACKAGE_PREFIX_MAP = new LinkedHashMap<>();

    static {
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.acckeeper.", "acckeeper.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.rbacds.", "rbacds.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.buddy.", "buddy.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.settingrepo.", "settingrepo.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.notify.", "notify.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.logicengine.", "logicengine.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.audit.", "audit.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.fileio.", "fileio.");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.voucher.", "voucher.");
    }

    @Nonnull
    @Override
    public String resolve(@Nonnull ListenerResolveInfo info) throws ListenerResolverException {
        String canonicalName = info.getEntityClass().getCanonicalName();
        String declaredHandlerName = info.getDeclaredHandlerName();
        if (canonicalName == null || canonicalName.isEmpty()) {
            throw new ListenerResolverException("无法获取实体类的全限定名");
        }
        for (Map.Entry<String, String> entry : PACKAGE_PREFIX_MAP.entrySet()) {
            if (canonicalName.startsWith(entry.getKey())) {
                return entry.getValue() + declaredHandlerName;
            }
        }
        return declaredHandlerName;
    }
}

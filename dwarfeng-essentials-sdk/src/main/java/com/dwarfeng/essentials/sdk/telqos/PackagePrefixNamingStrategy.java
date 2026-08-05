package com.dwarfeng.essentials.sdk.telqos;

import com.dwarfeng.springtelqos.sdk.naming.AbstractNamingStrategy;
import com.dwarfeng.springtelqos.stack.naming.NamingStrategy;
import com.dwarfeng.springtelqos.stack.naming.ToCommandIdentityInfo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于指令类包名前缀生成指令标识的命名策略。
 *
 * <p>
 * 聚合运行时可能同时装配多个来源服务中标识相同的 Telqos 指令。该策略根据指令类的全限定名识别来源服务，并在原始指令标识前追加服务前缀，
 * 从而避免不同来源服务的指令标识发生冲突。无法识别指令类或匹配来源服务时，保留原始指令标识。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class PackagePrefixNamingStrategy extends AbstractNamingStrategy {

    public static final NamingStrategy INSTANCE = new PackagePrefixNamingStrategy();
    private static final Map<String, String> PACKAGE_PREFIX_MAP = new LinkedHashMap<>();

    static {
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.acckeeper.", "acckeeper:");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.rbacds.", "rbacds:");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.buddy.", "buddy:");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.settingrepo.", "settingrepo:");
        PACKAGE_PREFIX_MAP.put("com.dwarfeng.notify.", "notify:");
    }

    @Override
    protected String doToCommandIdentity(ToCommandIdentityInfo info) {
        Class<?> commandClass = info.getCommandInfo().getCommandClass();
        String canonicalName = commandClass == null ? null : commandClass.getCanonicalName();
        if (canonicalName != null) {
            for (Map.Entry<String, String> entry : PACKAGE_PREFIX_MAP.entrySet()) {
                if (canonicalName.startsWith(entry.getKey())) {
                    return entry.getValue() + info.getCommandInfo().getIdentify();
                }
            }
        }
        return info.getCommandInfo().getIdentify();
    }
}

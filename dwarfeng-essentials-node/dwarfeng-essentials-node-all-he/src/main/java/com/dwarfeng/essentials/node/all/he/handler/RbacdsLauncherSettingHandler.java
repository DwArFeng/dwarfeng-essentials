package com.dwarfeng.essentials.node.all.he.handler;

import com.dwarfeng.subgrade.stack.handler.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RbacdsLauncherSettingHandler implements Handler {

    @Value("${com.dwarfeng.essentials.rbacds.launcher.reset_filter_support}")
    private boolean resetFilterSupport;

    @Value("${com.dwarfeng.essentials.rbacds.launcher.start_reset_delay}")
    private long startResetDelay;

    public boolean isResetFilterSupport() {
        return resetFilterSupport;
    }

    public long getStartResetDelay() {
        return startResetDelay;
    }

    @Override
    public String toString() {
        return "RbacdsLauncherSettingHandler{" +
                "resetFilterSupport=" + resetFilterSupport +
                ", startResetDelay=" + startResetDelay +
                '}';
    }
}

package com.dwarfeng.essentials.node.all.he.handler;

import com.dwarfeng.subgrade.stack.handler.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingrepoLauncherSettingHandler implements Handler {

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.reset_formatter_support}")
    private boolean resetFormatterSupport;

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.start_reset_delay}")
    private long startResetDelay;

    public boolean isResetFormatterSupport() {
        return resetFormatterSupport;
    }

    public long getStartResetDelay() {
        return startResetDelay;
    }
}

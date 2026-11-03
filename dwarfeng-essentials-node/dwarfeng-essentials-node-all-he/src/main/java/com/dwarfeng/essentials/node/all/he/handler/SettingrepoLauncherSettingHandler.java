package com.dwarfeng.essentials.node.all.he.handler;

import com.dwarfeng.subgrade.stack.handler.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingrepoLauncherSettingHandler implements Handler {

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.reset_formatter_support}")
    private boolean resetFormatterSupport;

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.reset_warmup_driver_support}")
    private boolean resetWarmupDriverSupport;

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.start_reset_delay}")
    private long startResetDelay;

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.online_warmup_delay}")
    private long onlineWarmupDelay;

    @Value("${com.dwarfeng.essentials.settingrepo.launcher.enable_warmup_delay}")
    private long enableWarmupDelay;

    public boolean isResetFormatterSupport() {
        return resetFormatterSupport;
    }

    public boolean isResetWarmupDriverSupport() {
        return resetWarmupDriverSupport;
    }

    public long getStartResetDelay() {
        return startResetDelay;
    }

    public long getOnlineWarmupDelay() {
        return onlineWarmupDelay;
    }

    public long getEnableWarmupDelay() {
        return enableWarmupDelay;
    }
}

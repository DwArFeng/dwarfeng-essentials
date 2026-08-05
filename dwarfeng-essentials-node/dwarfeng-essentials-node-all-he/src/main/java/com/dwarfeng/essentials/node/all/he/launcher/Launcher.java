package com.dwarfeng.essentials.node.all.he.launcher;

import com.dwarfeng.springterminator.sdk.util.ApplicationUtil;

public class Launcher {

    public static void main(String[] args) {
        ApplicationUtil.launch(new String[]{
                "classpath:spring/application-context*.xml",
                "file:opt/opt*.xml",
                "file:optext/opt*.xml"
        }, ctx -> {
            new AcckeeperLauncherConsumer().accept(ctx);
            new RbacdsLauncherConsumer().accept(ctx);
            new BuddyLauncherConsumer().accept(ctx);
            new SettingrepoLauncherConsumer().accept(ctx);
            new NotifyLauncherConsumer().accept(ctx);
        });
    }
}

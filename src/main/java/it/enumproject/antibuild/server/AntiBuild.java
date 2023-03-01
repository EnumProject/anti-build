package it.enumproject.antibuild.server;

import it.enumproject.antibuild.provider.EnumProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBuild extends JavaPlugin {

    private EnumProvider provider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        provider = new EnumProvider(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        provider = null;
    }

}
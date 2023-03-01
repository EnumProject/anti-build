package it.enumproject.antibuild.server.listeners;

import it.enumproject.antibuild.api.BuildAPI;
import it.enumproject.libs.listeners.EnumListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildListener extends EnumListener {

    public BuildListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        BuildAPI api = new BuildAPI(event.getPlayer().getUniqueId());
        if(plugin.getConfig().getStringList("ignored-blocks").contains(event.getBlockPlaced().getType().name())) return;
        if(!api.isBuilding()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        BuildAPI api = new BuildAPI(event.getPlayer().getUniqueId());
        if(plugin.getConfig().getStringList("ignored-blocks").contains(event.getBlock().getType().name())) return;
        if(!api.isBuilding()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        BuildAPI api = new BuildAPI(event.getPlayer().getUniqueId());
        api.setBuilding(false);
    }

}
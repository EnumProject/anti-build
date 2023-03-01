package it.enumproject.antibuild.server.commands;

import it.enumproject.antibuild.api.BuildAPI;
import it.enumproject.antibuild.api.permission.Permission;
import it.enumproject.libs.commands.EnumCommand;
import it.enumproject.libs.player.EnumPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildCommand extends EnumCommand {

    FileConfiguration config = plugin.getConfig();

    public BuildCommand(JavaPlugin plugin) {
        super("build", Permission.BUILD.getPermission(), false, plugin);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        EnumPlayer player = (EnumPlayer) sender;
        BuildAPI api = new BuildAPI(player.getUniqueId());

        api.setBuilding(!api.isBuilding());

        if(api.isBuilding()) {
            sendMessage(player, config.getString("messages.build.disabled"));
        } else {
            sendMessage(player, config.getString("messages.build.enabled"));
        }
    }

    @Override
    public String getPermissionMessage() {
        return config.getString("messages.insufficient_permissions");
    }

    @Override
    public String getNoConsoleMessage() {
        return config.getString("messages.no_console");
    }

}
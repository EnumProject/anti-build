package it.enumproject.antibuild.server.commands;

import it.enumproject.antibuild.api.permission.Permission;
import it.enumproject.libs.commands.EnumCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCommand extends EnumCommand {

    private final FileConfiguration config = plugin.getConfig();

    public MainCommand(JavaPlugin plugin) {
        super("antibuild", Permission.BUILD.getPermission(), true, plugin);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(args.length != 1) {
            sendMessage(sender, "&7Running &bEnum&9AntiBuild &7version &b" + plugin.getDescription().getVersion());
            sendMessage(sender, "&7Created by &aEnum Project");
            return;
        }

        if(args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();

            sendMessage(sender, config.getString("messages.plugin_reloaded"));
            return;
        }

        sendMessage(sender, config.getString("messages.invalid_arguments"));
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
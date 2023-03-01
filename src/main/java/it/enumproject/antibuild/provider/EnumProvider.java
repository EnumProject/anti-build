package it.enumproject.antibuild.provider;

import it.enumproject.antibuild.server.AntiBuild;
import it.enumproject.antibuild.server.commands.BuildCommand;
import it.enumproject.antibuild.server.commands.MainCommand;
import it.enumproject.antibuild.server.listeners.BuildListener;;

public class EnumProvider {

    private final AntiBuild plugin;

    public EnumProvider(AntiBuild plugin) {
        this.plugin = plugin;
        init();
    }

    private void init() {
        getCommands();
        getListeners();
    }

    private void getCommands() {
        new MainCommand(plugin);
        new BuildCommand(plugin);
    }

    private void getListeners() {
        new BuildListener(plugin);
    }

}
package it.enumproject.antibuild.api.permission;

import org.bukkit.permissions.Permissible;

public enum Permission {

    COMMAND_MAIN("command.main"),
    BUILD("build");

    private final String permission;

    Permission(String permission) {
        this.permission = "antibuild." + permission;
    }

    public String getPermission() {
        return permission;
    }

    public boolean has(Permissible permissible) {
        return permissible.hasPermission(permission);
    }

}
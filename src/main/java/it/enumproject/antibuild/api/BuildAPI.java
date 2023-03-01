package it.enumproject.antibuild.api;

import java.util.ArrayList;
import java.util.UUID;

public class BuildAPI {

    private final ArrayList<UUID> buildingPlayers = new ArrayList<>();

    private final UUID uuid;

    public BuildAPI(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isBuilding() {
        return buildingPlayers.contains(uuid);
    }

    public void setBuilding(boolean value) {
        if(value) {
            buildingPlayers.add(uuid);
            return;
        }
        buildingPlayers.remove(uuid);
    }

}
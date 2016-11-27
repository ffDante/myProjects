package com.vitalii.docks.forklifts;

import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.vehicles.Vehicle;

public class Forklift {

    public Forklift(){}

    public Forklift(BasicContainer container, Vehicle vehicle) {
        loadContainer(container, vehicle);
    }

    public boolean loadContainer(BasicContainer container, Vehicle vehicle) {
        if (!container.isExplosiveProtected() || !container.isToxicProtected()) {
            return vehicle.addContainer(container);
        } else {
            return false;
        }
    }
}

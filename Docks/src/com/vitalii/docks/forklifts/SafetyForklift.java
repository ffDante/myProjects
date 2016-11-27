package com.vitalii.docks.forklifts;

import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.vehicles.Vehicle;

public class SafetyForklift extends Forklift{

    public SafetyForklift () {
        super();
    }

    public SafetyForklift(BasicContainer container, Vehicle vehicle) {
        super(container, vehicle);
    }

    @Override
    public boolean loadContainer(BasicContainer container, Vehicle vehicle) {
       return vehicle.addContainer(container);
    }
}

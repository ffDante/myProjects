package com.vitalii.docks.vehicles;

import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.containers.HeavyContainer;
import com.vitalii.docks.containers.RefrigeratedContainer;
import com.vitalii.docks.forklifts.Forklift;
import com.vitalii.docks.forklifts.SafetyForklift;

import java.util.ArrayList;
import java.util.List;

public class StartDocks {
    public static void main(String[] args) {
        List<BasicContainer> containers = new ArrayList<>();
        containers.add(new HeavyContainer("toxic"));
        containers.add(new BasicContainer());
        containers.add(new RefrigeratedContainer("explosive"));

        VehicleCapacity regularBoatCapacity = new VehicleCapacity(10,3,3,1,1);
        Vehicle boat1 = new Boat(regularBoatCapacity);
        Forklift forklift1 = new Forklift();
        Forklift safetyForklift1 = new SafetyForklift();
        boat1.addContainer(containers.get(2), safetyForklift1);

        if (!boat1.isEmpty() && containers.get(2).equals(boat1.nextAvailableContainer())
                && boat1.getNumRefrigerated() == 1 && boat1.getNumHeavy() == 1 && boat1.getNumBasic() == 1 && boat1.getNumExplosive() == 1) {
            System.out.println("Explosive refrigerated container was successfully loaded to Boat1");
        } else {
            System.out.println("Sorry, it didn't work!");
        }
    }
}

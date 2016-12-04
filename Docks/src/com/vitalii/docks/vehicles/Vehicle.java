package com.vitalii.docks.vehicles;

import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.containers.HeavyContainer;
import com.vitalii.docks.containers.RefrigeratedContainer;
import com.vitalii.docks.forklifts.Forklift;
import com.vitalii.docks.forklifts.SafetyForklift;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Vehicle {

	private VehicleCapacity capacity;
	private int hasNumToxic;
	private int hasNumExplosive;
	private int hasNumRefrigerated;
	private int hasNumHeavy;
	private int hasNumBasic;
	
	Stack<BasicContainer> cargo = new Stack<>();
	
	public Vehicle() {}
	public Vehicle(VehicleCapacity vc) {
		this.capacity = vc;
	}

	public int getNumToxic() {
		return hasNumToxic;
	}
	public int getNumExplosive() {
		return hasNumExplosive;
	}
	public int getNumRefrigerated() {
		return hasNumRefrigerated;
	}
	public int getNumHeavy() {
		return hasNumHeavy;
	}
	public int getNumBasic() {
		return hasNumBasic;
	}
	public void setNumToxic(int hasNumToxic) {
		this.hasNumToxic = hasNumToxic;
	}
	public void setNumExplosive(int hasNumExplosive) {
		this.hasNumExplosive = hasNumExplosive;
	}
	public void setNumRefrigerated(int hasNumRefrigerated) {
		this.hasNumRefrigerated = hasNumRefrigerated;
	}
	public void setNumHeavy(int hasNumHeavy) {
		this.hasNumHeavy = hasNumHeavy;
	}
	public void setNumBasic(int hasNumBasic) {
		this.hasNumBasic = hasNumBasic;
	}
	public boolean addContainer(BasicContainer container, Forklift forklift) {
		if (container.isExplosiveProtected() && forklift instanceof SafetyForklift && (this.hasNumExplosive < capacity.getMaxNumExplosive())) {
			addContainerByType(container);
			this.setNumExplosive(++hasNumExplosive);
		} else if (container.isToxicProtected() && forklift instanceof SafetyForklift && (this.hasNumToxic < capacity.getMaxNumToxic())) {
			addContainerByType(container);
			this.setNumToxic(++hasNumToxic);
		} else {
			addContainerByType(container);
		}
		return container.equals(nextAvailableContainer());
	}

	public void addContainers(Forklift forklift, BasicContainer... containers) {
		for (BasicContainer container : containers) {
			addContainer(container, forklift);
		}
	}

	public void addContainers(Forklift forklift, ArrayList<BasicContainer> containers) {
		for (BasicContainer container : containers) {
			addContainer(container, forklift);
		}
	}

	private void addContainerByType(BasicContainer container) {
		if (container instanceof RefrigeratedContainer && (this.hasNumRefrigerated < capacity.getMaxNumRefrigerated())) {
			cargo.push(container);
			this.setNumRefrigerated(++hasNumRefrigerated);
			this.setNumHeavy(++hasNumHeavy);
			this.setNumBasic(++hasNumBasic);
		} else if (container instanceof HeavyContainer && (this.hasNumHeavy < capacity.getMaxNumHeavy())) {
			cargo.push(container);
			this.setNumHeavy(++hasNumHeavy);
			this.setNumBasic(++hasNumBasic);
		} else if (container instanceof BasicContainer && (this.hasNumBasic < capacity.getMaxNumBasic())) {
			cargo.push(container);
			this.setNumBasic(++hasNumBasic);
		}
	}

	public boolean isEmpty() {
		return (hasNumBasic == 0);
	}

	BasicContainer nextAvailableContainer() {
        if (!cargo.isEmpty()){
            return cargo.peek();
        } else {
            return null;
        }
    }
}

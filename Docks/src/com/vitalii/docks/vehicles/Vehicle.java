package com.vitalii.docks.vehicles;

import java.util.Stack;
import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.containers.HeavyContainer;
import com.vitalii.docks.containers.RefrigeratedContainer;

public abstract class Vehicle {

	private VehicleCapacity capacity;
	private int hasNumToxic;
	private int hasNumExplosive;
	private int hasNumRefrigerated;
	private int hasNumHeavy;
	private int hasNumBasic;
	
	Stack<BasicContainer> cargo = new Stack<>();
	
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
	void addContainer(BasicContainer con) {		
		if (con.isExplosiveProtected() && (this.hasNumExplosive < capacity.getMaxNumExplosive())) {
			addContainerByType(con);
			this.setNumExplosive(hasNumExplosive++);
		} else if (con.isToxicProtected() && (this.hasNumToxic < capacity.getMaxNumToxic())) {
			addContainerByType(con);
			this.setNumToxic(hasNumToxic++);
		}		
	}
	void addContainers(BasicContainer... cons) {
		for (BasicContainer con : cons) {
			addContainer(con);
		}
	}
	private void addContainerByType(BasicContainer con) {
		if (con instanceof BasicContainer && (this.hasNumBasic < capacity.getMaxNumBasic())) {
			cargo.push(con);
			this.setNumBasic(hasNumBasic++);
		} else if (con instanceof HeavyContainer && (this.hasNumHeavy < capacity.getMaxNumHeavy())) {
			cargo.push(con);
			this.setNumHeavy(hasNumHeavy++);
			this.setNumBasic(hasNumBasic++);
		} else if (con instanceof RefrigeratedContainer && (this.hasNumRefrigerated < capacity.getMaxNumRefrigerated())) {
			cargo.push(con);
			this.setNumRefrigerated(hasNumRefrigerated++);
			this.setNumHeavy(hasNumHeavy++);
			this.setNumBasic(hasNumBasic++);
		}
	}
	boolean isEmpty() {
		return hasNumBasic == 0;
	}
	BasicContainer nextAvailableContainer() {
        return cargo.peek();
    }
}

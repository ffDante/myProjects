package com.vitalii.docks.vehicles;

import java.util.Stack;
import com.vitalii.docks.containers.Container;

public abstract class Vehicle {

	private int capacityToxic;
	private int capacityExplosive;
	private int capacityRefrigerated;
	private int capacityHeavy;
	private int capacity;
	private int loadedToxic;
	private int loadedExplosive;
	private int loadedRefrigerated;
	private int loadedHeavy;
	private int loadedContainers;
	
	Stack<Container> cargo = new Stack<Container>();
	
	public int getCapacityToxic() {
		return capacityToxic;
	}
	public int getCapacityExplosive() {
		return capacityExplosive;
	}
	public int getCapacityRefrigerated() {
		return capacityRefrigerated;
	}
	public int getCapacityHeavy() {
		return capacityHeavy;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacityToxic(int capacityToxic) {
		if ((capacityExplosive + capacityToxic) <= capacity) {
			this.capacityToxic = capacityToxic;
		}
	}
	public void setCapacityExplosive(int capacityExplosive) {
		if ((capacityExplosive + capacityToxic) <= capacity) {
			this.capacityExplosive = capacityExplosive;
		}
	}
	public void setCapacityRefrigerated(int capacityRefrigerated) {
		if (capacityRefrigerated <= capacityHeavy) {
			this.capacityRefrigerated = capacityRefrigerated;
		}
	}
	public void setCapacityHeavy(int capacityHeavy) {
		if (capacityHeavy <= capacity) {
			this.capacityHeavy = capacityHeavy;
		}
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getLoadedToxic() {
		return loadedToxic;
	}
	public int getLoadedExplosive() {
		return loadedExplosive;
	}
	public int getLoadedRefrigerated() {
		return loadedRefrigerated;
	}
	public int getLoadedHeavy() {
		return loadedHeavy;
	}
	public int getLoadedContainers() {
		return loadedContainers;
	}
	public void setLoadedToxic(int loadedToxic) {
		this.loadedToxic = loadedToxic;
	}
	public void setLoadedExplosive(int loadedExplosive) {
		this.loadedExplosive = loadedExplosive;
	}
	public void setLoadedRefrigerated(int loadedRefrigerated) {
		this.loadedRefrigerated = loadedRefrigerated;
	}
	public void setLoadedHeavy(int loadedHeavy) {
		this.loadedHeavy = loadedHeavy;
	}
	public void setLoadedContainers(int loadedContainers) {
		this.loadedContainers = loadedContainers;
	}
	public void addContainer(Container con) {
		if (con.isProtectedAgainstExplosive() && (this.loadedExplosive < this.capacityExplosive)) { 
			cargo.push(con);
			this.setLoadedExplosive(loadedExplosive++);
		}
	}
}

package com.vitalii.docks.vehicles;

import com.vitalii.docks.exceptions.IllegalCapacityException;

public class VehicleCapacity {
	
	private int maxNumToxic;
	private int maxNumExplosive;
	private int maxNumRefrigerated;
	private int maxNumHeavy;
	private int maxNumBasic;
	String message = "Invalid capacity";
	
	public VehicleCapacity(int maxNumBasic, int maxNumHeavy, int maxNumRefrigerated, int maxNumExplosive, int maxNumToxic) {
		this.maxNumBasic = maxNumBasic;
		this.maxNumHeavy = maxNumHeavy;
		this.maxNumRefrigerated = maxNumRefrigerated;
		this.maxNumExplosive = maxNumExplosive;
		this.maxNumToxic = maxNumToxic;
	}
	
	public int getMaxNumToxic() {
		return maxNumToxic;
	}
	public int getMaxNumExplosive() {
		return maxNumExplosive;
	}
	public int getMaxNumRefrigerated() {
		return maxNumRefrigerated;
	}
	public int getMaxNumHeavy() {
		return maxNumHeavy;
	}
	public int getMaxNumBasic() {
		return maxNumBasic;
	}
	public void setMaxNumToxic(int maxNumToxic) throws IllegalCapacityException {

		if ((maxNumExplosive + maxNumToxic) <= maxNumBasic) {
			this.maxNumToxic = maxNumToxic;
		} else {
			throw new IllegalCapacityException(message);
		}
	}
	public void setMaxNumExplosive(int maxNumExplosive) throws IllegalCapacityException {
		if ((maxNumExplosive + maxNumToxic) <= maxNumBasic) {
			this.maxNumExplosive = maxNumExplosive;
		} else {
            throw new IllegalCapacityException(message);
        }
	}
	public void setMaxNumRefrigerated(int maxNumRefrigerated) throws IllegalCapacityException {
		if (maxNumRefrigerated <= maxNumHeavy) {
			this.maxNumRefrigerated = maxNumRefrigerated;
		} else {
            throw new IllegalCapacityException(message);
        }
	}
	public void setMaxNumHeavy(int maxNumHeavy) throws IllegalCapacityException {
		if (maxNumHeavy <= maxNumBasic) {
			this.maxNumHeavy = maxNumHeavy;
		} else {
            throw new IllegalCapacityException(message);
        }
	}
	public void setMaxNumBasic(int maxNumBasic) {
		this.maxNumBasic = maxNumBasic;
	}
	
}

package com.vitalii.docks.vehicles;

public abstract class VehicleCapacity {
	
	private int maxNumToxic;
	private int maxNumExplosive;
	private int maxNumRefrigerated;
	private int maxNumHeavy;
	private int maxNumBasic;
	
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
	public void setMaxNumToxic(int maxNumToxic) {
		if ((maxNumExplosive + maxNumToxic) <= maxNumBasic) {
			this.maxNumToxic = maxNumToxic;
		}
	}
	public void setMaxNumExplosive(int maxNumExplosive) {
		if ((maxNumExplosive + maxNumToxic) <= maxNumBasic) {
			this.maxNumExplosive = maxNumExplosive;
		}
	}
	public void setMaxNumRefrigerated(int maxNumRefrigerated) {
		if (maxNumRefrigerated <= maxNumHeavy) {
			this.maxNumRefrigerated = maxNumRefrigerated;
		}
	}
	public void setMaxNumHeavy(int maxNumHeavy) {
		if (maxNumHeavy <= maxNumBasic) {
			this.maxNumHeavy = maxNumHeavy;
		}
	}
	public void setMaxNumBasic(int maxNumBasic) {
		this.maxNumBasic = maxNumBasic;
	}
	
}

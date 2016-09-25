package com.vitalii.docks.vehicles;

import java.util.Stack;
import com.vitalii.docks.containers.BasicContainer;
import com.vitalii.docks.containers.HeavyContainer;
import com.vitalii.docks.containers.RefrigeratedContainer;

public abstract class Vehicle {

	private int maxNumToxic;
	private int maxNumExplosive;
	private int maxNumRefrigerated;
	private int maxNumHeavy;
	private int maxNumBasic;
	private int hasNumToxic;
	private int hasNumExplosive;
	private int hasNumRefrigerated;
	private int hasNumHeavy;
	private int hasNumBasic;
	
	Stack<BasicContainer> cargo = new Stack<BasicContainer>();
	
	public Vehicle(int maxNumToxic, int maxNumExposive, int maxNumRefrigerated, int maxNumHeavy, int maxNumBasic) {
		
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
	public void addContainer(BasicContainer con) {		
		if (con.isExplosiveProtected() && (this.hasNumExplosive < this.maxNumExplosive)) {
			addContainerByType(con);
			this.setNumExplosive(hasNumExplosive++);
		} else if (con.isToxicProtected() && (this.hasNumToxic < this.maxNumToxic)) {
			addContainerByType(con);
			this.setNumToxic(hasNumToxic++);
		}		
	}
	private void addContainerByType(BasicContainer con) {
		if (con instanceof BasicContainer && (this.hasNumBasic < this.maxNumBasic)) {
			cargo.push(con);
			this.setNumBasic(hasNumBasic++);
		} else if (con instanceof HeavyContainer && (this.hasNumHeavy < this.maxNumHeavy)) {
			cargo.push(con);
			this.setNumHeavy(hasNumHeavy++);
		} else if (con instanceof RefrigeratedContainer && (this.hasNumRefrigerated < this.maxNumRefrigerated)) {
			cargo.push(con);
			this.setNumRefrigerated(hasNumRefrigerated++);
		}
	}
}

package com.vitalii.docks.containers;

public class BasicContainer{
	
	private boolean toxicProtected;
	private boolean explosiveProtected;

	public BasicContainer(){}
	
	public BasicContainer(String toxicOrExplosive) {
		if ("toxic".equals(toxicOrExplosive)) {
			this.setToxicProtected();
		} else if ("explosive".equals(toxicOrExplosive)) {
			this.setExplosiveProtected();
		}
	}
	
	public boolean isToxicProtected() {
		return toxicProtected;
	}

	public void setToxicProtected() {
		this.toxicProtected = true;
	}

	public boolean isExplosiveProtected() {
		return explosiveProtected;
	}

	public void setExplosiveProtected() {
		this.explosiveProtected = true;
	}	
	
}

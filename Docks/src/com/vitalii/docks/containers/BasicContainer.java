package com.vitalii.docks.containers;

public class BasicContainer{
	
	private boolean toxicProtected;
	private boolean explosiveProtected;
	
	public BasicContainer(boolean toxic, boolean explosive){
		this.setToxicProtected(toxic);
		this.setExplosiveProtected(explosive);
	}
	
	public boolean isToxicProtected() {
		return toxicProtected;
	}

	public void setToxicProtected(boolean toxic) {
		this.toxicProtected = toxic;
	}

	public boolean isExplosiveProtected() {
		return explosiveProtected;
	}

	public void setExplosiveProtected(boolean explosive) {
		this.explosiveProtected = explosive;
	}	
	
}

package com.vitalii.docks.containers;

public class Container {
	
	boolean protectedAgainstToxic;
	boolean protectedAgainstExplosive;
	
	public Container(boolean toxic, boolean explosive){
		this.setProtectedAgainstToxic(toxic);
		this.setProtectedAgainstExplosive(explosive);
	}

	public boolean isProtectedAgainstToxic() {
		return protectedAgainstToxic;
	}

	public void setProtectedAgainstToxic(boolean toxic) {
		this.protectedAgainstToxic = toxic;
	}

	public boolean isProtectedAgainstExplosive() {
		return protectedAgainstExplosive;
	}

	public void setProtectedAgainstExplosive(boolean explosive) {
		this.protectedAgainstExplosive = explosive;
	}	
	
}

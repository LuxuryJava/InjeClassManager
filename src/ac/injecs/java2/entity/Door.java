package ac.injecs.java2.entity;

public class Door {
	private int uno;
	private String rinfo;
	private boolean doorOpen;
	
	public Door(int uno, String rinfo, boolean doorOpen) {
		this.uno = uno;
		this.rinfo = rinfo;
		this.doorOpen = doorOpen;
	}
	
	public int getuno() {
		return uno;
	}
	
	public String getrinfo() {
		return rinfo;
	}
	
	public boolean doorOpen() {
		return doorOpen;
	}
}

package ac.injecs.java2.entity;

public class Door {
	private String uno;
	private String rinfo;
	private boolean doorOpen;

	public Door(String uno, String rinfo, boolean doorOpen) {
        this.uno = uno;
        this.rinfo = rinfo;
        this.doorOpen = doorOpen;
    }
	public String getuno() {
		return uno;
	}
	
	public String getrinfo() {
		return rinfo;
	}
	
	public boolean getdoorOpen() {
		return doorOpen;
	}
	
	public static class Builder{
		private String uno;
		private String rinfo;
		private boolean doorOpen;

        public Builder setuno(String uno) {
            this.uno = uno;
            return this;
        }

        public Builder setrinfo(String rinfo){
            this.rinfo = rinfo;
            return this;
        }

        public Builder setdoorOpen(boolean doorOpen) {
            this.doorOpen = doorOpen;
            return this;
        }

        public Door build(){
        	Door door = new Door(uno, rinfo, doorOpen);
            return door;
        }
    }
}

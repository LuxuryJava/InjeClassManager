package ac.injecs.java2.entity;

public class Room {
    private String roomInfo;

    private boolean doorOpen;

    private boolean roomUsing;

    private boolean hasProjector;

    private int roomPeople;
    
    public Room(String roomInfo,boolean doorOpen,boolean roomUsing,boolean hasProjector,int roomPeople) {
    	this.roomInfo=roomInfo;
    	this.doorOpen=doorOpen;
    	this.roomUsing=roomUsing;
    	this.hasProjector=hasProjector;
    	this.roomPeople=roomPeople;
    	
    }
    public String getRoomInfo() {
    	return roomInfo;
    }
    
    public boolean getdoorOpen() {
    	return doorOpen;
    }
    public boolean getroomUsing() {
    	return roomUsing;
    }
    public boolean gethasProjector() {
    	return hasProjector;
    }
    public int getroomPeople() {
    	return roomPeople;
    }
}

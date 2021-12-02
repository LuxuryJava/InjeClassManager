package ac.injecs.java2.entity;

public class Room {
	private String roomInfo;

	private boolean doorOpen;

	private boolean roomUsing;

	private boolean hasProjector;

	private int roomPeople;

	public Room(String roomInfo, boolean doorOpen, boolean roomUsing, boolean hasProjector, int roomPeople) {
		this.roomInfo = roomInfo;
		this.doorOpen = doorOpen;
		this.roomUsing = roomUsing;
		this.hasProjector = hasProjector;
		this.roomPeople = roomPeople;

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

	@Override
	public String toString() {
		return "Room{" + "roomInfo='" + roomInfo + '\'' + ", doorOpen=" + doorOpen + ", roomUsing=" + roomUsing
				+ ", hasProjector=" + hasProjector + ", roomPeople=" + roomPeople + '}';
	}

	public static class Builder {
		private String roomInfo;

		private boolean doorOpen;

		private boolean roomUsing;

		private boolean hasProjector;

		private int roomPeople;

		public Builder roomInfo(String roomInfo) {
			this.roomInfo = roomInfo;
			return this;
		}

		public Builder doorOpen(boolean doorOpen) {
			this.doorOpen = doorOpen;
			return this;
		}

		public Builder roomUsing(boolean roomUsing) {
			this.roomUsing = roomUsing;
			return this;
		}

		public Builder hasProjector(boolean hasProjector) {
			this.hasProjector = hasProjector;
			return this;
		}

		public Builder roomPeople(int roomPeople) {
			this.roomPeople = roomPeople;
			return this;
		}

		public Room build() {
			Room room = new Room(roomInfo, doorOpen, roomUsing, hasProjector, roomPeople);
			return room;
		}

	}
}

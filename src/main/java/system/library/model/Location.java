package system.library.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {
	
	@Column(name = "floorNumber")
	private int floorNumber;
	@Column(name = "roomNumber")
	private String roomNumber;
	@Column(name = "rackNumber")
	private String rackNumber;
	@Column(name = "shelfNumber")
	private int shelfNumber;
	@Column(name = "columnNumber")
	private int columnNumber;
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRackNumber() {
		return rackNumber;
	}
	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}
	public int getShelfNumber() {
		return shelfNumber;
	}
	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	public int getColumnNumber() {
		return columnNumber;
	}
	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	} 
	

}

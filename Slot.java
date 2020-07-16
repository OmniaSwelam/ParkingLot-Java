

public abstract class Slot {
	
	private String ID;
	private Vehicle vehicle;
	private ticket t;
	private parkingSlotType type;
	//private boolean free;
	public enum parkingSlotType{
		Compact,
		Regular;
	}

	public Slot(){
		
	}
	public Slot(parkingSlotType type) {
		this.type= type;
	}
	//ID setter and getter
	public void setID (String id) {
		this.ID= id;
	}
	public String getID() {
		return this.ID;
	}
	
	public ticket parkVehicle(Vehicle vehicle, Slot slot) {
		//this.free= false;
		this.vehicle= vehicle;
		this.t= new ticket(vehicle, slot);
		System.out.print("Start time: " + t.getStartTime() + "/ License of parked car: "+ t.getParkedCar() +"/ ID of used slot: "+ t.getUsedSlot());
		return t;
		}

	public void removeVehicle(ticket t) {
		//this.free= true;
		this.vehicle= null;
		
	}	
	public boolean isFree() {
		if (this.vehicle== null)
			return true;
		else
			return false;
	}
}

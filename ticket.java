
public class ticket {
	private final float startTime;
	private final Vehicle parkedCar;
	private final Slot usedSlot;
	
	public ticket(Vehicle vehicle, Slot slot) {
		this.startTime= System.currentTimeMillis();
		this.parkedCar= vehicle;
		this.usedSlot= slot;
	}
	
	public float getStartTime() {
		return this.startTime;
	}
	public String getParkedCar() {
		return parkedCar.getLicenseNum();
	}
	public String getUsedSlot() {
		return usedSlot.getID();
	}
}

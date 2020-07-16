import java.util.ArrayList;
import java.util.HashMap;

public class parkingLot {
	private String name;
	private String address;
	//number of used slots of each type (index)
	private int regularSlotCount=0;
	private int compactSlotCount=0;
	
	//all slots
	private final int maxRegularCount;
	private final int maxCompactCount;
	private ArrayList<Slot> compactSlots;
	private ArrayList<Slot> regularSlots;
	
	//store full slots
	private HashMap<Vehicle, Slot> parkedCars;
	
	
	private ticket t;
	private boolean redSign;
	private boolean isVehicleFound;
	//private boolean isCompactFull;
	
	public parkingLot(int reg, int compact) {
		this.maxRegularCount = reg;
		this.maxCompactCount = compact;
		compactSlots= new ArrayList<Slot>(this.maxCompactCount);
		regularSlots= new ArrayList <Slot>(this.maxRegularCount);		
		for (Integer i=0; i<reg; i++) {
			Slot s= new regularSlots();
			s.setID(i.toString()+'r');
			regularSlots.add(s);
		}
		for (Integer i=0; i<compact; i++) {
			Slot c= new compactSlots();
			c.setID(i.toString()+'c');
			compactSlots.add(c);
		}
		
		parkedCars= new HashMap<Vehicle, Slot>();

	}
	public  ArrayList<Slot> getRegularSlots (){
		for(int i =0; i<regularSlots.size(); i++) {
			System.out.print(regularSlots.get(i).getID());
		}		
		return this.regularSlots;
	}
	public  ArrayList<Slot> getCompactSlots (){
		return this.compactSlots;
	}
	public void setName(String n) {
		this.name=n;
	}
	public String getName() {
		return this.name;
	}
	public void setAddress(String a) {
		this.address=a;
	}
	public String getAddress() {
		return this.address;
	}
	
	
	public boolean isRegFull() {
		if (regularSlotCount== maxRegularCount) {
			//this.isRegularFull= true;
			return true;
		}
		else
			return false;
	}
	
	public boolean isComFull() {
		if (compactSlotCount == maxCompactCount) {
			//this.isCompactFull= true;
			return true;
		}
		else
			return false;
	}
	
	public boolean isFull() {
		if (isRegFull() && isComFull()) {
			this.redSign= true;
			System.out.print("parking lot status: full");
			return true;
		}
		else {
			System.out.print("parking lot status: not full yet");			
			return false;
		}
			
			
	}
	
	public void parkVehicleInSlot(Vehicle vehicle)throws Exception {

		if (vehicle instanceof yarisCars) {
			if (isComFull()) {
				if (isRegFull()) {
					throw new Exception("No available space!");
				}
				//park it in regular
				else {
					this.t= regularSlots.get(regularSlotCount).parkVehicle(vehicle,regularSlots.get(regularSlotCount));
					parkedCars.put(vehicle, regularSlots.get(regularSlotCount));
					System.out.println("Vehicle was parked successfully");
					regularSlotCount++;
				}
				
			}
			//park it in compact
			else {
				this.t= compactSlots.get(this.compactSlotCount).parkVehicle(vehicle, compactSlots.get(this.compactSlotCount));
				parkedCars.put(vehicle, compactSlots.get(this.compactSlotCount));
				System.out.println("Vehicle was parked successfully");
				compactSlotCount++;
			}
					
		} 
		//corolaCars, check regular only
		else {
			if (isRegFull()) {
				throw new Exception("No available space!");
			}
			//park in regular
			else {
				this.t= regularSlots.get(regularSlotCount).parkVehicle(vehicle,getRegularSlots().get(regularSlotCount));
				parkedCars.put(vehicle,  regularSlots.get(regularSlotCount));
				System.out.println("Vehicle was parked successfully");
				regularSlotCount++;
			}
		}
	}
	public void removeVehicleFromSlot (Vehicle vehicle) throws Exception{
		Slot s= searchForVehicle(vehicle);
		if (isVehicleFound) {
			s.removeVehicle(this.t);			
			parkedCars.remove(vehicle,s);
			if(s instanceof regularSlots) regularSlotCount--;
			else if(s instanceof compactSlots) compactSlotCount--;
			System.out.println("Vehicle was removed successfully");
		}
		else
			throw new Exception("VehicleNot found!");
	}
	
	public Slot searchForVehicle(Vehicle vehicle) {
		if(parkedCars.containsKey(vehicle)) {
			isVehicleFound= true;
			System.out.println("Vehicle is already here");
			return parkedCars.get(vehicle);
		}
		else {
			isVehicleFound= false;
			System.out.println("Vehicle is not here!");
			return parkedCars.get(vehicle);
		}			
	}
	
}
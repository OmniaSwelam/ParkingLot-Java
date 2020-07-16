import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws Exception {
		
		parkingLot p= new parkingLot(3,3);
		p.setName("Garage 1");
		p.setAddress("Helwan,Cairo");
		
		//Vehicles
		ArrayList<Vehicle> vehicles= new ArrayList<Vehicle>();
		
		Vehicle y1= new yarisCars();
		yarisCars y2= new yarisCars();
		yarisCars y3= new yarisCars();
		yarisCars y4= new yarisCars();
		
		corolaCars c1= new corolaCars();
		corolaCars c2= new corolaCars();
		//corolaCars c3= new corolaCars();
		
		vehicles.add(y1);
		vehicles.add(y2);
		vehicles.add(y3);
		vehicles.add(y4);
		
		vehicles.add(c1);
		vehicles.add(c2);
		//vehicles.add(c3);
		
	   // for (Integer i=0; i<vehicles.size(); i++) {
	    //	vehicles.get(i).setLicenseNum(i.toString()+"car");
			//p.parkVehicleInSlot(vehicles.get(i));
		//}
		
		//p.getRegularSlots();
		p.parkVehicleInSlot(y1);
		p.parkVehicleInSlot(y2);
		p.parkVehicleInSlot(y3);
		p.parkVehicleInSlot(y4);
		p.parkVehicleInSlot(c1);
		p.parkVehicleInSlot(c2);
		p.isFull();

		//p.removeVehicleFromSlot(y1);
		//p.searchForVehicle(y1);
	}

}

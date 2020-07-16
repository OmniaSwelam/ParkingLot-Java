
public abstract class Vehicle {
	
	private String licenseNum;
	private  vehicleType type;
	//private ticket t;
	public enum vehicleType{
		toyotaYaris,
		toyotaCorola;
	}

	
	public Vehicle(vehicleType type)
	{
		this.type= type;
	}
	
	public void setLicenseNum (String l) {
		this.licenseNum= l;
	}
	public String getLicenseNum() {
		return this.licenseNum;
	}
	public vehicleType getType() {
		return this.type;
	}
	
	
}

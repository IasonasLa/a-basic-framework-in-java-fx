package apalaktikh;

public class twoWheeled extends Vihicle {
private int saetHight;
private int storageUnite;
	twoWheeled(String permissionNumb, String module, String gasType, String carType, int cc, int worth,
			int seatHight,int storageUnite) {
		super(permissionNumb, module, gasType, carType, cc, worth);
		this.saetHight=seatHight;
		this.storageUnite=storageUnite;
		
	}
	public int getSaetHight() {
		return saetHight;
	}
	public void setSaetHight(int saetHight) {
		this.saetHight = saetHight;
	}
	public int getStorageUnite() {
		return storageUnite;
	}
	public void setStorageUnite(int storageUnite) {
		this.storageUnite = storageUnite;
	}

}

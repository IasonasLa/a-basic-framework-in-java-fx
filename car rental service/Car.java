package apalaktikh;

public class Car extends Vihicle {
private int carSeats;
private int doorsNumb;

	public  Car(String permissionNumb, String module, String gasType, String carType, int cc, int worth,int carSeats,
			int doorsNumb) {
		super(permissionNumb, module, gasType, carType, cc, worth);
		this.carSeats=carSeats;
		this.doorsNumb=doorsNumb;
		
	}

	public int getCarSeats() {
		return carSeats;
	}

	public void setCarSeats(int carSeats) {
		this.carSeats = carSeats;
	}

	public int getDoorsNumb() {
		return doorsNumb;
	}

	public void setDoorsNumb(int doorsNumb) {
		this.doorsNumb = doorsNumb;
	}
	

}

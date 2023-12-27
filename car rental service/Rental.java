package apalaktikh;



public class Rental {
	private String reservation;
	private String reservedCar;
	private String reservationName;
	private String pickUpplace;
	private String date;
	private String time;
	private String amount;
	public Rental(String reservation,String reservedCar, String reservationName, String  pickUpplace,String date,
			String time,String amount){
		this.reservation=reservation;
		this.reservedCar=reservedCar;
		this.reservationName=reservationName;
		this.pickUpplace=pickUpplace;
		this.date=date;
		this.time=time;
		this.amount=amount;
		
	

}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getReservedCar() {
		return reservedCar;
	}
	public void setReservedCar(String reservedCar) {
		this.reservedCar = reservedCar;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getPickUpplace() {
		return pickUpplace;
	}
	public void setPickUpplace(String pickUpplace) {
		this.pickUpplace = pickUpplace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}

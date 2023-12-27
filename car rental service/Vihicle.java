package apalaktikh;

public class Vihicle {
private static String permissionNumb;
private String module;
private String gasType;
private String carType;
private int cc;
private int worth;
Vihicle(String permissionNumb,String module, String gasType,String carType,int cc,int worth){
this.permissionNumb=permissionNumb;
this.module=module;
this.gasType=gasType;
this.carType=carType;
this.cc=cc;
this.worth=worth;
}
public static String getPermissionNumb() {
	return permissionNumb;
}
public  void setPermissionNumb(String permissionNumb) {
	this.permissionNumb = permissionNumb;
}
public String getModule() {
	return module;
}
public void setModule(String module) {
	this.module = module;
}
public String getGasType() {
	return gasType;
}
public void setGasType(String gasType) {
	this.gasType = gasType;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
public int getCc() {
	return cc;
}
public void setCc(int cc) {
	this.cc = cc;
}
public int getWorth() {
	return worth;
}
public void setWorth(int worth) {
	this.worth = worth;
}






}

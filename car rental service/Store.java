package apalaktikh;

public class Store {
private String code;
private String sureName;
private String city;
public Store(String code, String sureName,String city){
	this.code=code;
	this.sureName=sureName;
	this.city=city;
	
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getSureName() {
	return sureName;
}
public void setSureName(String sureName) {
	this.sureName = sureName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}


}

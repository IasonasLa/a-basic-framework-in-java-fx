package apalaktikh;

public class Client {
private String id;
private String permNumb;
private String name;
private String eMail;
private String phoneNumb;
public Client (String id, String permNumb,String name,String eMail ,String  phoneNumb){
	this.id=id;
	this.permNumb=permNumb;
	this.name=name;
	this.eMail=eMail;
	this.phoneNumb=phoneNumb;
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPermNumb() {
	return permNumb;
}
public void setPermNumb(String permNumb) {
	this.permNumb = permNumb;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public String getPhoneNumb() {
	return phoneNumb;
}
public void setPhoneNumb(String phoneNumb) {
	this.phoneNumb = phoneNumb;
}

}

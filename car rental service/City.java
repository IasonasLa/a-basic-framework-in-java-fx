package apalaktikh;

public class City {
	private String code;
	private String cityName;
	public static int MAX_CODE=0;
	public City(String code,String cityName){
		this.code=code;
		this.cityName=cityName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}

package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Network {
	private int NetworkID;
	private String SSID;
	private String Password;
	private String Latitude;
	private String Longitude;
	private String Validity;
	
	public Network () {}
	public Network (int netID, String ssid, String pass, String latitude, String longitude, String validity) {
		setNetworkID(netID);
		setSSID(ssid);
		setPassword(pass);
		setLatitude(latitude);
		setLongitude(longitude);
		setValidity(validity);
	}
	public int getNetworkID() {
		return NetworkID;
	}
	public void setNetworkID(int networkID) {
		NetworkID = networkID;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getValidity() {
		return Validity;
	}
	public void setValidity(String validity) {
		Validity = validity;
	}
}

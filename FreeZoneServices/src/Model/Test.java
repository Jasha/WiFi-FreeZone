package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {
	private int TestID;
	private String TestIme;
	
	public Test() {}
	
	public Test(int id, String ime) {
		TestID = id;
		TestIme = ime;
	}

	public int getTestID() {
		return TestID;
	}

	public void setTestID(int testID) {
		TestID = testID;
	}

	public String getTestIme() {
		return TestIme;
	}

	public void setTestIme(String testIme) {
		TestIme = testIme;
	}
}
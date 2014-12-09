package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Test;

public class TestLogic {
	private Connection _connection;

	public TestLogic(Connection connection) {
		_connection = connection;
	}

	public int createTest(Test test) throws SQLException {
		PreparedStatement psCreate;
		int result = 0;
		psCreate = _connection.prepareStatement("INSERT INTO Test (Ime) VALUES (?)");
		psCreate.setString(1, test.getTestIme());
		result = psCreate.executeUpdate();
		return result;
	}
	
	public List<Test> getAllTests() throws SQLException {
		PreparedStatement psGetAll;
		psGetAll = _connection.prepareStatement("SELECT TestID, Ime FROM Test");
		ResultSet resultSet = psGetAll.executeQuery();
		List<Test> tests = new ArrayList<Test>();
		while(resultSet.next()) {
			Test test = new Test();
			test.setTestID(resultSet.getInt(1));
			test.setTestIme(resultSet.getString(2));
			
			tests.add(test);
		}
		resultSet.close();
		
		return tests;
	}

}
package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Network;

public class NetworkLogic {
	private Connection _connection;
	
	public NetworkLogic(Connection connection) {
		_connection = connection;
	}

	public int createNetwork(Network network) throws SQLException {
		PreparedStatement psCreate;
		int result = 0;
		psCreate = _connection.prepareStatement("INSERT INTO network (SSID, Password, Latitude, Longitude, Validity) VALUES (?, ?, ?, ?, ?)");
		psCreate.setString(1, network.getSSID());
		psCreate.setString(2, network.getPassword());
		psCreate.setString(3, network.getLatitude());
		psCreate.setString(4, network.getLongitude());
		psCreate.setString(5, network.getValidity());
		result = psCreate.executeUpdate();
		return result;
	}
	
	public List<Network> getAllNetworks() throws SQLException {
		PreparedStatement psGetAll;
		psGetAll = _connection.prepareStatement("SELECT NetworkID, SSID, Password, Latitude, Longitude, Validity FROM network");
		ResultSet resultSet = psGetAll.executeQuery();
		List<Network> networks = new ArrayList<Network>();
		while (resultSet.next()) {
			Network network = new Network();
			network.setNetworkID(resultSet.getInt(1));
			network.setSSID(resultSet.getString(2));
			network.setPassword(resultSet.getString(3));
			network.setLatitude(resultSet.getString(4));
			network.setLongitude(resultSet.getString(5));
			network.setValidity(resultSet.getString(6));
			networks.add(network);
		}
		resultSet.close();
		return networks;
		
	}
	
}

package connection;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class mysql_connection {

	public Connection dbConn()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test", "beytullah",
				"beytullah");
		return con;
	}
}

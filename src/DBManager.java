import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private final static String DB_NAME="student";
	private final static String URL =
			"jdbc:postgresql://localhost:5432/"+DB_NAME;
	private final static String USER_NAME="postgres";
	private final static String PASSWORD="postgres";
	
	public static Connection createConnection() {
		try {
			Connection con =
					DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			return con;
			
		} catch (Exception e) {
			throw new RuntimeException("DBê⁄ë±Ç…é∏îsÇµÇ‹ÇµÇΩÅB",e);
		}
		
	}
	
	public static void closeConnestion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
		}
		
	}
	
	
}

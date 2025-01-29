package sportmateinc.sportmatebusinesslayer.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sportmateinc.sportmatebusinesslayer.entities.Location;
import sportmateinc.sportmatedblayer.SportMateDB;

public class LocationService {
	
	private LocationService() {}
	
	private static Logger logger = Logger.getLogger(LocationService.class);

	public static List<Location> findAll() {

		List<Location> resultList = new ArrayList<>();
		Statement stmt = null;
		SportMateDB db = SportMateDB.getInstance();
		try {
			db.apriConnessione();
			stmt = db.getConnectionDetails().createStatement();
			String sql = "SELECT * FROM CENTRISPORTIVI WHERE LATITUDINE != 0 OR LONGITUDINE != 0";
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				String[] parts = result.getString(3).split(",");
				resultList.add(new Location(result.getInt(1), parts[3] + " " + parts[4], parts[0] + ", " + parts[1] + " " + parts[2], result.getString(2),
						result.getDouble(4), result.getDouble(5)));
			}
			stmt.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			db.chiudiConnessione();
		}
		return resultList;

	}
}

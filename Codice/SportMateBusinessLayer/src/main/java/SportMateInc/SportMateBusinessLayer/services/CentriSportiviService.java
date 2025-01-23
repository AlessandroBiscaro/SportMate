package SportMateInc.SportMateBusinessLayer.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;

import SportMateInc.SportMateBusinessLayer.entity.Location;
import sportmateinc.sportmatedblayer.SportMateDB;

public class CentriSportiviService {

	public static List<Location> getLocation(){
		
		List<Location> resultList = new ArrayList<>();
		
		try {
			SportMateDB db = SportMateDB.getInstance();
			db.apriConnessione();
			DSLContext create = db.getContext();
			if (db != null) {
				Statement stmt = db.getConnectionDetails().createStatement();
				String sql = "SELECT * FROM CENTRISPORTIVI ";
				ResultSet result = stmt.executeQuery(sql);
//				while (result.next()) {
				for (int i=1; i<3; i++) {
					String[] parts = result.getString(3).split(",");

					resultList.add(new Location(result.getInt(1),parts[4], parts[2], result.getString(2), result.getDouble(4),result.getDouble(5)));
				}
				stmt.close();
				db.chiudiConnessione();
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return resultList;
		
		
	}
	
}

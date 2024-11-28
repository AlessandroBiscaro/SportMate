package SportMateInc.SportMateDBLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SportMateDB {
	private Connection connection;
	private static SportMateDB database = null;
	private static final String DB_REL_FILE = "../resources/SportMate.db";
	private static final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	private static final Logger LOGGER = LogManager.getLogger(SportMateDB.class);
	
	
	
	public static SportMateDB instance() {
		if(database == null) {
				database = new SportMateDB();
		}
		return database;
	}
	
	private SportMateDB(){
		try {
		connection = DriverManager.getConnection(DB_URL);
		if(connection != null) {
			LOGGER.info("Connection to SportMateDB successfully started!");
		}
	} catch (SQLException e) {
		LOGGER.info(String.format("Connection to SportMateDB failed: %s",e.getMessage()));
	}
	}
	
}

/*
 * SportMateDB
 */
package sportmateinc.sportmatedblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sportmateinc.sportmatedblayer.exceptions.InvalidOperationException;

/**
 * La classe fornisce un'utile astrazione per gestire la connessione al database
 * <i>embedded</i> usato in SportMate, di seguito denominato <i>SportMateDB</i>.
 * 
 * @version 1.0
 * @since 1.0
 */

public class SportMateDB {

	private Connection connection = null;
	private static SportMateDB database = null;
	private static final String DB_REL_FILE = "./src/main/resources/SportMateDB.db";
	private static final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	private static final Logger LOGGER = LogManager.getLogger(SportMateDB.class);

	/**
	 * Instanzia un nuovo componente <i>SportMateDB</i>.
	 * 
	 * @return l'istanza di <i>SpormateDB</i> attivata
	 */

	public static SportMateDB instance() {
		if (database == null) {
			database = new SportMateDB();
		}
		return database;
	}

	private SportMateDB() {
	}

	/**
	 * Instaura una nuova connessione a <i>SportMateDB</i>.
	 */

	public void apriConnessione() throws InvalidOperationException {
		try {
			connection = DriverManager.getConnection(DB_URL);
			LOGGER.info("Connection to SportMateDB successfully started!");
		} catch (SQLException e) {
			LOGGER.error(String.format("Connection to SportMateDB failed: %s", e.getMessage()));
		}
	}

	/**
	 * Interrompe la connessione a <i>SportMateDB</i>.
	 */

	public void chiudiConnessione() {
		try {
			connection.close();
		} catch (SQLException e) {
			LOGGER.error(String.format("Closing connection to SportMateDB failed: %s", e.getMessage()));
		}
	}

	/**
	 * Restituisce il percorso relativo associato al file in cui è memorizzato
	 * SportMateDB.
	 * 
	 * @return l'URL relativo del file
	 */
	public static String getDbRelFile() {
		return DB_REL_FILE;
	}

	/**
	 * Restituisce l'URL di connessione a <i>SportMateDB</i>.
	 * 
	 * @return l'URL di connessione a SportMateDB
	 */
	public static String getDbUrl() {
		return DB_URL;
	}

	/**
	 * Restituisce l'oggetto rappresentante la connessione attualmente attiva a
	 * <i>SportMateDB</i>.
	 * 
	 * @return l'oggetto {@link Connection} associato a <i>SportMateDB</i>
	 */
	public Connection getConnectionDetails() {
		return connection;
	}

}

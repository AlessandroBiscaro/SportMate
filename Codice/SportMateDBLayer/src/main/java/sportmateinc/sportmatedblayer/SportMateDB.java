/*
 * SportMateDB
 */
package sportmateinc.sportmatedblayer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * La classe fornisce un'utile astrazione per gestire la connessione al database
 * <i>embedded</i> usato in SportMate, di seguito denominato <i>SportMateDB</i>.
 * 
 * @version 1.0
 * @since 1.0
 */

public class SportMateDB {

	private static final String DB_NAME = "SportMateDB.db";
	private static final Logger LOGGER = LogManager.getLogger(SportMateDB.class);
	private static final String DB_REL_FILE = getDBRelFile();
	private static final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	private Connection connection = null;
	private static SportMateDB database = null;

	/**
	 * Instanzia un nuovo componente <i>SportMateDB</i>.
	 * 
	 * @return l'istanza di <i>SpormateDB</i> attivata
	 */

	public static SportMateDB getInstance() {
		if (database == null) {
			database = new SportMateDB();
		}
		return database;
	}

	private static String getDBRelFile() {
		String filePath = System.getProperty("user.home") + "/SportMate/data";
		URL resource = SportMateDB.class.getClassLoader().getResource(DB_NAME);
		
		if (resource == null) {
			LOGGER.error("SportMateDBFile not found!");
		}
		
		File permanentDbFile = new File(filePath, DB_NAME);
		try {
			Files.createDirectories(Paths.get(filePath));
			if (!permanentDbFile.exists()) {
				extractDatabase(permanentDbFile);
				LOGGER.info(String.format("Database initiliazed in %s: ", permanentDbFile.getAbsolutePath()));
			}
		} catch (IOException e) {
			LOGGER.error(String.format("Error while initializing SportMateDB: %s", e.getMessage()));
		}
		return permanentDbFile.getAbsolutePath();

	}

	private static void extractDatabase(File permanentDbFile) throws IOException {

		InputStream inputStream = SportMateDB.class.getClassLoader().getResourceAsStream(DB_NAME);
		if (inputStream == null) {
			throw new IllegalStateException("Impossibile aprire il file database: " + DB_NAME);
		}
		Files.copy(inputStream, permanentDbFile.toPath());

	}

	private SportMateDB() {
	}

	/**
	 * Instaura una nuova connessione a <i>SportMateDB</i>.
	 */

	public void apriConnessione() {
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
	 * @return l'URL di connessione a <i>SportMateDB</i>
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

package sportmateinc.sportmatedblayer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SportMateDBTest {

	private File tempDbFile;

	@Test
	public final void testApriConnessione() throws SQLException {
		// Metodo che controlla se la connessione è aperta correttamente
		SportMateDB connection = SportMateDB.getInstance();
		connection.apriConnessione();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.getConnectionDetails().createStatement();
			rs = stmt.executeQuery("SELECT * FROM sqlite_sequence");
			assertTrue("Connessione a SportMateDB non instaturata correttamente!", rs.next());
		} finally {
			stmt.close();
			rs.close();
		}
	}

	@Test
	public final void testChiudiConnessione() throws SQLException {
		SportMateDB connection = SportMateDB.getInstance();
		connection.apriConnessione();
		connection.chiudiConnessione();
		assertTrue("Connessione a SportMateDB non chiusa correttamente", connection.getConnectionDetails().isClosed());
	}

	@Test
	public final void testGetInstance() {
		SportMateDB connection = SportMateDB.getInstance();
		assertNotNull("Metodo instance della classe SportMateDB errato", connection);
		SportMateDB c2 = SportMateDB.getInstance();
		assertSame("Metodo instance della classe SportMateDB errato", connection, c2);
	}

	@Test
	public final void testGetDbURL() {
		assertEquals("Metodo getDbUrl della classe SportMateDB errato", SportMateDB.getDbUrl(),
				"jdbc:sqlite:" + SportMateDB.getDbRelFile());
	}

	@Test
	public final void testGetDbRelFile() {
		assertEquals("Metodo getDbRelFile della classe SportMateDB errato", SportMateDB.DB_REL_FILE,
				SportMateDB.getDbRelFile());
	}

	@Test
	public final void testGetDbName() {
		assertEquals("Metodo getDbName della classe SportMateDB errato", SportMateDB.DB_NAME, SportMateDB.getDbName());
	}

	@Before
	public void setUp() throws IOException {
		tempDbFile = File.createTempFile("test-db", ".db");
		tempDbFile.deleteOnExit();
	}

	@After
	public void tearDown() {
		tempDbFile.delete();
	}

	@Test
	public void testExtractDatabaseSuccessfulxtraction() throws IOException {
		assertTrue("Il file temporaneo dovrebbe essere eliminato", tempDbFile.delete());
		SportMateDB.extractDatabase(tempDbFile);
		assertTrue("Il file dovrebbe essere stato creato", tempDbFile.exists());
		assertTrue("Il file non dovrebbe essere vuoto", tempDbFile.length() > 0);
	}

	@Test(expected = FileAlreadyExistsException.class)
	public void testExtractDatabaseFileAlreadyExistsThrowsException() throws IOException {
		// Il file è già stato creato durante il setUp()
		SportMateDB.extractDatabase(tempDbFile);
	}

	@Test(expected = NullPointerException.class)
	public void testExtractDatabaseNullFileThrowsNullPointerException() throws IOException {
		SportMateDB.extractDatabase(null);
	}

}

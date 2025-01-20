package sportmateinc.sportmatedblayer;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class SportMateDBTest {

	@Test
	public final void testApriConnessione() throws SQLException {
		//metodo che controlla se la connessione è aperta correttamente
		SportMateDB connection = SportMateDB.getInstance();
		connection.apriConnessione();
		Statement stmt = null;
		ResultSet rs =null;
		try {
		   stmt = connection.getConnectionDetails().createStatement();
		   rs = stmt.executeQuery("SELECT 1");
		   assertTrue("Connessione a SportMateDB non instaturata correttamente!",rs.next());
		}
		finally {
		   if (stmt != null) stmt.close();
		   if (rs != null) rs.close();
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
		assertEquals("Metodo getDbUrl della classe SportMateDB errato", SportMateDB.getDbUrl(), "jdbc:sqlite:" + SportMateDB.getDbRelFile());
	}
	
	@Test
	public final void testGetDbRelFile() {
		assertEquals("Metodo getDbUrl della classe SportMateDB errato", SportMateDB.DB_REL_FILE, SportMateDB.getDbRelFile());
	}
	
}

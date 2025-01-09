package sportmateinc.sportmatedblayer;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import sportmateinc.sportmatedblayer.exceptions.InvalidOperationException;

public class SportMateDBTest {

	@Test
	public final void testApriConnessione() throws SQLException, InvalidOperationException {
		SportMateDB connection = SportMateDB.instance();
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
	public final void testChiudiConnessione() throws SQLException, InvalidOperationException {
		SportMateDB connection = SportMateDB.instance();
		connection.apriConnessione();
		connection.chiudiConnessione();
		assertTrue("Connessione a SportMateDB non chiusa correttamente", connection.getConnectionDetails().isClosed());
	}

	@Test
	public final void testGetInstance() {
		SportMateDB connection = SportMateDB.instance();
		assertNotNull("Metodo instance della classe SportMateDB errato", connection);
		SportMateDB c2 = SportMateDB.instance();
		assertSame("Metodo instance della classe SportMateDB errato", connection, c2);
	}

}

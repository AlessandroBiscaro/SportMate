package sportmateinc.sportmatedblayer;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import sportmateinc.sportmatedblayer.exceptions.InvalidOperationException;

public class SportMateDBTest {

	private SportMateDB connection;

	public SportMateDBTest() {
		this.connection = SportMateDB.instance();
	}

	@Test
	public final void testApriConnessione() throws SQLException {
		assertFalse("Connessione non aperta", connection.isClosed());
	}

	@Test
	public final void testConnessioneValida() throws SQLException {
		assertTrue("Connessione non valida", connection.isValid(5));
	}

	@Test
	public final void testChiudiConnessione() throws SQLException, InvalidOperationException {
		connection.chiudiConnessione();
		assertTrue("Connessione aperta", connection.isClosed());
	}
	
	@SuppressWarnings("null")
	@Test(expected = InvalidOperationException.class)
	public final void testChiudiConnessioneIllegale() throws InvalidOperationException {
		SportMateDB c1 = null;
		c1.chiudiConnessione();
	}
	
	@Test(expected = InvalidOperationException.class)
	public final void testApriConnessioneIllegale() throws InvalidOperationException {
		connection.apriConnessione();
	}


	@Test
	public final void testGetInstance() {
		assertNotNull("Metodo instance della classe SportMateDB errato", connection);
		SportMateDB c2 = SportMateDB.instance();
		assertSame("Metodo instance della classe SportMateDB errato", connection, c2);
	}

}

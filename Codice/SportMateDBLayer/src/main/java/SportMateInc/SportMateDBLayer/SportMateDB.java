package SportMateInc.SportMateDBLayer;

public class SportMateDB {
	public static String DB_REL_FILE = "resources/SportMate.db";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	//Usa singleton
	
	public SportMate() {
		apriConnessione();
	}
	
	public Boolean apriConnessione() {
		return true;
	}
	
	
}

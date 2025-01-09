package SportMateInc.SportMateBusinessLayer;


import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

import sportmateinc.sportmatedblayer.SportMateDB;
/**
 * La classe contiene i metodi necessari per interfacciarsi con 
 * <i>SportMateDB</i>, senza la necessità di scrivere istruzioni
 * SQL esplicite.
 * @see SportMateDB
 * @version 1.0 
 * @since 1.0
 */
public class GenerateJooq {
	private static final String DB_URL = "jdbc:sqlite:" + "../SportMateDBLayer/" + SportMateDB.getDbRelFile();
	private GenerateJooq() {}
	
	/**
	 * Genera le classi necessarie per modellare le tabelle e i record  memorizzati
	 * in <i>SportMateDB</i>.
	 * @throws Exception se il processo di generazione automatica non va a buon fine
	 */
	
	public static void generateJooq() throws Exception {
		Jdbc JDBC = new Jdbc().withDriver("org.sqlite.JDBC").withUrl(DB_URL);
		Database database = new Database().withName("org.jooq.meta.sqlite.SQLiteDatabase").withIncludes(".*")
				.withExcludes("");
		
		Target target = new Target().withPackageName("SportMateInc.SportMateBusinessLayer").withDirectory("src-generated/");
		Generator generator = new Generator().withDatabase(database).withTarget(target);
		Configuration configuration = new Configuration().withJdbc(JDBC).withGenerator(generator);
		GenerationTool.generate(configuration);
	}
	
	public static void main(String[] args) {
		try {
			generateJooq();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


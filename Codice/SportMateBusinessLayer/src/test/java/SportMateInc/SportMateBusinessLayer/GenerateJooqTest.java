package SportMateInc.SportMateBusinessLayer;
import org.junit.BeforeClass;
import org.junit.Test;

import sportmateinc.sportmatedblayer.SportMateDB;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Target;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Configuration;

public class GenerateJooqTest {
	
	@BeforeClass
	public static void setUp() {
		 BasicConfigurator.configure();
	     Logger.getRootLogger().setLevel(Level.ERROR);
	}
	
    @Test
    public void testJdbcConfiguration() {
        Jdbc jdbc = new Jdbc()
                .withDriver("org.sqlite.JDBC")
                .withUrl("jdbc:sqlite:" + SportMateDB.getDbRelFile());

        assertEquals("Il driver JDBC dovrebbe essere corretto", "org.sqlite.JDBC", jdbc.getDriver());
        assertNotNull("L'URL del database non dovrebbe essere nullo", jdbc.getUrl());
        assertFalse("L'URL del database non dovrebbe essere vuoto", jdbc.getUrl().isEmpty());
    }

    @Test
    public void testDatabaseConfiguration() {
        Database database = new Database()
                .withName("org.jooq.meta.sqlite.SQLiteDatabase")
                .withIncludes(".*")
                .withExcludes("");

        assertEquals("Il nome del database dovrebbe essere SQLiteDatabase",
                "org.jooq.meta.sqlite.SQLiteDatabase", database.getName());
        assertEquals("Il pattern di inclusione dovrebbe includere tutto", ".*", database.getIncludes());
        assertEquals("Il pattern di esclusione dovrebbe essere vuoto", "", database.getExcludes());
    }

    @Test
    public void testTargetConfiguration() {
        Target target = new Target()
                .withPackageName("SportMateInc.SportMateBusinessLayer")
                .withDirectory("src-generated/");

        assertEquals("Il package name dovrebbe essere corretto",
                "SportMateInc.SportMateBusinessLayer", target.getPackageName());
        assertEquals("La directory di destinazione dovrebbe essere src-generated/",
                "src-generated/", target.getDirectory());
    }

    @Test
    public void testFullConfiguration() {
        Jdbc jdbc = new Jdbc().withDriver("org.sqlite.JDBC").withUrl("jdbc:sqlite:" + SportMateDB.getDbRelFile());
        Database database = new Database().withName("org.jooq.meta.sqlite.SQLiteDatabase").withIncludes(".*").withExcludes("");
        Target target = new Target().withPackageName("SportMateInc.SportMateBusinessLayer").withDirectory("src-generated/");
        Generator generator = new Generator().withDatabase(database).withTarget(target);
        
        Configuration configuration = new Configuration().withJdbc(jdbc).withGenerator(generator);

        assertNotNull("La configurazione dovrebbe essere creata correttamente", configuration);
        assertEquals("Il driver dovrebbe essere corretto", "org.sqlite.JDBC", configuration.getJdbc().getDriver());
        assertEquals("Il package generato dovrebbe essere corretto", 
                "SportMateInc.SportMateBusinessLayer", configuration.getGenerator().getTarget().getPackageName());
    }
}

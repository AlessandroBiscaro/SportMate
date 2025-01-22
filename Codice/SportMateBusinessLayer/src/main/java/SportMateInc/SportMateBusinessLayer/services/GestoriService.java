package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Gestori.GESTORI;
import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jooq.DSLContext;
import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.entity.Gestore;
import SportMateInc.SportMateBusinessLayer.entity.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;

public class GestoriService {

	
	private GestoriService() {}
	
	public static Gestore findByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(GESTORI)
		.where(GESTORI.MAIL.eq(username))
		.fetchOne();
		db.chiudiConnessione();
		return new Gestore(result.get(GESTORI.IDGESTORE), 
						   result.get(GESTORI.MAIL),
						   result.get(GESTORI.NOME),
						   result.get(GESTORI.COGNOME), 
						   LocalDate.parse(result.get(GESTORI.DATANASCITA)), 
						   result.get(GESTORI.TELEFONO), 
						   result.get(GESTORI.PASSWORD));
	}
	
	public static int aggiungiGestore(Gestore admin) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();	
		return create.insertInto(GESTORI, GESTORI.IDGESTORE, GESTORI.NOME, GESTORI.COGNOME, GESTORI.DATANASCITA, GESTORI.MAIL, GESTORI.TELEFONO, GESTORI.PASSWORD)
		.values(admin.getIdGestore(), admin.getNome(), admin.getCognome(), DateTimeFormatter.ofPattern("YYYY/MM/DD").format(admin.getDataNascita()), admin.getMail(), admin.getTelefono(), admin.getPassword())
		.execute();
	}
	
	public static int AggiornaDatiGestore(Gestore admin) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		return create.update(GESTORI)
	            .set(GESTORI.NOME, admin.getNome())
	            .set(GESTORI.COGNOME, admin.getCognome())
	            .set(GESTORI.MAIL, admin.getMail())
	            .set(GESTORI.DATANASCITA, DateTimeFormatter.ofPattern("YYYY/MM/DD").format(admin.getDataNascita())) 
	            .set(GESTORI.TELEFONO, admin.getTelefono())
	            .set(GESTORI.PASSWORD, admin.getPassword())
	            .where(GESTORI.IDGESTORE.eq(admin.getIdGestore())) 
	            .execute(); 
	}
	
	
	
	
	
}

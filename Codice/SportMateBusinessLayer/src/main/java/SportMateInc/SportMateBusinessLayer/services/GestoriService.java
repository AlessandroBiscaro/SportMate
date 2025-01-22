package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Gestori.GESTORI;

import java.time.LocalDate;
import org.jooq.DSLContext;
import org.jooq.Record;
import SportMateInc.SportMateBusinessLayer.entity.Gestore;
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
		return create.insertInto(GESTORI, GESTORI.NOME, GESTORI.COGNOME, GESTORI.DATANASCITA, GESTORI.MAIL, GESTORI.TELEFONO, GESTORI.PASSWORD)
		.values(admin.getNome(), admin.getCognome(), admin.getDataNascita().toString(), admin.getMail(), admin.getTelefono(), admin.getPassword())
		.execute();
	}
	
	public static int aggiornaDatiGestore(Gestore admin) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		return create.update(GESTORI)
	            .set(GESTORI.NOME, admin.getNome())
	            .set(GESTORI.COGNOME, admin.getCognome())
	            .set(GESTORI.MAIL, admin.getMail())
	            .set(GESTORI.DATANASCITA, admin.getDataNascita().toString()) 
	            .set(GESTORI.TELEFONO, admin.getTelefono())
	            .set(GESTORI.PASSWORD, admin.getPassword())
	            .where(GESTORI.IDGESTORE.eq(admin.getIdGestore())) 
	            .execute(); 
	}
}

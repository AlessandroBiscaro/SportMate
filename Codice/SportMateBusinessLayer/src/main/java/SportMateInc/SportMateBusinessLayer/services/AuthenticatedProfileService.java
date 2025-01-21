package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;
import static SportMateInc.SportMateBusinessLayer.tables.Gestori.GESTORI;

import org.jooq.DSLContext;
import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.entity.AuthenticatedProfile;
import sportmateinc.sportmatedblayer.SportMateDB;

public class AuthenticatedProfileService {

	private AuthenticatedProfileService() {}
	
	public static AuthenticatedProfile findUserByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select(UTENTI.MAIL, UTENTI.NOME, UTENTI.PASSWORD)
				.from(UTENTI)
		.where(UTENTI.MAIL.eq(username))
		.fetchOne();
		db.chiudiConnessione();
		if(result == null) {
			return null;
		}
		return new AuthenticatedProfile(result.get(UTENTI.MAIL), result.get(UTENTI.PASSWORD), result.get(UTENTI.NOME));
	}
	
	public static AuthenticatedProfile findManagerByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select(GESTORI.MAIL, GESTORI.NOME, GESTORI.PASSWORD)
				.from(GESTORI)
		.where(GESTORI.MAIL.eq(username))
		.fetchOne();
		db.chiudiConnessione();
		if(result == null) {
			return null;
		}
		return new AuthenticatedProfile(result.get(GESTORI.MAIL), result.get(GESTORI.PASSWORD), result.get(GESTORI.NOME));
	}
	
	public static AuthenticatedProfile findProfileByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select(GESTORI.MAIL, GESTORI.NOME, GESTORI.PASSWORD)
				.from(GESTORI)
		.where(GESTORI.MAIL.eq(username))
		.unionAll(create.select(UTENTI.MAIL, UTENTI.NOME, UTENTI.PASSWORD)
				.from(UTENTI)
		.where(UTENTI.MAIL.eq(username)))
		.fetchOne();
		db.chiudiConnessione();
		return new AuthenticatedProfile(result.get(GESTORI.MAIL), result.get(GESTORI.PASSWORD), result.get(GESTORI.NOME));
	}
	
}

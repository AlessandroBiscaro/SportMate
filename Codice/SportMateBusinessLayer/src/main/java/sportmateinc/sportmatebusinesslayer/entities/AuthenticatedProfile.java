package sportmateinc.sportmatebusinesslayer.entities;

public class AuthenticatedProfile {
	
	private final String username;
	private final String password;
	private final String nome;
	
	public AuthenticatedProfile(String username, String password, String nome) {
		if(username == null) {
			throw new NullPointerException("AuthenticatedProfile.username could not be null!");
		}
		if(password == null) {
			throw new NullPointerException("AuthenticatedProfile.password could not be null!");
		}
		if(nome == null) {
			throw new NullPointerException("AuthenticatedProfile.nome could not be null!");
		}
		this.username = username;
		this.password = password;
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public String getNome() {
		return nome;
	}
	
}

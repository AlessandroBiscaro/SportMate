package sportmateinc.sportmatebusinesslayer.entities;

public class Feedback {
	private final Integer idFeedback;
	private String oggetto;
	private String testo;
	private int numLike;
	private Utente mittente;

	public Feedback(Integer idFeedback, String oggetto, String testo, int numLike, Utente mittente) {
		this.idFeedback = idFeedback;
		setOggetto(oggetto);
		setTesto(testo);
		setNumLike(numLike);
		setMittente(mittente);
	}

	public Integer getIdFeedback() {
		return idFeedback;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		if (oggetto == null) {
			throw new NullPointerException("Feedback.Oggetto must not be null!");
		}
		this.oggetto = oggetto;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public int getNumLike() {
		return numLike;
	}

	public void setNumLike(int numLike) {
		if (numLike < 0) {
			throw new IllegalArgumentException("Feedback.numLike must be greater than zero!");
		}
		this.numLike = numLike;
	}

	public Utente getMittente() {
		return mittente;
	}

	public void setMittente(Utente mittente) {
		if (mittente == null) {
			throw new NullPointerException("Feedback.Mittente must not be null!");
		}
		this.mittente = mittente;
	}
}

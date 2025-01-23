package SportMateInc.SportMateBusinessLayer.entity;

public class Feedback {
	private final Integer idFeedback;
	private String oggetto;
	private String testo;
	private Integer numLike;
	private Utente mittente;
	
	public Feedback(Integer idFeedback, String oggetto, String testo, Integer numLike, Utente mittente) {
		this.idFeedback = idFeedback;
		setOggetto(oggetto);
		setTesto(testo);
		setNumLike(numLike);
		setMittente(mittente);
	}
	
	/**
	 * @return the idFeedback
	 */
	public Integer getIdFeedback() {
		return idFeedback;
	}
	/**
	 * @return the oggetto
	 */
	public String getOggetto() {
		return oggetto;
	}
	/**
	 * @param oggetto the oggetto to set
	 */
	public void setOggetto(String oggetto) {
		if(oggetto == null) {
			throw new NullPointerException("Feedback.Oggetto must not be null!");
		}
		this.oggetto = oggetto;
	}
	/**
	 * @return the testo
	 */
	public String getTesto() {
		return testo;
	}
	/**
	 * @param testo the testo to set
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}
	/**
	 * @return the numLike
	 */
	public Integer getNumLike() {
		return numLike;
	}
	/**
	 * @param numLike the numLike to set
	 */
	public void setNumLike(Integer numLike) {
		if(numLike < 0) {
			throw new IllegalArgumentException("Feedback.numLike must be greater than zero!");
		}
		this.numLike = numLike;
	}
	/**
	 * @return the mittente
	 */
	public Utente getMittente() {
		return mittente;
	}
	/**
	 * @param mittente the mittente to set
	 */
	public void setMittente(Utente mittente) {
		if(mittente == null) {
			throw new NullPointerException("Feedback.Mittente must not be null!");
		}
		this.mittente = mittente;
	}
}

package sportmateinc.sportmatebusinesslayer.entities;

public class Partita {

	private int idPartita;
	private int postiTot;
	private int pubblica;
	private int stato;
	private String modPagamento;
	private int idOrgan;
	private int idDisp;
	private int goalCasa;
	private int goalFuori;

	public Partita(int idPartita, int postiTot, int pubblica, int stato, String modPagamento, int idOrgan, int idDisp) {

		this.idPartita = idPartita;
		this.postiTot = postiTot;
		this.pubblica = pubblica;
		this.stato = stato;
		this.modPagamento = modPagamento;
		this.idOrgan = idOrgan;
		this.idDisp = idDisp;
		this.goalCasa = 0;
		this.goalFuori = 0;
	}

	public Partita(int postiTot, int pubblica, int stato, String modPagamento, int idOrgan, int idDisp) {
		this(0, postiTot, pubblica, stato, modPagamento, idOrgan, idDisp);
	}

	public int getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}

	public int getPostiTot() {
		return postiTot;
	}

	public void setPostiTot(int postiTot) {
		this.postiTot = postiTot;
	}

	public int getPubblica() {
		return pubblica;
	}

	public void setPubblica(int pubblica) {
		this.pubblica = pubblica;
	}

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}

	public String getModPagamento() {
		return modPagamento;
	}

	public void setModPagamento(String modPagamento) {
		this.modPagamento = modPagamento;
	}

	public int getIdOrgan() {
		return idOrgan;
	}

	public void setIdOrgan(int idOrgan) {
		this.idOrgan = idOrgan;
	}

	public int getIdDisp() {
		return idDisp;
	}

	public void setIdDisp(int idDisp) {
		this.idDisp = idDisp;
	}

	public int getGoalCasa() {
		return goalCasa;
	}

	public void setGoalCasa(int goalCasa) {
		this.goalCasa = goalCasa;
	}

	public int getGoalFuori() {
		return goalFuori;
	}

	public void setGoalFuori(int goalFuori) {
		this.goalFuori = goalFuori;
	}

}

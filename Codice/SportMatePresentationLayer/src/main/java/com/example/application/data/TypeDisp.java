package com.example.application.data;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class TypeDisp extends AbstractEntity {

    private boolean prenotato;
    private LocalDateTime dataOra;
    private String tipologiaCampo;
    private Integer prezzo;
    private boolean spogliatoi;
    private String note;

    public boolean isPrenotato() {
        return prenotato;
    }
    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }
    public LocalDateTime getDataOra() {
        return dataOra;
    }
    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }
    public String getTipologiaCampo() {
        return tipologiaCampo;
    }
    public void setTipologiaCampo(String tipologiaCampo) {
        this.tipologiaCampo = tipologiaCampo;
    }
    public Integer getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }
    public boolean isSpogliatoi() {
        return spogliatoi;
    }
    public void setSpogliatoi(boolean spogliatoi) {
        this.spogliatoi = spogliatoi;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

}

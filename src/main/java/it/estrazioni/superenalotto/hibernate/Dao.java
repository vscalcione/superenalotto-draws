package it.estrazioni.superenalotto.hibernate;

import it.estrazioni.superenalotto.hibernate.EstrazioniTo;

import java.util.List;

public interface Dao {
    public void insert(EstrazioniTo to);
    public List<EstrazioniTo> read(EstrazioniTo to);
}

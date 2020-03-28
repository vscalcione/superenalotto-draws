package it.estrazioni.superenalotto.hibernate.dao;

import it.estrazioni.superenalotto.hibernate.EstractionsTo;

import java.util.List;

public interface Dao {
    void insert(EstractionsTo to);
    List<EstractionsTo> read(EstractionsTo to);
}

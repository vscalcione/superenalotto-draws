package it.estrazioni.superenalotto.hibernate.bo;

import it.estrazioni.superenalotto.hibernate.dao.Dao;
import it.estrazioni.superenalotto.hibernate.dao.DaoImpl;
import it.estrazioni.superenalotto.hibernate.EstrazioniTo;

import java.util.ArrayList;
import java.util.List;

public class BaseObjectImpl implements BaseObject{

    public boolean convalidate(Integer[] array) {
        Dao daoImpl = new DaoImpl();
        EstrazioniTo to = new EstrazioniTo();
        to.setN1(array[0]);
        to.setN2(array[1]);
        to.setN3(array[2]);
        to.setN4(array[3]);
        to.setN5(array[4]);
        to.setN6(array[5]);
        List<EstrazioniTo> listTo = new ArrayList<EstrazioniTo>();
        listTo = daoImpl.read(to);
        if(listTo != null) {
            return false;
        }else{
            return true;
        }
    }
}

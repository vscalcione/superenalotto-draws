package it.estrazioni.superenalotto.hibernate.dao;

import it.estrazioni.superenalotto.hibernate.EstractionsTo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DaoImpl implements Dao{

    private EntityManager entityManager;

    public DaoImpl() {
    }

    public DaoImpl(EntityManager entityManager) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void insert(EstractionsTo to) {

    }

    @Override
    public List<EstractionsTo> read(EstractionsTo to) {
        String query = "FROM EstractionsTo WHERE n1=:n1 AND n2=:n2 AND n3=:n3 AND n4=:n4 AND n5=:n5 AND n6=:n6";
        return this.entityManager.createQuery(query, EstractionsTo.class)
                .setParameter("n1", to.getN1())
                .setParameter("n2", to.getN2())
                .setParameter("n3", to.getN3())
                .setParameter("n4", to.getN4())
                .setParameter("n5", to.getN5())
                .setParameter("n6", to.getN6())
                .getResultList();
    }
}

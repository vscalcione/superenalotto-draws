package it.estrazioni.superenalotto.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Estrazioni")
public class EstrazioniTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Concorso")
    private int concorso;

    @Column(name="Data")
    private int data;

    @Column(name="n1")
    private int n1;

    @Column(name="n2")
    private int n2;

    @Column(name="n3")
    private int n3;

    @Column(name="n4")
    private int n4;

    @Column(name="n5")
    private int n5;

    @Column(name="n6")
    private int n6;

    @Column(name="jolly")
    private int jolly;

    @Column(name="superstar")
    private int superstar;

    @Column(name="Valuta")
    private String valuta;

    @Column(name="sei")
    private int sei;

    @Column(name="Quotasei")
    private String quotaSei;

    @Column(name="Cinquepiu")
    private int cinquePiu;

    @Column(name="QuotaCinquePiu")
    private String quotaCinquePiu;

    @Column(name="Cinque")
    private int cinque;

    @Column(name="QuotaCinque")
    private String quotaCinque;

    @Column(name="Quattro")
    private int quattro;

    @Column(name="QuotaQuattro")
    private String quotaQuattro;

    @Column(name="Tre")
    private int tre;

    @Column(name="QuotaTre")
    private String quotaTre;

    @Column(name="Due")
    private int due;

    @Column(name="QuotaDue")
    private String quotaDue;

    @Column(name="jackpot")
    private String jackpot;

    @Column(name="SuperVincitore")
    private String superVincitore;

    public EstrazioniTo () {
    }

    public int getConcorso() {
        return concorso;
    }

    public void setConcorso(int concorso) {
        this.concorso = concorso;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getN6() {
        return n6;
    }

    public void setN6(int n6) {
        this.n6 = n6;
    }

    public int getJolly() {
        return jolly;
    }

    public void setJolly(int jolly) {
        this.jolly = jolly;
    }

    public int getSuperstar() {
        return superstar;
    }

    public void setSuperstar(int superstar) {
        this.superstar = superstar;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public int getSei() {
        return sei;
    }

    public void setSei(int sei) {
        this.sei = sei;
    }

    public String getQuotaSei() {
        return quotaSei;
    }

    public void setQuotaSei(String quotaSei) {
        this.quotaSei = quotaSei;
    }

    public int getCinquePiu() {
        return cinquePiu;
    }

    public void setCinquePiu(int cinquePiu) {
        this.cinquePiu = cinquePiu;
    }

    public String getQuotaCinquePiu() {
        return quotaCinquePiu;
    }

    public void setQuotaCinquePiu(String quotaCinquePiu) {
        this.quotaCinquePiu = quotaCinquePiu;
    }

    public int getCinque() {
        return cinque;
    }

    public void setCinque(int cinque) {
        this.cinque = cinque;
    }

    public String getQuotaCinque() {
        return quotaCinque;
    }

    public void setQuotaCinque(String quotaCinque) {
        this.quotaCinque = quotaCinque;
    }

    public int getQuattro() {
        return quattro;
    }

    public void setQuattro(int quattro) {
        this.quattro = quattro;
    }

    public String getQuotaQuattro() {
        return quotaQuattro;
    }

    public void setQuotaQuattro(String quotaQuattro) {
        this.quotaQuattro = quotaQuattro;
    }

    public int getTre() {
        return tre;
    }

    public void setTre(int tre) {
        this.tre = tre;
    }

    public String getQuotaTre() {
        return quotaTre;
    }

    public void setQuotaTre(String quotaTre) {
        this.quotaTre = quotaTre;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public String getQuotaDue() {
        return quotaDue;
    }

    public void setQuotaDue(String quotaDue) {
        this.quotaDue = quotaDue;
    }

    public String getJackpot() {
        return jackpot;
    }

    public void setJackpot(String jackpot) {
        this.jackpot = jackpot;
    }

    public String getSuperVincitore() {
        return superVincitore;
    }

    public void setSuperVincitore(String superVincitore) {
        this.superVincitore = superVincitore;
    }
}

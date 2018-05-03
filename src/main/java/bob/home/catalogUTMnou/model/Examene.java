package bob.home.catalogUTMnou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Examene {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Grupa grupa;

    @ManyToOne
    private Disciplina disciplina;

    private String data;
    private String ora;
    private String tipExamen;
    private String anScolar;
    private String an;
    private String semestru;

    @ManyToOne
    private Profesor profesor;

    public Examene() {
    }

    public Examene(Grupa grupa, Disciplina disciplina, String data, String ora, String tipExamen, String anScolar, String an, String semestru, Profesor profesor) {
        this.grupa = grupa;
        this.disciplina = disciplina;
        this.data = data;
        this.ora = ora;
        this.tipExamen = tipExamen;
        this.anScolar = anScolar;
        this.an = an;
        this.semestru = semestru;
        this.profesor = profesor;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getSemestru() {
        return semestru;
    }

    public void setSemestru(String semestru) {
        this.semestru = semestru;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIntervalOrar() {
        return ora;
    }

    public void setIntervalOrar(String intervalOrar) {
        this.ora = intervalOrar;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getTipExamen() {
        return tipExamen;
    }

    public void setTipExamen(String tipExamen) {
        this.tipExamen = tipExamen;
    }

    public String getAnScolar() {
        return anScolar;
    }

    public void setAnScolar(String anScolar) {
        this.anScolar = anScolar;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}

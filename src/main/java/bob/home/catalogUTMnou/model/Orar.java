package bob.home.catalogUTMnou.model;

import javax.persistence.*;

@Entity
public class Orar {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Grupa grupa;

    @ManyToOne
    private Disciplina disciplina;

    private String intervalOrar;
    private String zi;

    @ManyToOne
    private Profesor profesor;

    @Enumerated(value = EnumType.STRING)
    private AnScolar anScolar;

    private String an;
    private String semestru;


    public Orar() {
    }

    public Orar(Grupa grupa, Disciplina disciplina, String intervalOrar, String zi, Profesor profesor, AnScolar anScolar, String an, String semestru) {
        this.grupa = grupa;
        this.disciplina = disciplina;
        this.intervalOrar = intervalOrar;
        this.zi = zi;
        this.profesor = profesor;
        this.anScolar = anScolar;
        this.an = an;
        this.semestru = semestru;
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

    public String getIntervalOrar() {
        return intervalOrar;
    }

    public void setIntervalOrar(String intervalOrar) {
        this.intervalOrar = intervalOrar;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public AnScolar getAnScolar() {
        return anScolar;
    }

    public void setAnScolar(AnScolar anScolar) {
        this.anScolar = anScolar;
    }


}

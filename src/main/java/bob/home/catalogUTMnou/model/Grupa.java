package bob.home.catalogUTMnou.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Grupa {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    private String numeGrupa;
    private String anStart;
    private String semestru;

    @ManyToOne
    private Facultate facultate ;

    @Enumerated(value = EnumType.STRING)
    private AnScolar anScolar;

    @ManyToMany(mappedBy = "grupa")
    private Set<Disciplina> disciplina;

    public Grupa() {
    }

    public Grupa(String numeGrupa, String anStart, String semestru, Facultate facultate, AnScolar anScolar) {
        this.numeGrupa = numeGrupa;
        this.anStart = anStart;
        this.semestru = semestru;
        this.facultate = facultate;
        this.anScolar = anScolar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeGrupa() {
        return numeGrupa;
    }

    public void setNumeGrupa(String numeGrupa) {
        this.numeGrupa = numeGrupa;
    }

    public String getAnStart() {
        return anStart;
    }

    public void setAnStart(String anStart) {
        this.anStart = anStart;
    }

    public String getSemestru() {
        return semestru;
    }

    public void setSemestru(String semestru) {
        this.semestru = semestru;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public Set<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Set<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public AnScolar getAnScolar() {
        return anScolar;
    }

    public void setAnScolar(AnScolar anScolar) {
        this.anScolar = anScolar;
    }
}



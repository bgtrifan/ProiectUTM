package bob.home.catalogUTMnou.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Disciplina {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private long id;

    private String denumire;

    @ManyToOne
    private Profesor profesor;

    @ManyToOne
    private Facultate facultate;

    private Integer nrCredite;
    private Integer an;
    private Integer semestru;

    @ManyToMany
    @JoinTable(name="DISCIPLINE_GRUPE",
               joinColumns=@JoinColumn(name="DISCIPLINA_ID", referencedColumnName = "ID"),
               inverseJoinColumns = @JoinColumn(name = "GRUPA_ID", referencedColumnName = "ID"))
    private Set<Grupa> grupa;

    public Disciplina() {
    }

    public Disciplina(String denumire, Profesor profesor, Facultate facultate, Integer nrCredite, Integer an, Integer semestru, Set<Grupa> grupa) {
        this.denumire = denumire;
        this.profesor = profesor;
        this.facultate = facultate;
        this.nrCredite = nrCredite;
        this.an = an;
        this.semestru = semestru;
        this.grupa = grupa;
    }

    public Disciplina(String denumire, Profesor profesor, Facultate facultate, Integer nrCredite, Integer an, Integer semestru) {
        this.denumire = denumire;
        this.profesor = profesor;
        this.facultate = facultate;
        this.nrCredite = nrCredite;
        this.an = an;
        this.semestru = semestru;
    }

    public Set<Grupa> getGrupa() {
        return grupa;
    }

    public void setGrupa(Set<Grupa> grupa) {
        this.grupa = grupa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(Integer nrCredite) {
        this.nrCredite = nrCredite;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Integer getSemestru() {
        return semestru;
    }

    public void setSemestru(Integer semestru) {
        this.semestru = semestru;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}

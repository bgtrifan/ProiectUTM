package bob.home.catalogUTMnou.model;


import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Disciplina disciplina;

    private String nota;
    private String an;
    private String semestru;

    @Enumerated(value = EnumType.STRING)
    private StatusNota status;

    private String crediteObtinute;
    private String dataNota;

    @Enumerated(value = EnumType.STRING)
    private AnScolar anScolar;

    public Note() {
    }

    public Note(Student student, Disciplina disciplina, String nota, String an, String semestru, StatusNota status, String crediteObtinute, String dataNota, AnScolar anScolar) {
        this.student = student;
        this.disciplina = disciplina;
        this.nota = nota;
        this.an = an;
        this.semestru = semestru;
        this.status = status;
        this.crediteObtinute = crediteObtinute;
        this.dataNota = dataNota;
        this.anScolar = anScolar;
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

    public String getCrediteObtinute() {
        return crediteObtinute;
    }

    public void setCrediteObtinute(String crediteObtinute) {
        this.crediteObtinute = crediteObtinute;
    }

    public String getDataNota() {
        return dataNota;
    }

    public void setDataNota(String dataNota) {
        this.dataNota = dataNota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    public StatusNota getStatus() {
        return status;
    }

    public void setStatus(StatusNota status) {
        this.status = status;
    }

    public AnScolar getAnScolar() {
        return anScolar;
    }

    public void setAnScolar(AnScolar anScolar) {
        this.anScolar = anScolar;
    }
}

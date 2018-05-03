package bob.home.catalogUTMnou.model;

public class FiltruNote {

    private AnScolar anScolar;
    private String an;
    private String semestru;
    private Disciplina disciplina;
    private Grupa grupa;

    public FiltruNote() {
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public AnScolar getAnScolar() {
        return anScolar;
    }

    public void setAnScolar(AnScolar anScolar) {
        this.anScolar = anScolar;
    }

    public String getSemestru() {
        return semestru;
    }

    public void setSemestru(String semestru) {
        this.semestru = semestru;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }
}

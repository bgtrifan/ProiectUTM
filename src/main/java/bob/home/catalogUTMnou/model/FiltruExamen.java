package bob.home.catalogUTMnou.model;

public class FiltruExamen {

    private AnScolar anScolar;
    private String an;
    private String semestru;

    public FiltruExamen() {
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

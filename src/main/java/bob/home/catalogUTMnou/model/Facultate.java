package bob.home.catalogUTMnou.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Facultate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String numeFacultate;
    private String formaInvatamant;

    public Facultate(String numeFacultate, String formaInvatamant) {
        this.numeFacultate = numeFacultate;
        this.formaInvatamant = formaInvatamant;
    }

    public Facultate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeFacultate() {
        return numeFacultate;
    }

    public void setNumeFacultate(String numeFacultate) {
        this.numeFacultate = numeFacultate;
    }

    public String getFormaInvatamant() {
        return formaInvatamant;
    }

    public void setFormaInvatamant(String formaInvatamant) {
        this.formaInvatamant = formaInvatamant;
    }
}

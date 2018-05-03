package bob.home.catalogUTMnou.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nume;
    private String prenume;
    private String cnp;
    private String adresa;
    private String telefon;
    private String email;
    @ManyToOne
    private Grupa grupa;
    private String username;
    private String parola;
//    @ManyToOne
//    private Roles role;
    private String dataNastere;
    @ManyToOne
    private Facultate facultate;
    private String an;
    private String promotie;

    public Student() {
    }


    public Student(String nume, String prenume, String cnp, String adresa, String telefon, String email, Grupa grupa, String username, String parola,  String dataNastere, Facultate facultate, String an, String promotie) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.grupa = grupa;
        this.username = username;
        this.parola = parola;
//        this.role = role;
        this.dataNastere = dataNastere;
        this.facultate = facultate;
        this.an = an;
        this.promotie = promotie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }


    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getPromotie() {
        return promotie;
    }

    public void setPromotie(String promotie) {
        this.promotie = promotie;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }
}

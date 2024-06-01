public class Magazin {
    private String nume;
    private String categorie;
    private Dreptunghi coordonate_geografice;
    private String zona;
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public Dreptunghi getCoordonate_geografice() {
        return coordonate_geografice;
    }
    public void setCoordonate_geografice(Dreptunghi coordonate_geografice) {
        this.coordonate_geografice = coordonate_geografice;
    }
    public Magazin(String nume, String categorie, Dreptunghi coordonate_geografice) {
        this.nume = nume;
        this.categorie = categorie;
        this.coordonate_geografice = coordonate_geografice;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    @Override
    public String toString() {
        return "Magazin{" +
                "nume=" + nume +
                ", categorie=" + categorie +
                ", coordonate_geografice=" + coordonate_geografice +
                '}';
    }
}

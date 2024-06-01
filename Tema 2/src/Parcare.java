public class Parcare {
    private String nume;
    private int numar_locuri;
    private Dreptunghi coordonate_geografice;
    private String zona;
    public String getNume() {
        return nume;
    }
    public int getNumar_locuri() {
        return numar_locuri;
    }
    public Dreptunghi getCoordonate_geografice() {
        return coordonate_geografice;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setNumar_locuri(int numar_locuri) {
        this.numar_locuri = numar_locuri;
    }
    public void setCoordonate_geografice(Dreptunghi coordonate_geografice) {
        this.coordonate_geografice = coordonate_geografice;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public Parcare(String nume, int numar_locuri, Dreptunghi coordonate_geografice) {
        this.nume = nume;
        this.numar_locuri = numar_locuri;
        this.coordonate_geografice = coordonate_geografice;
    }
    @Override
    public String toString() {
        return "Parcare{" +
                "nume='" + nume + '\'' +
                ", numar_locuri=" + numar_locuri +
                ", coordonate_geografice=" + coordonate_geografice +
                '}';
    }
}

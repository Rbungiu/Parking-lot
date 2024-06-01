import java.util.ArrayList;

public class ZonaComerciala {
    private static ArrayList<Magazin> magazine = new ArrayList<>();
    private String nume;
    private Dreptunghi coordonate_geografice;
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public Dreptunghi getCoordonate_geografice() {
        return coordonate_geografice;
    }
    public void setCoordonate_geografice(Dreptunghi coordonate_geografice) {
        this.coordonate_geografice = coordonate_geografice;
    }
    public ZonaComerciala(String nume, Dreptunghi coordonate_geografice) {
        this.nume = nume;
        this.coordonate_geografice = coordonate_geografice;
    }
    public void adaugareMagazin(Magazin m){
        magazine.add(m);
    }
    public void stergeMagazine(){
        magazine.clear();
    }

    @Override
    public String toString() {
        return "ZonaComerciala{" +
                "nume='" + nume + '\'' +
                ", coordonate_geografice=" + coordonate_geografice +
                ", magazie=" + magazine +
                '}';
    }
}

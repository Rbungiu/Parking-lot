import java.util.ArrayList;

public class ZonaParcare {
    private String denumire;
    private Dreptunghi coordonate_geografice;
    private int tarif;
    private static ArrayList<Parcare> parcari=new ArrayList<>();
    public Dreptunghi getCoordonate_geografice() {
        return coordonate_geografice;
    }
    public void setCoordonate_geografice(Dreptunghi coordonate_geografice) {
        this.coordonate_geografice = coordonate_geografice;
    }
    public int getTarif() {
        return tarif;
    }
    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public ZonaParcare(String denumire, Dreptunghi coordonate_geografice, int tarif) {
        this.denumire = denumire;
        this.coordonate_geografice = coordonate_geografice;
        this.tarif = tarif;

    }
    public void adugareParcare(Parcare p){
        parcari.add(p);
    }
    public void stergeParcari(){
        parcari.clear();
    }

    @Override
    public String toString() {
        return "ZonaParcare{" +
                "denumire='" + denumire + '\'' +
                ", coordonate_geografice=" + coordonate_geografice +
                ", tarif=" + tarif +
                ", parcari=" + parcari +
                '}';
    }
}

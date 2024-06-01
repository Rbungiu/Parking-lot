import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

public class Main {
    static HashMap<Integer, ZonaParcare> zoneDeParcare = new HashMap<>();
    static HashMap<Integer, Parcare> parcari = new HashMap<>();
    static HashMap<Integer, ZonaComerciala> zoneComerciale = new HashMap<>();
    static HashMap<Integer, Magazin> magazine = new HashMap<>();
    static HashMap<String, ArrayList<LocalTime>> situatieParcari=new HashMap<>();
    public static void main(String[] args) {
        int y=0;
        int x=0;
        try {
            Scanner sc=new Scanner(new File("parcari.txt"));
            while(sc.hasNext()){
                String s=sc.nextLine();
                String []nume=s.split(":");
                String denumire=nume[0];
                if(denumire.charAt(0)=='Z') {
                    x++;
                    String []zonaParcare = s.split(",");
                    int coordN=Integer.parseInt(zonaParcare[0].replaceAll("[^0-9]", ""));
                    int coordS=Integer.parseInt(zonaParcare[1].replaceAll("[^0-9]", ""));
                    int coordV=Integer.parseInt(zonaParcare[2].replaceAll("[^0-9]", ""));
                    int coordE=Integer.parseInt(zonaParcare[3].replaceAll("[^0-9]", ""));
                    Point N=new Point(0, coordN);
                    Point S=new Point(0, -coordS);
                    Point V=new Point(-coordV, 0);
                    Point E=new Point(coordE, 0);
                    Dreptunghi dreptunghi=new Dreptunghi(N, S, V, E);
                    ZonaParcare zonaParcare1=new ZonaParcare(denumire, dreptunghi, 0);
                    zoneDeParcare.put(x,zonaParcare1);

                }
                else {
                    String[] parcare = s.split(",");
                    String[] coord1=parcare[0].split(":");
                    String[] coord2=parcare[3].split(":");
                    int coordN=Integer.parseInt(coord1[1].replaceAll("[^0-9]", ""));
                    int coordS=Integer.parseInt(parcare[1].replaceAll("[^0-9]", ""));
                    int coordV=Integer.parseInt(parcare[2].replaceAll("[^0-9]", ""));
                    int coordE=Integer.parseInt(coord2[0].replaceAll("[^0-9]", ""));
                    int locuri=Integer.parseInt(nume[2].replaceAll("[^0-9]", ""));
                    Point N=new Point(0, coordN);
                    Point S=new Point(0, -coordS);
                    Point V=new Point(-coordV, 0);
                    Point E=new Point(coordE, 0);
                    Dreptunghi dreptunghi=new Dreptunghi(N, S, V, E);
                    Parcare parcare1=new Parcare(denumire, locuri, dreptunghi);
                    if(zoneDeParcare.get(x)!=null) {
                        parcare1.setZona(zoneDeParcare.get(x).getDenumire());
                        zoneDeParcare.get(x).adugareParcare(parcare1);
                    }
                    y++;
                    parcari.put(y, parcare1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu s-a gasit fisierul");
        }
        x=0;
        y=0;
        try{
            Scanner sc=new Scanner(new File("comercial.txt"));
            while(sc.hasNext()){
                String s=sc.nextLine();
                String []nume=s.split(":");
                String denumire=nume[0];
                if(denumire.charAt(0)=='Z' && denumire.charAt(1)=='o' && denumire.charAt(2)=='n' && denumire.charAt(3)=='a'){
                    x++;
                    String []zonaComerciala = s.split(",");
                    int coordN=Integer.parseInt(zonaComerciala[0].replaceAll("[^0-9]", ""));
                    int coordS=Integer.parseInt(zonaComerciala[1].replaceAll("[^0-9]", ""));
                    int coordV=Integer.parseInt(zonaComerciala[2].replaceAll("[^0-9]", ""));
                    int coordE=Integer.parseInt(zonaComerciala[3].replaceAll("[^0-9]", ""));
                    Point N=new Point(0, coordN);
                    Point S=new Point(0, -coordS);
                    Point V=new Point(-coordV, 0);
                    Point E=new Point(coordE, 0);
                    Dreptunghi dreptunghi=new Dreptunghi(N, S, V, E);
                    ZonaComerciala zonaComerciala1=new ZonaComerciala(denumire, dreptunghi);
                    zoneComerciale.put(x, zonaComerciala1);
                }
                else {
                    String[] magazin = s.split(",");
                    int coordN=Integer.parseInt(magazin[0].replaceAll("[^0-9]", ""));
                    int coordS=Integer.parseInt(magazin[1].replaceAll("[^0-9]", ""));
                    int coordV=Integer.parseInt(magazin[2].replaceAll("[^0-9]", ""));
                    int coordE=Integer.parseInt(magazin[3].replaceAll("[^0-9]", ""));
                    String tip=nume[2];
                    Point N=new Point(0, coordN);
                    Point S=new Point(0, -coordS);
                    Point V=new Point(-coordV, 0);
                    Point E=new Point(coordE, 0);
                    Dreptunghi dreptunghi=new Dreptunghi(N, S, V, E);
                    Magazin magazin1=new Magazin(denumire, tip, dreptunghi);
                    if(zoneComerciale.get(x)!=null) {
                        magazin1.setZona(zoneComerciale.get(x).getNume());
                        zoneComerciale.get(x).adaugareMagazin(magazin1);
                    }
                    y++;
                    magazine.put(y, magazin1);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Nu s-a gasit fisierul");
        }
        Scanner sc=new Scanner(System.in);
        int n, s, v, e;
        System.out.println("N:");
        n= sc.nextInt();
        System.out.println("S:");
        s= sc.nextInt();
        System.out.println("V:");
        v= sc.nextInt();
        System.out.println("E:");
        e= sc.nextInt();
        Point N=new Point(0, n);
        Point S=new Point(0, -s);
        Point V=new Point(-v, 0);
        Point E=new Point(e, 0);
        Dreptunghi masina=new Dreptunghi(N,S,V,E);
        //1.
        Point centruMasina=masina.centru();
        if(parcari!=null) {
            double distMin = Math.hypot(parcari.get(1).getCoordonate_geografice().centru().x - centruMasina.x, parcari.get(1).getCoordonate_geografice().centru().y - centruMasina.y);
            Parcare pMin = parcari.get(1);
            for (int i = 2; i <= parcari.size(); i++) {
                if (masina.getN().y <= parcari.get(i).getCoordonate_geografice().getN().y && masina.getS().y >= parcari.get(i).getCoordonate_geografice().getS().y && masina.getV().x >= parcari.get(i).getCoordonate_geografice().getV().x && masina.getE().x <= parcari.get(i).getCoordonate_geografice().getE().x) {
                    pMin = parcari.get(i);
                    break;
                }
                double distActuala = Math.hypot(parcari.get(i).getCoordonate_geografice().centru().x - centruMasina.x, parcari.get(i).getCoordonate_geografice().centru().y - centruMasina.y);
                if (distActuala < distMin) {
                    distMin = distActuala;
                    pMin = parcari.get(i);
                }
            }
            System.out.print("1. ");
            System.out.println(pMin.getZona() + " " + pMin);
        }
        else{
            System.out.println("Nu exista parcari");
        }
        LocalTime time =LocalTime.of(10, 0);
        System.out.println("Ce fisier doriti sa cititi?");
        x=sc.nextInt();
        int flag=1;
        try {
            Scanner scanner= new Scanner(new File("situatieParcari"+x+"_ora10.00.txt"));
            while(scanner.hasNext()){
                ArrayList<LocalTime> ore=new ArrayList<>();
                String string=scanner.nextLine();
                String []linie=string.split(" ");
                String nume=linie[0];
                int poz=Integer.parseInt(nume.replaceAll("[^0-9]", ""));
                for(int i=1;i<linie.length;i++){
                    String []ora=linie[i].split(",");
                    LocalTime oraOcupata=LocalTime.parse(ora[0]);
                    if(oraOcupata.isBefore(time)){
                        flag=0;
                        break;
                    }
                    ore.add(oraOcupata);
                }
                if(parcari.get(poz).getNumar_locuri()<ore.size()){
                    flag=0;
                }
                if (flag==0){
                    break;
                }
                situatieParcari.put(nume, ore);
            }
        }catch (FileNotFoundException a) {
            System.out.println("Nu s-a gasit fisierul");
            flag=0;
        }
        if(flag==1 && parcari!=null) {
            //2.
            int locuriMax = parcari.get(1).getNumar_locuri() - situatieParcari.get(parcari.get(1).getNume()).size();
            Parcare p = parcari.get(1);
            for (int i = 2; i <= parcari.size(); i++) {
                int locuriLibere = parcari.get(i).getNumar_locuri() - situatieParcari.get(parcari.get(i).getNume()).size();
                if (locuriLibere > locuriMax) {
                    locuriMax = locuriLibere;
                    p = parcari.get(i);
                }
            }
            if (locuriMax > 0) {
                System.out.print("2. ");
                System.out.println(p.getZona() + " " + p.getNume() + " " + locuriMax + " " + p.getCoordonate_geografice());
            } else {
                //3.
                LocalTime oraMin = LocalTime.MAX;
                Parcare pO = parcari.get(1);
                for (int i = 1; i <= situatieParcari.size(); i++) {
                    for (int j = 1; j < situatieParcari.get(parcari.get(i).getNume()).size(); j++) {
                        if (situatieParcari.get(parcari.get(i).getNume()).get(j).isBefore(oraMin)) {
                            oraMin = situatieParcari.get(parcari.get(i).getNume()).get(j);
                            pO = parcari.get(i);
                        }
                    }
                }
                System.out.print("3. ");
                System.out.println(oraMin + " " + pO.getZona() + " " + pO.getNume() + " " + pO.getCoordonate_geografice());
            }
        }
        else{
            System.out.println("Nici una dintre cerinte nu poate fi rezolvata deoarece fisierul are erori sau nu poate fi gasit");
        }
        //4.
        if(magazine!=null) {
            double distMin = Math.hypot(magazine.get(1).getCoordonate_geografice().centru().x - centruMasina.x, magazine.get(1).getCoordonate_geografice().centru().y - centruMasina.y);
            Magazin mMin = magazine.get(1);
            for (int i = 2; i <= magazine.size(); i++) {
                if (Objects.equals(magazine.get(i).getCategorie(), " farmacie")) {
                    double distActuala = Math.hypot(magazine.get(i).getCoordonate_geografice().centru().x - centruMasina.x, magazine.get(i).getCoordonate_geografice().centru().y - centruMasina.y);
                    if (distActuala < distMin) {
                        distMin = distActuala;
                        mMin = magazine.get(i);
                    }
                }
            }
            System.out.print("4. ");
            System.out.println(mMin.getZona() + " " + mMin.getNume());
        }
        else{
            System.out.println("Nu exista magzazine");
        }
    }
}
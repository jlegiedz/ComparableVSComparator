import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.xml.internal.xsom.impl.UName.comparator;

/**
 * Created by asia on 10/09/17.
 */
public class Pracownik implements Comparable<Pracownik> {
    private String imie;
    private String nazwisko;
    private double pensja;

    public Pracownik(String imie, String nazwisko, double pensja){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = pensja;
    }
    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public double getPensja(){
        return pensja;
    }

    @Override
    public int compareTo(Pracownik o) {
        int pensja = Double.compare(getPensja(),o.getPensja());
        if(pensja ==0){
            return getNazwisko().compareTo(o.getNazwisko());
        }
        return pensja;

    }

    public String toString(){
        return imie +", " + nazwisko + ", " + pensja;
    }


    public static void main(String[] args) {
        List<Pracownik> listaPracownikow = new ArrayList<>();
        listaPracownikow.add(new Pracownik("Barbara","Nowak", 6768.33));
        listaPracownikow.add(new Pracownik("Janusz","Sowakowski", 4768.33));
        listaPracownikow.add(new Pracownik("Zygmunt","Glowa", 32768.33));
        listaPracownikow.add(new Pracownik("Jolanta","Badula", 32768.33));
        listaPracownikow.add(new Pracownik("Magdalena","Badula", 32768.33));


//        Collections.sort(listaPracownikow);
//        for(Pracownik pracownik:listaPracownikow){
//            System.out.println(pracownik);
//        }


        //anonymous implementation of Comparator

//        Collections.sort(listaPracownikow, new Comparator<Pracownik>() {
//            @Override
//            public int compare(Pracownik o1, Pracownik o2) {
//                int nazwisko = o1.getNazwisko().compareTo(o2.getNazwisko());
//                if(nazwisko ==0){
//                    return o1.getImie().compareTo(o2.getImie());
//                }
//                return nazwisko;
//            }
//        });

        Collections.sort(listaPracownikow, (o1 ,o2) ->
        { return o1.getImie().compareTo(o2.getImie());
        });

        for(Pracownik pracownik:listaPracownikow){
            System.out.println(pracownik);
        }
    }

}

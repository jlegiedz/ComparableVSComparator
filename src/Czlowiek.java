import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.sort;

/**
 * Created by asia on 16/07/17.
 */
public class Czlowiek implements Comparable<Czlowiek>{
    private String imie;
    private String nazwisko;
    private char plec;

    public Czlowiek(char plec,String imie, String nazwisko) {
        this.plec = plec;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public char getPlec(){
        return plec;
    }
    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }

    public String toString(){
        return  plec + ": " + imie + ", " + nazwisko;
    }


    // implementing method compareTo of Comparable interface
    @Override
    public int compareTo(Czlowiek o) {
        int porownaneNazwiska =  nazwisko.compareTo(o.nazwisko);
        if(porownaneNazwiska == 0){
            return imie.compareTo(o.imie);
        }
        else {
            return porownaneNazwiska;
        }
    }

    public static void main(String[] args) {
        List<Czlowiek>  ludzie = new ArrayList<Czlowiek>();
        ludzie.add(new Czlowiek('K',"Joanna", "Legiedz"));
        ludzie.add(new Czlowiek('M',"Rafal", "Legiedz"));
        ludzie.add(new Czlowiek('K',"Magdalena", "Bajer"));
        ludzie.add(new Czlowiek('M',"Zbiegniew", "Nowak"));

        System.out.println("nieposortowana lista:");
        for(Czlowiek czlowiek: ludzie) {
            System.out.println(czlowiek);
        }
        System.out.println("----------------");

        // If any class implements comparable inteface then collection
        // of that object can be sorted automatically
        // using Collection.sort() or Arrays.sort().Object will be sorted
        // on the basis of compareTo method in that class.

        sort(ludzie);

        // sort(List<T>, Comparator<? super T>)
        // to sort using comparator interface, my class doesnt have to
        // implement Comparator- a third class can do that-CzlowiekComparator

       sort(ludzie,new CzlowiekComparator());

        System.out.println("posortowana lista:");
        for(Czlowiek czlowiek: ludzie) {
            System.out.println(czlowiek);
        }


    }
}

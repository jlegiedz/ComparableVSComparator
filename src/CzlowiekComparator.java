import java.util.Comparator;

/**
 * Created by asia on 16/07/17.
 */
//Class whose objects to be sorted do not need to implement this interface.
public class CzlowiekComparator implements Comparator<Czlowiek> {
    @Override
    public int compare(Czlowiek o1, Czlowiek o2) {
        int plec = o1.getPlec()- o2.getPlec();
        if(plec == 0){
            return o1.compareTo(o2);
        }
            return plec;
    }
}

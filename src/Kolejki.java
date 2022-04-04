import java.util.ArrayList;
import java.util.Random;

public class Kolejki {

    private static Random random = new Random();

    public static ArrayList<zlecenie>kolejka_bez_priorytetów(int dlugosc,int zakres_cylindra, int max_czas_wejscia){
        ArrayList<zlecenie> zlecenia = new ArrayList<>();
        zlecenia.add(new zlecenie(1,random.nextInt(0,zakres_cylindra),0));
        for(int i=1; i < dlugosc; i++){
            zlecenia.add(new zlecenie(i+1,random.nextInt(0,zakres_cylindra), random.nextInt(0,max_czas_wejscia)));
        }
        return zlecenia;
    }
}

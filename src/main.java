import java.util.ArrayList;
import java.util.Comparator;

public class main {
    public static void main(String[] args){
        ArrayList<zlecenie> zlecenia = Kolejki.kolejka_bez_priorytetów(8,100,50);
        System.out.println(zlecenia);
        System.out.println(Algorytmy.FCFS(zlecenia));
        zlecenia.sort(Comparator.comparingInt(zlecenie::getCzas_zgloszenia));
        System.out.println(zlecenia);
    }
}

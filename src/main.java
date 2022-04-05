import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wiaj w symulatorze algorytmów dostępu do dysku!\nPodaj dlugość ciągu zleceń jakie algorytmy mają otrzymać");
        int dlug = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj długość dysku (Adres ostatniej ścieżki)");
        int cyl = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj maksymalny czas zgłoszenia się procesu");
        int czas = Integer.parseInt(scan.nextLine());

        ArrayList<zlecenie> zlecenia = Kolejki.kolejka_bez_priorytetów(dlug,cyl,czas);
        for(zlecenie z :zlecenia)
            System.out.println(z);
        System.out.println(Algorytmy.FCFS(zlecenia));
        System.out.println(Algorytmy.SSTF(zlecenia));
        System.out.println(Algorytmy.CSCAN(zlecenia,cyl));

    }
}

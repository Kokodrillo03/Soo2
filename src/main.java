import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
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
        System.out.println("--------------------------------------------------------------------");
        ArrayList<zlecenie> zlecenia = Kolejki.kolejka_bez_priorytetów(dlug,cyl,czas);

        System.out.println("Lista wygenerowanych zleceń:");
        for(zlecenie z :zlecenia)
            System.out.println(z);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu FCFS "+Algorytmy.FCFS(zlecenia));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu SSTF "+Algorytmy.SSTF(zlecenia));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu SCAN "+Algorytmy.SCAN(zlecenia,cyl));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu CSCAN "+Algorytmy.CSCAN(zlecenia,cyl));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Przechodzimy do testu algorytmow w czasie rzeczywistym");
        System.out.println("W tym celu podaj kilka niezbednych parametrów!");
        System.out.println("Podaj częstość występowania procesow z priorytetem(Priorytet zostanie nadanym jednemu procesowi na podaną ilość)");
        int czedtosc = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj czas jaki zostanie nadany procesowi na jego obsłużenie");
        int czass = Integer.parseInt(scan.nextLine());
        Kolejki.Dodaj_priorytety(zlecenia,czedtosc,czass);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu EDF "+Algorytmy.EDF(zlecenia));
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Ilość przesunięć głowicy przy zastosowaniu algorytmu FD-SCAN "+Algorytmy.FD_SCAN(zlecenia,cyl));

    }
}

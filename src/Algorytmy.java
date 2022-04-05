import java.util.ArrayList;
import java.util.Comparator;

public class Algorytmy {


    public static int FCFS(ArrayList<zlecenie> zlecenia){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        while(!copy.isEmpty()||!aktualna_kolejka.isEmpty()){
            for(int i = copy.size()-1; i >= 0;i--){
                if(copy.get(i).getCzas_zgloszenia()<=czas){
                    aktualna_kolejka.add(copy.get(i));
                    copy.remove(i);
                }
            }
            if(aktualna_kolejka.isEmpty()){
                czas++;
            }else {
                aktualna_kolejka.sort(Comparator.comparingInt(zlecenie::getCzas_zgloszenia));
                int a = (aktualna_kolejka.get(0).getNr_cylindra() - head_pos);
                przesunięcia += Math.abs(a);
                czas += Math.abs(a);
                head_pos = aktualna_kolejka.get(0).getNr_cylindra();
                aktualna_kolejka.remove(0);
            }
        }

        return przesunięcia;
    }

    public static int SSTF(ArrayList<zlecenie> zlecenia){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        while(!copy.isEmpty()||!aktualna_kolejka.isEmpty()){
            for(int i = copy.size()-1; i >= 0;i--){
                if(copy.get(i).getCzas_zgloszenia()<=czas){
                    aktualna_kolejka.add(copy.get(i));
                    copy.remove(i);
                }
            }
                if(aktualna_kolejka.isEmpty()) {
                czas++;
            }else {
                    int finalHead_pos = head_pos;
                    aktualna_kolejka.sort(new Comparator<zlecenie>() {
                        @Override
                        public int compare(zlecenie o1, zlecenie o2) {
                            return Integer.compare(Math.abs(o1.getNr_cylindra() - finalHead_pos), Math.abs(o2.getNr_cylindra() - finalHead_pos));
                        }
                    });
                    int a = (aktualna_kolejka.get(0).getNr_cylindra() - head_pos);
                    przesunięcia += Math.abs(a);
                    czas += Math.abs(a);
                    head_pos = aktualna_kolejka.get(0).getNr_cylindra();
                    aktualna_kolejka.remove(0);
                }
        }

        return przesunięcia;
    }

    public static int CSCAN(ArrayList<zlecenie> zlecenia, int dlugosc_dysku){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        while(!copy.isEmpty()||!aktualna_kolejka.isEmpty()){
            for(int i = copy.size()-1; i >= 0;i--){
                if(copy.get(i).getCzas_zgloszenia()<=czas&&copy.get(i).getNr_cylindra()>head_pos){
                    aktualna_kolejka.add(copy.get(i));
                    copy.remove(i);
                }
            }
            if(aktualna_kolejka.isEmpty()) {
                czas++;
                head_pos++;
                przesunięcia++;
                if(head_pos>dlugosc_dysku){
                    head_pos=0;
                    przesunięcia +=dlugosc_dysku;
                }
            }else {
                int finalHead_pos = head_pos;
                aktualna_kolejka.sort(new Comparator<zlecenie>() {
                    @Override
                    public int compare(zlecenie o1, zlecenie o2) {
                        return Integer.compare(Math.abs(o1.getNr_cylindra() - finalHead_pos), Math.abs(o2.getNr_cylindra() - finalHead_pos));
                    }
                });
                int a = (aktualna_kolejka.get(0).getNr_cylindra() - head_pos);
                przesunięcia += Math.abs(a);
                czas += Math.abs(a);
                head_pos = aktualna_kolejka.get(0).getNr_cylindra();
                aktualna_kolejka.remove(0);
            }
        }

        return przesunięcia;
    }

    }



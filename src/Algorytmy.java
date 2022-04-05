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
                if(copy.get(i).getCzas_zgloszenia()<=czas&&copy.get(i).getNr_cylindra()>=head_pos){
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

    public static int SCAN(ArrayList<zlecenie> zlecenia, int dlugosc_dysku){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        boolean forward=true;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        while(!copy.isEmpty()||!aktualna_kolejka.isEmpty()) {
                for (int i = copy.size() - 1; i >= 0; i--) {
                    if (copy.get(i).getCzas_zgloszenia() <= czas && copy.get(i).getNr_cylindra() > head_pos) {
                        if(forward) {
                            aktualna_kolejka.add(copy.get(i));
                            copy.remove(i);
                        }
                    }
                }
                for (int i = copy.size() - 1; i >= 0; i--) {
                    if (copy.get(i).getCzas_zgloszenia() <= czas && copy.get(i).getNr_cylindra() < head_pos) {
                        if(!forward) {
                            aktualna_kolejka.add(copy.get(i));
                            copy.remove(i);
                        }
                    }
                }
            if (aktualna_kolejka.isEmpty()) {
                if(forward) {
                    czas++;
                    head_pos++;
                    przesunięcia++;
                    if (head_pos == dlugosc_dysku) forward = false;
                }else{
                    czas++;
                    head_pos--;
                    przesunięcia++;
                    if (head_pos == 0) forward = true;
                }
            }else{
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

    public static int EDF(ArrayList<zlecenie>zlecenia){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        ArrayList<zlecenie> priorytetowa_kolejka = new ArrayList<>();
        while(!copy.isEmpty() || !aktualna_kolejka.isEmpty() || !priorytetowa_kolejka.isEmpty()){
            for(int i = copy.size()-1; i >= 0;i--){
                if(copy.get(i).getCzas_zgloszenia()<=czas){
                    if(copy.get(i).getDeadline()==-1) {
                        aktualna_kolejka.add(copy.get(i));
                    }else {
                        priorytetowa_kolejka.add(copy.get(i));
                    }
                    copy.remove(i);
                }
            }
            if(aktualna_kolejka.isEmpty()&&priorytetowa_kolejka.isEmpty()){
                czas++;
            }else {
                if(priorytetowa_kolejka.isEmpty()) {
                    aktualna_kolejka.sort(Comparator.comparingInt(zlecenie::getCzas_zgloszenia));
                    int a = (aktualna_kolejka.get(0).getNr_cylindra() - head_pos);
                    przesunięcia += Math.abs(a);
                    czas += Math.abs(a);
                    head_pos = aktualna_kolejka.get(0).getNr_cylindra();
                    aktualna_kolejka.remove(0);
                }else{
                    priorytetowa_kolejka.sort(Comparator.comparingInt(zlecenie::getDeadline));
                    int a = (priorytetowa_kolejka.get(0).getNr_cylindra() - head_pos);
                    przesunięcia += Math.abs(a);
                    czas += Math.abs(a);
                    head_pos = priorytetowa_kolejka.get(0).getNr_cylindra();
                    if(priorytetowa_kolejka.get(0).getDeadline()<czas)System.out.println("Proces nie wykonany w czasie " + priorytetowa_kolejka.get(0)+" czas obsłużenia: "+czas);
                    priorytetowa_kolejka.remove(0);
                }
            }
        }

        return przesunięcia;
    }
    //TWOJA MAMA CIE NIE KOCHA;
    public static int FD_SCAN(ArrayList<zlecenie>zlecenia, int dlugosc_dysku){
        ArrayList<zlecenie> copy = new ArrayList<>(zlecenia);
        int przesunięcia = 0;
        int head_pos = 0;
        int czas = 0;
        boolean forward=true;
        ArrayList<zlecenie> aktualna_kolejka = new ArrayList<>();
        while(!copy.isEmpty()||!aktualna_kolejka.isEmpty()) {
            if(forward) {
                for (int i = copy.size() - 1; i >= 0; i--) {
                    if (copy.get(i).getCzas_zgloszenia() <= czas && copy.get(i).getNr_cylindra() > head_pos) {
                        aktualna_kolejka.add(copy.get(i));
                        copy.remove(i);
                    }
                }
            }else{
                for (int i = copy.size() - 1; i >= 0; i--) {
                    if (copy.get(i).getCzas_zgloszenia() <= czas && copy.get(i).getNr_cylindra() < head_pos) {
                        aktualna_kolejka.add(copy.get(i));
                        copy.remove(i);
                    }
                }
            }
            if (aktualna_kolejka.isEmpty()) {
                if(forward) {
                    czas++;
                    head_pos++;
                    przesunięcia++;
                    if (head_pos == dlugosc_dysku) forward = false;
                }else{
                    czas++;
                    head_pos--;
                    przesunięcia++;
                    if (head_pos == 0) forward = true;
                }
            }else{
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
                int lewo = 0;
                int prawo = 0;
                for(zlecenie z : copy){
                    if(z.getCzas_zgloszenia()<=czas) {
                        if (z.getDeadline() != -1) {
                            if (z.getNr_cylindra() > head_pos){
                                prawo++;
                                if(z.getDeadline()<z.getNr_cylindra()-head_pos){
                                    prawo--;
                                    System.out.println("Proces nie moze zostać wykony w czasie " + z);
                                }
                            }
                            if (z.getNr_cylindra() < head_pos){
                                lewo++;
                                if(z.getDeadline()<head_pos-z.getNr_cylindra()){
                                    lewo--;
                                    System.out.println("Proces nie moze zostać wykony w czasie " + z);
                                }
                            }
                        }
                    }
                }
                for(zlecenie z : aktualna_kolejka){
                    if(z.getDeadline()!=-1){
                        if(forward){
                            prawo++;
                            if(z.getDeadline()<z.getNr_cylindra()-head_pos){
                                prawo--;
                                System.out.println("Proces nie moze zostać wykony w czasie " + z);
                            }
                        }
                        if(!forward){
                            lewo++;
                            if(z.getDeadline()<head_pos-z.getNr_cylindra()){
                                lewo--;
                                System.out.println("Proces nie moze zostać wykony w czasie " + z);
                            }
                        }
                    }
                }
                if(forward&&lewo>prawo){
                    zlecenia.addAll(aktualna_kolejka);
                    aktualna_kolejka.clear();
                    forward=false;
                }
                if(!forward&&lewo<prawo){
                    zlecenia.addAll(aktualna_kolejka);
                    aktualna_kolejka.clear();
                    forward=true;
                }
            }
        }

        return przesunięcia;
    }

    }



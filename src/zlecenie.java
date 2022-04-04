public class zlecenie {
    private int numer;
    private int nr_cylindra;
    private int czas_zgloszenia;
    private int deadline;

    @Override
    public String toString() {
        String retstr = "Zlecenie nr: "+numer+" numer cylindra: "+nr_cylindra+" czas zgłoszenia: " + czas_zgloszenia;
            if(deadline!=-1)retstr += ("Deadline: "+deadline);
            retstr += "\n";
            return retstr;
    }

    public zlecenie(int numer, int nr_cylindra, int czas_zgloszenia) {
        this.numer = numer;
        this.nr_cylindra = nr_cylindra;
        this.czas_zgloszenia = czas_zgloszenia;
        this.deadline = -1;
    }

    public zlecenie(int numer, int nr_cylindra, int czas_zgloszenia, int deadline) {
        this.numer = numer;
        this.nr_cylindra = nr_cylindra;
        this.czas_zgloszenia = czas_zgloszenia;
        this.deadline = deadline;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getNr_cylindra() {
        return nr_cylindra;
    }

    public void setNr_cylindra(int nr_cylindra) {
        this.nr_cylindra = nr_cylindra;
    }

    public int getCzas_zgloszenia() {
        return czas_zgloszenia;
    }

    public void setCzas_zgloszenia(int czas_zgloszenia) {
        this.czas_zgloszenia = czas_zgloszenia;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Dogadjaj {

    private LocalDate datum;
    private double osnovnaCena;
    private Sala sala;
    private List<Ulaznica> prodateUlaznice = new ArrayList<>();


    public Dogadjaj(LocalDate datum, double osnovnaCena, Sala sala) {
        this.sala = sala;
        this.osnovnaCena = osnovnaCena;
        this.datum = datum;
    }

    public abstract boolean mozeDaSeOdrzi(Sala sala);

    public abstract boolean kupiZaStajanje(int a);

    public boolean kupiZaSedenje(String oznakaReda, int brojSedista) {
        // 1. da li je zauzeto
        for (Ulaznica u : prodateUlaznice) {
            if (u instanceof UlaznicaSedenje us) {
                if (us.getOznakaReda().equals(oznakaReda) &&
                        us.getRedniBrojSedenja() == brojSedista) {
                    return false;
                }
            }
        }
        // 2. nadji red
        Red r = null;
        for (Red red : sala.getRedovi())
            if (red.getOznaka().equals(oznakaReda))
                r = red;

        if (r == null) return false;
        // 3. cena
        double cena = osnovnaCena;
        if (r.getVrsta() == VrstaReda.VIP) cena *= 1.5;
        else if (r.getVrsta() == VrstaReda.GALERIJA) cena *= 0.7;
        // 4. napravi kartu
        UlaznicaSedenje u = new UlaznicaSedenje(this, oznakaReda, brojSedista);
        u.setCena(cena);

        prodateUlaznice.add(u);
        return true;
    }



    public boolean kupiSusedne(int n) {
        for (Red r : sala.getRedovi()) {
            int uzastopno = 0;
            for (int i = 1; i <= r.getBrojSedista(); i++) {
                boolean zauzeto = false;
                // proveri da li je sedište zauzeto
                for (Ulaznica u : prodateUlaznice) {
                    if (u instanceof UlaznicaSedenje us) {
                        if (us.getOznakaReda().equals(r.getOznaka()) &&
                                us.getRedniBrojSedenja() == i) {
                            zauzeto = true;
                            break;
                        }
                    }
                }

                if (!zauzeto) {
                    uzastopno++;
                } else {
                    uzastopno = 0;
                }
                // našli smo dovoljno mesta
                if (uzastopno == n) {
                    int start = i - n + 1;
                    for (int j = start; j <= i; j++) {
                        double cena = osnovnaCena;
                        if (r.getVrsta() == VrstaReda.VIP) cena *= 1.5;
                        else if (r.getVrsta() == VrstaReda.GALERIJA) cena *= 0.7;
                        if (n > 5) cena *= 0.9; // popust 10%
                        UlaznicaSedenje u = new UlaznicaSedenje(this, r.getOznaka(), j);
                        u.setCena(cena);
                        prodateUlaznice.add(u);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public double ukupanPrihod() {
        int suma = 0;

        for (Ulaznica u : prodateUlaznice) {
            suma += u.getCena();
        }
        return suma;

    }

    public int kapacitet() {
        int sedista = 0;
        for (Red r : sala.getRedovi()) {
            sedista += r.getBrojSedista();
        }

        return sedista + sala.getKapacitetZaStajanje();
    }

    public double popunjenost() {
        return (double) prodateUlaznice.size() / kapacitet() * 100;
    }

    public List<String> slobodnaMesta() {

        List<String> rez = new ArrayList<>();

        for (Red r : sala.getRedovi()) {
            for (int i = 1; i <= r.getBrojSedista(); i++) {

                boolean zauzeto = false;
                for (Ulaznica u : prodateUlaznice) {
                    if (u instanceof UlaznicaSedenje us) {
                        if (us.getOznakaReda().equals(r.getOznaka()) &&
                                us.getRedniBrojSedenja() == i) {
                            zauzeto = true;
                            break;
                        }
                    }
                }
                if (!zauzeto) {
                    rez.add(r.getOznaka() + "-" + i);
                }
            }
        }
        return rez;
    }

    public int slobodnoStajanje() {

        int zauzeto = 0;

        for (Ulaznica u : prodateUlaznice) {
            if (!(u instanceof UlaznicaSedenje)) {
                zauzeto++;
            }
        }
        return sala.getKapacitetZaStajanje() - zauzeto;
    }

    public LocalDate getDatum() {return datum;}
    public void setDatum(LocalDate datum) {this.datum = datum;}

    public double getOsnovnaCena() {return osnovnaCena;}
    public void setOsnovnaCena(double osnovnaCena) {this.osnovnaCena = osnovnaCena;}

    public Sala getSala() {return sala;}
    public void setSala(Sala sala) {this.sala = sala;}

    public List<Ulaznica> getProdateUlaznice() {return prodateUlaznice;}
    public void setProdateUlaznice(List<Ulaznica> prodateUlaznice) {this.prodateUlaznice = prodateUlaznice;}
}

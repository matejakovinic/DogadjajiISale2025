import java.time.LocalDate;

public class Koncert extends Dogadjaj{

    private boolean vizuelniEfekti;
    private String nazivIzvodjaca;

    public Koncert(LocalDate datum, double osnovnaCena, Sala sala, boolean vizuelniEfekti, String nazivIzvodjaca) {
        super(datum, osnovnaCena, sala);
        this.vizuelniEfekti = vizuelniEfekti;
        this.nazivIzvodjaca = nazivIzvodjaca;
    }

    @Override
    public boolean mozeDaSeOdrzi(Sala sala) {
        if(!(sala.isImaBinu())) return false;
        if(vizuelniEfekti && (!sala.isImaPlatno())) return false;
        return true;
    }
    @Override
    public boolean kupiZaStajanje(int n) {

        int br = 0;
        // brojimo SAMO stajanje (obične ulaznice)
        for (Ulaznica u : getProdateUlaznice()) {
            if (!(u instanceof UlaznicaSedenje)) {
                br++;
            }
        }
        // kapacitet iz UML-a
        if (br + n > getSala().getKapacitetZaStajanje()) {
            return false;
        }
        // cena
        double cena = getOsnovnaCena();
        if (n > 10) cena *= 0.95;
        // pravljenje ulaznica
        for (int i = 0; i < n; i++) {
            Ulaznica u = new Ulaznica(this);
            u.setCena(cena);
            getProdateUlaznice().add(u);
        }
        return true;
    }

    public boolean isVizuelniEfekti() {return vizuelniEfekti;}
    public void setVizuelniEfekti(boolean vizuelniEfekti) {this.vizuelniEfekti = vizuelniEfekti;}

    public String getNazivIzvodjaca() {return nazivIzvodjaca;}
    public void setNazivIzvodjaca(String nazivIzvodjaca) {this.nazivIzvodjaca = nazivIzvodjaca;}
}

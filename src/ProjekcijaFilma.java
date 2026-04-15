import java.time.LocalDate;

public class ProjekcijaFilma extends Dogadjaj{

    private String naslov;
    private String opis;

    public ProjekcijaFilma(LocalDate datum, double osnovnaCena, Sala sala, String naslov, String opis) {
        super(datum, osnovnaCena, sala);
        this.naslov = naslov;
        this.opis = opis;
    }

    @Override
    public boolean mozeDaSeOdrzi(Sala sala) {
        int ukupnoSedista = 0;
        if(!(sala.isImaPlatno())) return false;
        for(Red r : sala.getRedovi()){
            ukupnoSedista += r.getBrojSedista();
        }
        if(ukupnoSedista < 20) return false;
        return true;
    }

    @Override
    public boolean kupiZaStajanje(int a) {
        return false;
    }

    public String getNaslov() {return naslov;}
    public void setNaslov(String naslov) {this.naslov = naslov;}

    public String getOpis() {return opis;}
    public void setOpis(String opis) {this.opis = opis;}
}

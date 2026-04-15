import java.time.LocalDate;

public class Predstava extends Dogadjaj{

    private String naziv;

    public Predstava(LocalDate datum, double osnovnaCena, Sala sala, String naziv) {
        super(datum, osnovnaCena, sala);
        this.naziv = naziv;
    }

    @Override
    public boolean mozeDaSeOdrzi(Sala sala) {

        if(!sala.isImaBinu()) return false;
        int ukupnoSedista = 0;
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

    public String getNaziv() {return naziv;}
    public void setNaziv(String naziv) {this.naziv = naziv;}
}

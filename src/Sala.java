import java.util.ArrayList;
import java.util.List;

public class Sala {

    private String naziv;
    private boolean imaBinu;
    private boolean imaPlatno;
    private int kapacitetZaStajanje;
    private List<Red> redovi = new ArrayList<>();
    private List<Dogadjaj> dogadjaji = new ArrayList<>();

    public Sala(String naziv, boolean imaBinu, boolean imaPlatno, int kapacitetZaStajanje) {
        this.naziv = naziv;
        this.imaBinu = imaBinu;
        this.imaPlatno = imaPlatno;
        this.kapacitetZaStajanje = kapacitetZaStajanje;
    }



    public boolean dodajDogadjaj(Dogadjaj d){

        for(Dogadjaj a : dogadjaji){
            if(a.getSala().equals(d.getSala()) && a.getDatum().equals(d.getDatum())){
                return false;
            }
        }
        if(!(d.mozeDaSeOdrzi(d.getSala()))) return false;

        dogadjaji.add(d);
        return true;
    }

    public String getNaziv() {return naziv;}
    public void setNaziv(String naziv) {this.naziv = naziv;}

    public boolean isImaBinu() {return imaBinu;}
    public void setImaBinu(boolean imaBinu) {this.imaBinu = imaBinu;}

    public boolean isImaPlatno() {return imaPlatno;}
    public void setImaPlatno(boolean imaPlatno) {this.imaPlatno = imaPlatno;}

    public int getKapacitetZaStajanje() {return kapacitetZaStajanje;}
    public void setKapacitetZaStajanje(int kapacitetZaStajanje) {this.kapacitetZaStajanje = kapacitetZaStajanje;}

    public List<Red> getRedovi() {return redovi;}
    public void setRedovi(List<Red> redovi) {this.redovi = redovi;}

    public List<Dogadjaj> getDogadjaji() {return dogadjaji;}
    public void setDogadjaji(List<Dogadjaj> dogadjaji) {this.dogadjaji = dogadjaji;}
}

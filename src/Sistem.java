import java.util.ArrayList;
import java.util.List;

public class Sistem {

    private List<Dogadjaj> dogadjaji = new ArrayList<>();

    public List<Dogadjaj> ispisiPoPrihodu() {

        dogadjaji.sort((d1, d2) -> Double.compare(d2.ukupanPrihod(), d1.ukupanPrihod()));

        return dogadjaji;
    }

    public List<Dogadjaj> nepopunjeni(double procenat) {

        List<Dogadjaj> rez = new ArrayList<>();

        for (Dogadjaj d : dogadjaji) {
            if (d.popunjenost() < procenat) {
                rez.add(d);
            }
        }
        return rez;
    }


    public List<Dogadjaj> getDogadjaji() {return dogadjaji;}
    public void setDogadjaji(List<Dogadjaj> dogadjaji) {this.dogadjaji = dogadjaji;}
}

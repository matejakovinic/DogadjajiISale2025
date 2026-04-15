public class Ulaznica {

    private double cena;
    private Dogadjaj dogadjaj;

    public Ulaznica(Dogadjaj dogadjaj) {
        this.dogadjaj = dogadjaj;
    }

    public void setCena(double a){
    this.cena = a;
    }

    public double getCena() {return cena;}

    public Dogadjaj getDogadjaj() {return dogadjaj;}
    public void setDogadjaj(Dogadjaj dogadjaj) {this.dogadjaj = dogadjaj;}
}

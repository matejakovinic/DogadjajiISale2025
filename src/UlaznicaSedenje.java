public class UlaznicaSedenje extends Ulaznica {

    private String oznakaReda;
    private int redniBrojSedenja;

    public UlaznicaSedenje(Dogadjaj dogadjaj, String oznakaReda, int redniBrojSedenja) {
        super(dogadjaj);
        this.oznakaReda = oznakaReda;
        this.redniBrojSedenja = redniBrojSedenja;
    }

    public String getOznakaReda() {return oznakaReda;}
    public void setOznakaReda(String oznakaReda) {this.oznakaReda = oznakaReda;}

    public int getRedniBrojSedenja() {return redniBrojSedenja;}
    public void setRedniBrojSedenja(int redniBrojSedenja) {this.redniBrojSedenja = redniBrojSedenja;}
}

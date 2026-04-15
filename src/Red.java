public class Red {

    private String oznaka;
    private int brojSedista;
    private VrstaReda vrsta;

    public Red(String oznaka, int brojSedista, VrstaReda vrsta) {
        this.oznaka = oznaka;
        this.brojSedista = brojSedista;
        this.vrsta = vrsta;
    }

    public String getOznaka() {return oznaka;}
    public void setOznaka(String oznaka) {this.oznaka = oznaka;}

    public int getBrojSedista() {return brojSedista;}
    public void setBrojSedista(int brojSedista) {this.brojSedista = brojSedista;}

    public VrstaReda getVrsta() {return vrsta;}
    public void setVrsta(VrstaReda vrsta) {this.vrsta = vrsta;}
}

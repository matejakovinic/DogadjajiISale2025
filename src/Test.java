
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        // 2 sale
        Sala s1 = new Sala("S1", true, true, 20);
        Sala s2 = new Sala("S2", true, false, 10);

        // dodavanje redova
        s1.getRedovi().add(new Red("A", 10, VrstaReda.OBICAN));
        s1.getRedovi().add(new Red("B", 10, VrstaReda.VIP));

        s2.getRedovi().add(new Red("C", 15, VrstaReda.OBICAN));
        s2.getRedovi().add(new Red("D", 10, VrstaReda.GALERIJA));

        // 4 događaja
        Dogadjaj k1 = new Koncert(LocalDate.now(), 1000, s1, true, "Izvodjac1");
        Dogadjaj k2 = new Koncert(LocalDate.now().plusDays(1), 1200, s2, false, "Izvodjac2");
        Dogadjaj p1 = new Predstava(LocalDate.now().plusDays(2), 800, s1, "Predstava1");
        Dogadjaj f1 = new ProjekcijaFilma(LocalDate.now().plusDays(3), 600, s2, "Film1", "Opis");

        // kupovina (sedenje + stajanje gde može)
        k1.kupiZaStajanje(5);
        k1.kupiZaSedenje("A", 1);

        k2.kupiZaStajanje(3);
        p1.kupiZaSedenje("A", 2);

        f1.kupiZaSedenje("C", 1);

        // test prihoda
        System.out.println(k1.ukupanPrihod());
        System.out.println(k2.ukupanPrihod());
        System.out.println(p1.ukupanPrihod());
        System.out.println(f1.ukupanPrihod());

        // test slobodnih mesta
        System.out.println(k1.slobodnaMesta());
        System.out.println(k1.slobodnoStajanje());
    }
}




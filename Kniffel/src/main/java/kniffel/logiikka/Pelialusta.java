package kniffel.logiikka;

import java.util.ArrayList;
import java.util.List;
import kniffel.nopat.Noppa;
import kniffel.pelaaja.Pelaaja;

/**
 *
 * @author nakkilinux
 */
public class Pelialusta {

    private List<Pelaaja> pelaajat;
    private List<Noppa> nopat;

    public Pelialusta() {
        this.pelaajat = new ArrayList();
        this.nopat = new ArrayList();
    }

    private void alustaNopat() {
        for (int i = 0; i <= 5; i++) {
            nopat.add(new Noppa());
        }
    }

}
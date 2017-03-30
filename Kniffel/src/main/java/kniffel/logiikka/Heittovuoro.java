package kniffel.logiikka;

import java.util.List;

/**
 *
 * @author nakkilinux
 */
public class Heittovuoro {

    private Pelaaja pelaaja;
    private List<Noppa> nopat;

    public Heittovuoro(Pelaaja pelaaja, List<Noppa> nopat) {
        pelaaja = pelaaja;
        this.nopat = nopat;
    }

    public void run() {
        int heitto = 0;
        int valittuja = 0;
        while (heitto < 3) {
            pelaaja.heitaNopat(nopat);
            pelaaja.valitseNopat(nopat);
            for (Noppa noppa : nopat) {
                if (noppa.saastetaanko() == true) {
                    valittuja++;
                }
            }
            if (valittuja == 5) {
                break;
            }
            heitto++;
        }
        int kohde = 0;
        pelaaja.lisaaTulos(nopat, kohde);

    }

}

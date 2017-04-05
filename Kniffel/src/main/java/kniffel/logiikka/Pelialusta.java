package kniffel.logiikka;

import java.util.ArrayList;
import java.util.List;
import kniffel.gui.PeliIkkuna;

/**
 *
 * @author nakkilinux
 */
public class Pelialusta {

    private List<Pelaaja> pelaajat;
    private List<Noppa> nopat;

    public Pelialusta() {
        this.nopat = new ArrayList();
        this.alustaNopat();
        ;
        this.pelaajat = new ArrayList<>();
    }

    private void alustaNopat() {
        for (int i = 0; i <= 5; i++) {
            nopat.add(new Noppa());
        }
    }

    public void lisaaPelaaja(String nimi) {
        if (this.pelaajat.size() < 5) {
            this.pelaajat.add(new Pelaaja(nimi));
        }

    }

    public void pelaaKierros() {
        for (Pelaaja pelaaja : pelaajat) {
            Heittovuoro vuoro = new Heittovuoro(pelaaja, nopat);
            vuoro.run();

        }
    }

    public void heitaNopat() {
        for (Noppa noppa : nopat) {
            if (noppa.saastetaanko() == false) {
                noppa.heitaNoppaa();
            }
        }
    }

    public List<Noppa> getNopat() {
        return this.nopat;
    }

}

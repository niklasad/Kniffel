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
    private Pistelaskuri laskuri;
    private int kierros;

    public Pelialusta() {
        this.nopat = new ArrayList();
        this.alustaNopat();
        this.pelaajat = new ArrayList<>();
        this.laskuri = new Pistelaskuri();
        this.kierros = 0;
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

    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

}

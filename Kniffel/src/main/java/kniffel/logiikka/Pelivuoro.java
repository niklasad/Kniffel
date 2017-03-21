package kniffel.logiikka;

import java.util.ArrayList;
import java.util.List;
import kniffel.nopat.Noppa;

/**
 *
 * @author nakkilinux
 */
public class Pelivuoro {

    private List<Noppa> nopat;

    public Pelivuoro(List<Noppa> nopat) {
        this.nopat = nopat;
    }

    public void heitaNopat() {
        for (int x = 0; x < this.nopat.size(); x++) {
            this.nopat.get(x).heitaNoppaa();
        }
    }

    public void naytaSilmaluvut() {
        for (int x = 0; x < nopat.size(); x++) {
            nopat.get(x).palautaSilmaluku();
        }
    }
}

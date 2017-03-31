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
            this.heitaNopat();
            this.valitseNopat();
            heitto ++;//            

        }
    }

    public void heitaNopat() {
        for (Noppa noppa : nopat) {
            if (noppa.saastetaanko() == false) {
                noppa.heitaNoppaa();
            }
        }
    }
    
    public void valitseNopat(){
        
    }
    

}

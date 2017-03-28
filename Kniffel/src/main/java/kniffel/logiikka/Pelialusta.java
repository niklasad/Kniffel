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
    private List<Pistetaulu> pisteet;
    public Pelialusta() {        
        this.nopat = new ArrayList();
        this.alustaNopat();        
    }

    private void alustaNopat() {
        for (int i = 0; i <= 5; i++) {
            nopat.add(new Noppa());
        }
    }
    
    public void lisaaPelaajat(List<Pelaaja> pelaajat){
        this.pelaajat = pelaajat;
    }
    
    public void pelaaKierros(){
        for (Pelaaja pelaaja : pelaajat) {
            Heittovuoro vuoro = new Heittovuoro(pelaaja,nopat);
            vuoro.run();
            
        }
    }
    
    

}

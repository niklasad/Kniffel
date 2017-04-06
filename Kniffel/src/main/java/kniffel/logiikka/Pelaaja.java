package kniffel.logiikka;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nakkilinux
 */
public class Pelaaja {

    private String nimi;
    private int pisteet;
    private int valisumma;
    private HashMap<String, Integer> tulokset;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.tulokset = new HashMap();
        this.valisumma = 0;
    }

    public String toString() {
        return "" + this.nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public int getValiSumma() {
        return this.valisumma;
    }

    public void lisaaTulos(String nimi, int pisteet) {
        if (!this.tulokset.containsKey(nimi)) {
            tulokset.put(nimi, pisteet);
            this.pisteet += pisteet;
            tarkistaValisumma(nimi, pisteet);
        }
    }

    public int haeTulos(String nimi) {
        if (tulokset.containsKey(nimi)) {
            return tulokset.get(nimi);
        }
        return -1;
    }

    public void tarkistaValisumma(String nimi, int pisteet) {
        if (nimi.equals("Ykköset") | nimi.equals("Kakkoset") | nimi.equals("Kolmoset") | nimi.equals("Neloset")
                | nimi.equals("Viitoset")) {
            valisumma += pisteet;
        }
        if (valisumma >= 63) {
            this.pisteet += 50;
        }
    }

}

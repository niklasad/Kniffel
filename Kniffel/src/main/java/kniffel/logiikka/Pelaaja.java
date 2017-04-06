package kniffel.logiikka;

import java.util.HashMap;
import java.util.List;

/**
 * Luokka pelaaja oliolle, joka pitää huolta pelaajan nimestä ja pelaajan
 * pisteistä
 *
 * @author nakkilinux
 */
public class Pelaaja {

    private String nimi;
    private int pisteet;
    private int valisumma;
    private HashMap<String, Integer> tulokset;

    /**
     * Pelaajan konstruktori, jossa asetetaan pelaajan yhteispisteet ja
     * välisumma nollaan ja luodaan HashMappi tulosten tallennusta varten
     *
     * @param nimi Käyttäjän asettama nimi, joka näkyy pelissä.
     */
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

    /**
     * Metodi lisää tulokset pelaajan omaan "pöytäkirjaan", eli HashMapille.
     *
     * @param nimi Käytettävän "tuloksen" nimi, eli esimerkiksi ykköset tai
     * täyskäsi
     * @param pisteet Pisteet joita kyseiseen tulokseen toisessa luokassa
     * heitetyillä nopilla saa
     */

    public void lisaaTulos(String nimi, int pisteet) {
        if (!this.tulokset.containsKey(nimi)) {
            tulokset.put(nimi, pisteet);
            this.pisteet += pisteet;
            tarkistaValisumma(nimi, pisteet);
        }
    }

    /**
     * Palauttaa pisteet, jotka on haetusta tuloksesta saatu
     *
     * @param nimi "tulos" jota haetaa, esim. kaksi paria
     * @return pisteet jotka tulokselle on merkitty, jos tulosta ei vielä
     * merkitty, palauttaa -1
     */
    public int haeTulos(String nimi) {
        if (tulokset.containsKey(nimi)) {
            return tulokset.get(nimi);
        }
        return -1;
    }

    /**
     * Metodi tarkistaa, onko pelaaja oikeutettu hyvitykseen tässä vaiheessa
     * peliä. Jos välisumman pisteet ovat/ylittävät 63, pelaaja saa 50 pisteen
     * hyvityksen.
     *
     * @param nimi kasvattaa välisummaa, jos asetetut pisteet kuuluvat
     * välisummaa kasvattaviin pisteisiin, eli ykkösistä kutosiin.
     * @param pisteet paljollako välisummaa kasvatetaan.
     */
    private void tarkistaValisumma(String nimi, int pisteet) {
        if (nimi.equals("Ykköset") | nimi.equals("Kakkoset") | nimi.equals("Kolmoset") | nimi.equals("Neloset")
                | nimi.equals("Viitoset") | nimi.equals("Kutoset")) {
            valisumma += pisteet;
        }
        if (valisumma >= 63) {
            this.pisteet += 50;
        }
    }

}

package kniffel.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Pelialusta pitää peliä kasassa, laskee kierrokset, hallitsee noppia, pelaajia
 * ja pistelaskuria.
 *
 *
 * @author nakkilinux
 */
public class Pelialusta {

    private List<Pelaaja> pelaajat;
    private List<Noppa> nopat;
    private Pistelaskuri laskuri;
    private int kierros;
    private int pelaaja;

    /**
     * konstruktori jossa alustetaan noppalista, pelaajalista sekä pistelaskuri
     * ja asetetaan vuorossa oleva pelaaja sekä kierros nollaksi.
     */
    public Pelialusta() {
        this.nopat = new ArrayList();
        this.alustaNopat();
        this.pelaajat = new ArrayList<>();
        this.laskuri = new Pistelaskuri();
        this.kierros = 0;
        int pelaaja = 0;
    }

    /**
     * alustaa noppalistan, eli lisää sinne 5 noppaa.
     */
    private void alustaNopat() {
        for (int i = 0; i < 5; i++) {
            nopat.add(new Noppa());
        }
    }

    /**
     * lisää pelaajalistalle pelaajan, jonka nimi on parametrin mukainen.
     *
     * @param nimi = pelaajalle asetettava nimi
     */
    public void lisaaPelaaja(String nimi) {
        if (this.pelaajat.size() < 4) {
            this.pelaajat.add(new Pelaaja(nimi));
        }

    }

    /**
     * heittää noppalistan nopat, jos niitä ei ole asetettu säästettäväksi.
     */
    public void heitaNopat() {
        for (Noppa noppa : nopat) {
            if (noppa.saastetaanko() == false) {
                noppa.heitaNoppaa();
            }
        }
    }

    /**
     * palauttaa pelin nopat listalla.
     *
     * @return nopat
     */
    public List<Noppa> getNopat() {
        return this.nopat;
    }

    /**
     * palauttaa listalla kaikki peliin asetetut pelaajat.
     *
     * @return pelaajat
     */
    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    /**
     * palauttaa pelin voittaneen pelaajan.
     *
     * @return voittajan nimen ja "voitit!" toivotuksen
     */
    public String getVoittaja() {
        Pelaaja voittaja = pelaajat.get(0);
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getPisteet() > voittaja.getPisteet()) {
                voittaja = pelaaja;
            }

        }
        return voittaja.getNimi();
    }

    /**
     * metodi käyttää pistelaskuria ja palauttaa sieltä nimellä haetun tuloksen.
     *
     * @param tulos = haetun tuloksen nimi
     * @return tuloksesta saatavat pisteet.
     */
    public int getTulos(String tulos) {
        if (tulos.equals("Ykköset")) {
            return this.laskuri.ykkoset(nopat);
        } else if (tulos.equals("Kakkoset")) {
            return this.laskuri.kakkoset(nopat);
        } else if (tulos.equals("Kolmoset")) {
            return this.laskuri.kolmoset(nopat);
        } else if (tulos.equals("Neloset")) {
            return this.laskuri.neloset(nopat);
        } else if (tulos.equals("Viitoset")) {
            return this.laskuri.vitoset(nopat);
        } else if (tulos.equals("Kutoset")) {
            return this.laskuri.kutoset(nopat);
        } else if (tulos.equals("Pari")) {
            return this.laskuri.pari(nopat);
        } else if (tulos.equals("Kaksi paria")) {
            return this.laskuri.kaksiParia(nopat);
        } else if (tulos.equals("Pieni suora")) {
            return this.laskuri.pieniSuora(nopat);
        } else if (tulos.equals("Suuri suora")) {
            return this.laskuri.suuriSuora(nopat);
        } else if (tulos.equals("Kolme samaa")) {
            return this.laskuri.kolmesamaa(nopat);
        } else if (tulos.equals("Neljä samaa")) {
            return this.laskuri.neljasamaa(nopat);
        } else if (tulos.equals("Täyskäsi")) {
            return this.laskuri.tayskasi(nopat);
        } else if (tulos.equals("Sattuma")) {
            return this.laskuri.sattuma(nopat);
        } else if (tulos.equals("Kniffel")) {
            return this.laskuri.yatzy(nopat);
        }
        return -1;
    }

    /**
     * palauttaa vuorossa olevan pelaajan sijainnin pelaajalistalla.
     *
     * @return pelaajan sijainnin listalla.
     */
    public int getVuorossaOlevaPelaaja() {
        return this.pelaaja;
    }

    /**
     * palauttaa meneillään olevan kierroksen järjestysluvun.
     *
     * @return kierrosluvun (1-15)
     */
    public int getKierros() {
        return this.kierros;
    }

    /**
     * "Siirtää vuoroa" eli millä indeksillä pelaajalistalta haetaan pelaajaa,
     * ja hyppää alkuun jos kierros on käyty.
     */
    public void seuraavaPelaaja() {
        int pelaajia = this.pelaajat.size() - 1;
        if (pelaaja < pelaajia) {
            pelaaja++;
        } else {
            pelaaja = 0;
            kierros++;
        }
    }

}

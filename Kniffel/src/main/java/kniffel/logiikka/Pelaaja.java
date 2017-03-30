package kniffel.logiikka;

import java.util.List;

/**
 *
 * @author nakkilinux
 */
public class Pelaaja {

    private String nimi;
    private int pisteet;
    private Pistelaskuri tulokset;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.tulokset = new Pistelaskuri();
    }

    public String toString() {
        return this.nimi + ", pisteet: " + this.pisteet;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void lisaaPisteet() {
        pisteet = tulokset.yhteisPisteet();
    }

    public void nollaaPisteet() {
        this.pisteet = 0;
    }

    public List<Noppa> heitaNopat(List<Noppa> nopat) {
        for (Noppa noppa : nopat) {
            if (noppa.saastetaanko() == false) {
                noppa.heitaNoppaa();
            }
        }
        return nopat;
    }

    public void valitseNopat(List<Noppa> nopat) {
        for (Noppa noppa : nopat) {
        }
    }

    public void lisaaTulos(List<Noppa> nopat, int kohde) {
        if (kohde == 1) {
            tulokset.ykkoset(nopat);
        } else if (kohde == 2) {
            tulokset.kakkoset(nopat);
        } else if (kohde == 3) {
            tulokset.kolmoset(nopat);
        } else if (kohde == 4) {
            tulokset.neloset(nopat);
        } else if (kohde == 5) {
            tulokset.vitoset(nopat);
        } else if (kohde == 6) {
            tulokset.kutoset(nopat);
        } else if (kohde == 7) {
            tulokset.pari(nopat);
        } else if (kohde == 8) {
            tulokset.kaksiParia(nopat);
        } else if (kohde == 9) {
            tulokset.kolmesamaa(nopat);
        } else if (kohde == 10) {
            tulokset.neljasamaa(nopat);
        } else if (kohde == 11) {
            tulokset.pieniSuora(nopat);
        } else if (kohde == 12) {
            tulokset.suuriSuora(nopat);
        } else if (kohde == 13) {
            tulokset.taysKasi(nopat);
        } else if (kohde == 14) {
            tulokset.sattuma(nopat);
        } else if (kohde == 15) {
            tulokset.yatzy(nopat);
        }
    }

}

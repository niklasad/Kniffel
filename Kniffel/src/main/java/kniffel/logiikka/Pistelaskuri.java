/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luokka pelin pisteiden laskemiseen, metodit laskevat kustakin "tuloksesta"
 * jollakin noppakädellä saatavat pisteet.
 *
 * @author niklasad
 */
public class Pistelaskuri {

    /**
     * konstruktori, ei tee mitään.
     */
    public Pistelaskuri() {

    }

    /**
     * Kaikki seuraavat(ykkosista kutosiin) metodit laskevat pisteitä tietyllä
     * noppakädellä tiettyyn "tulokseen" asetettuna pistelaskuri- metodia
     * hyväksi käyttäen.
     *
     * @param kasi viiden nopan yhdistelmä
     * @return palauttaa arvon, jonka noppayhdistelmä kyseisestä tuloksesta
     * tuottaa. Esim. noppayhdistelmä 5, 1, 2, 4, 1 palauttaa ykkosista 2.
     */
    public int ykkoset(List<Noppa> kasi) {
        int ykkoset = this.pisteLaskuri(kasi, 1);
        return ykkoset;

    }

    /**
     * sama kuin ykkösillä.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int kakkoset(List<Noppa> kasi) {
        int kakkoset = this.pisteLaskuri(kasi, 2);
        return kakkoset;
    }

    /**
     * sama kuin ykkösillä.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int kolmoset(List<Noppa> kasi) {
        int kolmoset = this.pisteLaskuri(kasi, 3);
        return kolmoset;
    }

    /**
     * sama kuin ykkösillä.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int neloset(List<Noppa> kasi) {
        int neloset = this.pisteLaskuri(kasi, 4);
        return neloset;
    }

    /**
     * sama kuin ykkösillä.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int vitoset(List<Noppa> kasi) {
        int vitoset = this.pisteLaskuri(kasi, 5);
        return vitoset;
    }

    /**
     * sama kuin ykkösillä.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int kutoset(List<Noppa> kasi) {
        int kutoset = this.pisteLaskuri(kasi, 6);
        return kutoset;
    }

    /**
     * laskee suurimman noppakäden sisältämän parin summan, jos paria ei löydy,
     * palauttaa 0.
     *
     * @param kasi 5 nopan yhdistelmä
     * @return pisteet jotka pari tuottaa
     */
    public int pari(List<Noppa> kasi) {
        int pari = this.samojenLoytaja(kasi, 2);
        return pari;
    }

    /**
     * Etsii ensin yhden parin, jos löytää, poistaa parin noppalistalta, jotta
     * samaa paria ei löydetä uudestaan, sitten etsii toisen parin.
     *
     * @param kasi 5 Nopan yhdistelmä
     * @return pisteet. Jos paria ei löydy, palauttaa 0.
     */
    public int kaksiParia(List<Noppa> kasi) {
        List<Noppa> kopio = new ArrayList<>(kasi);
        Noppa temp = new Noppa();
        int eka = this.samojenLoytaja(kopio, 2);
        if (eka == 0) {
            return 0;
        } else {
            temp.asetaSilmaluku(eka / 2);
            kopio.remove(temp);
            kopio.remove(temp);
            int toka = this.samojenLoytaja(kopio, 2);
            if (toka != 0 && toka != eka) {
                return eka + toka;
            }
        }
        return 0;
    }

    /**
     * Metodit kolmesamaa() ja neljasamaa() etsivät kolmen tai neljän nopan
     * yhdistelmät mitä kädestä löytyy ja palauttavat niiden summan. Jos
     * yhdistelmiä ei löydy, palauttavat 0.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int kolmesamaa(List<Noppa> kasi) {
        int kolmesamaa = this.samojenLoytaja(kasi, 3);
        return kolmesamaa;
    }

    /**
     * ks. kolmesamaa.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int neljasamaa(List<Noppa> kasi) {
        int neljasamaa = this.samojenLoytaja(kasi, 4);
        return neljasamaa;
    }

    /**
     * Jos käsi sisältää silmäluvut 1,2,3,4 ja 5, metodi palauttaa pisteet 15,
     * muuten 0.
     *
     * @param kasi noppayhdistelmä
     * @return pisteet
     */
    public int pieniSuora(List<Noppa> kasi) {
        Collections.sort(kasi);
        if (kasi.get(0).silmaluku() == 1 && kasi.get(1).silmaluku() == 2
                && kasi.get(2).silmaluku() == 3 && kasi.get(3).silmaluku() == 4
                && kasi.get(4).silmaluku() == 5) {
            return 15;
        } else {
            return 0;
        }
    }

    /**
     * jos käsi sisältää silmäluvut 2,3,4,5 ja 6 palauttaa pisteet 20, muuten 0.
     *
     * @param kasi noppayhdistelmä
     * @return pisteet
     */
    public int suuriSuora(List<Noppa> kasi) {
        Collections.sort(kasi);
        if (kasi.get(0).silmaluku() == 2 && kasi.get(1).silmaluku() == 3
                && kasi.get(2).silmaluku() == 4 && kasi.get(3).silmaluku() == 5
                && kasi.get(4).silmaluku() == 6) {
            return 20;
        } else {
            return 0;

        }
    }

    /**
     * etsii kädestä täyskättä, eli yhtä paria ja kolmea samaa lukua
     * järjestämällä nopat suuruusjärjestykseen jolloin käden sisältäessä
     * täyskäden joko 2 ensimmäistä ja 3 seuraavaa noppaa ovat samoja tai 3
     * ensimmäistä ja 2 viimeistä ovat samoja.
     *
     * @param kasi Noppayhdistelmä
     * @return palauttaa noppien summan jos täyskäsi löytyy, muuten 0
     */
    public int tayskasi(List<Noppa> kasi) {
        Collections.sort(kasi);
        int x = 0;
        if (!kasi.get(0).equals(kasi.get(4)) && kasi.get(0).equals(kasi.get(1))
                && kasi.get(2).equals(kasi.get(3)) && kasi.get(3).equals(kasi.get(4))) {
            x = this.sattuma(kasi);
        } else if (!kasi.get(0).equals(kasi.get(4)) && kasi.get(0).equals(kasi.get(1)) && kasi.get(1).equals(kasi.get(2))
                && kasi.get(3).equals(kasi.get(4))) {
            x = this.sattuma(kasi);
        }
        return x;
    }

    /**
     * palauttaa kaikkien noppien summan.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int sattuma(List<Noppa> kasi) {
        int x = 0;
        for (Noppa noppa : kasi) {
            x += noppa.silmaluku();
        }
        return x;
    }

    /**
     * jos käsi sisältää 5 samaa lukua, palauttaa 50, muuten 0.
     *
     * @param kasi = noppayhdistelmä
     * @return tulos
     */
    public int yatzy(List<Noppa> kasi) {
        if (kasi.get(0).equals(kasi.get(1)) && kasi.get(1).equals(kasi.get(2))
                && kasi.get(2).equals(kasi.get(3)) && kasi.get(3).equals(kasi.get(4))) {
            return 50;
        } else {
            return 0;
        }

    }

    /**
     * etsii kädestä kaikki tietyn luvun esiintymät ja summaa ne.
     *
     * @param kasi 5 nopan yhdistelmä
     * @param luku etsittävä luku
     * @return luvun esiintymien summa
     */
    public int pisteLaskuri(List<Noppa> kasi, Integer luku) {
        int pisteet = 0;
        for (Noppa noppa : kasi) {
            if (noppa.silmaluku() == luku) {
                pisteet += luku;
            }
        }
        return pisteet;
    }

    /**
     * Etsii kädestä kutosesta alaspäin lähtien jonkin saman numeron esiintymiä.
     *
     * @param kasi 5 nopan yhdistelmä
     * @param monta monen nopan yhdistelmää kaivataan, esim. kolmea samaa
     * @return palauttaa löytäessään suurimman löytyneen esim. kolmiluvun
     */
    public int samojenLoytaja(List<Noppa> kasi, int monta) {
        Noppa vrt = new Noppa();
        int x = 6;
        while (x > 0) {
            vrt.asetaSilmaluku(x);
            if (this.montaSisaltaa(kasi, vrt) >= monta) {
                return x * monta;
            }
            x--;
        }
        return 0;
    }

    /**
     * palauttaa luvun, montako tiettyä noppaa, eli nopan silmälukua käsi
     * sisältää.
     *
     * @param nopat = noppalista, yhdistelmä noppia
     * @param o haettu noppa(eli silmäluku)
     * @return montako tiettyä silmälukua käsi sisältää
     */
    public int montaSisaltaa(List<Noppa> nopat, Noppa o) {
        int monta = 0;
        for (Noppa noppa : nopat) {
            if (noppa.equals(o)) {
                monta++;
            }
        }
        return monta;
    }
}

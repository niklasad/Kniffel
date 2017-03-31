/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author niklasad
 */
public class Pistelaskuri {

    public Pistelaskuri() {

    }

    public int ykkoset(List<Noppa> kasi) {
        int ykkoset = this.pisteLaskuri(kasi, 1);
        return ykkoset;

    }

    public int kakkoset(List<Noppa> kasi) {
        int kakkoset = this.pisteLaskuri(kasi, 2);
        return kakkoset;
    }

    public int kolmoset(List<Noppa> kasi) {
        int kolmoset = this.pisteLaskuri(kasi, 3);
        return kolmoset;
    }

    public int neloset(List<Noppa> kasi) {
        int neloset = this.pisteLaskuri(kasi, 4);
        return neloset;
    }

    public int vitoset(List<Noppa> kasi) {
        int vitoset = this.pisteLaskuri(kasi, 5);
        return vitoset;
    }

    public int kutoset(List<Noppa> kasi) {
        int kutoset = this.pisteLaskuri(kasi, 6);
        return kutoset;
    }

    public int pari(List<Noppa> kasi) {
        int pari = this.samojenLoytaja(kasi, 2);
        return pari;
    }

    public int kaksiParia(List<Noppa> kasi) {
        Noppa temp = new Noppa();
        int eka = this.samojenLoytaja(kasi, 2);
        if (eka == 0) {
            return 0;
        } else {
            temp.asetaSilmaluku(eka / 2);
            kasi.remove(temp);
            kasi.remove(temp);
            int toka = this.samojenLoytaja(kasi, 2);
            if (toka != 0 && toka != eka) {
                return eka + toka;
            }
        }
        return 0;
    }

    public int kolmesamaa(List<Noppa> kasi) {
        int kolmesamaa = this.samojenLoytaja(kasi, 3);
        return kolmesamaa;
    }

    public int neljasamaa(List<Noppa> kasi) {
        int neljasamaa = this.samojenLoytaja(kasi, 4);
        return neljasamaa;
    }

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

    public int sattuma(List<Noppa> kasi) {
        int x = 0;
        for (Noppa noppa : kasi) {
            x += noppa.silmaluku();
        }
        return x;
    }

    public int yatzy(List<Noppa> kasi) {
        if (kasi.get(0).equals(kasi.get(1)) && kasi.get(1).equals(kasi.get(2))
                && kasi.get(2).equals(kasi.get(3)) && kasi.get(3).equals(kasi.get(4))) {
            return 50;
        } else {
            return 0;
        }

    }

    public int pisteLaskuri(List<Noppa> kasi, Integer luku) {
        int pisteet = 0;
        for (Noppa noppa : kasi) {
            if (noppa.silmaluku() == luku) {
                pisteet += luku;
            }
        }
        return pisteet;
    }

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

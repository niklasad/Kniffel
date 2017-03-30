/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import java.util.Collections;
import java.util.HashMap;
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
        int pari = this.samojenLoytaja(kasi, "pari");
        return pari;
    }

    public int kaksiParia(List<Noppa> kasi) {
        int x = 0;
        int eka = this.samojenLoytaja(kasi, "pari");
        if (eka != 0) {
            kasi.remove(eka);
            kasi.remove(eka);
            int toka = this.samojenLoytaja(kasi, "pari");
            if (toka != 0 && toka != eka) {
                x = eka + toka;
            }
        }
        return x;
    }

    public int kolmesamaa(List<Noppa> kasi) {
        int kolmesamaa = this.samojenLoytaja(kasi, "kolme");
        return kolmesamaa;
    }

    public int neljasamaa(List<Noppa> kasi) {
        int neljasamaa = this.samojenLoytaja(kasi, "nelja");
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
                && kasi.get(2).equals(kasi.get(3).equals(kasi.get(4)))) {
            for (Noppa noppa : kasi) {
                x += noppa.silmaluku();
            }
        } else if (!kasi.get(0).equals(kasi.get(4)) && kasi.get(0).equals(kasi.get(1).equals(kasi.get(2)))
                && kasi.get(3).equals(kasi.get(4))) {
            for (Noppa noppa : kasi) {
                x += noppa.silmaluku();
            }
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

    public int parinLoytaja(List<Noppa> kasi, String etsittava) {
        int x = 6;
        int pisteet;
        while (true) {
            if (kasi.contains(x)) {
                kasi.remove(x);
                if (kasi.contains(x)) {
                    kasi.remove(x);
                    if (etsittava.equals("pari")) {
                        pisteet = x * 2;
                        break;
                    } else if (kasi.contains(x)) {
                        kasi.remove(x);
                        if (etsittava.equals("kolme")) {
                            pisteet = x * 3;
                            break;
                        } else if (kasi.contains(x)) {
                            pisteet = x * 4;
                            break;
                        }
                    }
                }
            }
            x--;
            if (x == 0) {
                pisteet = 0;
                break;
            }
        }
        return pisteet;
    }

}

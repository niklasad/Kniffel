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

    private HashMap<String, Integer> pisteet;

    public Pistelaskuri() {
        this.pisteet = new HashMap<String, Integer>();
    }

    public int yhteisPisteet() {
        int x = 0;
        for (Integer piste : pisteet.values()) {
            x += piste;
        }
        return x;
    }

    public void ykkoset(List<Noppa> kasi) {
        int ykkoset = this.pisteLaskuri(kasi, 1);
        this.pisteet.put("ykköset", ykkoset);
    }

    public void kakkoset(List<Noppa> kasi) {
        int kakkoset = this.pisteLaskuri(kasi, 2);
        this.pisteet.put("kakkoset", kakkoset);
    }

    public void kolmoset(List<Noppa> kasi) {
        int kolmoset = this.pisteLaskuri(kasi, 3);
        this.pisteet.put("kolmoset", kolmoset);
    }

    public void neloset(List<Noppa> kasi) {
        int neloset = this.pisteLaskuri(kasi, 4);
        this.pisteet.put("neloset", neloset);
    }

    public void vitoset(List<Noppa> kasi) {
        int vitoset = this.pisteLaskuri(kasi, 5);
        this.pisteet.put("vitoset", vitoset);
    }

    public void kutoset(List<Noppa> kasi) {
        int kutoset = this.pisteLaskuri(kasi, 6);
        this.pisteet.put("kutoset", kutoset);
    }

    public void pari(List<Noppa> kasi) {
        int pari = this.samojenLoytaja(kasi, "pari");
        this.pisteet.put("pari", pari);
    }

    public void kaksiParia(List<Noppa> kasi) {
        int x = 0;
        int eka = this.samojenLoytaja(kasi, "pari");
        if (eka != 0) {
            kasi.remove(eka);
            kasi.remove(eka);
            int toka = this.samojenLoytaja(kasi, "pari");
            if (toka != 0 && toka != eka) {
                x = eka + toka;
                this.pisteet.put("kaksi paria", x);
            }
        }else{
            this.pisteet.put("kaksi paria", 0);
        }

    }

    public void kolmesamaa(List<Noppa> kasi) {
        int kolmesamaa = this.samojenLoytaja(kasi, "kolme");
        this.pisteet.put("kolmesamaa", kolmesamaa);
    }

    public void neljasamaa(List<Noppa> kasi) {
        int neljasamaa = this.samojenLoytaja(kasi, "nelja");
        this.pisteet.put("neljasamaa", neljasamaa);
    }

    public void pieniSuora(List<Noppa> kasi) {
        Collections.sort(kasi);
        if (kasi.get(0).silmaluku() == 1 && kasi.get(1).silmaluku() == 2
                && kasi.get(2).silmaluku() == 3 && kasi.get(3).silmaluku() == 4
                && kasi.get(4).silmaluku() == 5) {
            this.pisteet.put("pieni suora", 15);
        } else {
            this.pisteet.put("pieni suora", 0);
        }
    }

    public void suuriSuora(List<Noppa> kasi) {
        if (kasi.get(0).silmaluku() == 2 && kasi.get(1).silmaluku() == 3
                && kasi.get(2).silmaluku() == 4 && kasi.get(3).silmaluku() == 5
                && kasi.get(4).silmaluku() == 6) {
            this.pisteet.put("suuri suora", 20);
        } else {
            this.pisteet.put("suuri suora", 0);
        }

    }

    public void taysKasi(List<Noppa> kasi) {
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
        this.pisteet.put("täyskäsi", x);
    }

    public void sattuma(List<Noppa> kasi) {
        int x = 0;
        for (Noppa noppa : kasi) {
            x += noppa.silmaluku();
        }
        pisteet.put("sattuma", x);

    }

    public void yatzy(List<Noppa> kasi) {
        if (kasi.get(0).equals(kasi.get(1)) && kasi.get(1).equals(kasi.get(2))
                && kasi.get(2).equals(kasi.get(3)) && kasi.get(3).equals(kasi.get(4))) {
            this.pisteet.put("yatzy", 50);
        } else {
            this.pisteet.put("yatzy", 0);
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

    public int samojenLoytaja(List<Noppa> kasi, String etsittava) {
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

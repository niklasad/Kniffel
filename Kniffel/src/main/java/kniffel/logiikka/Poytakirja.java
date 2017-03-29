/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import java.util.HashMap;
import java.util.List;
import kniffel.nopat.Noppa;

/**
 *
 * @author niklasad
 */
public class Poytakirja {

    private HashMap<String, Integer> pisteet;

    public Poytakirja() {
        this.pisteet = new HashMap<String, Integer>();
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
    public void kolmesamaa(List<Noppa> kasi){
        int kolmesamaa = this.samojenLoytaja(kasi, "kolme");
        this.pisteet.put("kolmesamaa", kolmesamaa);
    }
    
    public void neljasamaa(List<Noppa> kasi){
        int neljasamaa = this.samojenLoytaja(kasi, "nelja");
        this.pisteet.put("neljasamaa", neljasamaa);
    }
    
    public void pieniSuora(List<Noppa> kasi){
        
    }
    
    public void suuriSuora(List<Noppa> kasi){
        
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

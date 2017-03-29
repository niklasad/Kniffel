/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka.tulokset;

import java.util.List;

/**
 *
 * @author niklasad
 */
public class Yatsi extends Tulos {

    public void kayta(List<Integer> kasi) {
        if (kasi.get(0) == kasi.get(1) && kasi.get(1) == kasi.get(2) && kasi.get(2) == kasi.get(3) && kasi.get(3) == kasi.get(4)) {
            pisteet = 50;
            kaytetty = true;
        }
    }

}

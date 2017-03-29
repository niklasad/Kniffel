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
public class Isosuora extends Tulos {

    @Override
    public void kayta(List<Integer> kasi) {
        if (kasi.contains(2) && kasi.contains(3) && kasi.contains(4) && kasi.contains(5) && kasi.contains(6)) {
            pisteet = 20;
            kaytetty = true;
        } else {
            pisteet = 0;
            kaytetty = true;
        }
    }

}

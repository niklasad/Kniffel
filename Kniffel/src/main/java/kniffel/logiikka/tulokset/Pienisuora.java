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
public class Pienisuora extends Tulos {

    @Override
    public void kayta(List<Integer> kasi) {
        if (kasi.contains(1) && kasi.contains(2) && kasi.contains(3) && kasi.contains(4) && kasi.contains(5)) {
            pisteet = 15;
            kaytetty = true;
        }else{
            pisteet = 0;
            kaytetty = true;
        }
    }

}

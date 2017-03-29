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
public class Pari extends Tulos {

    @Override
    public void kayta(List<Integer> kasi) {
        int x = 6;
        while (true) {
            if (kasi.contains(x)) {
                kasi.remove(x);
                if (kasi.contains(x)) {
                    pisteet = x + x;
                    kaytetty = true;
                    break;
                }
            }
            x--;
            if (x == 0) {
                pisteet = 0;
                kaytetty = true;
                break;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka.tulokset;

import java.util.List;
import kniffel.nopat.Noppa;

/**
 *
 * @author niklasad
 */
public class Kakkoset extends Tulos {

    @Override
    public void kayta(List<Integer> kasi) {
        for (Integer noppa : kasi) {
            if (noppa == 2) {
                pisteet += 2;
            }
        }
        kaytetty = true;
    }

}

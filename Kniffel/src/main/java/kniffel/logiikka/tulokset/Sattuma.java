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
public class Sattuma extends Tulos {

    public void kayta(List<Integer> kasi) {
        for (Integer luku : kasi) {
            pisteet += luku;
        }
        kaytetty = true;

    }

}

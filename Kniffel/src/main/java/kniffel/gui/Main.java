package kniffel.gui;

import kniffel.nopat.Noppa;
import kniffel.pelaaja.Pelaaja;

/**
 *
 * @author nakkilinux
 */
public class Main {

    public static void main(String[] args) {
        int x = 0;
        Noppa noppa = new Noppa();

        Pelaaja nikke = new Pelaaja("Nikke");
        System.out.println(nikke);

        nikke.lisaaPisteet(100);
        nikke.lisaaPisteet(-23);
        System.out.println(nikke);
        nikke.nollaaPisteet();
        System.out.println(nikke);

//        while (x < 150) {
//            noppa.heitaNoppaa();
//            System.out.println("Silmäluku: " + noppa.palautaSilmaluku());
//            x++;
//        }
    }
}

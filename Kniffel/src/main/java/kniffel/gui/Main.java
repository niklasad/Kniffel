package kniffel.gui;

import java.util.ArrayList;
import kniffel.logiikka.Noppa;
import kniffel.logiikka.Pelaaja;

/**
 *
 * @author nakkilinux
 */
public class Main {

    public static void main(String[] args) {
        int x = 0;
//        Pelialusta alusta = new Pelialusta();
//        ArrayList<Pelaaja> pelaajat = new ArrayList();
        Pelaaja nikke = new Pelaaja("Nikke");
//        pelaajat.add(nikke);
        ArrayList<Noppa> nopat = new ArrayList();
        nopat.add(new Noppa());
        nopat.add(new Noppa());
        nopat.add(new Noppa());
        nopat.add(new Noppa());
        nopat.add(new Noppa());
        System.out.println(nikke);

        System.out.println(nopat);
        System.out.println(nikke);

//        while (x < 150) {
//            noppa.heitaNoppaa();
//            System.out.println("Silmäluku: " + noppa.palautaSilmaluku());
//            x++;
//        }
    }
}

package kniffel.logiikka;

import java.util.Random;

/**
 * Noppaolio, joka saa randomnumeroita 1-6 välillä ja voi olla boolean arvolta
 * lukittu
 *
 * @author nakkilinux
 */
public class Noppa implements Comparable<Noppa> {

    private Random luku;
    private int silmaluku;
    private boolean lukittu;

    public Noppa() {
        this.luku = new Random();
        this.lukittu = false;
    }

    public int silmaluku() {
        return this.silmaluku;
    }

    /**
     * asettaa manuaalisesti halutun silmäluvun (Lähinnä testejä varten)
     *
     * @param luku
     */
    public void asetaSilmaluku(int luku) {
        this.silmaluku = luku;
    }

    public String toString() {
        return "" + this.silmaluku;
    }

    /**
     * arpoo nopalle uuden silmäluvun väliltä 1-6
     */
    public void heitaNoppaa() {
        this.silmaluku = luku.nextInt(6) + 1;
    }

    /**
     * vaihtaa nopan "statusta". Jos lukittu = true, noppaa ei heitetä
     * pelilaudan metodilla
     */
    public void saasta() {
        if (this.lukittu == true) {
            this.lukittu = false;
        } else {
            this.lukittu = true;
        }
    }

    /**
     * palauttaa boolean arvon, joka nopalla kutsuntahetkellä on
     *
     * @return
     */
    public boolean saastetaanko() {
        return this.lukittu;
    }

    /**
     * nopat ovat vertailukelpoisia keskenään silmäluvun perusteella
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Noppa o) {
        return this.silmaluku() - o.silmaluku();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Noppa verrattava = (Noppa) o;

        if (this.silmaluku() != verrattava.silmaluku()) {
            return false;
        }
        return true;
    }

}

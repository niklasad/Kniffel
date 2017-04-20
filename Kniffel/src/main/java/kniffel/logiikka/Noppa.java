package kniffel.logiikka;

import java.util.Random;

/**
 * Noppaolio, joka saa randomnumeroita 1-6 välillä ja voi olla boolean arvolta
 * lukittu.
 *
 * @author nakkilinux
 */
public class Noppa implements Comparable<Noppa> {

    private Random luku;
    private int silmaluku;
    private boolean lukittu;

    /**
     * konstruktori, joka asettaa nopan vapaaksi heitettäväksi ja alustaa random
     * olion.
     */
    public Noppa() {
        this.luku = new Random();
        this.lukittu = false;
    }

    /**
     * palauttaa nopan sen tämänhetkisen silmäluvun.
     *
     * @return silmäluku
     */
    public int silmaluku() {
        return this.silmaluku;
    }

    /**
     * asettaa manuaalisesti halutun silmäluvun (Lähinnä testejä varten).
     *
     * @param luku = haluttu luku
     */
    public void asetaSilmaluku(int luku) {
        this.silmaluku = luku;
    }

    /**
     * arpoo nopalle uuden silmäluvun väliltä 1-6.
     */
    public void heitaNoppaa() {
        this.silmaluku = luku.nextInt(6) + 1;
    }

    public String toString() {
        return "" + this.silmaluku;
    }

    /**
     * Vaihtaa nopan "statusta". Jos lukittu = true, noppaa ei heitetä
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
     * palauttaa boolean arvon, joka nopalla kutsuntahetkellä on.
     *
     * @return true tai false
     */
    public boolean saastetaanko() {
        return this.lukittu;
    }

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

package kniffel.logiikka;

import java.util.Random;

/**
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

    public void asetaSilmaluku(int luku) {
        this.silmaluku = luku;
    }

    public String toString() {
        return "" + this.silmaluku;
    }

    public void heitaNoppaa() {
        this.silmaluku = luku.nextInt(6) + 1;
    }

    public void saasta() {
        if (this.lukittu == true) {
            this.lukittu  = false;
        } else {
            this.lukittu = true;
        }
    }

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

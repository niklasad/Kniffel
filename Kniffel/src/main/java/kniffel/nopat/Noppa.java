package kniffel.nopat;

import java.util.Random;

/**
 *
 * @author nakkilinux
 */
public class Noppa {

    private Random luku;
    private int silmaluku;

    public Noppa() {
        this.luku = new Random();
    }

    public int palautaSilmaluku() {
        return this.silmaluku;
    }

    public void heitaNoppaa() {
        this.silmaluku = luku.nextInt(6) + 1;
    }
    
    
}

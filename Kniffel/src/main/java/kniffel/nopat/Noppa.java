package kniffel.nopat;

import java.util.Random;

/**
 *
 * @author nakkilinux
 */
public class Noppa {

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

    public void heitaNoppaa() {        
        this.silmaluku = luku.nextInt(6) + 1;
    }
    
    public void saasta(){
        this.lukittu = true;
    }
    
    public boolean saastetaanko(){
        return this.lukittu;
    }
    
    
    
    
}

package kniffel.pelaaja;

/**
 *
 * @author nakkilinux
 */
public class Pelaaja {

    private String nimi;
    private int pisteet;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }

    public String toString() {
        return this.nimi + ", pisteet: " + this.pisteet;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void lisaaPisteet(int pisteet) {
        if (pisteet >= 0) {
            this.pisteet += pisteet;
        }
    }

    public void nollaaPisteet() {
        this.pisteet = 0;
    }

}

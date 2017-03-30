/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nakkilinux
 */
public class PistelaskuriTest {

    private ArrayList<Noppa> nopat;
    private Pistelaskuri testi;

    public PistelaskuriTest() {

    }

    public void silmalukujenAsettaja(int luku) {
        for (Noppa noppa : nopat) {
            noppa.asetaSilmaluku(luku);
        }
    }

    public void heitaNopat() {
        for (Noppa noppa : nopat) {
            noppa.heitaNoppaa();
        }
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        int x = 0;
        this.nopat = new ArrayList();
        while (x < 5) {
            this.nopat.add(new Noppa());
            x++;
        }
        this.testi = new Pistelaskuri();

    }

    @Test
    public void ykkosienPisteetYkkosiaOn() {
        this.silmalukujenAsettaja(1);
        int x = testi.ykkoset(nopat);
        assertEquals(5, x);
    }

    @Test
    public void ykkosiinPisteitaNolla() {
        this.silmalukujenAsettaja(3);
        int x = testi.ykkoset(nopat);
        assertEquals(0, x);
    }

    @Test
    public void kakkosetPalauttaaSumman() {
        this.silmalukujenAsettaja(2);
        int x = testi.kakkoset(nopat);
        assertEquals(10, x);
    }

    @Test
    public void kakkosetPalauttaaNollan() {
        this.silmalukujenAsettaja(1);
        int x = testi.kakkoset(nopat);
        assertEquals(0, x);
    }

    @Test
    public void kolmosiinPisteita() {
        this.silmalukujenAsettaja(3);
        int x = testi.kolmoset(nopat);
        assertEquals(15, x);
    }

    @Test
    public void kolmosiinPisteitaNolla() {
        this.silmalukujenAsettaja(1);
        int x = testi.kolmoset(nopat);
        assertEquals(0, x);
    }

    @Test
    public void nelosiinPisteita() {
        this.silmalukujenAsettaja(4);
        assertEquals(20, testi.neloset(nopat));
    }

    @Test
    public void nelosiinPisteitaNolla() {
        this.silmalukujenAsettaja(3);
        assertEquals(0, testi.neloset(nopat));
    }

    @Test
    public void vitosiinPisteita() {
        this.silmalukujenAsettaja(5);
        assertEquals(25, testi.vitoset(nopat));
    }

    @Test
    public void vitosiinPisteitaNolla() {
        this.silmalukujenAsettaja(4);
        assertEquals(0, testi.vitoset(nopat));
    }

    @Test
    public void kutosiinPisteita() {
        this.silmalukujenAsettaja(6);
        assertEquals(30, testi.kutoset(nopat));
    }

    @Test
    public void kutosiinPisteitaNolla() {
        this.silmalukujenAsettaja(4);
        assertEquals(0, testi.kutoset(nopat));
    }

    @After
    public void tearDown() {
    }

}

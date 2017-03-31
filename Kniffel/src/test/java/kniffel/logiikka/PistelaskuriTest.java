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

    public void silmalukujenAsettajaEiTulosta() {
        nopat.get(0).asetaSilmaluku(1);
        nopat.get(1).asetaSilmaluku(2);
        nopat.get(2).asetaSilmaluku(3);
        nopat.get(3).asetaSilmaluku(4);
        nopat.get(4).asetaSilmaluku(6);

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

    @Test
    public void pariinPisteita() {
        this.silmalukujenAsettaja(4);
        assertEquals(8, testi.pari(nopat));
    }

    @Test
    public void pariinPisteitaNolla() {
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0, testi.pari(nopat));
    }

    @Test
    public void kahteenPariinPisteita() {
        this.nopat.get(0).asetaSilmaluku(2);
        this.nopat.get(1).asetaSilmaluku(4);
        this.nopat.get(2).asetaSilmaluku(6);
        this.nopat.get(3).asetaSilmaluku(4);
        this.nopat.get(4).asetaSilmaluku(2);

        assertEquals(12, testi.kaksiParia(nopat));
    }

    @Test
    public void kahteenPariinEiPisteitaNeljallaSamalla() {
        this.silmalukujenAsettaja(4);
        assertEquals(0, testi.kaksiParia(nopat));
    }

    @Test
    public void kahteenPariinPisteitaNolla() {
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0, testi.kaksiParia(nopat));
    }

    @Test
    public void kolmeensamaanPisteita() {
        this.silmalukujenAsettaja(5);
        assertEquals(15, testi.kolmesamaa(nopat));
    }

    @Test
    public void kolmeensamaanPisteitaNolla() {
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0, testi.kolmesamaa(nopat));
    }

    @Test
    public void neljaansamaanPisteita() {
        this.silmalukujenAsettaja(5);
        assertEquals(20, testi.neljasamaa(nopat));
    }
    
    @Test
    public void neljaansamaanPisteitaNolla(){
        nopat.get(0).asetaSilmaluku(6);
        nopat.get(1).asetaSilmaluku(3);
        nopat.get(2).asetaSilmaluku(6);
        nopat.get(3).asetaSilmaluku(6);
        nopat.get(4).asetaSilmaluku(3);
        assertEquals(0,testi.neljasamaa(nopat));
    }
    
    @Test
    public void takariinPisteita(){
        nopat.get(0).asetaSilmaluku(6);
        nopat.get(1).asetaSilmaluku(3);
        nopat.get(2).asetaSilmaluku(6);
        nopat.get(3).asetaSilmaluku(6);
        nopat.get(4).asetaSilmaluku(3);
        assertEquals(24, testi.tayskasi(nopat));
    }
    
    @Test
    public void takariinPisteitaNolla(){
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0,testi.tayskasi(nopat));
    }
    
    @Test
    public void pieneenSuoraanPisteita(){
        this.silmalukujenAsettajaEiTulosta();
        this.nopat.get(4).asetaSilmaluku(5);
        assertEquals(15, testi.pieniSuora(nopat));
    }
    
    @Test
    public void pieneenSuoraanPisteitaNolla(){
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0,testi.pieniSuora(nopat));
    }
    
    @Test
    public void suureenSuoraanPisteita(){
        this.silmalukujenAsettajaEiTulosta();
        this.nopat.get(0).asetaSilmaluku(5);
        assertEquals(20,testi.suuriSuora(nopat));
    }
    
    @Test
    public void suureenSuoraanPisteitaNolla(){
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0, testi.suuriSuora(nopat));
    }
    
    @Test
    public void sattumaanPisteita(){
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(16, testi.sattuma(nopat));
    }
    
    @Test
    public void yatsiinPisteita(){
        this.silmalukujenAsettaja(1);
        assertEquals(50, testi.yatzy(nopat));
    }
    
    @Test
    public void yatsiinPisteitaNolla(){
        this.silmalukujenAsettajaEiTulosta();
        assertEquals(0, testi.yatzy(nopat));
    }
    @After
    public void tearDown() {
    }

}

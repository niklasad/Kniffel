/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niklasad
 */
public class PelialustaTest {

    private Pelialusta alusta;

    public PelialustaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.alusta = new Pelialusta();
        alusta.lisaaPelaaja("Nakki");
        alusta.lisaaPelaaja("Pelaaja2");
        int x = 1;
        for (Noppa noppa : alusta.getNopat()) {
            noppa.asetaSilmaluku(x);
            x++;
        }

    }

    @Test
    public void noppiaOikeaMaara() {
        assertEquals(5, alusta.getNopat().size());
    }

    @Test
    public void pelaajanLisaysToimii() {
        assertEquals(2, alusta.getPelaajat().size());
        assertEquals("Nakki", alusta.getPelaajat().get(0).getNimi());
    }

    @Test
    public void eiVoiLisataYliNeljaaPelaajaa() {
        alusta.lisaaPelaaja("Pelaaja1");
        alusta.lisaaPelaaja("Pelaaja4");
        alusta.lisaaPelaaja("Pelaaja3");
        alusta.lisaaPelaaja("Pelaaja2");
        alusta.lisaaPelaaja("Pelaaja44");
        assertEquals(4, alusta.getPelaajat().size());
    }

    @Test
    public void seuraavaPelaajaToimiiKerran() {
        alusta.seuraavaPelaaja();
        assertEquals(1, alusta.getVuorossaOlevaPelaaja());
    }

    @Test
    public void seuraavaPelaajaToimiiKierroksenYli() {
        alusta.seuraavaPelaaja();
        alusta.seuraavaPelaaja();
        assertEquals(0, alusta.getVuorossaOlevaPelaaja());
    }

    @Test
    public void getVoittajaToimiiOikein() {
        alusta.getPelaajat().get(0).lisaaTulos("yatsi", 50);
        alusta.getPelaajat().get(1).lisaaTulos("kutoset", 24);
        assertEquals("Nakki", alusta.getVoittaja());
    }

    @Test
    public void getKierrosToimii() {
        alusta.seuraavaPelaaja();
        alusta.seuraavaPelaaja();
        assertEquals(1, alusta.getKierros());
    }

    @Test
    public void getTulosYkkosetToimii() {
        assertEquals(1, alusta.getTulos("Ykköset"));
    }

    @Test
    public void getTulosKakkosetToimii() {
        assertEquals(2, alusta.getTulos("Kakkoset"));
    }

    @Test
    public void getTulosKolmosetToimii() {
        assertEquals(3, alusta.getTulos("Kolmoset"));
    }

    @Test
    public void getTulosNelosetToimii() {
        assertEquals(4, alusta.getTulos("Neloset"));
    }

    @Test
    public void getTulosViitosetToimii() {
        assertEquals(5, alusta.getTulos("Viitoset"));
    }

    @Test
    public void getTulosKutosetToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(6);
        assertEquals(6, alusta.getTulos("Kutoset"));
    }

    @Test
    public void getTulosPariToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(2);
        assertEquals(4, alusta.getTulos("Pari"));
    }

    @Test
    public void getTulosKaksiPariaToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(2);
        alusta.getNopat().get(3).asetaSilmaluku(3);
        assertEquals(10, alusta.getTulos("Kaksi paria"));
    }

    @Test
    public void getTulosKolmoislukuToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(2);
        alusta.getNopat().get(3).asetaSilmaluku(2);
        assertEquals(6, alusta.getTulos("Kolme samaa"));
    }

    @Test
    public void getTulosNeljaSamaaToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(2);
        alusta.getNopat().get(3).asetaSilmaluku(2);
        alusta.getNopat().get(4).asetaSilmaluku(2);
        assertEquals(8, alusta.getTulos("Neljä samaa"));
    }

    @Test
    public void getTulosKniffelToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(2);
        alusta.getNopat().get(3).asetaSilmaluku(2);
        alusta.getNopat().get(4).asetaSilmaluku(2);
        alusta.getNopat().get(2).asetaSilmaluku(2);
        assertEquals(50, alusta.getTulos("Kniffel"));
    }

    @Test
    public void getTulosPieniSuoraToimii() {
        assertEquals(15, alusta.getTulos("Pieni suora"));
    }

    @Test
    public void getTulosSuuriSuoraToimii() {
        alusta.getNopat().get(0).asetaSilmaluku(6);
        assertEquals(20, alusta.getTulos("Suuri suora"));
    }

    @Test
    public void getTulosSattumaToimii() {
        assertEquals(15, alusta.getTulos("Sattuma"));
    }

    @Test
    public void getTulosTakariToimii() {
        assertEquals(0, alusta.getTulos("Täyskäsi"));
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

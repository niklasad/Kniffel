/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import kniffel.logiikka.Pelaaja;
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
public class PelaajaTest {

    private Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("pelaaja1");
    }

    @Test
    public void pelaajanNimeaminenToimii() {
        String nimi = pelaaja.getNimi();
        assertEquals("pelaaja1", nimi);
    }

    @Test
    public void pisteetAluksiNolla() {
        assertEquals(0, pelaaja.getPisteet());
    }

    @Test
    public void tuloksenLisaaminenKasvattaaYhteisPisteita() {
        pelaaja.lisaaTulos("Ykköset", 4);
        assertEquals(4, pelaaja.getPisteet());
    }

    @Test
    public void kahdenTuloksenLisaaminenKasvattaaYhteispisteitaOikein() {
        pelaaja.lisaaTulos("Kakkoset", 6);
        pelaaja.lisaaTulos("Neloset", 16);
        assertEquals(22, pelaaja.getPisteet());
    }

    @Test
    public void kaytettyaTulostaEiVoiMuuttaa() {
        pelaaja.lisaaTulos("Kakkoset", 6);
        pelaaja.lisaaTulos("Kakkoset", 2);
        assertEquals(6, pelaaja.haeTulos("Kakkoset"));
    }

    @Test
    public void nollanLisaaminenEiMuutaYhteisPisteita() {
        pelaaja.lisaaTulos("Kakkoset", 10);
        pelaaja.lisaaTulos("kolmoset", 0);
        assertEquals(10, pelaaja.getPisteet());
    }

    @Test
    public void getNimiToimii() {
        assertEquals("pelaaja1", pelaaja.getNimi());
    }

    @Test
    public void tulostaEiLoydyPalauttaaJotain() {
        assertEquals(pelaaja.haeTulos("Ykköset"), -1);
    }

    @Test
    public void valiSummanTarkastajaToimii() {
        pelaaja.lisaaTulos("Ykköset", 4);
        pelaaja.lisaaTulos("Kakkoset", 6);
        pelaaja.lisaaTulos("Neloset", 12);
        pelaaja.lisaaTulos("Pari", 12);
        assertEquals(22, pelaaja.getValiSumma());
    }

    @Test
    public void hyvitysToimii() {
        pelaaja.lisaaTulos("Ykköset", 3);
        pelaaja.lisaaTulos("Kakkoset", 6);
        pelaaja.lisaaTulos("Kolmoset", 9);
        pelaaja.lisaaTulos("Neloset", 12);
        pelaaja.lisaaTulos("Viitoset", 15);
        pelaaja.lisaaTulos("Kutoset", 18);
        assertEquals(true, pelaaja.onkoHyvitys());
        assertEquals(113, pelaaja.getPisteet());
    }

    @After
    public void tearDown() {
    }

}

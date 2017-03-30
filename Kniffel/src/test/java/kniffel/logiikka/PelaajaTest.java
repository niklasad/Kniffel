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
    public void yhdenPisteidenLisaaminen() {
        pelaaja.lisaaPisteet();
        assertEquals(1, pelaaja.getPisteet());
    }

    @Test
    public void useanPisteenLisaaminen() {
        pelaaja.lisaaPisteet();
        assertEquals(30, pelaaja.getPisteet());
    }

    @Test
    public void eiVoiLisataNegatiivisiaPisteita() {
        pelaaja.lisaaPisteet();
        pelaaja.lisaaPisteet();
        assertEquals(10, pelaaja.getPisteet());
    }

    @Test
    public void nollanLisaaminenEiMuutaPisteita() {
        pelaaja.lisaaPisteet();
        pelaaja.lisaaPisteet();
        assertEquals(10, pelaaja.getPisteet());
    }

    @Test
    public void pisteidenNollaaminen() {
        pelaaja.lisaaPisteet();
        pelaaja.nollaaPisteet();
        assertEquals(0, pelaaja.getPisteet());
    }

    @Test
    public void toStringToimii() {
        assertEquals("pelaaja1, pistet: 0", pelaaja.toString());
    }

    @After
    public void tearDown() {
    }

}

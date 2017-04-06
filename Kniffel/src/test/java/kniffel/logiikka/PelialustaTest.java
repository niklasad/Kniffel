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
    }

    @Test
    public void noppiaOikeaMaara() {
        assertEquals(5, alusta.getNopat().size());
    }

    @Test
    public void pelaajanLisaysToimii() {
        assertEquals(2, alusta.getPelaajat().size());
        assertEquals("Nakki", alusta.getPelaajat().get(0).toString());
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
    public void seuraavaPelaajaToimiiKerran(){        
        alusta.seuraavaPelaaja();
        assertEquals(1, alusta.getVuorossaOlevaPelaaja());
    }
    
    @Test
    public void seuraavaPelaajaToimiiKierroksenYli(){
        alusta.seuraavaPelaaja();
        alusta.seuraavaPelaaja();
        assertEquals(0, alusta.getVuorossaOlevaPelaaja());
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

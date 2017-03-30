/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.logiikka;

import kniffel.logiikka.Noppa;
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
public class NoppaTest {

    private Noppa noppa;

    public NoppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.noppa = new Noppa();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void silmaLukuEiVoiAlittaaNollaa() {
        int x = 0;
        while (x < 100000) {
            this.noppa.heitaNoppaa();
            assertTrue(noppa.silmaluku() > 0);
            x++;
        }
    }

    @Test
    public void silmaLukuEiVoiYlittaaKuutta() {
        int x = 0;
        while (x < 100000) {
            this.noppa.heitaNoppaa();
            assertTrue(noppa.silmaluku() <= 6);
            x++;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import kniffel.logiikka.Noppa;
import kniffel.logiikka.Pelialusta;

/**
 * Luokka joka asettaa käyttöliittymässä valittuun tulokseen oikeat pisteet
 * pelaajalle ja käyttöliittymään, sekä päivittää kaikki samalla pävittyvät
 * tiedot (summat jne.)
 *
 * @author niklasad
 */
public class TuloksenKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private JTable taulukko;
    private JButton heittonappi;
    private List<JButton> nopat;
    private JButton tulos;
    private JLabel status;
    private List<JButton> napit;

    public TuloksenKuuntelija(Pelialusta a, JTable t, JButton h, List<JButton> n,
            JButton x, JLabel s, List<JButton> tulosNapit) {
        this.alusta = a;
        this.taulukko = t;
        this.heittonappi = h;
        this.nopat = n;
        this.tulos = x;
        this.status = s;
        this.napit = tulosNapit;

    }

    /**
     * Kun tulosnappia painetaan käyttöliittymässä, tarkistetaan ensin, onko
     * kyseinen tulos jo käytetty. Jos on, niin statusteksti kertoo että tulos
     * on jo käytetty ja muuta ei tapahdu. Muutoin siirrytään metodiin joka
     * asettaa taulukkoon oikean tuloksen
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.onkoKaytetty() == false) {
            asetaTulokset();
        } else {
            status.setText("Tulos on jo käytetty");
        }
    }

    /**
     * Tämä metodi seuraa, jos actionPerformed metodi pääsee eteenpäin
     * tarkistusvaiheesta. Vuorossa olevan pelaajan "vuoronumeroa" tarvitaan,
     * jotta tulos asetetaan oikeaan paikkaan taulukossa, pisteet taas haetaan
     * klikatun napin nimen perusteella pelialustan metodin getTulos("tuloksen
     * nimi") avulla. Seuraavaksi asetetaan pisteet pelaajan henkilökohtaiselle
     * pistetaululle ja sen jälkeen päivitetään taulukkoon kyseisen tuloksen
     * pisteet. Viimeiseksi asetetaan napit seuraavaa pelaajaa/heittoa varten ja
     * päivitetään statusteksti.
     */
    public void asetaTulokset() {
        int pelaaja = alusta.getVuorossaOlevaPelaaja();
        int pisteet = alusta.getTulos(tulos.getText());

        alusta.getPelaajat().get(pelaaja).lisaaTulos(tulos.getText(), pisteet);

        paivitaTulokset(pisteet, pelaaja);
        alustaSeuraava();
        status.setText(alusta.getPelaajat().get(alusta.getVuorossaOlevaPelaaja()) + " heittää!");
    }

    /**
     * Tarkistaa onko painettu tulosnappi, eli tulos jo käytetty kyseiseltä
     * pelaajalta.
     *
     * @return
     */
    public boolean onkoKaytetty() {
        if (alusta.getPelaajat().get(alusta.getVuorossaOlevaPelaaja()).haeTulos(tulos.getText()) == -1) {
            return false;
        }
        return true;
    }

    private void paivitaTulokset(int pisteet, int pelaaja) {
        this.taulukko.setValueAt(pisteet, getRow(), pelaaja);
        this.taulukko.setValueAt(alusta.getPelaajat().get(pelaaja).getPisteet(), 17, pelaaja);
        this.taulukko.setValueAt(alusta.getPelaajat().get(pelaaja).getValiSumma(), 6, pelaaja);
        if (alusta.getPelaajat().get(pelaaja).onkoHyvitys() == true && taulukko.getValueAt(7, pelaaja) == null) {
            this.taulukko.setValueAt(50, 7, pelaaja);
        }
    }

    private void lukitseTulosNapit() {
        for (JButton nappi : napit) {
            nappi.setEnabled(false);
        }
    }

    /**
     * siirtää vuoroa, asettaa heittonapin käyttöön, lukitsee tulosnapit, ja
     * alustaa nopat seuraavaa vuoroa varten.
     */
    private void alustaSeuraava() {
        this.alusta.seuraavaPelaaja();
        heittonappi.setEnabled(true);
        lukitseTulosNapit();
        alustaNopat();

    }

    /**
     * Alustaa nopat seuraavaa kierrosta varten, eli asettaa nopat
     * heitettäviksi, ja lukitsee napit, jotta edellisen kierroksen noppia ei
     * voi käyttää.
     */
    private void alustaNopat() {
        for (Noppa noppa : alusta.getNopat()) {
            if (noppa.saastetaanko() == true) {
                noppa.saasta();
            }
        }
        for (JButton noppa : nopat) {
            noppa.setEnabled(false);
            noppa.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * palauttaa asetettavaa tulosta vastaavan rivikoordinaatin
     *
     * @return
     */
    public int getRow() {
        if (tulos.getText().equals("Ykköset")) {
            return 0;
        } else if (tulos.getText().equals("Kakkoset")) {
            return 1;
        } else if (tulos.getText().equals("Kolmoset")) {
            return 2;
        } else if (tulos.getText().equals("Neloset")) {
            return 3;
        } else if (tulos.getText().equals("Viitoset")) {
            return 4;
        } else if (tulos.getText().equals("Kutoset")) {
            return 5;
        } else if (tulos.getText().equals("Pari")) {
            return 8;
        } else if (tulos.getText().equals("Kaksi paria")) {
            return 9;
        } else if (tulos.getText().equals("Pieni suora")) {
            return 10;
        } else if (tulos.getText().equals("Suuri suora")) {
            return 11;
        } else if (tulos.getText().equals("Kolme samaa")) {
            return 12;
        } else if (tulos.getText().equals("Neljä samaa")) {
            return 13;
        } else if (tulos.getText().equals("Täyskäsi")) {
            return 14;
        } else if (tulos.getText().equals("Sattuma")) {
            return 15;
        } else if (tulos.getText().equals("Kniffel")) {
            return 16;
        } else {
            return -1;
        }
    }

}

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.onkoKaytetty() == false) {
            asetaTulokset();
        } else {
            status.setText("Tulos on jo käytetty");
        }
    }

    public void asetaTulokset() {
        int pelaaja = alusta.getVuorossaOlevaPelaaja();
        int pisteet = alusta.getTulos(tulos.getText());

        alusta.getPelaajat().get(pelaaja).lisaaTulos(tulos.getText(), pisteet);
        int summa = alusta.getPelaajat().get(pelaaja).getPisteet();

        this.taulukko.setValueAt(pisteet, getRow(), pelaaja);
        this.taulukko.setValueAt(summa, 17, pelaaja);

        heittonappi.setEnabled(true);
        lukitseTulosNapit();
        alustaNopat();
        status.setText(alusta.getPelaajat().get(pelaaja) + " heittää!");
    }

    public boolean onkoKaytetty() {
        int pelaaja = alusta.getVuorossaOlevaPelaaja();
        if (alusta.getPelaajat().get(pelaaja).haeTulos(tulos.getText()) == -1) {
            return false;
        }
        return true;
    }

    private void lukitseTulosNapit() {
        for (JButton nappi : napit) {
            nappi.setEnabled(false);
        }
    }

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

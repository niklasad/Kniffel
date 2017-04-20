/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kniffel.logiikka.Pelialusta;

/**
 * Kuuntelija aloitusikkunalle, joka lisää pelaajat pelialustalle.
 *
 * @author niklasad
 */
public class AloitusIkkunanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private JTextField pelaaja;
    private JButton aloitusnappi;
    private JLabel ohje;
    private JButton lisaysnappi;

    /**
     * konsturuktori joka saa parametreina tarvittavat komponentit
     * muokattavaksi.
     *
     * @param alusta = pelialusta
     * @param nimi = tekstikenttä johon nimi kirjoitetaan
     * @param o = päivittyvä ohjeteksti
     * @param a = nappi josta peli aloitetaan
     * @param p = nappi jolla pelaaja lisätään peliin (nimi lisätään)
     */
    public AloitusIkkunanKuuntelija(Pelialusta alusta, JTextField nimi, JLabel o, JButton a, JButton p) {
        this.alusta = alusta;
        this.pelaaja = nimi;
        this.ohje = o;
        this.aloitusnappi = a;
        this.lisaysnappi = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pelaaja.getText().isEmpty()) {
            ohje.setText("Tyhjä nimi ei kelpaa.");
        } else if (pelaaja.getText().length() > 10) {
            ohje.setText("Nimen maksimipituus 10 merkkiä, syötä uusi");
            pelaaja.setText("");
        } else {
            lisaaPelaaja();
            pelaaja.setText("");
            aloitusnappi.setEnabled(true);
        }
    }

    /**
     * Jos pelissä ei ole vielä 4 pelaajaa, metodi lisää pelialustan listalle
     * uuden pelaajan.
     */
    public void lisaaPelaaja() {
        this.alusta.lisaaPelaaja(pelaaja.getText());
        if (alusta.getPelaajat().size() < 4) {
            ohje.setText("Pelaaja lisätty! Syötä seuraava nimi");
        } else {
            lisaysnappi.setEnabled(false);
            ohje.setText("4 pelaajaa pelissä, aloita peli!");
        }
    }

}

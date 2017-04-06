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
 *
 * @author niklasad
 */
public class AloitusIkkunanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private JTextField pelaaja;
    private int pelaajia;
    private JButton aloitusnappi;
    private JLabel ohje;
    private JButton lisaysnappi;

    public AloitusIkkunanKuuntelija(Pelialusta alusta, JTextField nimi, JLabel o, JButton a, JButton p) {
        this.alusta = alusta;
        this.pelaaja = nimi;
        pelaajia = 0;
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

    public void lisaaPelaaja() {
        this.alusta.lisaaPelaaja(pelaaja.getText());
        pelaajia++;
        if (pelaajia < 4) {
            ohje.setText("Pelaaja lisätty! Syötä seuraava nimi");
        } else {
            lisaysnappi.setEnabled(false);
            ohje.setText("4 pelaajaa pelissä, aloita peli!");
        }
    }

}

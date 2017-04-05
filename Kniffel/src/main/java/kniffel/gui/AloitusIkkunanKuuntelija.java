/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import kniffel.logiikka.Pelialusta;

/**
 *
 * @author niklasad
 */
public class AloitusIkkunanKuuntelija implements ActionListener {

    private JComboBox pelaajienMaara;
    private Pelialusta alusta;
    private JTextField pelaaja;
    private int pelaajia;

    public AloitusIkkunanKuuntelija(Pelialusta alusta, JTextField nimi) {
        this.alusta = alusta;
        this.pelaaja = nimi;
        pelaajia = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.alusta.lisaaPelaaja(pelaaja.getText());
        pelaajia++;
        if (pelaajia < 4) {
            pelaaja.setText("Pelaaja lisätty! Syötä seuraava pelaaja");
        }else{
            pelaaja.setText("Et voi lisätä enempää pelaajia");
        }
    }

}

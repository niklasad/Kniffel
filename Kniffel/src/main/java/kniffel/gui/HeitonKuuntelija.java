/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kniffel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import kniffel.logiikka.Pelialusta;

/**
 *
 * @author niklasad
 */
public class HeitonKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private List<JButton> nopat;
    private int heitto;
    private JButton heittoNappi;
    private JLabel status;
    private List<JButton> napit;

    public HeitonKuuntelija(Pelialusta a, List<JButton> nopat, JButton b, JLabel s, List<JButton> n) {
        this.alusta = a;
        this.nopat = nopat;
        this.heitto = 0;
        this.heittoNappi = b;
        this.status = s;
        this.napit = n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (heitto < 2) {
            if (heitto == 0) {
                vapautaNopat();
            }
            this.heitaJaPaivitaNopat();
        } else {
            this.heitaJaPaivitaNopat();
            this.heittoNappi.setEnabled(false);
            vapautaTulosNapit();
            this.status.setText("Aseta pisteet");
            this.heitto = 0;
        }

    }

    private void heitaJaPaivitaNopat() {
        this.alusta.heitaNopat();
        heitto++;
        int x = 0;
        for (JButton noppa : nopat) {
            noppa.setText(alusta.getNopat().get(x).toString());
            x++;
        }
        paivitaStatus();
    }

    private void vapautaTulosNapit() {
        for (JButton nappi : napit) {
            nappi.setEnabled(true);
        }
    }

    private void vapautaNopat() {
        for (JButton noppa : nopat) {
            noppa.setEnabled(true);
        }
    }

    private void paivitaStatus() {
        if (this.heitto == 1) {
            this.status.setText("2 heittoa jäljellä");
        } else if (this.heitto == 2) {
            this.status.setText("1 heitto jäljellä");
        }
    }

}

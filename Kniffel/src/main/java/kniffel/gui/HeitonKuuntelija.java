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

    public HeitonKuuntelija(Pelialusta a, List<JButton> nopat, JButton b, JLabel s) {
        this.alusta = a;
        this.nopat = nopat;
        this.heitto = 0;
        this.heittoNappi = b;
        this.status = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (heitto < 2) {
            this.heitaJaPaivitaNopat();
            this.status.setText("Heitä uudestaan!");
        } else {
            this.heitaJaPaivitaNopat();
            this.heittoNappi.setEnabled(false);
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
    }

}

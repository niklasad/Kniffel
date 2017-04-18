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
import javax.swing.JFrame;
import javax.swing.JLabel;
import kniffel.logiikka.Pelialusta;

/**
 * Kuuntelija nopan heittämiselle
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
    private JFrame ikkuna;

    public HeitonKuuntelija(Pelialusta a, List<JButton> nopat, JButton b, JLabel s, List<JButton> n, JFrame peliIkkuna) {
        this.alusta = a;
        this.nopat = nopat;
        this.heitto = 0;
        this.heittoNappi = b;
        this.status = s;
        this.napit = n;
        this.ikkuna = peliIkkuna;
    }
    /**
     * Jos Pelialustan getKierros palauttaa 15, on peli päättynyt ja noppanapin teksti on jo muuttunut "Lopeta peli"
     * muotoon ja tällöin sen painaminen lopettaa nykyisen pelin ja avaa uuden AloitusIkkunan
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (alusta.getKierros() == 15) {
            ikkuna.dispose();
            new AloitusIkkuna().setVisible(true);
        } else {
            perusKierros();
        }

    }
    /**
     * Normaalit kierrostoimenpiteet Noppapainikkeelle, eli pelaajan ensimmäisen heiton jälkeen vapauttaa nopat valittaviksi
     * ja heittää nopat ja päivittää numerot oikeiksi käyttöliittymään. 3 heiton jälkeen asettaa heittonapin pois käytöstä ja
     * vapauttaa tulosnapit jotta tuloksen voi asettaa, sekä päivittää statuslabelin ohjeet ja nollaa vielä pelaajakohtaisen 
     * heittovuoron.
     */
    private void perusKierros() {
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
    /**
     * Heittää nopat Pelialustalla ja päivittää arvot käyttöliittymään
     */
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

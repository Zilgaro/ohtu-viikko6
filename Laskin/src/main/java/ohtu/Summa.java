/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta, syotekentta;
    private int edellinen;
    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        edellinen = 0;
    }
    
    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        
        int arvo = 0;
        
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos()); 
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
        sovellus.nollaa();
        sovellus.plus(edellinen);
    }
    
}

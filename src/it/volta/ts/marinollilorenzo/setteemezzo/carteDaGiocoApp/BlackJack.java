package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;


import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.volta.ts.marinollilorenzo.setteemezzo.bean.Carta;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.MazzoFrancese;

public class BlackJack extends GiocoDiCarte{

	MazzoFrancese mf = new MazzoFrancese();

	public Image daiCarta() {
		int casuale = (int)(Math.random() * mf.numeroCarte);
		mano.add(mazzo.getCarta(casuale));
		checkAsso(mano.get(mano.size() - 1));
		aggiornaPunteggio();
		return mazzo.getCarta(casuale).getImmagine();
	}

	public void aggiornaPunteggio() {
		Carta c = mano.get(mano.size() - 1);
		super.punteggio += c.getValore();
	}

	public boolean checkLose() {
		if(super.punteggio > 21)
			return true;
		else
			return false;
	}

	public boolean checkWin() {
		if(super.punteggio == 21)
			return true;
		else
			return false;
	}

	public void checkAsso(Carta c) {
		double x = c.getValore();
		if(x == 1) {
			String[] choices = {"11", "1"};
			int k = JOptionPane.showOptionDialog(new JPanel(), "Asso: 1 o 11?", "Asso", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, 0);
			if(k == 1)
				c.setValore(k);
			else
				c.setValore(11);
		}
	}
}
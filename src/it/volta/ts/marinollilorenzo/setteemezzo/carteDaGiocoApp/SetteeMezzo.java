package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import it.volta.ts.marinollilorenzo.setteemezzo.bean.Carta;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.Mazzo;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.MazzoTriestino;
import it.volta.ts.marinollilorenzo.setteemezzo.boundary.CaricatoreImmagini;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config.TipoMazzo;

public class SetteeMezzo extends GiocoDiCarte{
	MazzoTriestino mt = new MazzoTriestino();

	public Image daiCarta() {
		int casuale = (int)(Math.random() * mt.numeroCarte);
		mano.add(mazzo.getCarta(casuale));
		aggiornaPunteggio();
		return mazzo.getCarta(casuale).getImmagine();
	}
	public void aggiornaPunteggio() {
		Carta c = mano.get(mano.size() - 1);
		super.punteggio += c.getValore();
	}

	public boolean checkLose() {
		if(super.punteggio > 7.5)
			return true;
		else
			return false;
	}

	public boolean checkWin() {
		if(super.punteggio == 7.5)
			return true;
		else
			return false;
	}
}
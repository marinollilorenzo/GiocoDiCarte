package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;

import java.awt.Image;

import it.volta.ts.marinollilorenzo.setteemezzo.bean.Carta;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.MazzoFrancese;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.MazzoTriestino;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config.TipoMazzo;


public class Solitario extends GiocoDiCarte{

	Config c = Config.get();
	MazzoFrancese mf = new MazzoFrancese();
	MazzoTriestino mt = new MazzoTriestino();
	

	public Image daiCarta() {
		super.i ++;
		int casuale = 0;
		if(c.getTipoMazzo() == TipoMazzo.FRANCESE) {
			casuale = (int)(Math.random() * mf.numeroCarte);
			if(super.i == mf.numeroCartePerSeme + 1)
				super.i = 1;
		}else {
			casuale = (int)(Math.random() * mt.numeroCarte);
			if(super.i == mt.numeroCartePerSeme + 1)
				super.i = 1;
		}
		mano.add(mazzo.getCarta(casuale));
		aggiornaPunteggio();
		return mazzo.getCarta(casuale).getImmagine();	
	}
	public void aggiornaPunteggio() {
		Carta c = mano.get(mano.size() - 1);
		super.punteggio = (float) c.getValore();
	}
	public boolean checkLose() {
		if(super.punteggio == super.i)
			return true;
		else
			return false;
	}

	public boolean checkWin() {
		if(mazzo.isEmpty())
			return true;
		else
			return false;
	}
	public String daiDescrizione() {
		Carta c = mano.get(mano.size() - 1);
		return c.toString();
	}
	public String getPunteggio() {
		return "Punteggio " + super.i;
	}
	}


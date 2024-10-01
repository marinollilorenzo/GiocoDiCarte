package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import it.volta.ts.marinollilorenzo.setteemezzo.bean.Carta;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.Mazzo;
import it.volta.ts.marinollilorenzo.setteemezzo.bean.MazzoFactory;

public abstract class GiocoDiCarte {

	protected Mazzo mazzo = null;
	protected float punteggio = 0;
	protected ArrayList<Carta> mano = null;
	protected int i = 0;
	protected Carta first;
	
	public GiocoDiCarte() {
		mano = new ArrayList<Carta>();
		nuovaMano();
	}
	public abstract Image daiCarta();
	protected abstract void aggiornaPunteggio();
	public abstract boolean checkLose();
	public abstract boolean checkWin();
	
	
	
	public List<Image> mostramazzo(){
		return mazzo.getImages();
	}
	public String getPunteggio() {
		return "Punteggio " + punteggio;
	}
	
	public Image getRetro() {
		return mazzo.getRetro();
	}
	
	public String daiDescrizione() {
		Carta c = mano.get(mano.size() - 1);
		return c.toString();
	}
	
	public void nuovaMano() {
		mazzo = new MazzoFactory().genera();
		i = 0;
	}
	
	public void setPunteggio() {
		punteggio = 0;
	}
	public Image getFirst() {
		return first.getImmagine();
	}
}

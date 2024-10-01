package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.awt.Image;



public class Carta {
	private String seme;
	protected double valore;
	protected int primaFigura;
	protected String faccia;
	protected Image immagine;
	protected Carta next;

	public Carta(int primaFigura) {
		this.primaFigura = primaFigura;
		this.next = null;
	}

	public String getFaccia() {
		return faccia;
	}

	public void setFaccia(int f) {
		this.faccia = f == 1 ? "A":
			f < primaFigura ? "" + f: "";
	}

	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public Image getImmagine() {
		return immagine;
	}

	public void setImmagine(Image immagine) {
		this.immagine = immagine;
	}
	public Carta getNext() {
		return next;
	}

	public void setNext(Carta next) {
		this.next = next;
	}


	@Override
	public String toString() {
		return getSeme() + " " + getValore();
	}
}

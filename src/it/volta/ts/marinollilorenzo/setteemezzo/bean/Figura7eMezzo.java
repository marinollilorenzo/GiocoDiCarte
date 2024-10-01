package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.awt.Image;

public class Figura7eMezzo extends Carta implements TipoFiguraTriestina{

	public Figura7eMezzo(int primaFigura) {
		super(primaFigura);
	}
	
	public void setValore(int valore) {
		this.valore = 0.5;
	}
	public void setFaccia(int f) {
		faccia = TipoFiguraTriestina.figura[f-primaFigura];
	}
	
	public void setImmagine(Image immagine) {
		super.setImmagine(immagine);
	}
}

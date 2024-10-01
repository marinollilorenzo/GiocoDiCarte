package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.awt.Image;

public class FiguraBlackJack extends Carta implements TipoFiguraFrancese{

	public FiguraBlackJack(int primaFigura) {
		super(primaFigura);
	}

	public void setValore(int valore) {
		this.valore = 10;
	}
	public void setFaccia(int f) {
		faccia = TipoFiguraTriestina.figura[f-primaFigura];
	}
	
	public void setImmagine(Image immagine) {
		super.setImmagine(immagine);
	}
}

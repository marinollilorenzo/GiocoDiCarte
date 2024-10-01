package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config;

public class FiguraFactory {

	public Carta getFigura(int primaFigura) {
		switch(Config.get().getTipoGioco()) {
		case BLACKJACK:
			return new FiguraBlackJack(primaFigura);
		case SETTEEMEZZO:
			return new Figura7eMezzo(primaFigura);
		case SOLITARIO:
			return new Carta(0);
		}
		return null;
	}
}

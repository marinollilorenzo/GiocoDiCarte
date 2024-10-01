package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;


public class GiocoDiCarteFactory {

	private GiocoDiCarte gioco =  null;
	
	public GiocoDiCarte genera() {
		Config config = Config.get();
		
		switch(config.getTipoGioco()) {
		case BLACKJACK:
			return new BlackJack();
		case SETTEEMEZZO:
			return new SetteeMezzo();
		case SOLITARIO:
			return new Solitario();
		}
		return gioco;
	}
}

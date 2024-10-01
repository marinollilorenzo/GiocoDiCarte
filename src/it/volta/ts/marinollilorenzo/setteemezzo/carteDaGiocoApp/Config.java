package it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp;

import java.io.File;

public class Config {
	private static Config config = null;
	public enum TipoMazzo { FRANCESE, TRIESTINO }
	public enum TipoGioco { BLACKJACK, SETTEEMEZZO, SOLITARIO }
	private TipoMazzo tipoMazzo = TipoMazzo.TRIESTINO;
	private TipoGioco tipoGioco = TipoGioco.SETTEEMEZZO;
	private String deckPath;
	private Config() {}

	public static Config get() {
		if(config == null) 
			config = new Config();
		return config;
	}

	public void setScope(int i) {
		tipoGioco = tipoGioco.values()[i - 1];
		setTipoMazzo(tipoGioco);
		setDeckPath();
	}
	private void setDeckPath() {
		String cartellaProgetto = System.getProperty("user.dir");
		deckPath = cartellaProgetto + File.separator;
		switch (tipoMazzo) {
		case FRANCESE:
			deckPath += "carteFrancesi";	
			break;
		case TRIESTINO:
			deckPath += "carteTriestine";
			break;
		}
	}

	public String getDeckPath() {
		return deckPath;
	}
	public TipoGioco getTipoGioco() {
		return tipoGioco;
	}
	public TipoMazzo getTipoMazzo() {
		return tipoMazzo;
	}
	public void setTipoMazzo(int i) {
		this.tipoMazzo = tipoMazzo.values()[i-1];
		setDeckPath();
	}
	public void setTipoMazzo(TipoGioco tipoGioco) {
		switch(tipoGioco) {
		case BLACKJACK:
			tipoMazzo = tipoMazzo.FRANCESE;
			break;
		case SETTEEMEZZO:
			tipoMazzo = tipoMazzo.TRIESTINO;
			break;
		case SOLITARIO:
			tipoMazzo = tipoMazzo.FRANCESE;
			break;
		}
	}
	public void setTipoMazzo(TipoMazzo tm) {
		this.tipoMazzo = tm;
	}
	public boolean isSolitario() {
		return tipoGioco == TipoGioco.SOLITARIO;
	}
	

}

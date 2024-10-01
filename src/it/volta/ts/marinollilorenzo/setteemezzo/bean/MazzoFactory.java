package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config;

public class MazzoFactory {

	protected Mazzo mazzo = null;
	
	public Mazzo genera() {
		Config config = Config.get();
		
		switch(config.getTipoMazzo()) {
		case TRIESTINO:
			mazzo = new MazzoTriestino();
			break;
		case FRANCESE:
			mazzo = new MazzoFrancese();
			break;
		}
		mazzo.genera();
		return mazzo;
	}
}

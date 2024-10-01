package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.util.List;

	enum SemiTriestini { COPPE, DENARI, BASTONI, SPADE};

	public interface TipoMazzoTriestino {

		int numeroCarte = 40;
		int numeroCartePerSeme = 10;
		int primaFigura = 8;
		
		List<String> getSemi();
		String getSeme(int i);
	}

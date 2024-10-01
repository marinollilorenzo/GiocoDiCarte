package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.util.List;

enum SemiFrancesi { CUORI, QUADRI, FIORI, PICCHE};

public interface TipoMazzoFrancese {

	int numeroCarte = 52;
	int numeroCartePerSeme = 13;
	int primaFigura = 11;
	
	List<String> getSemi();
	String getSeme(int i);
}

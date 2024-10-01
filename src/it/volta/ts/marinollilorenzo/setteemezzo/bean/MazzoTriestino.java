package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import it.volta.ts.marinollilorenzo.setteemezzo.boundary.CaricatoreImmagini;

public class MazzoTriestino extends Mazzo implements TipoMazzoTriestino{

	public MazzoTriestino() {
		super.numeroCarte = TipoMazzoTriestino.numeroCarte;
		super.numeroCartePerSeme = TipoMazzoTriestino.numeroCartePerSeme;
		super.primaFigura = TipoMazzoTriestino.primaFigura;

		super.semi = getSemi();
		super.immagini = caricaImmagini();
	}

	public ArrayList<String> getSemi() {
		SemiTriestini semiEnum[] = SemiTriestini.values();
		ArrayList<String> alSemi = new ArrayList<>();
		for(SemiTriestini s : semiEnum)
			alSemi.add(s.name());
		return alSemi;
	}

	public String getSeme(int i) {
		return null;
	}

	public List<Image> caricaImmagini(){
		return new CaricatoreImmagini().caricaImmagini();
	}
}

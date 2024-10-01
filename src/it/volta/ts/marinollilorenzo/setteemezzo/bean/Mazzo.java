package it.volta.ts.marinollilorenzo.setteemezzo.bean;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config;

public class Mazzo {

	protected Carta first = null;
	protected int numeroCarte;
	protected int numeroCartePerSeme;
	protected int primaFigura;
	protected ArrayList<String> semi;
	List<Image> immagini = null;


	public void genera() {
		 first = null;

		for(int i = 0; i < numeroCarte; i ++) {

			Carta toAdd = isLiscia(i) ? new Carta(primaFigura) : new FiguraFactory().getFigura(primaFigura);
			toAdd.setImmagine(immagini.get(i));
			toAdd.setValore(i % numeroCartePerSeme + 1);
			toAdd.setSeme(semi.get(i / numeroCartePerSeme));
			if(first == null)
				first = toAdd;
			else {
				int rand = rand(i);
				if(rand == 0) {
					toAdd.setNext(first);
					first = toAdd;
				} else {
					Carta current = first.getNext();
					rand --;
					Carta prec = first;
					if(current == null)
						prec.setNext(toAdd);
					else {
						boolean t = false;
						do {
							if(rand == 0) {
								prec.setNext(toAdd);
								toAdd.setNext(current);
								t = true;
							}
							current = current.getNext();
							prec = prec.getNext();
							rand --;
						}while(!t);
					}
				}
			}
		}
	}
	public Carta getCarta() {
		int casuale = (int)(Math.random()* numeroCarte);
		Carta current = first;
		for(int i = 0; i < numeroCarte ; i++) {
			if(i == casuale) 
				return current;
			current = current.getNext();
		}
		return null;
	}
	public Carta getCarta(int x) {
		Carta current = first;
		for(int i = 0; i < numeroCarte ; i++) {
			if(i == x) 
				return current;
			current = current.getNext();
		}
		return null;
	}

	public int gerNumeroCartePerSeme() {
		return numeroCartePerSeme;
	}
	public List<Image> getImages(){
		List<Image> images =  new ArrayList<>();
		for(int i = 0; i < numeroCarte; i ++) {
			Carta c = getCarta();
			images.add(c.getImmagine());
		}
		return images;
	}
	public Image getRetro() {
		return immagini.get(numeroCarte);
	}

	private int rand (int x){
		Random rand = new Random();
		return rand.nextInt(x);
	}
	private boolean isLiscia(int i) {
		return i % (numeroCartePerSeme) + 1 < primaFigura;
	}

	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
}

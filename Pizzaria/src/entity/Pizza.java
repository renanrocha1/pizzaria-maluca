package entity;

import tad.Lista;
import tad.Lista2;

public class Pizza {

	
	private String sabor;
	public Lista listaIng = new Lista();
	
	public Pizza(){}

	public Pizza(char s) {
		if (s == 'c') {
			defineSabor("Calabresa", "Calabresa", "Brócolis", "Azeitona", "Ovo", "Ervilha");
		} else if (s == 'p') {
			defineSabor("Portuguesa", "Presunto", "Queijo", "Milho", "Ovo", "Azeitona");
		} else if (s == 't') {
			defineSabor("Toscana", "Tomate", "Azeitona", "Calabresa", "Presunto", "Cebola");
		} else if (s == 'm') {
			defineSabor("Marguerita", "Calabresa", "Milho", "Tomate", "Brócolis", "Queijo");
		} else if (s == 'r') {
			defineSabor("Romana", "Queijo", "Cebola", "Milho", "Presunto", "Ervilha");
		} else if (s == 'v') {
			defineSabor("Vegetariana", "Brócolis", "Tomate", "Ervilha", "Ovo", "Cebola");
		}
	}

	private void defineSabor(String s, String i1, String i2, String i3, String i4, String i5) {
		this.setSabor(s);
		this.listaIng.inserePrimeiro(i1);
		this.listaIng.insereUltimo(i2);
		this.listaIng.insereUltimo(i3);
		this.listaIng.insereUltimo(i4);
		this.listaIng.insereUltimo(i5);
	}

	public String mostraPizza() {
		String s = getSabor()+"\n";

		for (int i = 1; i <= 5; i++) {
			s += listaIng.retornaNaPos(i).ingrdiente + " - " + (listaIng.retornaNaPos(i).controle==0?"f":"v") + "\n";
		}

		return s;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	

}

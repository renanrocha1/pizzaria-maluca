package tad;

import entity.Pizza;

public class Lista2 {
	
	public ElLista2 primeiro, ultimo, atual;
	
	public Lista2() {
		primeiro = ultimo = atual = null;
	}

	public boolean vazio() {
		return primeiro == null;
	}

	public int comprimento() {
		int comp = 0;
		atual = primeiro;
		while (atual != null) {
			comp++;
			atual = atual.proximo;
		}
		return comp;
	}

	public void inserePrimeiro(Pizza p) {
		ElLista2 novo = new ElLista2(p);
		if (vazio()) {
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		} else {
			novo.proximo = primeiro;
			primeiro = novo;
		}
	}

	public void insereUltimo(Pizza p) {
		ElLista2 novo = new ElLista2(p);
		if (vazio()) {
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		} else {
			ultimo.proximo = novo;
			ultimo = novo;
		}
	}

	public void movePos(int pos) {
		atual = primeiro;
		for (int i = 1; i < pos; i++) {
			atual = atual.proximo;
		}
	}

	public ElLista2 retornaNaPos(int pos) {
		movePos(pos);
		ElLista2 elemento = atual;
		return elemento;
	}

	public void insereNaPos(Pizza p, int pos) {
		ElLista2 novo = new ElLista2(p);
		movePos(pos);
		novo.proximo = atual.proximo;
		atual.proximo = novo;
	}

	public ElLista2 primeiro() {
		return primeiro;
	}

	public ElLista2 ultimo() {
		return ultimo;
	}

	public void removePrimeiro() {
		primeiro = primeiro.proximo;
	}

	public void removeUltimo() {
		if (comprimento() > 1) {
			movePos(comprimento() - 1);
			ultimo = atual;
			ultimo.proximo = null;
		} else {
			primeiro = null;
		}
	}

	public void removeNaPos(int pos) {
		if(pos==1)
			removePrimeiro();
		else{
			ElLista2 temp;
			movePos(pos);
			temp = atual.proximo;
			movePos(pos - 1);
			atual.proximo = temp;
		}
	}

	public ElLista2 buscaElmt(String in) {
		atual = primeiro;
		boolean retornou = false;
		while (retornou == false && atual != null) {
			if (atual.p.getSabor().equals(in)) {
				retornou = true;
			} else {
				atual = atual.proximo;
			}
		}
		if (atual == null) {
			return null;
		}
		return atual;

	}
}

	
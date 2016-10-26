package tad;

public class Lista {
	private ElLista primeiro, ultimo, atual;

	public Lista() {
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

	public void inserePrimeiro(String s) {
		ElLista novo = new ElLista(s);
		if (vazio()) {
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		} else {
			novo.proximo = primeiro;
			primeiro = novo;
		}
	}

	public void insereUltimo(String s) {
		ElLista novo = new ElLista(s);
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

	public ElLista retornaNaPos(int pos) {
		movePos(pos);
		ElLista elemento = atual;
		return elemento;
	}

	public void insereNaPos(String s, int pos) {
		ElLista novo = new ElLista(s);
		movePos(pos);
		novo.proximo = atual.proximo;
		atual.proximo = novo;
	}

	public ElLista primeiro() {
		return primeiro;
	}

	public ElLista ultimo() {
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
			ElLista temp;
			movePos(pos);
			temp = atual.proximo;
			movePos(pos - 1);
			atual.proximo = temp;
		}
	}

	public ElLista buscaElmt(String in) {
		atual = primeiro;
		boolean retornou = false;
		while (retornou == false && atual != null) {
			if (atual.ingrdiente.equals(in)) {
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
	
	
	public static void main(String[] args) {
		Lista l = new Lista();
		l.insereUltimo("Sorte\nSeus amigos compraram ingredientes demais\nPegue 1 ingrediente de um jogador");
		l.insereUltimo("Sorte\nSeu tempero est� perfeito\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nSua massa est� no ponto certo\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nFaltou a luz na cozinha\nPerca 1 ingrediente");
		l.removeNaPos(1);
		System.out.println(l.comprimento());
	}
}

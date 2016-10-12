package tad;

public class ListaCirc {
	private ElListaD primeiro, ultimo, atual;
	private int comprimento = 0;
	
	public ListaCirc() {
		primeiro = ultimo = atual = null;
	}
	
	public boolean vazio(){
		return primeiro==null;
	}
	
	public int comprimento(){
		return comprimento;
	}
	
	public void inserePrimeiro(String i){
		ElListaD novo = new ElListaD(i);
		if (vazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			primeiro.anterior = novo;
			novo.proximo = primeiro;
			primeiro = novo;
			primeiro.anterior = ultimo;
		}
		comprimento++;
	}
	
	public void insereUltimo(String i){
		ElListaD novo = new ElListaD(i);
		if (vazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			ultimo.proximo = novo;
			novo.anterior = ultimo;
			ultimo = novo;
			ultimo.proximo = primeiro;
		}
		comprimento++;
	}
	
	public void movePos(int pos){
		atual = primeiro;
		for (int i=1;i<pos;i++){
			atual = atual.proximo;
		}
	}
	
	public void insereNaPos(int pos, String i){
		ElListaD novo = new ElListaD(i);
		movePos(pos);
		novo.anterior = atual;
		novo.proximo = atual.proximo;
		atual.proximo.anterior = novo;
		atual.proximo = novo;
		comprimento++;
	}
	
	public ElListaD primeiro(){
		return primeiro;
	}
	
	public ElListaD ultimo(){
		return ultimo;
	}
	
	public ElListaD atual(){
		return atual;
	}
	
	public void removePrimeiro(){
		if(primeiro.proximo!=null){
			primeiro = primeiro.proximo;
			primeiro.anterior = ultimo;	
		}else{
			primeiro = null;
		}
		comprimento--;
	}
	
	public void removeUltimo(){
		if(ultimo.anterior!=null){
			ultimo = ultimo.anterior;
			ultimo.proximo = primeiro;
		}else{
			ultimo = null;
		}
		comprimento--;
	}
	
	public void removeNaPos(int pos){
		ElListaD temp;
		movePos(pos);
		temp = atual;
		atual.anterior.proximo = temp.proximo;
		atual.proximo.anterior = temp.anterior;
		comprimento--;
	}
}

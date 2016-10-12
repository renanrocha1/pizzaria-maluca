package tad;

public class Pilha {

	private ElPilha topo = null;
	
	public boolean vazio(){
		return this.topo == null;
	}
	
	public void empilhar(String v){
		ElPilha novo = new ElPilha(v);
		novo.proximo = this.topo;
		this.topo = novo;
	}
	
	public String desempilhar(){
		String r = this.topo.valor;
		this.topo = topo.proximo;
		return r;
	}
}

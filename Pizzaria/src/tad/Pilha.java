package tad;

public class Pilha {

	private ElPilha topo = null;
	
	public boolean vazio(){
		return this.topo == null;
	}
	
	public void empilhar(String v, byte n){
		ElPilha novo = new ElPilha(v, n);
		novo.proximo = this.topo;
		this.topo = novo;
	}
	
	public ElPilha desempilhar(){
		ElPilha r = this.topo;
		this.topo = topo.proximo;
		return r;
	}
}

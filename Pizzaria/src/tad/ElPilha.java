package tad;

public class ElPilha {
	public String valor;
	public byte controle = 0;
	public ElPilha proximo;
	
	public ElPilha(String v, byte n){
		valor = v;
		controle = n;
		proximo = null;
	}
}

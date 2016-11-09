package tad;

public class ElLista {

	public ElLista proximo = null;
	public String ingrdiente;
	public byte controle = 0;
	
	public ElLista(String in) {
		ingrdiente = in;
		proximo = null;
	}
	
	public ElLista(String s, byte n){
		ingrdiente = s;
		controle = n;
		proximo = null;
	}
}

package tad;

public class ElListaD {
	public ElListaD proximo, anterior;
	public String ingrediente;
	
	public ElListaD(String i) {
		ingrediente =i;
		anterior = null;
		proximo = null;
	}
	
}

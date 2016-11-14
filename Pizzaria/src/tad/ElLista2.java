package tad;

import entity.Pizza;

public class ElLista2 {
	public Pizza p = new Pizza();
	public ElLista2 proximo;
	
	public ElLista2(Pizza piz) {
		p = piz;
		proximo = null;
	}

}

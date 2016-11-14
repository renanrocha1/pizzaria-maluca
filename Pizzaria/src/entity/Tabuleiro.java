package entity;

import tad.ListaCirc;

public class Tabuleiro {
	ListaCirc l = new ListaCirc();
	SorteAzar sa = new SorteAzar();
	
	public Tabuleiro() {
		l = new ListaCirc();
		l.inserePrimeiro("Perde Tudo");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Azeitona");
		l.insereUltimo("Brócolis");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Ervilha");
		l.insereUltimo("Queijo");
		//l.insereUltimo("");
		l.insereUltimo("Presunto");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Calabresa");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Cebola");
		l.insereUltimo("Ovo");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Brócolis");
		l.insereUltimo("Sorte ou Azar");
		//l.insereUltimo("");
		l.insereUltimo("Milho");
		l.insereUltimo("Tomate");
		l.insereUltimo("Presunto");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Azeitona");
		l.insereUltimo("Milho");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Azeitona");
		l.insereUltimo("Ovo");
		l.insereUltimo("Tomate");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Queijo");
		l.insereUltimo("Calabresa");
		l.insereUltimo("Sorte ou Azar");
		l.insereUltimo("Cebola");
		
		
	}
	
	public String jogada(Pizza piz, int pos){
		l.movePos(pos);
		String casa = l.atual().ingrediente;
		if(casa.equals("Perde Tudo")){
			for(int i=1;i<=5;i++){
				piz.listaIng.retornaNaPos(i).controle = 0;
			}
		}else if(casa.equals("Sorte ou Azar")){
			sa.efeitos(piz);
		}else{
			for(int i=1;i<=5;i++){
				if(piz.listaIng.retornaNaPos(i).ingrdiente.equals(casa)){
					piz.listaIng.retornaNaPos(i).controle = 1;
					break;
				}
			}
		}
		return casa;
	}
}

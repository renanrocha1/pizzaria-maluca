package entity;

import java.util.Random;


import tad.ElPilha;
import tad.Lista;
import tad.Pilha;
import view.GanheIng;
import view.PegueIngs;
import view.PercaIng;
import view.Principal;

public class SorteAzar {
	
	static Pilha p = new Pilha();
	static Lista l = new Lista();
	public static Pizza piz;
	public boolean op7;
	
	public SorteAzar() {
		l.insereUltimo("Sorte: Seus amigos compraram ingredientes demais\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Sorte: Seu tempero est� perfeito\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte: Sua massa est� no ponto certo\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Azar: Faltou a luz na cozinha\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar: Seus amigos compraram ingredientes demais\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar: Voc� exagerou no tempero\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte: Todos adoraram suas �ltimas pizzas\nGanhe 2 ingredientes",(byte)2);
		l.insereUltimo("Azar: Sua pizza queimou\nPerca todos os ingredientes",(byte)7);
		l.insereUltimo("Sorte: Voc� fez compras na feira\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Azar: Sua cozinha alagou\nPerca 2 ingredientes",(byte)4);
		l.insereUltimo("Sorte: Seus amigos esqueceram as sacolas na sua pizzaria\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Azar: Voc� colocou muito sal\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar: Voc� colocou muita pimenta\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte: Seus amigos n�o tem como guardar ingredientes\nPegue 2 ingredientes de um jogador",(byte)6);
		l.insereUltimo("Azar: O forno n�o esquentou\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte: Voc� foi ao supermecado\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte: Seus amigos esqueceram de ligar a geladeira\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Azar: O supermercado est� fechado\nPerca 2 ingredientes",(byte)4);
		l.insereUltimo("Sorte: Sua pizza est� deliciosa\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte: Sua pizzaria est� cheia hoje\nGanhe 2 ingredientes",(byte)2);
		
		
		while(!l.vazio()){
			reembaralha();
		}
	}
	
	public static void reembaralha(){
		Random r = new Random();
		int pos = r.nextInt(l.comprimento())+1;
		p.empilhar(l.retornaNaPos(pos).ingrdiente, l.retornaNaPos(pos).controle);
		l.removeNaPos(pos);
	}
	
	public void efeitos(Pizza piz){
		op7 = false;
		this.piz = piz;
		ElPilha ep = p.desempilhar();
		Tabuleiro.getSA(ep.valor);
		l.insereUltimo(ep.valor, ep.controle);
		int op = ep.controle;
		switch(op){
			case 1:
				GanheIng.getNum(1);
				Principal.openComposite1();
				break;
			case 2:
				GanheIng.getNum(2);
				Principal.openComposite1();
				break;
			case 3:
				PercaIng.getNum(1);
				Principal.openComposite2();
				break;
			case 4:
				PercaIng.getNum(2);
				Principal.openComposite2();
				break;
			case 5:
				PegueIngs.getNum(1);
				Principal.openComposite3();
				break;
			case 6:
				PegueIngs.getNum(2);
				Principal.openComposite3();
				break;
			case 7:
				for(int i = 1;i<=5;i++){
					piz.listaIng.retornaNaPos(i).controle = 0;
				}
				op7 = true;
				break;
		}
		if(p.vazio())
			reembaralha();
	}
}

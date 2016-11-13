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
	
	public SorteAzar() {
		l.insereUltimo("Sorte\nSeus amigos compraram ingredientes demais\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Sorte\nSeu tempero está perfeito\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte\nSua massa está no ponto certo\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte\nFaltou a luz na cozinha\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar\nSeus amigos compraram ingredientes demais\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar\nVocê exagerou no tempero\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte\nTodos adoraram suas últimas pizzas\nGanhe 2 ingredientes",(byte)2);
		l.insereUltimo("Azar\nSua pizza queimou\nPerca todos os ingredientes",(byte)7);
		l.insereUltimo("Sorte\nVocê fez compras na feira\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Azar\nSua cozinha alagou\nPerca 2 ingredientes",(byte)4);
		l.insereUltimo("Sorte\nSeus amigos esqueceram as sacolas na sua pizzaria\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Azar\nVocê colocou muito sal\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Azar\nVocê colocou muita pimenta\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte\nSeus amigos não tem como guardar ingredientes\nPegue 2 ingredientes de um jogador",(byte)6);
		l.insereUltimo("Azar\nO forno não esquentou\nPerca 1 ingrediente",(byte)3);
		l.insereUltimo("Sorte\nVocê foi ao supermecado\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte\nSeus amigos esqueceram de ligar a geladeira\nPegue 1 ingrediente de um jogador",(byte)5);
		l.insereUltimo("Azar\nO supermercado está fechado\nPerca 2 ingredientes",(byte)4);
		l.insereUltimo("Sorte\nSua pizza está deliciosa\nGanhe 1 ingrediente",(byte)1);
		l.insereUltimo("Sorte\nSua pizzaria está cheia hoje\nGanhe 2 ingredientes",(byte)2);
		
		
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
		this.piz = piz;
		ElPilha ep = p.desempilhar();
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
				break;
		}
	}
}

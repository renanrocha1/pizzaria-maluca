package entity;

import java.util.Random;

import tad.Lista;
import tad.Pilha;

public class SorteAzar {
	
	Pilha p = new Pilha();
	Lista l = new Lista();
	
	public SorteAzar() {
		l.insereUltimo("Sorte\nSeus amigos compraram ingredientes demais\nPegue 1 ingrediente de um jogador");
		l.insereUltimo("Sorte\nSeu tempero está perfeito\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nSua massa está no ponto certo\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nFaltou a luz na cozinha\nPerca 1 ingrediente");
		l.insereUltimo("Azar\nSeus amigos compraram ingredientes demais\nPerca 1 ingrediente");
		l.insereUltimo("Azar\nVocê exagerou no tempero\nPerca 1 ingrediente");
		l.insereUltimo("Sorte\nTodos adoraram suas últimas pizzas\nGanhe 2 ingredientes");
		l.insereUltimo("Azar\nSua pizza queimou\nPerca todos os ingredientes");
		l.insereUltimo("Sorte\nVocê fez compras na feira\nGanhe 1 ingrediente");
		l.insereUltimo("Azar\nSua cozinha alagou\nPerca 2 ingredientes");
		l.insereUltimo("Sorte\nSeus amigos esqueceram as sacolas na sua pizzaria\nPegue 1 ingrediente de um jogador");
		l.insereUltimo("Azar\nVocê colocou muito sal\nPerca 1 ingrediente");
		l.insereUltimo("Azar\nVocê colocou muita pimenta\nPerca 1 ingrediente");
		l.insereUltimo("Sorte\nSeus amigos não tem como guardar ingredientes\nPegue 2 ingredientes de um jogador");
		l.insereUltimo("Azar\nO forno não esquentou\nPerca 1 ingrediente");
		l.insereUltimo("Sorte\nVocê foi ao supermecado\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nSeus amigos esqueceram de ligar a geladeira\nPegue 1 ingrediente de um jogador");
		l.insereUltimo("Azar\nO supermercado está fechado\nPerca 2 ingredientes");
		l.insereUltimo("Sorte\nSua pizza está deliciosa\nGanhe 1 ingrediente");
		l.insereUltimo("Sorte\nSua pizzaria está cheia hoje\nGanhe 2 ingredientes");
		
		
		while(!l.vazio()){
			reembaralha();
		}
	}
	
	public void reembaralha(){
		Random r = new Random();
		int pos = r.nextInt(l.comprimento())+1;
		System.out.println(pos+ " "+ l.comprimento());
		p.empilhar(l.retornaNaPos(pos).ingrdiente);
		l.removeNaPos(pos);
	}
	
	public static void main(String[] args) {
		SorteAzar sa = new SorteAzar();
		//System.out.println(sa.l.vazio());		
	}
}

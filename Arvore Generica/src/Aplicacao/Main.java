package Aplicacao;


import Estrutura.Arvore;

public class Main {

	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();
		
		arvore.insere(2);
		arvore.insere(4);
		arvore.insere(7);
		arvore.insere(3);
		arvore.insere(10);
		arvore.insere(20);
		
		arvore.imprimir();
		
		arvore.retornaRaizNos();
		
		arvore.retornaNosFolha();
		
		arvore.retornaGrauNos();
		
		arvore.retornaProfundidadeNos();
		
		arvore.retornaAlturaNos();
		
		arvore.retornaNiveisNos();
		
		arvore.retornaSubArvoresNos();
		
	
	}

}

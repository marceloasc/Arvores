package Estrutura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Arvore {

	public No raiz;
	public List nos = new ArrayList<No>();

	int contAltura;
	int contProfundidade;
	int contNivel;

	public void insere(int valor) {

		No novo = new No(valor);

		if (this.raiz == null) {
			raiz = novo;
			raiz.setNivel(0);
			this.nos.add(novo);

		} else {

			No atual = this.raiz;

			while (true) {

				List<String> opcoesFilho = Arrays.asList("direita", "esquerda");
				Random escolha = new Random();
				int opcao = escolha.nextInt(opcoesFilho.size());

				if (opcoesFilho.get(opcao) == "direita") {
					if (atual.getDireita() != null) {
						atual = atual.getDireita();
					} else {
						atual.setDireita(novo);
						novo.setPai(atual);
						int nivelNovo = novo.getPai().getNivel() + 1;
						novo.setNivel(nivelNovo);
						this.nos.add(novo);
						break;
					}

				} else {
					if (atual.getEsquerda() != null) {
						atual = atual.getEsquerda();
					} else {
						atual.setEsquerda(novo);
						novo.setPai(atual);
						int nivelNovo = novo.getPai().getNivel() + 1;
						novo.setNivel(nivelNovo);
						this.nos.add(novo);
						break;
					}

				}

			}

		}

	}

	public void imprimir() {

		System.out.println("Arvore: ");

		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			n.imprimeNo();
			System.out.println();
		}

	}

	public void retornaRaizNos() {

		System.out.println("------------------------------------------------------------");

		List nosSemRaiz = new ArrayList<Integer>();

		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			if (n.getValor() != this.raiz.getValor()) {
				nosSemRaiz.add(n.getValor());
			}
		}
		System.out.println("Raiz: " + this.raiz.getValor());
		System.out.println("Nós: " + nosSemRaiz);
	}

	public void retornaNosFolha() {
		System.out.println("------------------------------------------------------------");
		System.out.println();

		List folhas = new ArrayList<Integer>();

		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			if (n.getEsquerda() == null && n.getDireita() == null) {
				folhas.add(n.getValor());
			}
		}

		System.out.println("Nós folha: " + folhas);
	}

	public void retornaGrauNos() {
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			if (n.getEsquerda() == null && n.getDireita() == null) {
				n.setGrau(0);
			} else if (n.getEsquerda() != null && n.getDireita() == null
					|| n.getEsquerda() == null && n.getDireita() != null) {
				n.setGrau(1);
			} else {
				n.setGrau(2);
			}
		}

		System.out.println();
		System.out.println("Grau de cada Nó:");
		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			System.out.println("Nó: " + n.getValor());
			System.out.println("Grau: " + n.getGrau());
			System.out.println();
		}

	}

	public void retornaAlturaNos() {
		
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < this.nos.size(); i++) {

			No n = (No) this.nos.get(i);

			List visitados = new ArrayList<No>();
			List descendentes = new ArrayList<Integer>();

			Queue<No> fila = new LinkedList<>();

			visitados.add(n);
			fila.add(n);

			while (!fila.isEmpty()) {
				No atual = fila.peek();
				fila.remove();
				descendentes.add(atual);

				List filhosAtual = new ArrayList<No>();
				filhosAtual.add(atual.getDireita());
				filhosAtual.add(atual.getEsquerda());

				for (int j = 0; j < filhosAtual.size(); j++) {
					if (filhosAtual.get(j) != null) {
						if (visitados.contains(filhosAtual.get(j)) == false) {
							visitados.add(filhosAtual.get(j));
							fila.add((No) filhosAtual.get(j));
						}
					}
				}
			}
			
			descendentes.remove(0);
			
			No descMaiorNivel = null;
			int maior = -1;
			for (int d = 0; d < descendentes.size(); d++) {
				
				No noDesc = (No) descendentes.get(d);
				
				if (noDesc.getNivel() > maior) {
					maior = noDesc.getNivel();
					descMaiorNivel = noDesc;
				}
				
			}
		
			if (descMaiorNivel != null) {
				int alturaNo = descMaiorNivel.getNivel() - n.getProfundidade();
				n.setAltura(alturaNo);
			}
		}
		
		System.out.println();
		System.out.println("Altura de cada Nó:");
		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			System.out.println("Nó: " + n.getValor());
			System.out.println("Altura: " + n.getAltura());
			System.out.println();
		}

	}

	public void retornaProfundidadeNos() {

		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < this.nos.size(); i++) {

			No n = (No) this.nos.get(i);
			No atual = n;

			contProfundidade = 0;

			while (atual != this.raiz) {
				No paiAtual = atual.getPai();
				atual = paiAtual;
				contProfundidade += 1;
			}
			n.setProfundidade(contProfundidade);

		}

		System.out.println();
		System.out.println("Profundidade de cada Nó:");
		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			System.out.println("Nó: " + n.getValor());
			System.out.println("Profundidade: " + n.getProfundidade());
			System.out.println();
		}

	}

	public void retornaNiveisNos() {

		System.out.println("------------------------------------------------------------");

		System.out.println();
		System.out.println("Nivel de cada Nó:");
		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			System.out.println("Nó: " + n.getValor());
			System.out.println("Nivel: " + n.getNivel());
			System.out.println();
		}

	}

	public void retornaSubArvoresNos() {

		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < this.nos.size(); i++) {

			No n = (No) this.nos.get(i);

			if (n.getEsquerda() == null && n.getDireita() == null) {

				n.setContSubArvores(0);

			} else if (n.getEsquerda() != null && n.getDireita() == null
					|| n.getEsquerda() == null && n.getDireita() != null) {

				n.setContSubArvores(1);

			} else {
				n.setContSubArvores(2);
			}
		}

		System.out.println();
		System.out.println("Sub-arvore de cada Nó:");
		for (int i = 0; i < this.nos.size(); i++) {
			No n = (No) this.nos.get(i);
			System.out.println("Nó: " + n.getValor());
			System.out.println("Sub-árvores: " + n.getContSubArvores());
			System.out.println();
		}

	}

}

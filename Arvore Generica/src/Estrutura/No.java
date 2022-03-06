package Estrutura;

public class No {
	
	private No pai;
	private int valor;
	private No esquerda;
	private No direita;
	
	private int grau;
	private int profundidade;
	private int nivel;
	private int altura;
	private int contSubArvores;
	
	
	public No() {
	}
	
	public No(int valor) {
		this.valor = valor;
	}
	
	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public int getValor() {
		return valor;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerdo) {
		this.esquerda = esquerdo;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direito) {
		this.direita = direito;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getContSubArvores() {
		return contSubArvores;
	}

	public void setContSubArvores(int contSubArvores) {
		this.contSubArvores = contSubArvores;
	}

	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public Object retornaValorPai() {
		if (this.pai != null) {
			int pai = this.pai.valor;
			return pai;
		}
		return null;
	}
	
	public Object retornaValorEsquerda() {
		if (this.esquerda != null) {
			int esqd = this.esquerda.valor;
			return esqd;
		}
		return null;
	}
	
	public Object retornaValorDireita() {
		if (this.direita != null) {
			int dir = this.direita.valor;
			return dir;
		}
		return null;
	}


	public void imprimeNo() {
		System.out.println("Nó pai: " + this.retornaValorPai());
		System.out.println("Valor: " + this.valor);
		System.out.println("Filhos: " + "Esquerdo: " + this.retornaValorEsquerda() + " " + "Direito: " + this.retornaValorDireita());
	}

}
package exemplo;

public class Arvore {
	private No raiz = null;
	
	public Arvore() { }

	/******************************************OPERAÇÕES BASICAS*****************************************/

	public No getRaiz()
	{
		return this.raiz;
	}
	
	public void insere( No raiz, int chave, String filename, int size)
	{
		if (raiz == null)
			this.raiz = new No(chave, filename, size);
		else
		{	
			if (chave < raiz.getValor()){
				if (raiz.getEsquerda() != null)
					insere(raiz.getEsquerda(), chave, filename, size);
				else{
					No no = new No(chave, filename, size);
					raiz.setEsquerda(no);
				}
			}
			else {
				if (raiz.getDireita() != null)
					insere(raiz.getDireita(), chave, filename, size);
				else{
					No no = new No(chave, filename, size);
					raiz.setDireita(no);
				}
			}
		}
	}
	
	private void reposicionaArvore(No pai, No corrente, int valor)
	{
		if (corrente.getEsquerda() == null && corrente.getDireita() == null) /*sem filhos*/
		{
			No apontaCorrente = null;
			
			if (pai.getEsquerda() == corrente)
				pai.setEsquerda(null);
			else
				apontaCorrente = pai.getDireita();
			
			pai.setDireita(null);
			
			corrente = null;
		}
		else
			if (corrente.getEsquerda() == null || corrente.getDireita() == null) /*apenas um filho*/
			{
				No sucessor = null;
				if (corrente.getEsquerda() != null)
					sucessor = corrente.getEsquerda();
				else
					sucessor = corrente.getDireita();

				if (pai.getEsquerda() == corrente)
					pai.setEsquerda(sucessor);
				else
					pai.setDireita(sucessor);
				
				corrente = null;
			}
			else{ /*dois filhos*/
				/*localiza nó mais à esquerda da sub-arvore da direita de nó corrente*/
				No antecessor = corrente;
				No substituto = corrente.getDireita();
				 
				while (substituto.getEsquerda() != null) {
					antecessor = substituto;
					substituto = substituto.getEsquerda();
				}
				
				corrente.setValor(substituto.getValor());
				
				antecessor.setEsquerda(substituto.getDireita());
				
				substituto = null;
			}
			
			
	}
	
	public boolean remove( No pai, No corrente, int valor)
	{
		if (corrente == null)
			return false;
		else{
			if (corrente.getValor() == valor)
			{
				reposicionaArvore(pai, corrente, valor);
				return true;
			} 
			else
				if (valor <= raiz.getValor() )
					return remove(corrente, corrente.getEsquerda(), valor);
				else
					return remove(corrente, corrente.getDireita(), valor);
		}
	}
	
	public void caminhaPreFixado(No raiz)
	{
		if (raiz != null)
		{
			System.out.print(raiz.getValor() + " ");
			caminhaPreFixado(raiz.getEsquerda());
			caminhaPreFixado(raiz.getDireita());
		}
	}

	public void caminhaPosFixado(No raiz)
	{
		if (raiz != null)
		{
			caminhaPosFixado(raiz.getEsquerda());
			caminhaPosFixado(raiz.getDireita());
			System.out.print(raiz.getValor() + " ");
		}
	}
	
	public void caminhaCentral(No raiz)
	{
		if (raiz != null)
		{
			caminhaCentral(raiz.getEsquerda());
			System.out.print(raiz.getValor() + " ");
			caminhaCentral(raiz.getDireita());
		}
	}
	
	
	/******************************************OUTRAS OPERAÇÕES*****************************************/
	//Outras operações implemente aqui

	
}

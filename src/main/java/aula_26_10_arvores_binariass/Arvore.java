package aula_26_10_arvores_binariass;

public class Arvore {
	private No raiz = null;
	
	public Arvore() { }

	/******************************************OPERAÇÕES BASICAS*****************************************/

	public No getRaiz()
	{
		return this.raiz;
	}
	
//	public void insere( No noAtual, int chave, String filename, int size){
         
        // implementação deita por mim - MAX
//        
//            if(this.raiz == null)
//                this.raiz = new No(chave, filename, size);
//            
//            // vamos para a esquerda
//            if(chave < noAtual.getValor()){
//                if (noAtual.getEsquerda() == null)
//                    noAtual.setEsquerda(new No(chave, filename, size));
//                else{
//                    insere(noAtual.getEsquerda(), chave, filename, size);
//                }
//            }        
//            // vamos para a direita
//            else{
//              if (noAtual.getDireita() == null)
//                    noAtual.setDireita(new No(chave, filename, size));
//                else{
//                    insere(noAtual.getDireita(), chave, filename, size);
//                }   
//            }
//            
//        }        
        
         
        public int contaNos(int valorAtual, No raiz){
            if (raiz != null){
                valorAtual = contaNos(valorAtual, raiz.getEsquerda());
                valorAtual = contaNos(valorAtual, raiz.getDireita());
                return valorAtual+1;
            }
            return valorAtual;
	}
        
        public int totalSize(int valorAtual, No noAtual){
            if (noAtual != null){
                valorAtual = totalSize(valorAtual, noAtual.getEsquerda());
                valorAtual = totalSize(valorAtual, noAtual.getDireita());
                return valorAtual+noAtual.getSize();
            }
            return valorAtual;
	}
        
        public int retornaNivel(No raiz, int valor) {
        int nivel = 1;

        if(raiz != null) {
            if(raiz.getValor() == valor) {
                return nivel;
            } else {
                if(valor < raiz.getValor()) {
                return nivel += retornaNivel(raiz.getEsquerda(), valor);
            } else {
                return nivel += retornaNivel(raiz.getDireita(), valor);
            }
                
            }
        }

        return nivel;
        }
        
        public int getNivel2(No noAtual, int chave){
            int nivel = 1;
            
            if (noAtual.getValor() == chave)
                return nivel;
            else{
                
                if (chave < noAtual.getValor())
                    return nivel += getNivel(noAtual.getEsquerda(), chave, nivel);
                else
                    return nivel += getNivel(noAtual.getDireita(), chave, nivel);
            }
            
        }
        
        public int getNivel(No noAtual, int chave, int nivel){
            int count = 0;
            
            if (noAtual.getValor() == chave)
                return nivel;
            else{
                nivel += 1;
                if (chave < noAtual.getValor())
                    return getNivel(noAtual.getEsquerda(), chave, nivel);
                else
                    return getNivel(noAtual.getDireita(), chave, nivel);
            }
            
        }
        
        
        public int fileSize(No noAtual, int chave){
            if (noAtual.getValor() == chave)
                return noAtual.getSize();
            else{
                if (chave < noAtual.getValor())
                    return fileSize(noAtual.getEsquerda(), chave);
                else
                    return fileSize(noAtual.getDireita(), chave);
            }
        }
        
         //;  IMPLEMENTAÇÃO DO CARLÃO:  
        public void insere( No raiz, int chave, String filename, int size){
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
	
//	private void reposicionaArvore(No pai, No corrente, int valor){
//            
//		if (corrente.getEsquerda() == null && corrente.getDireita() == null) /*sem filhos*/
//		{
//			No apontaCorrente = null;
//			
//			if (pai.getEsquerda() == corrente)
//				pai.setEsquerda(null);
//			else
//				apontaCorrente = pai.getDireita();
//			
//			pai.setDireita(null);
//			
//			corrente = null;
//		}
//		else
//			if (corrente.getEsquerda() == null || corrente.getDireita() == null) /*apenas um filho*/
//			{
//				No sucessor = null;
//				if (corrente.getEsquerda() != null)
//					sucessor = corrente.getEsquerda();
//				else
//					sucessor = corrente.getDireita();
//
//				if (pai.getEsquerda() == corrente)
//					pai.setEsquerda(sucessor);
//				else
//					pai.setDireita(sucessor);
//				
//				corrente = null;
//			}
//			else{ /*dois filhos*/
//				/*localiza nó mais à esquerda da sub-arvore da direita de nó corrente*/
//				No antecessor = corrente;
//				No substituto = corrente.getDireita();
//				 
//				while (substituto.getEsquerda() != null) {
//					antecessor = substituto;
//					substituto = substituto.getEsquerda();
//				}
//				
//				corrente.setValor(substituto.getValor());
//				
//				antecessor.setEsquerda(substituto.getDireita());
//				
//				substituto = null;
//			}			
//	}
//        
//
//	
//	public boolean remove(No pai, No corrente, int valor){      
//         // implementação CARLÃO
//		if (corrente == null)
//			return false;
//		else{
//			if (corrente.getValor() == valor)
//			{
//				reposicionaArvore(pai, corrente, valor);
//				return true;
//			} 
//			else
//				if (valor <= raiz.getValor() )
//					return remove(corrente, corrente.getEsquerda(), valor);
//				else
//					return remove(corrente, corrente.getDireita(), valor);
//		}
//	}
        
        
        //IMPLEMENTAÇÃO MAX
        
        public No achaNo(No noAtual, int valor){
            if (noAtual.getValor() == valor)
                return noAtual;
            else{
                if (valor < noAtual.getValor())
                    return achaNo(noAtual.getEsquerda(), valor);
                else
                    return achaNo(noAtual.getDireita(), valor);
            }
        }
        
//        // verifica se o valor é o valor do nó e caso seja troca as referencias
//        public boolean remove(No pai, No corrente, int valor){   
//            
//            // a árvore foi completamente percorrida e o valor não foi encontrado.
//            if (corrente == null)
//                return false;
//    
//            // o nó a ser removido é o atual.
//            if (corrente.getValor() == valor){
//                trocaReferencias(pai, corrente);
//                return true;
//            }
//            // verifica para qual lado seguir, caso seja maior vai para a direita, 
//            // caso menor, para a esquerda, até achar o correto
//            else{
//                if (valor > corrente.getValor())
//                    return remove(corrente, corrente.getDireita(), valor);
//                else 
//                    return remove(corrente, corrente.getEsquerda(), valor);
//            }
//        }
//        
//        // troca as referencias (apontadores) - Utilizado na remoção
//        public void trocaReferencias(No pai, No corrente){
//            
//            // verifica se o nós corrente esta a esquerda ou a direita do pai.
//            boolean ehEsquerda = true;           
//            if (corrente.getValor() > pai.getValor())
//                ehEsquerda = false;
//            
//            // é um nó folha. É só remover a referência do pai.
//            if (corrente.getDireita() == null && corrente.getEsquerda() == null){
//                
//                if (ehEsquerda)
//                    pai.setEsquerda(null);         
//                else
//                    pai.setDireita(null);
//                return;
//            }
//
//            // somente um filho. Setamos o valor desse filho ao pai
//            if (corrente.getDireita() == null || corrente.getEsquerda() == null){
//                if (corrente.getDireita() == null){                    
//                    if (ehEsquerda)
//                        pai.setEsquerda(corrente.getEsquerda());         
//                    else
//                        pai.setDireita(corrente.getEsquerda());
//                }
//                else{
//                    if (ehEsquerda)
//                        pai.setEsquerda(corrente.getDireita());         
//                    else
//                        pai.setDireita(corrente.getDireita());
//                }
//                return;
//            }
//            
//            // Dois filhos. Pegamos o da direita e posteriormente todos da esquerda
//            else{
//                No substituto = corrente.getDireita();
//                while (substituto.getEsquerda() != null){
//                    substituto = substituto.getEsquerda();
//                }
//                substituto.setDireita(corrente.getDireita());
//                substituto.setEsquerda(corrente.getEsquerda());
//                if (ehEsquerda)
//                    pai.setEsquerda(substituto);         
//                else
//                    pai.setDireita(substituto);
//            }
//                
//        }
       
	
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

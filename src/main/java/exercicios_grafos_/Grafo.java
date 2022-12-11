package exercicios_grafos_;

import java.util.ArrayList;
import java.util.Iterator;

public class Grafo {
	
	private class No{
		public Vertice vertice = null;
		public No ant = null;
		public No prox = null;
	}

	private int quantVertices = 0;
	
	private No G = null;
	
	public Grafo(){}

	public Grafo(int chave)
	{
            addVertice(chave);
	}
	
	public Vertice getVertice(int chave){
		if (G != null){
			No aux = G;
			
			while (aux != null) {
				if (aux.vertice.chave == chave)
					return aux.vertice;
				aux = aux.prox;
			}
		}
		return null;
	}	
	
	public Vertice addVertice(int chave){
		try{
			Vertice v = new Vertice(chave);
			v.chave = chave;
			No novo = new No();
			novo.vertice = v;
		
			if (G == null) 
				G = novo;
			else {
				No aux = G;
			
				while (aux.prox != null)
					aux = aux.prox;
			
				aux.prox = novo;
				novo.ant = aux;
			}
			quantVertices++;
			return v;
		}
		catch (Exception e){
			return null;
		}
		
	}
	
	public boolean removeVertice(int chave){
		if (G != null){
			if (G.prox == null){
				removeAdjacencias(G.vertice);
				G = null;
			}
			else{
				No aux = G;
				while (aux.prox != null) {
					if (aux.vertice.chave == chave){
						removeAdjacencias(aux.vertice);
						if (aux.ant == null){
							G = G.prox;
							G.ant = null;
						}
						else
							if (aux.prox == null){
								No ant = aux.ant;
								ant.prox = null;
							}
							else{
								No ant = aux.ant;
								aux.prox.ant = ant;
								ant.prox = aux.prox;
							}
							
						aux = null;
						quantVertices--;
						return true;
					}
					aux = aux.prox;
				}
			}
		}
		return false;
	}
	
	private boolean removeAdjacencias(Vertice v){
		try{
			while (v.possuiAdjacencias())
				v.removeAdjacencia(0);
			quantVertices = 0;
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public void reset(){
		if (G != null){
			No aux = G;
			
			while (aux != null) {
				aux.vertice.visitado = false;
				aux = aux.prox;
			}
		}
	}	
	
	public void print()
	{
		if (G != null){
			No aux = G;
			
			while (aux != null) {
				System.out.print(aux.vertice.print());
				System.out.println("");
				aux = aux.prox;
			}
		}
	}
        
	public void menorCaminho(int origem, int destino){
	}

	/*
	 * IMPLEMENTAÇÕES ADICIONAIS
	 */

        
        	public void caminhaLargura() throws CloneNotSupportedException{
		Aresta adj = new Aresta();
		ArrayList<Aresta> adjacencias;
		Iterator<Aresta> iterator;
		ArrayList<Vertice> fila = new ArrayList();
		
		if (G != null){
			//Pega o v�rtice de entrada
			Vertice v = G.vertice;
			fila.add(v);
			v.visitado = true;
			System.out.println(v.chave);
			while (fila.size() > 0){
				//Retira vertice da fila
				v = fila.get(0);
				fila.remove(0);
				//Recupera a lista de adjac�ncias deste v�rtice
				adjacencias = v.getAdjacencias();
				iterator = adjacencias.iterator();
				
				//Percorre a lista de adjac�ncias deste v�rtice, enfileirando
				while (iterator.hasNext())
				{
					adj = iterator.next();
					if (!adj.destino.visitado){
						adj.destino.visitado = true;
						fila.add(adj.destino);
						System.out.println(adj.destino.chave);
					}
				}
			}
		}
	}
	

	public void caminhaProfundidade(){
		Aresta adj = new Aresta();
		ArrayList<Aresta> adjacencias;
		Iterator<Aresta> iterator;
		ArrayList<Vertice> pilha = new ArrayList();
		
		if (G != null){
			Vertice v = G.vertice;
			//Opera��o push
			pilha.add(v);
			v.visitado = true;
			System.out.println(v.chave);

			while (pilha.size() > 0){
				//Opera��o peek
				v = pilha.get(pilha.size()-1);
				adjacencias = v.getAdjacencias();
				iterator = adjacencias.iterator();
				while (iterator.hasNext())
				{
					adj = iterator.next();
					if (!adj.destino.visitado){
						adj.destino.visitado = true;
						//Opera��o push
						pilha.add(adj.destino);
						System.out.println(adj.destino.chave);

						adjacencias = adj.destino.getAdjacencias();
						iterator = adjacencias.iterator();
					}
				}
				//Opera��o pop
				pilha.remove(pilha.size()-1);
			}
		}
	}
	
	private int[][] geraMatrizCustos(){
		ArrayList<Aresta> adjacencias;
		Iterator<Aresta> iterator;
		int[][] matrizAdjacencias = new int[quantVertices+1][quantVertices+1];
		
		if (G != null){
			No aux = G;
			while (aux.prox != null){
				adjacencias = aux.vertice.getAdjacencias();
				iterator = adjacencias.iterator();
				while (iterator.hasNext())
				{
					Aresta adj = iterator.next();
					matrizAdjacencias[aux.vertice.chave][adj.destino.chave] = adj.peso;
				}
				aux = aux.prox;
			}
		}
		return matrizAdjacencias;
	}
    
	
}

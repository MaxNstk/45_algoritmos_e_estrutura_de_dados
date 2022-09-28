package prioridade;

import java.util.Scanner;

public class FilaPrioridade {
	
	private  No inicio;
	
	public FilaPrioridade(){
		inicio = null;
	}
	
	/*
	 * Nosso critério de prioridade será com base na comparação do parâmetro "prior" dentro
	 * dos elementos já existentes na fila. Este critério determina o seguinte: quanto menor o valor 
	 * de "prior", mais alta será a prioridade. Se já houver elemento(s) de mesma prioridade na fila
	 * o novo elemento será o ultimo deste subgrupo.
	 */
	public void insere(int chave, int prior)
	{
		if (inicio == null)
			inicio = new No(chave, prior);
		else
		{
			//Vamos percorrer a fila buscando a posição de inserção
			No aux = inicio; 
			//Esta variável vai marcar o ponto de inserção do novo nó. 

			No novo = new No(chave, prior);
			
			while (aux != null){
				/*
				 * Estes condicionais avaliam as possibilidades: 
				 * - percorrendo a fila nós achamos um subgrupo de mesma prioridade e neste caso precisaremos
				 *   trabalhar a nova inclusão ao final deste subgrupo 
				 * - percorrendo a fila encontramos um nó de prioridade menor que o novo nó a ser inserido.
				 *   Neste caso a inserção será neste ponto, imediatamente antes deste nó de prioridade menor.
				 * - percorremos a fila e este chega-se a conclusão que o novo nó deve ser incluido ao final, 
				 *   pois é o de mais baixa prioridade
				 */
				
				
				if (aux.prioridade > novo.prioridade){
					if (aux.ant == null){
						novo.prox = aux;
						aux.ant = novo;
						inicio = novo;
					}
					else {
						novo.prox = aux;
						novo.ant = aux.ant;
						aux.ant.prox = novo;
						aux.ant = novo;
					}
					break;
				}
				else
					//Achei alguem com prioridade identica. Vamos inserir depois do último de mesma prioridade
					if (aux.prioridade == novo.prioridade){
						while (aux.prox != null && aux.prox.prioridade == novo.prioridade)
							aux = aux.prox; //Estou me movimentando sobre o subrupo de mesma prioridade
						
						if (aux.prox == null){
							novo.ant = aux;
							aux.prox = novo;
						}
						else {
							novo.ant = aux;
							novo.prox = aux.prox;
							novo.prox.ant = novo;
							novo.ant.prox = novo;
						}
						break;
					}
					else
						//Alcancei fim da fila. Insere no final como mais baixa prioridade.
						if (aux.prioridade < novo.prioridade && aux.prox == null){ 
							novo.ant = aux;
							aux.prox = novo;
							break;
						}
				
				aux = aux.prox; //Estou me movimentando sobre a fila
			}
		}

	}

	/*
	 * A remoção é feita sempre no inicio da fila, visto que a inserção respeita o critério
	 * de prioridade.
	 */
	public int remove()
	{
		if (inicio != null){
			No aux = inicio;
			inicio = inicio.prox;
		
			if (inicio != null)
				inicio.ant = null;
		
			int result = aux.chave;
			aux = null;

			return result;
		}
		
		return -1;
	}
	
	public void print()
	{
		if (inicio != null){
			No aux = inicio;
			
			while (aux!= null){
				System.out.println(aux.prioridade);
				aux = aux.prox;
			}
		}
	}
	
}

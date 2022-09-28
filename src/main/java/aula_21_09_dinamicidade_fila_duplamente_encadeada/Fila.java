package aula_21_09_dinamicidade_fila_duplamente_encadeada;

import java.util.Scanner;

public class Fila {
	private static No inicio = null;
	
	public static void insere(int chave)
	{
		if (inicio == null){
			inicio = new No();
			inicio.chave = chave;
			inicio.ant = null;
			inicio.prox = null;
		}
		else
		{
			No aux = inicio;
			while (aux.prox != null)
				aux = aux.prox;
			
			No novo = new No();
			novo.chave = chave;
			aux.prox = novo;
			novo.ant = aux;
		}
		
	}
	
	
	public static int remove()
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
	
	public static int remove(int chave)
	{
		if (inicio != null){
			No aux = inicio;
			while (aux.chave != chave && aux.prox != null)
				aux = aux.prox;
			
			if (aux.chave == chave){
				if (aux.prox != null && aux.ant != null){
					aux.ant.prox = aux.prox;
					aux.prox.ant = aux.ant;
				}
				else
					if (aux.prox == null)
						aux.ant.prox = null;
					else
						if (aux.ant == null){
							inicio = aux.prox;
							inicio.ant = null;
						}
							
			}

			return aux.chave;
		}
		
		return -1;
	}
	
	public static void print()
	{
		if (inicio != null){
			No aux = inicio;
			
			while (aux.prox != null){
				System.out.print(aux.chave + " ") ;
				aux = aux.prox;
			}
			System.out.println(aux.chave);
		}
	}
	
	public static void destroi(){
		if (inicio != null){
			while (inicio.prox != null){
				inicio = inicio.prox;
				inicio.ant = null;
			}
			inicio = null;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("***FILA DUPLAMENTE ENCADEADA***");
		System.out.println("[1] - Incluir ");
		System.out.println("[2] - Remover");
		System.out.println("[3] - Imprimir");
		System.out.println("[4] - Destruir");
		System.out.println("[5] - Sair");
		int opcao = s.nextInt();
		while (opcao != 5){
			switch(opcao){
			case 1:
				System.out.println("Informe o valor da chave");
				int chave = s.nextInt();
				insere(chave);
				break;
			case 2:
				remove();
				break;
			case 3: 
				print();
				break;
			case 4: 
				destroi();
				break;
			case 5: 
				break;
			default:
				System.out.println("Opcao invalida!!!!");
				break;
			}
			System.out.println("***FILA DUPLAMENTE ENCADEADA***");
			System.out.println("[1] - Incluir ");
			System.out.println("[2] - Remover");
			System.out.println("[3] - Imprimir");
			System.out.println("[4] - Destruir");
			System.out.println("[5] - Sair");
			opcao = s.nextInt();
		}
	}
}

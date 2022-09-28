package deque;

import java.util.Scanner;

public class Deque {

public static class No {
	int chave = 0;
	No prox = null;
	No ant = null;
}

	private static No inicio = null;
	private static int n = 0;
	
	public static boolean insereFinal(int chave)
	{
		
		try {
			if (inicio == null){
				inicio = new No();
				inicio.chave = chave;
				inicio.ant = null;
				inicio.prox = null;
			}
			else
			{
				No novo = new No();
				novo.chave = chave;
			
				No aux = inicio;
				while (aux.prox != null)
					aux = aux.prox;
			
				aux.prox = novo;
				novo.ant = aux;
			}
			n++;
			return true;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean insereInicio(int chave)
	{
		try {
			if (inicio == null){
				inicio = new No();
				inicio.chave = chave;
				inicio.ant = null;
				inicio.prox = null;
			}
			else
			{
				No novo = new No();
				novo.chave = chave;
				novo.prox = inicio;
				inicio.ant = novo;
				inicio = novo;
			}
			n++;
			return true;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	/*A variavel pos indica a posição relativa onde vai ser inserido
	o novo  nó da lista. */ 
	public static boolean insereMeio(int pos,int chave)
	{
		try {
			if (inicio == null)
				return false;

			if (pos == 1)
				return insereInicio(chave);

			if (pos > n)
				return insereFinal(chave);
			
			No aux = inicio;
			int cont  = 1;
			while (aux.prox != null && cont < pos) {
				aux = aux.prox;
				cont++;
			}
			
			No novo = new No();
			novo.chave = chave;
			
			No ant = aux.ant;
			ant.prox = novo;
			novo.ant = ant;
			
			novo.prox = aux;
			aux.ant = novo;
			n++;
			return true;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static int removeFim()
	{
		try {
			if (inicio == null)
				return -1;

			No aux = inicio;
			while (aux.prox != null) 
				aux = aux.prox;
			
			No ant = aux.ant;
			ant.prox = null;
			int chave = aux.chave;
			aux = null;
			
			n--;
			return chave;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return -1;
		}

	}
	
	public static int removeInicio()
	{
		try {
			if (inicio == null)
				return -1;

			No prox = inicio.prox;
			int chave = inicio.chave;
			
			inicio.prox = null;
			prox.ant= null;
			inicio = null;
			inicio = prox;
			
			n--;
			return chave;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return -1;
		}

	}
	
	/*A variavel pos indica a posição relativa onde vai ser inserido
	o novo  nó da lista. */ 
	public static int removeMeio(int pos)
	{
		try {
			if (inicio == null)
				return -1;

			if (pos == 1)
				return removeInicio();

			if (pos == n)
				return removeFim();
			
			No aux = inicio;
			int cont  = 1;
			while (aux.prox != null && cont < pos) {
				aux = aux.prox;
				cont++;
			}
			
			No prox = aux.prox;
			No ant = aux.ant;
			
			ant.prox = prox;
			prox.ant = ant;
			
			int chave = aux.chave;
			aux = null;

			n++;
			return chave;
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public static void print()
	{
		if (inicio != null){
			No aux = inicio;
			
			while (aux.prox != null){
				System.out.println(aux.chave);
				aux = aux.prox;
			}
			System.out.println(aux.chave);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int op = 0;
		int valor = 0;
		while (op != 8){
			System.out.println("1 - Incluir no inicio");
			System.out.println("2 - Incluir no final");
			System.out.println("3 - Incluir no meio");
			System.out.println("4 - Remover do inicio");
			System.out.println("5 - Remover do final");
			System.out.println("6 - Remover do meio");
			System.out.println("7 - Imprimir");
			System.out.println("8 - Sair");
			System.out.println("Informe operação");
			op = s.nextInt();
			switch(op){
				case 1:
				case 2:
					System.out.println("Informe o valor");
					valor = s.nextInt();
					boolean retorno = op == 1 ? insereInicio(valor) : insereFinal(valor);
					break;
				case 3:
					System.out.println("Informe o valor");
					valor = s.nextInt();
					System.out.println("Informe a posição");
					int pos = s.nextInt();
					retorno = insereMeio(valor, pos);
					break;
				case 4:
				case 5:
					int chave = op == 4 ? removeInicio() : removeFim();
					break;
				case 6:
					System.out.println("Informe a posição");
					pos = s.nextInt();
					chave = removeMeio(pos);
					break;
				case 7:
					print();
					break;
				case 8:
					break;
				default:
					System.out.println("******Opção invalida!!!!******");
					break;
			}
		}
	}
}

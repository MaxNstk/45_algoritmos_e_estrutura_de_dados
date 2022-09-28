/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_14_09_22_estrututras_lineares;
import java.util.Scanner;

/**
 *
 * @author maxna
 */
public abstract class ListaAbstrata {
    protected int[] lista = new int[5];
	protected  int n = 0;

	
	protected abstract boolean insere(int valor);
	protected abstract boolean remove();

	protected void imprime() {
		System.out.println();
		System.out.println("****ESTADO ATUAL DA FILA****");
		for (int i = 0; i < lista.length; i++)
			System.out.print(lista[i]+ " ");
		System.out.println();
		System.out.println();
	}
	
	public void start() {
		Scanner s = new Scanner(System.in);
		int op = 0;
		int valor = 0;
		while (op != 4){
			System.out.println("1 - Incluir");
			System.out.println("2 - Remover");
			System.out.println("3 - Imprimir");
			System.out.println("4 - Sair");
			System.out.println("Informe operação");
			op = s.nextInt();
			switch(op){
				case 1:
					System.out.println("Informe o valor");
					valor = s.nextInt();
					if (insere(valor)) System.out.println("Inclu�do");
					else System.out.println("cheio!");
					break;
				case 2:
					System.out.println("Removido: " + remove());
					break;
				case 3:
					imprime();
					break;
				case 4:
					break;
				default:
					System.out.println("******Op��o invalida!!!!******");
					break;
			}
		}
		System.out.println("******FIM!!!!******");
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_14_09_22_estrututras_lineares;

public class Pilha extends ListaAbstrata{

	@Override
	protected void imprime() {
		System.out.println();
		System.out.println("****ESTADO ATUAL DA PILHA****");
		System.out.println("TOPO");
		for (int i = lista.length -1; i >= 0 ; i--)
			System.out.println(lista[i]);
		System.out.println();
	}
	protected boolean insere(int valor){
		System.out.println("*** EMPILHANDO ELEMENTO ***");
		if (n < lista.length){
			lista[n] = valor;
			n++;
			return true;
		}
		return false;
	}
	protected boolean remove(){
		System.out.println("*** DESEMPILHANDO ELEMENTO ***");
		if (n > 0){
			n--;
			lista[n] = 0;
			return true;
		}
		return false;
	}
	//**peek
	protected void consulta(){
		System.out.println("TOPO DA PILHA " + lista[n-1]);
	}
	
	@Override
	public void start(){
		System.out.println("*** PILHA ***");
		super.start();
	}

}

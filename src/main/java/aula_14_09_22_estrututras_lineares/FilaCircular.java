/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_14_09_22_estrututras_lineares;

/**
 *
 * @author maxna
 */
public class FilaCircular extends ListaAbstrata {
	protected int inicio = 1;
	protected int fim = 0;

	@Override
	protected void imprime() {
		System.out.println();
		System.out.println("****ESTADO ATUAL DA FILA****");
		for (int i = 0; i < lista.length; i++){
			if (i == (inicio-1))
				System.out.print(lista[i]+ "(i) ");
			else
				if (i == (fim-1))
					System.out.print(lista[i]+ "(f) ");
				else
					System.out.print(lista[i]+ " ");

		}
		System.out.println();
		System.out.println();
	}
	
	
	//**enqueue
	protected boolean insere(int valor){
		System.out.println("*** ENFILEIRANDO ELEMENTO ***");
		if (n < lista.length){
			//Enfileirar
			fim = (fim % lista.length) + 1;
			lista[fim-1] = valor;
			n++;
			return true;
		}
		return false;
	}

	//**dequeue
	protected boolean remove(){
		System.out.println("*** DESINFILEIRANDO ELEMENTO ***");
		if (n > 0){
			//Desinfileirar
			lista[inicio-1]= 0;
			inicio = (inicio % lista.length) +1;
			n--;
			return true;
		}
		return false;
	}
	
	@Override
	public void start(){
		System.out.println("*** FILA CIRCULAR ***");
		super.start();
	}

 }

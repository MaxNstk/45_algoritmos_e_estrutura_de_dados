/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_14_09_22_estrututras_lineares;

import java.util.Scanner;

public class FilaSequencial extends ListaAbstrata {
	protected boolean insere(int valor) {
		System.out.println("*** ENFILEIRANDO ELEMENTO ***");
		if (n < lista.length) {
			// Enfileirar
			lista[n] = valor;
			n++;
			return true;
		}
		return false;
	}
	protected boolean remove() {
		System.out.println("*** DESINFILEIRANDO ELEMENTO ***");
		if (n > 0) {
			// Desinfileirar
			for (int i = 0; i < (n - 1); i++) {
				lista[i] = lista[i + 1];
			}
			n--;
			lista[n] = 0;
			return true;
		}
		return false;
	}
	@Override
	public void start() {
		System.out.println("*** FILA CONVENCIONAL ***");
		super.start();
	}
}

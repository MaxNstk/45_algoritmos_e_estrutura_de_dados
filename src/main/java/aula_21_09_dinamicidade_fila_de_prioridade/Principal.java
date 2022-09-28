package prioridade;

public class Principal {

	public static void main(String[] args) {
		FilaPrioridade fila = new FilaPrioridade();
		
		fila.insere(43124, 3);
		fila.insere(43124, 1);
		fila.insere(43124, 5);
		fila.insere(43124, 3);
		fila.insere(43124, 8);
		fila.insere(43124, 1);
		fila.insere(43124, 2);
		fila.insere(43124, 5);
		fila.insere(43124, 3);
		fila.insere(43124, 3);
		fila.insere(43124, 15);
		fila.insere(43124, 0);


		

		
		fila.print();
	}

}

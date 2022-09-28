package aula_14_09_22_estrututras_lineares;

import java.util.Scanner;

public class Deque extends FilaSequencial {

	//**insere
	protected boolean insereInicio(int valor){
		System.out.println("*** INSERINDO NO INICIO ***");
		if (n < lista.length){
			for (int i = n-1; i >= 0 ; i--)
				lista[i+1] = lista[i];
			lista[0] = valor;
			n++;
			return true;
		}
		return false;
	}
	
	//**remove
	protected boolean removeFinal(){
		System.out.println("*** REMOVENDO DO FINAL ***");
		if (n > 0){
			n--;
			lista[n] = 0;
			return true;
		}
		return false;
	}
	
	
	@Override
	public void start(){
		System.out.println("******DEQUE ******");
		Scanner s = new Scanner(System.in);
		int op = 0;
		int valor = 0;
		while (op != 6){
			System.out.println("1 - Inserir no final");
			System.out.println("2 - Remover do inicio");
			System.out.println("3 - Inserir no inicio");
			System.out.println("4 - Remover do final");
			System.out.println("5 - Imprimir");
			System.out.println("6 - Sair");
			System.out.println("Informe operação");
			op = s.nextInt();
			switch(op){
				case 1:
					System.out.println("Informe o valor");
					valor = s.nextInt();
					System.out.println("Incluído : " + super.insere(valor));
					break;
				case 2:
					System.out.println("Removido : " + super.remove());
					break;
				case 3:
					System.out.println("Informe o valor");
					valor = s.nextInt();
					System.out.println("Incluído : " + insereInicio(valor));
					break;
				case 4:
					System.out.println("Incluído : " + removeFinal());
					break;
				case 5:
					imprime();
					break;
				case 6:
					break;
				default:
					System.out.println("******Opção invalida!!!!******");
					break;
			}
		}
		System.out.println("******FIM!!!!******");
	}

}

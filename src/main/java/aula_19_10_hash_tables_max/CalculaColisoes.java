package aula_19_10_hash_tables_max;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Este programa pega uma tabela de tamanho n e faz um ensaio da seguinte forma: gera as chaves 
 * pelo m�todo da divis�o e da multiplica��o para ver quantas colis�es cada m�todo provoca.
 */
public class CalculaColisoes {
	
	/*
	 * Esta fun��o define o tamanho da tabela hash. O esquema � o seguinte: 
	 */
	public static int defineTamanho(int n, int colisoes){
		/*1 - Quantidade m�nima de slots em acordo com a quantidade de colis�es que 
		 *    considero toler�vel. � o tamanho prim�rio da tabela, mas n�o o definitivo.
		 */
		int m = n/colisoes;
		
		/*2- Busca-se as duas potencias de 2. Queremos o valor imediatamente anterior ao tamanho
		 *   inicial(piso) e tamb�m o valor imediatamente posterior(teto).  
		 */
		
		int exp = 0; 
		int piso = 0; 
		int aux = (int) Math.pow(2, exp);
		while (aux < m){
			piso = aux; 
			exp++;
			aux = (int) Math.pow(2, exp);
		}
		int teto = (int) Math.pow(2, exp);
		
		//3 - Busca os numeros primos no intervalo definido entrre piso e teto
		ArrayList listaPrimos = new ArrayList();
		for (int i = piso; i <= teto; i++)
		{
			boolean primo = i >= 2;
			for (int x = 2; x < i; x++)
			{
				if (i % x == 0){
					primo = false; break;
				}
			}
			if (primo)
				listaPrimos.add(i);
		}
		
		//4 - Descobrimos o mais distante. Este � o tamanho final da tabela.
		return (int)listaPrimos.get((listaPrimos.size()/2));
	}

	/*Nesta fun��o "n" � a quantidade de elementos a inserir. Para fins de ensaio vamos considerar
	 * um conjunto de chaves sequenciais de 1..n;
	 */
	public static int[] geraChavesMetodoDivisao(int n, int colisoes)
	{
		int h = 0;

		Hash hash = new Hash(n, colisoes);
		int[] t = new int[hash.colecao.length];

		try{
			for (int i = 1; i <= n; i++){
				h = (int)(i % hash.colecao.length);
				//System.out.println("K=" +i + " h(k)=" +h);
				t[h]++;
			}
			return t;
		}
		catch (Exception e)
		{
			System.out.println("ERRO GERANDO CHAVES: " + e.getMessage());
			return null;
		}
	}
	
	/*Nesta fun��o "n" � a quantidade de elementos a inserir. Para fins de ensaio vamos considerar
	 * um conjunto de chaves sequenciais de 1..n; da mesma forma que a fun��o anterior.
	 */
	public static int[] geraChavesMetodoMultiplicacao(int n, int colisoes)
	{
		int h = 0;
		double A = (Math.sqrt(5)-1)/2;
		Hash hash = new Hash(n, colisoes);
		int[] t = new int[hash.colecao.length];

		try{
			for (int i = 1; i <= n; i++){
				h = (int)(hash.colecao.length*((i*A) % 1));
				//System.out.println("K=" +i + " h(k)=" +h);
				t[h]++;
			}
			return t;
		}
		catch (Exception e)
		{
			System.out.println("ERRO GERANDO CHAVES: " + e.getMessage());
			return null;
		}
	}
	
	
	public static int calculaColisoes(int[] tabela)
	{
		int cont = 0;
		
		for (int i = 0; i < tabela.length; i++)
			if (tabela[i] > 1)
				cont += tabela[i]-1;
		return cont;
	}
	
	public static void print(int[] tabela)
	{
		for (int i = 0; i < tabela.length; i++)
			System.out.println(tabela[i]);
	}
	

	public static void main(String[] args) throws UnsupportedEncodingException {

		//Numero de registros a serem inseridas na tabela
		int n = 500000;
		
		//N�mero m�dio de colis�es que eu considero aceitavel
		int colisoes = 2;
		
		int c1 = calculaColisoes(geraChavesMetodoDivisao(n, colisoes));
		int c2 = calculaColisoes(geraChavesMetodoMultiplicacao(n, colisoes));
		
		System.out.println("METODO DA DIVIS�O -------- COLIS�ES: " + c1);
		System.out.println("METODO DA MULTIPLICA��O -- COLIS�ES: " + c2);
		
		double dif = Math.abs((((double)c2-(double)c1)/(double)c1 * 100));
		
		System.out.println("DIFEREN�A PERCENTUAL: " + new DecimalFormat("00.0").format(dif) + "%");
	}
}

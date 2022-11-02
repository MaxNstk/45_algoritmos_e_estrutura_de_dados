package aula_19_10_hash_tables_max;

import java.util.ArrayList;

public class Hash {

	public Cliente colecao[];
	public int tamanho;
	private int n;
	private int colisoes;

	//No construtor, "n" � quantidade de registros que quero inserir, e "c" m�dia de colis�es aceit�vel 
	public Hash(int n, int c) {
		colecao = new Cliente[defineTamanho(n,c)];
		tamanho = colecao.length;
		colisoes = c;
		this.n = n;
	}
	
	//Tomemos "n" como a quantidade de registros a inserir, e "c" a quantidade de colis�es tolerada
	public  int defineTamanho(int n, int colisoes){

		//1. Definir o tamanho prim�rio da tabela. N�o o definitivo.
		int tamanhoProvisorio = n/colisoes;
		
		//2. Buscar as duas potencias de 2 imediatamente anterior e posterior a "tamanhoProvisorio"
		int exp = 0; 
		int piso = 0; 
		int aux = (int) Math.pow(2, exp);
		while (aux < tamanhoProvisorio){
			piso = aux; 
			exp++;
			aux = (int) Math.pow(2, exp);
		}
		int teto = (int) Math.pow(2, exp);
		
		//3.Busca os numeros primos no intervalo definido entre piso e teto
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
		
		//4.Descobrimos o mais distante. Este � o tamanho final da tabela.
		return (int)listaPrimos.get((listaPrimos.size()/2));
	}
	

	//Esta fun��o realiza o hashing pelo m�todo da multiplica��o
	int hashing(int codCliente) {
		int m = n/colisoes;
		double A = (Math.sqrt(5)-1)/2;

		return (int)(m*((codCliente*A) % 1));
	}
	
	public boolean colisao(int chave){
            return colecao[chave] != null;
	}
	
	public boolean insere(int codCliente, Cliente c) {
                c.setCod(codCliente);
		try{
                    if (colecao != null){
                        int chave = hashing(codCliente);
                        if (!colisao(chave)){
                                colecao[chave] = c;
                        }
                        //Trata colisao. Aqui devemos gerenciar nossa lista encadeada.
                        else{
                                Cliente aux = colecao[chave];
                                while (aux.prox != null) 
                                    aux = aux.prox;                                        
                                aux.prox = c;
                                c.ant = aux;
                                colisoes++;
                        }
                    }
                    return true;
		}
		catch (Exception e)
		{
			System.out.println("N�o foi incluido");
			return false;
		}
	}
	
	public boolean remove(int codCliente) {
		try{
                    if (colecao != null){
                        int chave = hashing(codCliente);
                        if (colecao[chave] == null)
                            return false;
                        
                        /* Vamos proceder a remo��o. Se n�o houve colis�o neste slot, apenas limpamos o slot.
                         * Caso  contr�rio, temos que gerenciar nossa lista din�mica. Observe:
                         */
                        if (colecao[chave].prox == null)
                                colecao[chave] = null;
                        // há colisões
                        else{
                            
                            Cliente aux = colecao[chave];
                            while (aux.getCod() != codCliente){
                                aux = aux.prox;
                            }
                            // é o primeiro
                            if (aux.ant == null){
                                // elemento único
                                if (aux.prox == null)
                                    colecao[chave] = null;            
                                // múltiplos elementos
                                else{
                                    colecao[chave] = aux.prox;
                                    colecao[chave].ant = null;
                                }
                            }                              
                            // é o último
                            else if (aux.prox == null)
                                aux.ant.prox = null;
                            
                            // é um do meio da cadeia
                            else{
                                aux.ant.prox = aux.prox;
                                aux.prox.ant = aux.ant;
                            }
                            
                        }
                    }
                    return true;
		}
		catch (Exception e)
		{
			System.out.println("Não foi incluido");
			return false;
		}
	}
        
        // copiei ai em baixo do carlão
        
        private String concatenaColisoes(Cliente c) {
        String msg = "[";
        while (c.prox != null) {
                msg += ", " + c.getNome();
                c = c.prox;
        }
        msg += ", " + c.getNome();
        msg += "]";
        return msg;
	}
	

	public void imprime() {
            System.out.println("Colisões registradas." + colisoes);
            for (int i = 0; i < tamanho; ++i){ 
                    if (colecao[i] != null) 
                            System.out.println(concatenaColisoes(colecao[i]));
                    else
                            System.out.println("[Slot não ocupado]");
            }
            System.out.println("--------------------------------------------");                
	}
}

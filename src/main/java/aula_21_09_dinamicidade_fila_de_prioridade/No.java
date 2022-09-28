package prioridade;

public class No {
	public int chave = -1;
	public int prioridade = -1;
	public No ant = null;
	public No prox = null;
	
	public No (int chave, int prioridade){
		this.chave = chave;
		this.prioridade = prioridade;
	}
}

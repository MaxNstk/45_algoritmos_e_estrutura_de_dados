package aula_19_10_hash_tables_carlos;

public class Cliente {
	private int cod = -1;
	private String CPF = "";
	private String nome = "";
	public Cliente prox = null;
	public Cliente ant = null;
	
	public Cliente(String CPF, String nome)
	{
		setCPF(CPF);
		setNome(nome);
		setCod(cod);
	}
	
	public void setCPF(String CPF)
	{
		this.CPF = CPF;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setCod(int cod)
	{
		this.cod = cod;
	}

	public String getCPF()
	{
		return CPF;
	}
	
	public String getNome()
	{
		return nome;
	}

	public int getCod()
	{
		return cod;
	}
}

package aula_19_10_hash_tables_max;

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
    }

    public void setCPF(String CPF)
    {
            this.CPF = CPF;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


    public void setNome(String nome)
    {
            this.nome = nome;
    }

    public String getCPF()
    {
            return CPF;
    }

    public String getNome()
    {
            return nome;
    }

}

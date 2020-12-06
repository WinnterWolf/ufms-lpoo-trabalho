package ufms.lpoo.models;

public class Funcionario extends Pessoa{
    private float salario;
    private String funcao;

    public Funcionario(String nome, String cpf, Endereco endereco, String celular, float salario, String funcao) {
        super(nome, cpf, endereco, celular);
        this.salario = salario;
        this.funcao = funcao;
    }
    public Funcionario(Funcionario f) {
        super(f.getNome(), f.getCpf(), f.getEndereco(), f.getCelular());
        this.salario = f.getSalario();
        this.funcao = f.getFuncao();
    }

    @Override
    public String toString() {
        return "nome= "+getNome();
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}

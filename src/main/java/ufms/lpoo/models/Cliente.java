package ufms.lpoo.models;

public class Cliente extends Pessoa{


    public Cliente(String nome, String cpf, Endereco endereco, String celular) {
        super(nome, cpf, endereco, celular);
    }

    public Cliente(Cliente c) {
        super(c.getNome(), c.getCpf(), c.getEndereco(), c.getCelular());
    }
    @Override
    public String toString() {
        return "nome= "+getNome()+", celular= "+getCelular();
    }
}

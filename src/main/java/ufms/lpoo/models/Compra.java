package ufms.lpoo.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compra {

    private Funcionario funcionario;
    private Cliente cliente;
    private List<Produto> produtosLista = new ArrayList<>();

    public Compra(Funcionario funcionario, Cliente cliente) {
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto prod){

        this.produtosLista.add(prod);
    }
    public void listarCompra(){

        Collections.sort(this.produtosLista);//Ordenando em ordem alfabética pelo nome do produto
        double soma = 0;
        System.out.println("Funcionario: "+getFuncionario());
        System.out.println("Cliente: "+getCliente());
        System.out.print("Produtos: ");
        System.out.println(produtosLista.toString());
        for (Produto p: getProdutos()) {
            soma += p.getValor();
        }
        System.out.printf("Total da compra: %.2f", soma);


    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtosLista;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtosLista = produtos;
    }
}

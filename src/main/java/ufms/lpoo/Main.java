package ufms.lpoo;

import ufms.lpoo.models.Endereco;
import ufms.lpoo.models.Funcionario;
import ufms.lpoo.resources.Auxiliar;

import javax.swing.*;
import java.util.*;

public class Main {

    Scanner sc = new Scanner(System.in);

    Map<Integer, Endereco> enderecos = new HashMap<>();
    List<Funcionario> funcionarios = new ArrayList<>();


    public void adicionaEndereco(){
        String rua, bairro, cidade, cep, resposta;
        int numero;
        boolean maisUm = true;

        System.out.println("Insira um endereço ");
        while(maisUm){
            try {
                System.out.print("Digite o nome da rua: ");
                rua = sc.nextLine();
                System.out.print("Digite o nome do bairro: ");
                bairro = sc.nextLine();
                System.out.print("Digite o numero da casa: ");
                numero = sc.nextInt();
                sc.nextLine();
                System.out.print("Digite o nome da cidade: ");
                cidade = sc.nextLine();
                System.out.print("Deseja informar o CEP? ");
                resposta = sc.next();
                if (resposta.toLowerCase().equals("sim")) {
                    System.out.print("Informe o CEP ");
                    sc.nextLine();
                    cep = sc.nextLine();
                    Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                    enderecos.put(Auxiliar.autoIncrementKey(), endereco);
                } else {
                    Endereco endereco = new Endereco(rua, numero, bairro, cidade);
                    enderecos.put(Auxiliar.autoIncrementKey(), endereco);
                }
                System.out.print("Deseja informar outro endereço? ");
                resposta = sc.next();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("insira os dados corretamente.");
            }
        }
        for (Endereco e: enderecos.values()) {
            System.out.println(e.getCidade());

        }

    }

    public void adicionaFuncionario(){

        String nome, cpf, celular, resposta, cepFuncionario;
        Endereco enderecoFuncionario;
        System.out.println("Insira um Funcionário");
        boolean maisUm = true;
        while(maisUm){//nome cpf celular e Endereco

            try {


                System.out.print("Insira um nome: ");
                nome = sc.nextLine();
                System.out.print("Insira um cpf: ");
                cpf = sc.nextLine();
                System.out.print("Insira um celular: ");
                celular = sc.nextLine();
                System.out.print("Deseja cadastrar um novo Endereço? ");
                resposta = sc.nextLine();
                if(resposta.toLowerCase().equals("sim"))
                    adicionaEndereco();
                System.out.println("Deseja escolher o seu endereço pelo CEP?");
                resposta = sc.nextLine();
                if(resposta.toLowerCase().equals("sim")){
                    System.out.println("Escolha um entre os CEP's cadastrados no sistema a seguir:");
                    for (Endereco e: enderecos.values()) {
                        System.out.println(e.getCep());
                    }
                    System.out.print("Digite o CEP do funcionario: ");
                    cepFuncionario = sc.nextLine();
                    enderecos.containsValue(cepFuncionario)
                }

            } catch (InputMismatchException e){

            }
        }
    }

    public static void main(String[] args) {
    /*TODO nserir pelo menos 6 Enderecos, 2 Funcionarios, 2 Clientes, 2 Fornecedores, 10 Produtos
       •Innserir pelo menos 2 compras•Listar as Compras*/





    }
}

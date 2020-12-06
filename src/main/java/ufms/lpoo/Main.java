package ufms.lpoo;

import ufms.lpoo.models.*;
import ufms.lpoo.resources.Auxiliar;

import java.util.*;
import java.util.List;

public class Main {


    static Map<Integer, Endereco> enderecos = new HashMap<>();
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Fornecedor> fornecedores = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static List<Compra> compras = new ArrayList<>();


    public static void main(String[] args) {
        /*TODO nserir pelo menos 6 Enderecos, 2 Funcionarios, 2 Clientes, 2 Fornecedores, 10 Produtos
       •Inserir pelo menos 2 compras•Listar as Compras*/

        adicionaEndereco();
        adicionaFuncionario();
        adicionaCliente();
        adicionaFornecedor();
        adicionaProduto();
        adicionaCompra();
        listarCompras();


    }

    public static void adicionaEndereco() {
        String rua, bairro, cidade, cep, resposta;
        int numero;
        boolean maisUm = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um endereço ");
        while (maisUm) {
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
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim")) {
                    System.out.print("Informe o CEP ");
                    cep = sc.nextLine();
                    Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                    enderecos.put(Auxiliar.autoIncrementKey(), endereco);
                } else {
                    Endereco endereco = new Endereco(rua, numero, bairro, cidade);
                    enderecos.put(Auxiliar.autoIncrementKey(), endereco);
                }
                System.out.print("Deseja informar outro endereço? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
            } catch (InputMismatchException e) {
                System.out.println("insira os dados corretamente.");
            } catch (NullPointerException n) {
                System.out.println("Tente novamente");
            }
        }
        System.out.println();
    }

    public static void adicionaFuncionario() {

        String nome, cpf, celular, resposta, cepFuncionario, funcao, ruaFuncionario;
        Endereco enderecoFuncionario;
        float salario;
        System.out.println("Insira um Funcionário");
        boolean maisUm = true;
        Scanner sc = new Scanner(System.in);

        while (maisUm) {

            try {
                System.out.print("Insira um nome: ");
                nome = sc.nextLine();
                System.out.print("Insira um cpf: ");
                cpf = sc.nextLine();
                System.out.print("Insira um celular: ");
                celular = sc.nextLine();
                System.out.print("Insira a função do funcionário: ");
                funcao = sc.nextLine();
                System.out.print("Insira o salario do funcionário: ");
                salario = sc.nextFloat();
                sc.nextLine();
                System.out.print("Deseja cadastrar um novo Endereço? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim"))
                    adicionaEndereco();
                System.out.print("Deseja escolher o endereço pelo CEP? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim")) {
                    System.out.println("Escolha um entre os CEP's cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep() != null)
                            System.out.println(e.getCep());
                    }
                    System.out.print("Digite o CEP do funcionario: ");
                    cepFuncionario = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep().equals(cepFuncionario)) {
                            enderecoFuncionario = e;
                            achou = true;
                            Funcionario funcionario = new Funcionario(nome, cpf, enderecoFuncionario, celular, salario, funcao);
                            funcionarios.add(funcionario);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O Cep informado não foi encontrado. Tente novamente.");
                    }
                } else {
                    System.out.println("Escolha um entre os endereços cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        System.out.println(e.toString());
                    }
                    System.out.print("Digite o nome da rua do funcionário: ");
                    ruaFuncionario = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getRua().equals(ruaFuncionario)) {
                            enderecoFuncionario = e;
                            achou = true;
                            Funcionario funcionario = new Funcionario(nome, ruaFuncionario, enderecoFuncionario, celular, salario, funcao);
                            funcionarios.add(funcionario);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O endereço informado não foi encontrado. Tente novamente.");
                    }
                }
                System.out.print("Deseja cadastrar outro funcionário? ");
                resposta = sc.next();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("insira os dados corretamente.");
            } catch (NullPointerException n) {
                System.out.println("Tente novamente");
            }
        }
        System.out.println();
    }

    public static void adicionaCliente() {

        String nome, cpf, celular, resposta, cepCliente;
        Endereco enderecoCliente;
        boolean maisUm = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um cliente");
        while (maisUm) {
            try {
                System.out.print("Insira um nome: ");
                nome = sc.nextLine();
                System.out.print("Insira um cpf: ");
                cpf = sc.nextLine();
                System.out.print("Insira um celular: ");
                celular = sc.nextLine();
                System.out.print("Deseja cadastrar um novo Endereço? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim"))
                    adicionaEndereco();
                System.out.print("Deseja escolher o endereço pelo CEP? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim")) {
                    System.out.println("Escolha um entre os CEP's cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep() != null)
                            System.out.println(e.getCep());
                    }
                    System.out.print("Digite o CEP do cliente: ");
                    cepCliente = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep().equals(cepCliente)) {
                            enderecoCliente = e;
                            achou = true;
                            Cliente cliente = new Cliente(nome, cpf, enderecoCliente, celular);
                            clientes.add(cliente);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O Cep informado não foi encontrado. Tente novamente.");
                    }
                } else {
                    String ruaCliente;
                    System.out.println("Escolha um entre os endereços cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        System.out.println(e.toString());
                    }
                    System.out.print("Digite o nome da rua do cliente: ");
                    ruaCliente = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getRua().equals(ruaCliente)) {
                            enderecoCliente = e;
                            achou = true;
                            Cliente cliente = new Cliente(nome, cpf, enderecoCliente, celular);
                            clientes.add(cliente);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O endereço informado não foi encontrado. Tente novamente.");
                    }
                }
                System.out.print("Deseja cadastrar outro cliente? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
            } catch (InputMismatchException e) {
                System.out.println("insira os dados corretamente.");
            } catch (NullPointerException n) {
                System.out.println("Tente novamente");
            }
        }
        System.out.println();
    }

    public static void adicionaFornecedor() {
        String nomeFantasia, cnpj, celular, resposta, cepFornecedor, razaoSocial, ruaFornecedor;
        Endereco enderecoFornecedor;
        boolean maisUm = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um Fornecedor");
        while (maisUm) {
            try {
                System.out.print("Insira o nome fantasia: ");
                nomeFantasia = sc.nextLine();
                System.out.print("Insira a razao social: ");
                razaoSocial = sc.nextLine();
                System.out.print("Insira um cnpj: ");
                cnpj = sc.nextLine();
                System.out.print("Insira um celular: ");
                celular = sc.nextLine();
                System.out.print("Deseja cadastrar um novo Endereço? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim"))
                    adicionaEndereco();
                System.out.print("Deseja escolher o endereço pelo CEP? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim")) {
                    System.out.println("Escolha um entre os CEP's cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep() != null)
                            System.out.println(e.getCep());
                    }
                    System.out.print("Digite o CEP do Fornecedor: ");
                    cepFornecedor = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getCep().equals(cepFornecedor)) {
                            enderecoFornecedor = e;
                            achou = true;
                            Fornecedor fornecedor = new Fornecedor(razaoSocial, nomeFantasia, cnpj, enderecoFornecedor, celular);
                            fornecedores.add(fornecedor);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O Cep informado não foi encontrado. Tente novamente.");
                    }
                } else {
                    System.out.println("Escolha um entre os endereços cadastrados no sistema a seguir:");
                    for (Endereco e : enderecos.values()) {
                        System.out.println(e.toString());
                    }
                    System.out.print("Digite o nome da rua do Fornecedor: ");
                    ruaFornecedor = sc.nextLine();
                    boolean achou = false;
                    for (Endereco e : enderecos.values()) {
                        if (e.getRua().equals(ruaFornecedor)) {
                            enderecoFornecedor = e;
                            achou = true;
                            Fornecedor fornecedor = new Fornecedor(razaoSocial, nomeFantasia, cnpj, enderecoFornecedor, celular);
                            fornecedores.add(fornecedor);
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O endereço informado não foi encontrado. Tente novamente.");
                    }
                }
                System.out.print("Deseja cadastrar outro Fornecedor? ");
                resposta = sc.next();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("insira os dados corretamente.");
            } catch (NullPointerException n) {
                System.out.println("Tente novamente");
            }
        }
        System.out.println();
    }

    public static void adicionaProduto() {
        //String nomeProduto, float valor, Fornecedor empresa
        String nomeProduto, resposta, cnpjFornecedor;
        float valorProduto;
        Fornecedor fornecedorProduto;
        boolean maisUm = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um produto");
        while (maisUm) {
            try {
                System.out.print("Insira o nome do produto: ");
                nomeProduto = sc.nextLine();
                System.out.print("Insira o valor do produto: ");
                valorProduto = sc.nextFloat();
                sc.nextLine();
                System.out.print("Deseja cadastrar um novo Fornecedor? ");
                resposta = sc.nextLine();
                if (resposta.toLowerCase().equals("sim"))
                    adicionaFornecedor();

                System.out.println("Escolha um entre os CNPJ's cadastrados no sistema a seguir:");
                for (Fornecedor f : fornecedores) {
                    System.out.println(f.getCnpj());
                }
                System.out.print("Digite o CNPJ do Fornecedor: ");
                cnpjFornecedor = sc.nextLine();
                boolean achou = false;
                for (Fornecedor f : fornecedores) {
                    if (f.getCnpj().equals(cnpjFornecedor)) {
                        fornecedorProduto = f;
                        achou = true;
                        Produto produto = new Produto(nomeProduto, valorProduto, fornecedorProduto);
                        produtos.add(produto);
                        break;
                    }
                }
                if (!achou) {
                    System.out.println("O CNPJ informado não foi encontrado. Tente novamente.");
                }

                System.out.print("Deseja cadastrar outro Produto? ");
                resposta = sc.next();
                if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao"))
                    maisUm = false;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("insira os dados corretamente.");
            } catch (NullPointerException n) {
                System.out.println("Tente novamente");
            }
        }
        System.out.println();
    }

    public static void adicionaCompra() {
        Scanner sc = new Scanner(System.in);
        String nomeCliente, nomeFuncionario, nomeProduto, resposta;
        Cliente clienteCompra = null;
        Funcionario funcionarioVenda = null;
        boolean maisUmProduto = true;

        System.out.println("Adicione uma compra");

        try {
            System.out.println("Escolha o cliente através da lista a seguir:");
            System.out.println(clientes.toString());
            System.out.print("Digite o nome do cliente da compra: ");
            nomeCliente = sc.nextLine();
            boolean achouFuncionario = false;
            boolean achouCliente = false;
            for (Cliente c : clientes) {
                if (c.getNome().equals(nomeCliente)) {
                    achouCliente = true;
                    clienteCompra = new Cliente(c);
                }
            }
            if (!(achouCliente)) {
                System.out.println("O cliente informado não foi encontrado. tente novamente.");
                throw new InputMismatchException();
            }

            System.out.println("Escolha o funcionário através da lista a seguir:");
            System.out.println(funcionarios.toString());
            System.out.print("Digite o nome do funcionário que realizou a venda: ");
            nomeFuncionario = sc.nextLine();
            for (Funcionario f : funcionarios) {
                if (f.getNome().equals(nomeFuncionario)) {
                    achouFuncionario = true;
                    funcionarioVenda = new Funcionario(f);
                }
            }
            if (!(achouFuncionario)) {
                System.out.println("O funcionário informado não foi encontrado. tente novamente.");
                throw new InputMismatchException();
            }
            if (achouCliente && achouFuncionario) {
                Compra compra = new Compra(funcionarioVenda, clienteCompra);
                System.out.println("Escolha os produtos da compra através dos produtos cadastrados");
                for (Produto p : produtos) {
                    System.out.println(p.toString());
                }
                while (maisUmProduto) {

                    System.out.println("Qual o nome do produto que você deseja adicionar a compra?");
                    nomeProduto = sc.nextLine();
                    boolean achou = false;
                    for (Produto prod : produtos) {
                        if (prod.getNomeProduto().toLowerCase().equals(nomeProduto.toLowerCase())) {
                            compra.adicionarProduto(prod);
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println("O produto informado não foi encontrado.");
                    }
                    System.out.println("Deseja adicionar mais um produto?");
                    resposta = sc.nextLine();
                    if ((resposta.toLowerCase().equals("nao")) || (resposta.toLowerCase().equals("não"))) {
                        maisUmProduto = false;
                        compras.add(compra);
                    }
                }
            }


        } catch (InputMismatchException e) {
            System.out.println("insira os dados corretamente.");

        } finally {
            System.out.print("Deseja adicionar outra compra? ");
            resposta = sc.nextLine();
            if (resposta.toLowerCase().equals("sim")) {
                adicionaCompra();
            }
        }

        System.out.println();
    }

    public static void listarCompras() {
        for (Compra c : compras) {
            c.listarCompra();
            System.out.println();
        }
        System.out.println();
    }

}

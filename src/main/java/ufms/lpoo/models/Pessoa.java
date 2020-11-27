package ufms.lpoo.models;

import ufms.lpoo.interfaces.verificavel;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa implements verificavel {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private String celular;

    public Pessoa(String nome, String cpf, Endereco endereco, String celular) {
        this.nome = nome;
        if(validar(cpf))
            this.cpf = cpf;
         else
            solicitarNovo();

        this.endereco = endereco;
        this.celular = celular;
    }

    @Override
    public boolean validar(String cpf) {

        String parsedCPF = cpf.replaceAll("-|\\.","");
        System.out.println("cpf sem caracteres: "+parsedCPF);

        if (parsedCPF.equals("00000000000") ||
                parsedCPF.equals("11111111111") ||
                parsedCPF.equals("22222222222") || parsedCPF.equals("33333333333") ||
                parsedCPF.equals("44444444444") || parsedCPF.equals("55555555555") ||
                parsedCPF.equals("66666666666") || parsedCPF.equals("77777777777") ||
                parsedCPF.equals("88888888888") || parsedCPF.equals("99999999999") ||
                (parsedCPF.length() != 11))
            return false;

        char dig10, dig11;
        int soma, i, resultado, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(parsedCPF.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))//se o resto da divisão (operador %) calculado for 10 ou 11, o dígito verificador será 0;// nos outros casos, o dígito verificador é o próprio resto.
                dig10 = '0';
            else dig10 = (char)(resultado + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(parsedCPF.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))
                dig11 = '0';
            else dig11 = (char)(resultado + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == parsedCPF.charAt(9)) && (dig11 == parsedCPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    @Override
    public void solicitarNovo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("O CPF informado é inválido. Informe um novo CPF.");

        try {
            String cpfNovo = sc.nextLine();
            if(validar(cpfNovo))
                this.cpf = cpfNovo;
            else
                solicitarNovo();
        } catch (InputMismatchException e){
            System.out.print("Você deve inserir um CPF no formato ###.###.###-## onde # são os números.");
            solicitarNovo();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}

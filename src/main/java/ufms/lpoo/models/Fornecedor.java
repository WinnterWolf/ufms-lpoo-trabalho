package ufms.lpoo.models;

import ufms.lpoo.interfaces.verificavel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fornecedor implements verificavel {


    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;
    private String celular;

    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;

        if(validar(cnpj))
            this.cnpj = cnpj;
        else
            solicitarNovo();

        this.endereco = endereco;
        this.celular = celular;
    }

    @Override
    public boolean validar(String cnpj) {
        String parsedCNPJ = cnpj.replaceAll("-|\\.|\\/","");
        System.out.println("cnpj sem caracteres: "+parsedCNPJ);

        if (parsedCNPJ.equals("00000000000000") || parsedCNPJ.equals("11111111111111") ||
                parsedCNPJ.equals("22222222222222") || parsedCNPJ.equals("33333333333333") ||
                parsedCNPJ.equals("44444444444444") || parsedCNPJ.equals("55555555555555") ||
                parsedCNPJ.equals("66666666666666") || parsedCNPJ.equals("77777777777777") ||
                parsedCNPJ.equals("88888888888888") || parsedCNPJ.equals("99999999999999") ||
                (parsedCNPJ.length() != 14))
            return(false);

        char dig13, dig14;
        int soma, i, resultado, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int)(parsedCNPJ.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            resultado = soma % 11;
            if ((resultado == 0) || (resultado == 1))
                dig13 = '0';
            else dig13 = (char)((11-resultado) + 48);

// Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(parsedCNPJ.charAt(i)- 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            resultado = soma % 11;
            if ((resultado == 0) || (resultado == 1))
                dig14 = '0';
            else dig14 = (char)((11-resultado) + 48);

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == parsedCNPJ.charAt(12)) && (dig14 == parsedCNPJ.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            System.out.println(erro);
            return(false);
        }
    }

    @Override
    public void solicitarNovo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("O CNPJ informado é inválido. Informe um novo CNPJ.");

        try {
            String cnpjNovo = sc.nextLine();

            if(validar(cnpjNovo))
                this.cnpj = cnpjNovo;
            else
                solicitarNovo();
        }catch (InputMismatchException e){
            System.out.println("Você deve inserir um CNPJ no formato ##.###.###/####-## onde # são os números.");
            solicitarNovo();
        }


    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

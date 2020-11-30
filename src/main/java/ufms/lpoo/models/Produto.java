package ufms.lpoo.models;

import java.awt.*;

public class Produto implements Comparable<Produto>{

    private String nomeProduto;
    private float valor;
    private Fornecedor empresa;

    public Produto(String nomeProduto, float valor, Fornecedor empresa) {

        try{
            this.nomeProduto = nomeProduto;
            this.valor = valor;
            this.empresa = empresa;
        } catch (Exception e){
            System.out.print(e);
        }

    }


    @Override
    public int compareTo(Produto o) {
        return this.getNomeProduto().compareTo(o.getNomeProduto());
    }

    @Override
    public String toString() {
        return
                "nomeProduto= " + nomeProduto + '\'' +
                ", valor= " + valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Fornecedor getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Fornecedor empresa) {
        this.empresa = empresa;
    }


}

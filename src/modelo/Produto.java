package modelo;

import utils.Utils;

public class Produto {
    // Coloquei um contador para que toda vez que adicionarem um produto o número do contador aumenta
    private static int count = 0;

    // Atributos do prooduto
    private int id;
    private String nome;
    private double preco;

    // MÉTODO CONSTRUTOR - ID não precisa pois irá conter o número do contador.
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.id = count;
        count++; // A PARTIR DO PRIMEIRO PRODUTO CRIADO SEMPRE SERÁ ACRESCENTADO +1 AO PROXIMO ID.
    }

    // MÉTODOS GET E SETT

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void setCount(int count) {
        Produto.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Produto: " + this.getNome() + "     ID: " + this.getId() +
                "\n|Preço: " + Utils.doubleString(this.getPreco());
    }
}

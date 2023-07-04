package main;

import modelo.Produto;
import screen.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;
    private static boolean isOnline; // VALOR PADRÃO = FALSE;

    //GET E SETT DAS UTILITARIAS GLOBAIS
    public static Scanner getInput() {
        return input;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(ArrayList<Produto> produtos) {
        Mercado.produtos = produtos;
    }

    public static Map<Produto, Integer> getCarrinho() {
        return carrinho;
    }

    public static boolean isIsOnline() {
        return isOnline;
    }

    public static void setIsOnline(boolean isOnline) {
        Mercado.isOnline = isOnline;
    }

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();

        // PRODUTOS JÁ EXISTENTES NO MERCADO
        Produto arroz = new Produto("Arroz", 10);
        produtos.add(arroz);

        Produto feijao = new Produto("Feijão", 10);
        produtos.add(feijao);

        Produto batata = new Produto("Batata", 8);
        produtos.add(batata);
        Produto boi = new Produto("Bife de boi", 15);
        produtos.add(boi);
        // PARA INICIAR O PROJETO! =)
        ScreenMenu.menu();
    }

}
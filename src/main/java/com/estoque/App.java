package com.estoque;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] table = new String[10][4];
        int option;
        while (true) {
            System.out.println("--- Bem-vindo ao Sistema ---");
            System.out.println("Escolha uma das opções a seguir para continuar:");
            System.out.print("1. Adicionar Produto.");
            System.out.print("2. Excluir Produto.");
            System.out.print("3. Vender Produtos.");
            System.out.print("4. Imprimir Produtos.");
            System.out.print("5. Sair.");
            option = scanner.nextInt();
            if (option == 5) {
                System.out.println("Saindo do sistema. Ate a proxima!");
                break;
            }
            switch (option) {
                case 1:
                    System.out.print("Insira o codigo do produto: ");
                    String code = scanner.nextLine();
                    System.out.print("Insira o nome do produto: ");
                    String product = scanner.nextLine();
                    System.out.print("Insira a quantidade do estoque: ");
                    int quanProduct = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Insira o preço: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    int status = addProduct(table, code, product, quanProduct, price);
                    printMessag("CADASTRAR", status);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    break;
            }
        }
    }

    static int addProduct(String[][] table, String code, String product, int quanProduct, int price) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] != null && table[i][0].equals(code)) {
                return (0);
            }
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == null) {
                table[i][0] = code;
                table[i][1] = product;
                table[i][2] = String.valueOf(quanProduct);
                table[i][3] = String.valueOf(price);
                return (1);
            }
        }
        return (-1);
    }

    static int deleteProduct(String[][] table, String code) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] != null && table[i][0].equals(code)) {
                table[i][0] = null;
                table[i][1] = null;
                table[i][2] = null;
                table[i][3] = null;
                return (1);
            }
        }
        return (-1);
    }

    static int sellProduct(String[][] table, String code, int quanProduct) {

    }

    static void printMessage(String type, int status) {
        switch (type) {
            case "CADASTRAR":
                if (status == 0)
                    System.out.println("Produto ja cadastrado!");
                else if (status == 1)
                    System.out.println("Produto cadastrado com sucesso!");
                else if (status == -1)
                    System.out.println("Não é possível adicionar mais produtos, memória cheia!");
                break;
            case "EXCLUIR":
                if (status == 1)
                    System.out.println("Produto excluido com sucesso!");
                else if (status == -1)
                    System.out.println("Produto nao cadastrado!");
                break;
            case "VENDER":

                break;
            default:
                break;
        }
    }
}

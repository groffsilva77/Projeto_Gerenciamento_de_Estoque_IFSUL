package com.estoque;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] table = new String[10][4];
        int option;
        while (true) {
            System.out.println("--- Bem-vindo ao Sistema ---");
            System.out.println("1. Adicionar Produto.");
            System.out.println("2. Excluir Produto.");
            System.out.println("3. Vender Produtos.");
            System.out.println("4. Imprimir Produtos.");
            System.out.println("5. Sair.");
            System.out.print("Escolha uma das opções acima para continuar: ");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 5) {
                System.out.println("Saindo do sistema. Ate a proxima!");
                break;
            }
            switch (option) {
                case 1:
                    System.out.print("Codigo: ");
                    String code = scanner.nextLine();
                    int itExists = -2;
                    for (int i = 0; i < table.length; i++) {
                        if (table[i][0] != null && code.equals(table[i][0])) {
                            itExists = 0;
                            break;
                        }
                    }
                    if (itExists == 0) {
                        printMessage("CADASTRAR", itExists);
                        break;
                    }
                    System.out.print("Produto: ");
                    String product = scanner.nextLine();

                    System.out.print("Insira a quantidade do estoque: ");
                    int quanProduct = scanner.nextInt();
                    System.out.print("Insira o preço: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    int status = addProduct(table, code, product, quanProduct, price);
                    printMessage("CADASTRAR", status);
                    break;
                case 2:
                    System.out.print("Insira o codigo do produto a ser excluido: ");
                    code = scanner.nextLine();
                    status = deleteProduct(table, code);
                    printMessage("EXCLUIR", status);
                    break;
                case 3:
                    System.out.print("Insira o codigo do produto: ");
                    code = scanner.nextLine();
                    System.out.print("Insira a quantidade a ser vendida: ");
                    quanProduct = scanner.nextInt();
                    scanner.nextLine();
                    status = sellProduct(table, code, quanProduct);
                    printMessage("VENDER", status);
                    break;
                case 4:
                    printTable(table);
                    break;
                default:
                    break;
            }
        }
    }

    static int addProduct(String[][] table, String code, String product, int quanProduct, int price) {
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
        if (quanProduct <= 0)
            return (2);
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] != null && table[i][0].equals(code)) {
                int currentStock = Integer.parseInt(table[i][2]);
                if (currentStock < quanProduct)
                    return (3);
                int newStock = currentStock - quanProduct;
                table[i][2] = String.valueOf(newStock);
                return (0);
            }
        }
        return (1);
    }

    static void printTable(String[][] table) {
        System.out.printf("%-8s %-25s %-12s %-8s\n", "Codigo", "Produto", "Quantidade", "Preço");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-8s %-25s %-12s %-8s\n", table[i][0], table[i][1], table[i][2], table[i][3]);
        }
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
                if (status == 0)
                    System.out.println("Venda realizada com sucesso!");
                else if (status == 1)
                    System.out.println("Produto não cadastrado!");
                else if (status == 2)
                    System.out.println("Quantidade inválida!");
                else if (status == 3)
                    System.out.println("Estoque insuficiente!");
                break;
            default:
                break;
        }
    }
}

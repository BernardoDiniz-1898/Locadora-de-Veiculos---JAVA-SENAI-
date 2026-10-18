package br.com.senai.concessionaria.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine();
        return valor == null ? "" : valor.trim();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String linha = scanner.nextLine().trim();
                if (linha.isEmpty()) {
                    continue;
                }
                return Integer.parseInt(linha);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("\nValor inválido! Digite um número inteiro.\n");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String linha = scanner.nextLine().trim();
                if (linha.isEmpty()) {
                    continue;
                }
                return Double.parseDouble(linha.replace(",", "."));
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("\nValor inválido! Digite um número decimal.\n");
            }
        }
    }

    public static void pressionarEnter() {
        System.out.println("\nPressione Enter para continuar...");
        System.out.print("==> ");
        scanner.nextLine();
    }

    public static void fechar() {
        scanner.close();
    }
}

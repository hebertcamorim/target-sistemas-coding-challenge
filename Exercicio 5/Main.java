//A escolha da linguagem foi JAVA

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar um Scanner para leitura de dados
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar a entrada do usuário
        System.out.print("Digite a String: ");
        String palavra = scanner.nextLine();
        
        // Inverter a palavra manualmente
        String palavraInvertida = "";
        
        // Loop para inverter a string
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        
        // Exibir a palavra invertida
        System.out.println("String original: " + palavra);
        System.out.println("String invertida: " + palavraInvertida);
        
        // Fechar o Scanner
        scanner.close();
    }
}
//A escolha da linguagem foi JAVA

import java.util.Scanner;
public class Main {
  public static void main(String[] args) {    
    int a = 0, b = 1, nextNumber;
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite um número: ");
    int num = scanner.nextInt();
  
    boolean checkFibonacci = (num == a || num == b);
  
    while (b < num) {
      nextNumber = a + b;
      a = b;
      b = nextNumber;
      checkFibonacci = checkFibonacci || (b == num);
    }
    System.out.print(checkFibonacci ? String.format("O número %d faz parte da sequência de Fibonacci.", num) :
    String.format("O número %d não faz parte da sequência de Fibonacci.", num));
    scanner.close();
  }
}
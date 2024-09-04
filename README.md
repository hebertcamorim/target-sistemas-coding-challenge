# DESAFIO TARGET SISTEMAS

## Sumário
- [Exercício 1](#1-valor-da-variável-soma)
- [Exercício 2](#2-determinando-se-um-número-pertence-à-sequência-de-fibonacci)
- [Exercício 3](#3-cálculo-faturamento-diário-de-uma-distribuidora)
- [Exercício 4](#4-faturamento-mensal-de-uma-distribuidora)
- [Exercício 5](#5-escreva-um-programa-que-inverta-os-caracteres-de-um-string)
  
# Descrição
<div align="justify">
Este repositório contém soluções para cinco problemas de programação, abordando conceitos básicos como loops, sequência de Fibonacci, análise de dados e manipulação de strings. Os problemas são resolvidos utilizando diferentes linguagens de programação. A seguir estão as descrições e os requisitos de cada problema:
</div>

## 1. Valor da variável soma

Dado o trecho de código abaixo:
```
int INDICE = 13, SOMA = 0, K = 0;
Enquanto K < INDICE faça {
  K = K + 1;
  SOMA = SOMA + K;
}
Imprimir(SOMA);
```

Ao final do processamento, qual será o valor da variável SOMA?


```java
//A escolha da linguagem foi JAVA

public class Main {
    public static void main(String[] args) {
      int indice = 13, soma = 0, k = 0;
      while(k < indice) {
        k++;
        soma+= + k;
      }
      System.out.print(soma);
  }
}
```

O resultado da saída do processamento da __soma é 91.__

- [Exercício 1](#1-valor-da-variável-soma) - [Exercício 2](#2-determinando-se-um-número-pertence-à-sequência-de-fibonacci) - [Exercício 3](#3-cálculo-faturamento-diário-de-uma-distribuidora) - [Exercício 4](#4-faturamento-mensal-de-uma-distribuidora) - [Exercício 5](#5-escreva-um-programa-que-inverta-os-caracteres-de-um-string)

## 2. Determinando se um número pertence à sequência de Fibonacci

<div align="justify">
  Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar
  onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
  
  <b>IMPORTANTE:</b> Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
</div>

Partindo da premissa de que a equação geral utilizada é a fórmula recursiva da sequência de Fibonacci: __𝐹(𝑛)=𝐹(𝑛−1)+𝐹(𝑛−2)__

__a__ e __b__ são os dois primeiros números da sequência de Fibonacci (0 e 1).

__nextNumber__ será usado para armazenar o próximo número na sequência.

```java

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
```
## 3) Cálculo faturamento diário de uma distribuidora

<div align="justify">
  Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
 
  • O menor valor de faturamento ocorrido em um dia do mês;
 
  • O maior valor de faturamento ocorrido em um dia do mês;
 
  • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

  <b>IMPORTANTE:</b>

  a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;

  b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
</div>

```python

import json

"""
------------------------------------------------------------------------
A linguagem escolhida foi PYTHON, devido à sua capacidade de automação
e à utilização da biblioteca JSON para o tratamento dos dados.
  Para melhor entendimento, foi utilizado o padrão camel case.
------------------------------------------------------------------------
"""

"""
------------------------------------------------------------------------
Função loadDataJson: Carrega os dados do arquivo JSON.
------------------------------------------------------------------------
"""
def loadDataJson(pathToFile):
    with open(pathToFile, 'r') as file:
        return json.load(file)

"""
------------------------------------------------------------------------
Função calculateRevenue: Calcula estatísticas do faturamento.
------------------------------------------------------------------------
"""
def calculateRevenue(data):
    dailyRevenue = [item['valor'] for item in data if item['valor'] > 0]

    if len(dailyRevenue) == 0:
        return print("Não há dados no arquivo JSON.")
        
    lowestRevenue = min(dailyRevenue)
    highestRevenue = max(dailyRevenue)
    monthlyAverage = sum(dailyRevenue) / len(dailyRevenue)
    daysAboveAverage = sum(revenue > monthlyAverage for revenue in dailyRevenue)


    """
    ------------------------------------------------------------------------
    Função formatCurrency: Exibe os valores em milha e decimal.
    ------------------------------------------------------------------------
    """
    def formatCurrency(value):
        formattedValue = f"{value:,.2f}".replace(',', 'X').replace('.', ',').replace('X', '.')
        return f"R$ {formattedValue}"

    print(f"O menor valor de faturamento corresponde a {formatCurrency(lowestRevenue)}")
    print(f"O maior valor de faturamento corresponde a {formatCurrency(highestRevenue)}")
    print(f"O número de dias com faturamento superior à média corresponde a {daysAboveAverage} dias")

# Caminho e/ou nome do arquivo JSON
pathToFile = 'dados.json'

# Carregar os dados e calcular o faturamento
data = loadDataJson(pathToFile)
calculateRevenue(data)
```

O menor valor de faturamento corresponde a __R$ 373,78__

O maior valor de faturamento corresponde a __R$ 48.924,24__

Número de dias com faturamento superior à média corresponde a __10 dias__

## 4) Faturamento mensal de uma distribuidora

<div align="justify">
  
  Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

  • SP – R$67.836,43
 
  • RJ – R$36.678,66

  • MG – R$29.229,88

  • ES – R$27.165,48

  • Outros – R$19.849,53

  Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  
</div>

```java
//A escolha da linguagem foi JAVA

public class Main {

    // Função calculatePercentage: Calcula o percentual
    public static double calculatePercentage(double value, double totalRevenue) {
        if (totalRevenue == 0) {
            return 0;
        }
        return (value / totalRevenue) * 100;
    }

    // Função displayPercentage: Exibe o percentual formatado
    public static void displayPercentage(String state, double percentage) {
        System.out.printf("%s: %.2f%%\n", state, percentage);
    }

    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        // Cálculo do faturamento total
        double totalRevenue = sp + rj + mg + es + outros;

        // Cálculo e exibição dos percentuais
        displayPercentage("SP", calculatePercentage(sp, totalRevenue));
        displayPercentage("RJ", calculatePercentage(rj, totalRevenue));
        displayPercentage("MG", calculatePercentage(mg, totalRevenue));
        displayPercentage("ES", calculatePercentage(es, totalRevenue));
        displayPercentage("Outros", calculatePercentage(outros, totalRevenue));
    }
}
```
O percentual de faturamento para o estado de SP corresponde a __37.53%__

O percentual de faturamento para o estado de RJ corresponde a __20.29%__

O percentual de faturamento para o estado de MG corresponde a __16.17%__

O percentual de faturamento para o estado de ES corresponde a __15.03%__

O percentual de faturamento para Outros estados corresponde a __10.98%__


## 5) Escreva um programa que inverta os caracteres de um string.
<div align="justify">
 
  Escreva um programa que inverta os caracteres de um string.
  
  <b>IMPORTANTE:</b>
  
  a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
  
  b) Evite usar funções prontas, como, por exemplo, reverse;

```java
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
```
Caso seja inserida a frase __'Target Sistemas',__ a frase invertida será __'sametsiS tegraT'.__

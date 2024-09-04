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
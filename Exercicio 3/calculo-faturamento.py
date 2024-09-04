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
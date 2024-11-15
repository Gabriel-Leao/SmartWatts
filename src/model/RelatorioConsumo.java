package model;

public class RelatorioConsumo {
    private Equipamento equipamento;
    private double consumoMensal;

    public RelatorioConsumo(Equipamento equipamento) {
        this.equipamento = equipamento;
        this.consumoMensal = equipamento.calcularConsumo(30);
    }

    public String obterEstrategiaEconomia() {
        if (consumoMensal > 100) {
            return "Consumo alto. Considere reduzir o tempo de uso diário.";
        } else if (consumoMensal > 50) {
            return "Consumo moderado. Verifique modos de baixo consumo para este equipamento.";
        } else {
            return "Consumo baixo. Seu uso está eficiente.";
        }
    }

    @Override
    public String toString() {
        return "Equipamento: " + equipamento.getNome() + "\nConsumo Mensal: " + consumoMensal + " kWh\nEstratégia: " + obterEstrategiaEconomia();
    }
}

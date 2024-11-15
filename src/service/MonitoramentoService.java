package service;

import model.Equipamento;

public class MonitoramentoService {
    public double calcularConsumoTotal(Equipamento[] equipamentos) {
        double total = 0;
        for (Equipamento e : equipamentos) {
            total += e.calcularConsumo(30);
        }
        return total;
    }

    public String recomendarReducaoConsumo(double consumoTotal) {
        if (consumoTotal > 500) {
            return "Consumo total elevado. Considere revisar o tempo de uso dos equipamentos.";
        } else if (consumoTotal > 200) {
            return "Consumo moderado. Avalie modos de baixo consumo.";
        } else {
            return "Consumo dentro do esperado. Continue monitorando para ajustes.";
        }
    }
}

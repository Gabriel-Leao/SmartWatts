package utils;

import model.Equipamento;

public class GraficoConsumo {
    public static void gerarGraficoConsumo(Equipamento[] equipamentos) {
        System.out.println("Gráfico de Consumo:");
        for (Equipamento e : equipamentos) {
            System.out.println(e.getNome() + ": " + e.calcularConsumo(30) + " kWh");
        }
    }
}

package model;

public class Equipamento {
    private String nome;
    private double potenciaWatts;
    private double horasDiarias;

    public Equipamento(String nome, double potenciaWatts, double horasDiarias) {
        this.nome = nome;
        this.potenciaWatts = potenciaWatts;
        this.horasDiarias = horasDiarias;
    }

    public double calcularConsumoDiario() {
        return (potenciaWatts / 1000) * horasDiarias;
    }

    public double calcularConsumo(double dias) {
        return calcularConsumoDiario() * dias;
    }

    public String getNome() { return nome; }
}

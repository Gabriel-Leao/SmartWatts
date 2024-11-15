import model.Equipamento;
import model.RelatorioConsumo;
import service.MonitoramentoService;
import utils.GraficoConsumo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade = 0;
        while (true) {
            System.out.print("Quantos equipamentos deseja monitorar? ");
            if (scanner.hasNextInt()) {
                quantidade = Integer.parseInt(scanner.nextLine());
                break;
            } else {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }

        Equipamento[] equipamentos = new Equipamento[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nome do equipamento " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            double potencia = 0;
            while (true) {
                System.out.print("Potência (em watts): ");
                if (scanner.hasNextDouble()) {
                    potencia = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número válido para a potência.");
                    scanner.nextLine();
                }
            }

            double horasUsoDiario = 0;
            while (true) {
                System.out.print("Horas de uso diário: ");
                if (scanner.hasNextDouble()) {
                    horasUsoDiario = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número válido para as horas de uso diário.");
                    scanner.nextLine();
                }
            }

            equipamentos[i] = new Equipamento(nome, potencia, horasUsoDiario);
        }
        scanner.close();

        System.out.println("\nRelatórios de Consumo:");
        for (Equipamento equipamento : equipamentos) {
            RelatorioConsumo relatorio = new RelatorioConsumo(equipamento);
            System.out.println(relatorio);
        }

        MonitoramentoService monitoramentoService = new MonitoramentoService();
        double consumoTotal = monitoramentoService.calcularConsumoTotal(equipamentos);
        System.out.println("\nConsumo Total Mensal: " + consumoTotal + " kWh");
        System.out.println(monitoramentoService.recomendarReducaoConsumo(consumoTotal));

        GraficoConsumo.gerarGraficoConsumo(equipamentos);
    }
}

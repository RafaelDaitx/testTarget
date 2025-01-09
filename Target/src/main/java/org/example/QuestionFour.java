package org.example;
import java.util.HashMap;
import java.util.Map;

public class QuestionFour {
    public static void main(String[] args) {
        Map<String, Double> faturamento = new HashMap<>();
        faturamento.put("SP", 67836.43);
        faturamento.put("RJ", 36678.66);
        faturamento.put("MG", 29229.88);
        faturamento.put("ES", 27165.48);
        faturamento.put("Outros", 19849.53);

        double faturamentoTotal = faturamento.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Percentual de representação por estado:");

        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            String estado = entry.getKey();
            double valor = entry.getValue();
            double percentual = (valor / faturamentoTotal) * 100;
            System.out.printf("Estado " + estado + " tem o percentual de " + String.format("%.2f", percentual) + "%%. \n");
        }
    }
}

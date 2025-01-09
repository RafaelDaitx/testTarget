package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.List;

//Obs: não considerei feriados pois não sei se há no mês, isso poderia ficar, pensando
//na esteira do desenvolvimento, como a ser desenvolvido posteriormente.

public class QuestionThree {

    static class Dia {
        public int dia;
        public double valor;
    }

    public static void main(String[] args) {
        try {
            List<Dia> faturamento = carregarFaturamento("C:\\Rafael\\ProjectsLife\\RocketSeat\\Target\\src\\main\\java\\org\\example\\dados.json");
            exibirResultados(calcularEstatisticas(faturamento));
        } catch (Exception e) {
            tratarErro(e);
        }
    }

    private static List<Dia> carregarFaturamento(String caminhoArquivo) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(caminhoArquivo).toFile(), new TypeReference<>() {
        });
    }

    private static ValoresDosDados calcularEstatisticas(List<Dia> faturamento) {
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double somaValores = 0;
        int diasValidos = 0;

        for (Dia dia : faturamento) {
            if (dia.valor > 0) {
                menorValor = Math.min(menorValor, dia.valor);
                maiorValor = Math.max(maiorValor, dia.valor);
                somaValores += dia.valor;
                diasValidos++;
            }
        }

        double mediaMensal = diasValidos > 0 ? somaValores / diasValidos : 0;
        int diasAcimaMedia = contarDiasAcimaMedia(faturamento, mediaMensal);

        return new ValoresDosDados(menorValor, maiorValor, diasAcimaMedia);
    }

    private static int contarDiasAcimaMedia(List<Dia> faturamento, double mediaMensal) {
        return (int) faturamento.stream()
                .filter(dia -> dia.valor > mediaMensal)
                .count();
    }

    private static void exibirResultados(ValoresDosDados valoresDosDados) {
        System.out.printf("Menor valor de faturamento: R$ " + String.format("%.2f", valoresDosDados.menorValor));
        System.out.printf("\nMaior valor de faturamento: R$ " + String.format("%.2f", valoresDosDados.maiorValor));
        System.out.printf("\nDias com faturamento acima da média: " + valoresDosDados.diasAcimaMedia);
    }

    private static void tratarErro(Exception e) {
        System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
    }

    private static class ValoresDosDados {
        final double menorValor;
        final double maiorValor;
        final int diasAcimaMedia;

        ValoresDosDados(double menorValor, double maiorValor, int diasAcimaMedia) {
            this.menorValor = menorValor;
            this.maiorValor = maiorValor;
            this.diasAcimaMedia = diasAcimaMedia;
        }
    }
}

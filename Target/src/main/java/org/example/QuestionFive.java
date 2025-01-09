package org.example;
import java.util.Scanner;
public class QuestionFive {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra ou frase para inverter: ");
        String textoOriginal = entrada.nextLine();

        String textoInvertido = inverterTexto(textoOriginal);

        System.out.println("Texto invertido: " + textoInvertido);
    }

    public static String inverterTexto(String texto) {
        StringBuilder textoInvertido = new StringBuilder();

        for (int i = texto.length() - 1; i >= 0; i--) {
            textoInvertido.append(texto.charAt(i));
        }
        return textoInvertido.toString();
    }
}
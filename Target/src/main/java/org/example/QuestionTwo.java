package org.example;

import java.util.Scanner;

public class QuestionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int penultimoNumero = 0, ultimoNumero = 1, numeroFibonacci = 0;

        System.out.print("Informe um número: ");
        int numeroRecebido = scanner.nextInt();

        while (numeroFibonacci < numeroRecebido) {
            numeroFibonacci = penultimoNumero + ultimoNumero;
            penultimoNumero = ultimoNumero;
            ultimoNumero = numeroFibonacci;
            System.out.println(numeroFibonacci);
        }
        if(numeroRecebido == 0 || numeroRecebido == 1 || numeroFibonacci == numeroRecebido) {
            System.out.println("O número " + numeroRecebido + " faz parte da sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numeroRecebido + " não faz parte da sequência de Fibonacci.");
        }
    }
}

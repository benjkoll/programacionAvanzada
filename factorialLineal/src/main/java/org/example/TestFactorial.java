package org.example;
import java.math.BigInteger;
public class TestFactorial {

    public static void main(String[] args) {
        int numero = 10;

        for (int i = 0; i < 10000; i++) {
            FactorialIterativo.calcular(numero);
            FactorialRecursivo.calcular(numero);
        }
        long inicio;
        long fin;
        inicio = System.nanoTime();
        BigInteger resultadoIterativo = FactorialIterativo.calcular(numero);
        fin = System.nanoTime();
        System.out.println("Factorial iterativo calculado.");
        System.out.println("Tiempo iterativo: " + (fin - inicio) / 1_000_000.0 + " milisegundos\n");
        inicio = System.nanoTime();
        BigInteger resultadoRecursivo = FactorialRecursivo.calcular(numero);
        fin = System.nanoTime();
        System.out.println("Factorial recursivo calculado.");
        System.out.println("Tiempo recursivo: " + (fin - inicio) / 1_000_000.0 + " milisegundos");
    }
}

class FactorialIterativo {
    public static BigInteger calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }
}
class FactorialRecursivo {
    public static BigInteger calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(calcular(n - 1));
    }
}
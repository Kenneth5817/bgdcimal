package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.StandardSocketOptions;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        int años = 30;
        int totalPagos = años * 12;
        BigDecimal principal = new BigDecimal("20000"); // Monto del préstamo
        BigDecimal tasaInteresAnual = new BigDecimal("0.05"); // Tasa de interés anual del 5%

        // Pasamos la tasa de interés anual a tasa mensual
        BigDecimal tasaInteresXMes = tasaInteresAnual.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);

        // Calculamos el pago mensual (PMT) con la fórmula
        BigDecimal pmt = calcularPagoMensual(principal, tasaInteresXMes, totalPagos);

        BigDecimal saldoPendiente = principal;

        // Mostramos el pago mensual (PMT)
        System.out.println("Préstamo: "+ saldoPendiente+"€");
        System.out.println("Tasa de interés anual: "+tasaInteresAnual+"%");
        System.out.println("Pago mensual (PMT): " + pmt +"€");
        System.out.println("Esquema de amortización:");
        System.out.println("------------------------");
        System.out.println( "Mes\tPago\tPrincipal\t Interés\tBalance");

        // Bucle para calcular los pagos mes a mes
        for (int mes = 1; mes <= totalPagos; mes++) {
            // Calculamos el pago de interés para el mes
            BigDecimal interesMes = saldoPendiente.multiply(tasaInteresXMes).setScale(10, RoundingMode.HALF_EVEN);

            // Calculamos el pago de principal
            BigDecimal pagoPrincipal = pmt.subtract(interesMes).setScale(10, RoundingMode.HALF_EVEN);

            // Reducimos el saldo pendiente
            saldoPendiente = saldoPendiente.subtract(pagoPrincipal).setScale(10, RoundingMode.HALF_EVEN);

            System.out.printf("Resultado: "+mes, pagoPrincipal, principal, interesMes, saldoPendiente);

            // Si el saldo pendiente llega a cero o es negativo, se saldrá del bucle
            if (saldoPendiente.compareTo(BigDecimal.ZERO) <= 0) {
                saldoPendiente = BigDecimal.ZERO;
                break;
            }
        }
    }

    // Método para calcular el pago mes a mes (PMT)
    public static BigDecimal calcularPagoMensual(BigDecimal principal, BigDecimal tasaInteresMensual, int totalPagos) {
        BigDecimal unoMasR = BigDecimal.ONE.add(tasaInteresMensual);
        BigDecimal unoMasR_a_la_n = unoMasR.pow(totalPagos);
        BigDecimal numerador = principal.multiply(tasaInteresMensual).multiply(unoMasR_a_la_n); // P * r * (1 + r)^n
        BigDecimal denominador = unoMasR_a_la_n.subtract(BigDecimal.ONE); //(1 + r)^n - 1

        // Calculamos PMT
        return numerador.divide(denominador, 10, RoundingMode.HALF_EVEN);
    }
}
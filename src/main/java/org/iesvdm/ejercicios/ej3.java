package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ej3 {
    public static void main(String[] args) {
        int años = 30; // Duración del préstamo en años
        int totalPagos = años * 12; // Total de pagos (30 años * 12 meses)
        BigDecimal principal = new BigDecimal("200000"); // Monto del préstamo
        BigDecimal tasaInteresAnual = new BigDecimal("0.05"); // Tasa de interés anual del 5%

        // Convertir la tasa de interés anual a tasa mensual
        BigDecimal tasaInteresXMes = tasaInteresAnual.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);

        // Calcular el pago mensual (PMT)
        BigDecimal pmt = calcularPagoMensual(principal, tasaInteresXMes, totalPagos);

        BigDecimal saldoPendiente = principal;

        // Mostrar el pago mensual (PMT)
        System.out.println("Pago mensual (PMT): " + pmt);
        System.out.println("Esquema de amortización:");
        System.out.printf( "Mes", "Pago Interés", "Pago Principal", "Pago Total", "Saldo Pendiente");

        // Bucle para calcular los pagos mes a mes
        for (int mes = 1; mes <= totalPagos; mes++) {
            // Calcular el pago de interés para el mes
            BigDecimal interesMes = saldoPendiente.multiply(tasaInteresXMes).setScale(10, RoundingMode.HALF_EVEN);

            // Calcular el pago de principal
            BigDecimal pagoPrincipal = pmt.subtract(interesMes).setScale(10, RoundingMode.HALF_EVEN);

            // Reducir el saldo pendiente
            saldoPendiente = saldoPendiente.subtract(pagoPrincipal).setScale(10, RoundingMode.HALF_EVEN);

            // Imprimir los detalles del mes
            System.out.printf("mes, interesMes, pagoPrincipal, pmt, saldoPendiente");

            // Si el saldo pendiente llega a cero o es negativo, salir del bucle
            if (saldoPendiente.compareTo(BigDecimal.ZERO) <= 0) {
                saldoPendiente = BigDecimal.ZERO;
                break;
            }
        }
    }

    // Método para calcular el pago mensual (PMT)
    public static BigDecimal calcularPagoMensual(BigDecimal principal, BigDecimal tasaInteresMensual, int totalPagos) {
        BigDecimal unoMasR = BigDecimal.ONE.add(tasaInteresMensual); // (1 + r)
        BigDecimal unoMasR_a_la_n = unoMasR.pow(totalPagos, MathContext.DECIMAL64); // (1 + r)^n
        BigDecimal numerador = principal.multiply(tasaInteresMensual).multiply(unoMasR_a_la_n); // P * r * (1 + r)^n
        BigDecimal denominador = unoMasR_a_la_n.subtract(BigDecimal.ONE); // (1 + r)^n - 1

        // Calcular PMT
        return numerador.divide(denominador, 10, RoundingMode.HALF_EVEN);
    }
}
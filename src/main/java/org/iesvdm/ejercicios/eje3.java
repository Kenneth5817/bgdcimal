package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
public class eje3 {

        public static void main(String[] args) {
            // Datos del préstamo
            BigDecimal principal = new BigDecimal("200000");  // Monto del préstamo (P)
            BigDecimal tasaInteresAnual = new BigDecimal("0.05");  // Tasa de interés anual (5%)
            int plazoAnios = 30;  // Plazo del préstamo en años
            int totalPagos = plazoAnios * 12;  // Número total de pagos (n)

            // Convertimos la tasa de interés anual a mensual
            BigDecimal tasaInteresXMes = tasaInteresAnual.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);

            // Calculamos el pago mensual (PMT) usando la fórmula de préstamo amortizable
            BigDecimal uno = BigDecimal.ONE;
            BigDecimal factorInteres = (uno.add(tasaInteresXMes)).pow(totalPagos, new MathContext(10, RoundingMode.HALF_EVEN));
            BigDecimal pmt = principal.multiply(tasaInteresXMes).multiply(factorInteres)
                    .divide(factorInteres.subtract(uno), 10, RoundingMode.HALF_EVEN);

            // Inicializamos el saldo pendiente con el monto del préstamo original
            BigDecimal saldoPendiente = principal;

            // Mostramos el pago mensual calculado
            System.out.printf("Pago mensual (PMT): %s%n", pmt.setScale(2, RoundingMode.HALF_EVEN));

            // Bucle para calcular los pagos mes a mes
            for (int mes = 1; mes <= totalPagos; mes++) {
                // Calcular el pago de interés para el mes
                BigDecimal interesMes = saldoPendiente.multiply(tasaInteresXMes).setScale(10, RoundingMode.HALF_EVEN);

                // Calculamos el pago de principal
                BigDecimal pagoPrincipal = pmt.subtract(interesMes).setScale(10, RoundingMode.HALF_EVEN);

                // Reducimos el saldo pendiente
                saldoPendiente = saldoPendiente.subtract(pagoPrincipal).setScale(10, RoundingMode.HALF_EVEN);

                // Imprimimos los detalles del mes
                System.out.printf("Mes %d: Interés: %s, Pago Principal: %s, Pago Total (PMT): %s, Saldo Pendiente: %s%n",
                        mes, interesMes.setScale(2, RoundingMode.HALF_EVEN),
                        pagoPrincipal.setScale(2, RoundingMode.HALF_EVEN),
                        pmt.setScale(2, RoundingMode.HALF_EVEN),
                        saldoPendiente.setScale(2, RoundingMode.HALF_EVEN));
            }
        }
    }


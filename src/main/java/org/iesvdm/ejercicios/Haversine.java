package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Haversine {
        // Constante: Radio de la Tierra en kilómetros
        public static final BigDecimal RADIO_TIERRA_KM = new BigDecimal("6378.0");

        // Método para convertir grados a radianes
        public static BigDecimal enRadianes(BigDecimal grados) {
            BigDecimal piDiv180 = new BigDecimal(Math.PI).divide(new BigDecimal("180"), MathContext.DECIMAL128);
            return grados.multiply(piDiv180);
        }

        // Método para calcular la distancia entre dos posiciones utilizando la fórmula de Haversine
        public static BigDecimal distanciaKm(Posicion posOrigen, Posicion posDestino) {
            MathContext mc = new MathContext(34, RoundingMode.HALF_EVEN); // Usamos Decimal128

            BigDecimal difLatitud = enRadianes(posDestino.getLatitud().subtract(posOrigen.getLatitud()));
            BigDecimal difLongitud = enRadianes(posDestino.getLongitud().subtract(posOrigen.getLongitud()));

            BigDecimal lat1EnRad = enRadianes(posOrigen.getLatitud());
            BigDecimal lat2EnRad = enRadianes(posDestino.getLatitud());

            // Fórmula de Haversine
            BigDecimal a = sinCuadrado(difLatitud.divide(new BigDecimal("2"), mc))
                    .add(cos(lat1EnRad).multiply(cos(lat2EnRad))
                            .multiply(sinCuadrado(difLongitud.divide(new BigDecimal("2"), mc))));

            BigDecimal c = new BigDecimal("2").multiply(atan2(sqrt(a), sqrt(BigDecimal.ONE.subtract(a))));

            // Distancia final en kilómetros
            return RADIO_TIERRA_KM.multiply(c, mc).setScale(2, RoundingMode.HALF_EVEN); // Redondeo a 2 decimales
        }

        // Métodos auxiliares para cálculos trigonométricos y matemáticos con BigDecimal
        public static BigDecimal sinCuadrado(BigDecimal valor) {
            return sin(valor).pow(2);
        }

        public static BigDecimal sin(BigDecimal valor) {
            return new BigDecimal(Math.sin(valor.doubleValue()), MathContext.DECIMAL128);
        }

        public static BigDecimal cos(BigDecimal valor) {
            return new BigDecimal(Math.cos(valor.doubleValue()), MathContext.DECIMAL128);
        }

        public static BigDecimal sqrt(BigDecimal valor) {
            return valor.sqrt(MathContext.DECIMAL128);
        }

        public static BigDecimal atan2(BigDecimal y, BigDecimal x) {
            return new BigDecimal(Math.atan2(y.doubleValue(), x.doubleValue()), MathContext.DECIMAL128);
        }
}

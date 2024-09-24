package org.iesvdm.ejercicios;
import java.math.BigDecimal;
public class Test_Haversine {
        public static void main(String[] args) {
            // Crear posiciones: Igualada y Granada
            Posicion igualada = new Posicion(new BigDecimal("41.57879"), new BigDecimal("1.617221"));
            Posicion granada = new Posicion(new BigDecimal("37.176487"), new BigDecimal("-3.597929"));

            // Calcular distancia en km
            BigDecimal distancia = Haversine.distanciaKm(igualada, granada);

            // Mostrar la distancia calculada
            System.out.println("Distancia calculada: " + distancia + " km");

            // Verificar si la distancia está cerca de 664 km
            BigDecimal distanciaEsperada = new BigDecimal("664.0");
            if (distancia.compareTo(distanciaEsperada) == 0) {
                System.out.println("Test exitoso: La distancia es correcta.");
            } else {
                System.out.println("Test fallido: La distancia es incorrecta.");
            }
        }
    }


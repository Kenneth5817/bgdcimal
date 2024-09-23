package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class exercise3 {
    public static void main(String[] args) {
        int años=30;
        int numPagos=12*30;
        BigDecimal principal=new BigDecimal("20000");
        BigDecimal tasaINtAnual=new BigDecimal("0.05");

        BigDecimal tasaINtXMes= tasaINtAnual.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);


    }
}

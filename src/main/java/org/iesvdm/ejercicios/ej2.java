package org.iesvdm.ejercicios;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ej2 {
    public static void main(String[] args) {
        BigDecimal p= new BigDecimal("10");
        BigDecimal r= new BigDecimal("0.05");
        int n= 2;
        /**n = años, p=monto principal, r=tasa de interés anual, c= cantidad final depositada**/

        /** Fórmula c=p(1+r);**/
        BigDecimal suma= BigDecimal.ONE.add(r);
        BigDecimal c=p.multiply(suma.pow(n));
        c.setScale(10, RoundingMode.HALF_EVEN);

        System.out.println("RESULTADO: "+c);
    }
}

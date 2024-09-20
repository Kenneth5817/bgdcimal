package org.iesvdm.ejercicios;
import java.math.BigDecimal;
import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        BigDecimal c= new BigDecimal("6");
        BigDecimal p= new BigDecimal("1");
        BigDecimal r= new BigDecimal("5");
        BigDecimal n= new BigDecimal("2");
        /**n = años, p=monto principal, r=tasa de interés anual, c= cantidad final depositada**/

        /** Fórmula c=p(1+r);**/
        BigDecimal formula= new BigDecimal("0.1");
        formula=p(1+r)^n;

        c=c.add(p);
        c=c.add(r);
        System.out.println("Años: "+n);
        System.out.println("Cantidad final: "+formula);
    }
}

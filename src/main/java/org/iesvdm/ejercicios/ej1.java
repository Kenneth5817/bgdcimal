package org.iesvdm.ejercicios;

import java.math.BigInteger;



public class ej1 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("5");
        BigInteger acumulador = BigInteger.ONE; /**Va uno a uno en vez de poner new BigInteger("5")**/

        while(n.compareTo(BigInteger.ZERO) > 0){
            /**NO USAR ++ Usar n. clase**/
            acumulador=acumulador.multiply(n);
            n=n.subtract(BigInteger.ONE);
        }
        System.out.println(acumulador);
    }

}

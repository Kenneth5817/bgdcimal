package org.iesvdm.functional;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /**ATRIBUTOS DEL METODO**/
        Operacion o=(x,y)->x+y;
        /**Operacion o={double x,double y}> {
         *      return x+y;
         * };
         */
        Function<String,Integer> f= s -> s.length();
        double res=o.calcular(1.2,1.3);
        System.out.println(res);

    int longCadena=f.apply("Hola java moderno");
    System.out.println(longCadena);
    }
}
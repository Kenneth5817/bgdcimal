package org.iesvdm.instituto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvendio al gestor del instituto");
        System.out.println("Cargando contexto de aplicación");

        ArrayList<Class> clases= CargadorContexto.CargadorContextoInstituto();
        System.out.println("Clases cargadas");

        for(Class clase: clases){
            System.out.println(clase);
        }
    }
}

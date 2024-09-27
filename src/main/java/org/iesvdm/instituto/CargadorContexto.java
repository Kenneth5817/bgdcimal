package org.iesvdm.instituto;

import org.iesvdm.annotations.Estudiante;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargadorContexto {
    public static ArrayList<Class> CargadorContextoInstituto(){
        org.iesvdm.annotations.Estudiante[] estudiantesAnnotations= Clase.class.getAnnotationsByType(org.iesvdm.annotations.Estudiante.class);
        //Annotation[] es == var

        /**Clase clase=new Clase("1","1DAW");
        Clase clase2= new Clase("2","2DAW");**/

        Map<Integer, Class> integerClassMap=new HashMap<>();
        for (Estudiante estudiantesAnnotation : estudiantesAnnotations) {
            System.out.println(estudiantesAnnotation);

            //BUscamos clase por id
            int curso=estudiantesAnnotation.curso();
            Class claseBuscada=integerClassMap.get(curso);


            if(claseBuscada==null){
                //Clase no existe en el mapa asi que se crea con el curso
                claseBuscada= new Clase().getClass();
                integerClassMap.put(curso,claseBuscada);
            }

            //
            claseBuscada.getEstudiantes().add(new org.iesvdm.instituto.Estudiante(
                estudianteAnnotation.nombre(),
                LocalDate.now(),
                100,
                estudianteAnnotation.direccion()
            ));
        }
        return new ArrayList<>(integerClassMap.values());
    }

}

package org.iesvdm.annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.*;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
//Hacer repeatable
@Repeatable(Estudiante.class)
@Target(ElementType.TYPE)
@Documented
public @interface Estudiante{

    String nombre() default "";
    String fechaNacimiento();
    int curso();
    String direccion_defecto() default "NO_ESPECIFICADO";
}
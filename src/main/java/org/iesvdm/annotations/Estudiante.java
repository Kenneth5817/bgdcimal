package org.iesvdm.annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.*;
import java.util.Date;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Estudiantes.class)
public @interface Estudiante{

    String nombre();
    String fechaNacimiento();
    int curso();
    String direccion() default "";
}
package org.iesvdm.annotations;

import java.lang.annotation.*;

/**Meta-Anotaciones**/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Estudiantes {
    Estudiante[] value();
}

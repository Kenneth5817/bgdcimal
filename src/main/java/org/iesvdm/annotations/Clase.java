package org.iesvdm.annotations;
import java.lang.annotation.*;
import java.util.List;

@Estudiante(
        nombre="Kenneth",
        fechaNacimiento="01/01/2001",
        curso=1
        )
public class Clase{

    List<Estudiante> estudiantes;
}

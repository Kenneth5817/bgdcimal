package org.iesvdm.instituto;

import org.iesvdm.annotations.Estudiante;

import java.util.ArrayList;
import java.util.List;

@Estudiante(
        nombre="Jose",
        fechaNacimiento="01/01/2001",
        curso=2
)
@Estudiante(
        nombre="Fran",
        fechaNacimiento="01/01/2001",
        curso=2
)
/**@Estudiantes({
        @Estudiante(nombre="jose", fechaNacimiento="01/01/2001", curso=2),
        @Estudiante(nombre="fran", fechaNacimiento="01/01/2001", curso=2)
})**/


public class Clase {

    public Clase(String curso, String clase) {
    }

    //Getters y Setters
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Clase() {
    }
    private String curso;

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public String getAula() {
        return aula;
    }
    public void setAula(String aula) {
        this.aula = aula;
    }

    public Clase(String curso) {
        this.curso = curso;
    }
    private List<Estudiante> estudiantes= new ArrayList<>();
    private String aula;
    @Override
    public String toString() {
        return "Clase{" +
                "curso='" + curso + '\'' +
                ", aula='" + aula + '\'' +
                '}';
    }
}

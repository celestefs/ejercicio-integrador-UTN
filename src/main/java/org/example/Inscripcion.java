package org.example;

import java.time.LocalDateTime;

public class Inscripcion {
    Alumno alumno;
    Materia materia;
    LocalDateTime fecha;

    public Inscripcion(){
    }

    public Inscripcion(Alumno alumno, Materia materia, LocalDateTime fecha) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = fecha;
    }

    public boolean aprobada(){
        return materia.puedeCursar(alumno);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean validarInscripcion(){

        boolean aprobada = true;

        if (alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas())){
            System.out.println(getAlumno().getNombre() + " puede inscribirse a la materia " + getMateria().getNombre());
            aprobada = true;
        } else{
            System.out.println(getAlumno().getNombre() + " no puede inscribirse a la materia " + getMateria().getNombre() + " ya que no posee las materias correlativas aprobadas.");
            aprobada = false;
        }
        return aprobada;
    }
}

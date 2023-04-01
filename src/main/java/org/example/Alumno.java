package org.example;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    String nombre;
    String legajo;
    ArrayList<Materia> materiasAprobadas = new ArrayList<>();

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public Alumno(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", legajo='" + legajo + '\'' +
                ", materiasAprobadas=" + materiasAprobadas +
                '}';
    }
}

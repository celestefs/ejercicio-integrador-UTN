package org.example;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    String nombre;
    ArrayList<Materia> correlativas = new ArrayList<>();

    public Materia(){
    }

    public Materia(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean puedeCursar(Alumno alumno){
        return alumno.getMateriasAprobadas().containsAll(correlativas);
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", correlativas=" + correlativas +
                '}';
    }
}

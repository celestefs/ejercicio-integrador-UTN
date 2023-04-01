package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class InscripcionTest {

    @Test
    public void testMateriaSinCorrelativas(){

        Materia materia = new Materia("Programación I");
        Alumno alumno = new Alumno("Juan Pérez", "123");
        Inscripcion inscripcion = new Inscripcion(alumno, materia, LocalDateTime.now());

        Assert.assertTrue(inscripcion.aprobada());

    }

    @Test
    public void testMateriaConCorrelativasYAlumnoLasTiene(){

        Materia materia1 = new Materia("Programación I");
        Materia materia2 = new Materia("Programación II");
        Materia materia3 = new Materia("Programación III");
        Alumno alumno = new Alumno("Juan Pérez", "123");
        materia3.correlativas.add(materia2);
        alumno.materiasAprobadas.add(materia2);
        Inscripcion inscripcion = new Inscripcion(alumno, materia3, LocalDateTime.now());

        Assert.assertTrue(inscripcion.aprobada());

    }

    @Test
    public void testMateriaConCorrelativasPeroAlumnoNoLasTiene(){

        Materia materia1 = new Materia("Programación I");
        Materia materia2 = new Materia("Programación II");
        Materia materia3 = new Materia("Programación III");
        Alumno alumno = new Alumno("Juan Pérez", "123");
        materia3.correlativas.add(materia2);
        alumno.materiasAprobadas.add(materia1);
        Inscripcion inscripcion = new Inscripcion(alumno, materia3, LocalDateTime.now());

        Assert.assertFalse(inscripcion.aprobada());

    }
}

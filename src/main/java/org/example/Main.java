package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Alumno alumno1 = new Alumno("Pedro", "233");
        Alumno alumno2 = new Alumno("Sofia", "154");
        Alumno alumno3 = new Alumno("Lucas", "456");

        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);

        Materia materia1 = new Materia("Programacion I");
        Materia materia2 = new Materia("Programacion II");
        Materia materia3 = new Materia("Programacion III");
        Materia materia4 = new Materia("Bases de datos I");
        Materia materia5 = new Materia("Bases de datos II");

        ArrayList<Materia> materias = new ArrayList<Materia>();
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
        materias.add(materia4);
        materias.add(materia5);

        // agrego las correlativas al Array correlativas

        materia2.correlativas.add(materia1);
        materia3.correlativas.add(materia2);
        materia5.correlativas.add(materia4);

        // agrego las materias aprobadas de los alumnos al Array materiasAprobadas

        alumno2.materiasAprobadas.add(materia1);
        alumno2.materiasAprobadas.add(materia4);
        alumno1.materiasAprobadas.add(materia1);
        alumno3.materiasAprobadas.add(materia1);

        Inscripcion nueva = new Inscripcion(alumno1, materia2, LocalDateTime.now());
        Inscripcion nueva2 = new Inscripcion(alumno2, materia2, LocalDateTime.now());
        Inscripcion nueva3 = new Inscripcion(alumno3, materia3, LocalDateTime.now());
        System.out.println(nueva.validarInscripcion());
        System.out.println(nueva2.validarInscripcion());
        System.out.println(nueva3.validarInscripcion());
        System.out.println(alumno2.toString());

        // corroboro si cierto alumno puede cursar cierta materia que requiere correlativas aprobadas

        System.out.println(materia3.puedeCursar(alumno2));

        try (Scanner scanner = new Scanner(new File("C:/Users/Celes/Desktop/inscripciones.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("salida.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split("\t");

                if (fields.length != 2) {
                    writer.write(line + " - Formato incorrecto\n");
                    continue;
                }

                String nombreAlumno = fields[0];
                String nombreMateria = fields[1];

                Alumno alumno = findAlumno(alumnos, nombreAlumno);
                Materia materia = findMateria(materias, nombreMateria);

                if (alumno == null) {
                    writer.write(line + " - No existe el alumno" + "\n");
                    writer.newLine();
                    continue;
                }

                if (materia == null) {
                    writer.write(line + " - No existe la materia" + "\n");
                    writer.newLine();
                    continue;
                }

                Inscripcion inscripcion = new Inscripcion(alumno, materia, LocalDateTime.now());
                String estado = inscripcion.aprobada() ? "Aprobada" : "Rechazada";

                writer.write(line + " - " + estado + "\n");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Alumno findAlumno(ArrayList<Alumno> alumnos, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }
        return null;
    }

    private static Materia findMateria(ArrayList<Materia> materias, String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombre)) {
                return materia;
            }
        }
        return null;
    }
}


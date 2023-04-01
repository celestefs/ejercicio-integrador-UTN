package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Pedro", "233");
        Alumno alumno2 = new Alumno("Sofia", "154");
        Alumno alumno3 = new Alumno("Lucas", "456");

        Materia materia1 = new Materia("Programación I");
        Materia materia2 = new Materia("Programación II");
        Materia materia3 = new Materia("Programación III");
        Materia materia4 = new Materia("Bases de datos I");
        Materia materia5 = new Materia("Bases de datos II");

        materia2.correlativas.add(materia1);
        materia3.correlativas.add(materia2);
        materia5.correlativas.add(materia4);

        alumno2.materiasAprobadas.add(materia1);
        alumno2.materiasAprobadas.add(materia4);
        Inscripcion nueva = new Inscripcion(alumno2, materia2, LocalDateTime.now());
        System.out.println(nueva.validarInscripcion());
        System.out.println(alumno2.toString());
        System.out.println(materia3.puedeCursar(alumno2));

        try {
            FileReader archivoEntrada = new FileReader("C:\\Users\\Celes\\Desktop\\inscripciones.txt");
            Scanner sc = new Scanner(archivoEntrada);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
                }
            sc.close();
            /*FileWriter archivoSalida = new FileWriter("C:\\Users\\Celes\\Desktop\\archivoDeSalida.txt");
            archivoSalida.write();
            archivoSalida.close();
            System.out.println("El archivo de salida ha sido creado.");*/
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}

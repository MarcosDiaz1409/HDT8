import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #8
 * 27/03/2023
 * Clase principal donde el usuario interactua con el programa
 */

public class Principal{

    public static void main(String[] args){

        // Se crea el ArrayList que almacena todas las lineas del archivo
        ArrayList<String> lineasArchivo = new ArrayList<>();

        // Lee el archivo de texto y agrega todas las lineas al ArrayList anterior
        File file = new File("C:/Ejemplos/ejemploHDT7.txt"); // Poner aqui la direccion del archivo de texto a utilizar
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(br.ready()) {
                    lineasArchivo.add(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
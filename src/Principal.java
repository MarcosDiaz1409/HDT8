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
        File file = new File("C:/Ejemplos/procesos.txt"); // Poner aqui la direccion del archivo de texto a utilizar
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(br.ready()) {
                    lineasArchivo.add(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Primera parte del codigo: Utilizando la clase VectorHeap para los procesos
        */

        System.out.println("\n ..:: Cola de prioridad utilizando VectorHeap ::.. \n");

        // Muestra los procesos que entraran a la cola
        System.out.println(" Procesos a entrar en la cola: \n");
        for(int i = 0; i < lineasArchivo.size(); i++) {
            System.out.println(lineasArchivo.get(i));
        }

        System.out.println("\n");

        List<Proceso> procesos = new ArrayList<>();

        // Procesa cada línea del ArrayList
        for (String linea : lineasArchivo) {
            String[] campos = linea.split(",");
            String nomProceso = campos[0];
            String nomUs = campos[1];
            int valorN = Integer.parseInt(campos[2]);

            Proceso proceso = new Proceso(nomProceso, nomUs, valorN);
            procesos.add(proceso);
        }

        // En esta parte del codigo se calculan la prioridad y van entrando los valores de los procesos a la cola

        VectorHeap<Proceso> colaPrioridad = new VectorHeap<Proceso>();
        ArrayList<Integer> valoresPR = new ArrayList<>();

        // Los procesos son atendidos por el CPU
        for (Proceso proceso : procesos){
            int updatedValue = proceso.getValorN() + 20 + 100;
            proceso.setValorN(updatedValue);
            colaPrioridad.add(proceso);
        }

        // Los procesos se retiran del CPU y se muestran segun la prioridad
        while (!colaPrioridad.isEmpty()) {
            Proceso proceso = colaPrioridad.remove();
            int originalValue = proceso.getValorN() - 120;
            int newValorPr = proceso.getValorPR();
            valoresPR.add(proceso.getValorN());
            System.out.println("Nombre del proceso: " + proceso.getNomProceso() + ", Nombre del usuario: " + proceso.getNomUs() + ", Valor nice: " + originalValue + ", Prioridad: " + newValorPr);
        }

        /**
         * Segunda parte del codigo: Utilizando PriorityQueue de Java Collection Framework
        */

        System.out.println("\n ..:: Cola de prioridad utilizando Java Collection Framework ::.. \n");

        // Muestra los procesos que entraran a la cola
        System.out.println(" Procesos a entrar en la cola: \n");
        for(int i = 0; i < lineasArchivo.size(); i++) {
            System.out.println(lineasArchivo.get(i));
        }

        System.out.println("\n");

        PriorityQueue<Proceso> ps = new PriorityQueue<>();

        // Procesa cada línea del ArrayList y lo agrega a la cola de prioridad
        for (String linea : lineasArchivo) {
            String[] campos = linea.split(",");
            String nomProceso = campos[0];
            String nomUs = campos[1];
            int valorN = Integer.parseInt(campos[2]);
            ps.offer(new Proceso(nomProceso, nomUs, valorN));
        }

        List<Integer> newvaloresPR = new ArrayList<>();

        // Elimina los valores de la cola segun sea su prioridad e imprime su informacion
        while (!ps.isEmpty()) {
            Proceso proceso = ps.poll();
            int valorPR2 = proceso.getValorN() + 20 + 100;
            newvaloresPR.add(valorPR2);
            System.out.printf("Nombre del proceso: %s, Nombre del usuario: %s, Valor nice: %d, Prioridad: %d\n",
                proceso.getNomProceso(), proceso.getNomUs(), proceso.getValorN(), valorPR2);
        }

    }   

}
/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #8
 * 27/03/2023
 * Interface que contiene los metodos que usara la clase de Vector Heap
 */

public interface IPriorityQueue<E>{

    /**
     * Metodo que agrega un elemento a la cola de prioridad
     */
    void add(E value);

    /**
     * Metodo que muestra y elimina el elemento de mayor prioridad en la cola
     */
    E remove();

    /**
     * Metodo que verifica si la cola de prioridad esta vacia
     */
    boolean isEmpty();

     /**
     * Metodo que devuelve el tamaño de la cola de prioridad
     */
    int size();

    /**
     * Metodo que devuelve el elemento de mayor prioridad en la cola
     */
    E getFirst();
    
}
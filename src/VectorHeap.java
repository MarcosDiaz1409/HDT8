import java.util.Vector;

/*
 * Marcos Diaz (221102)
 * Hoja de trabajo #8
 * 27/03/2023
 * Clase que instancia una cola de prioridad utilizando un Vector y Heaps
 */

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E>{

    protected Vector<E> cola; 

    /**
     * Parametros de la clase
     * @param cola vector donde se almacenaran los valores que entraran a la cola
     */

    /**
     * Constructor por defecto, crea una cola de prioridad vacia
     */
    public VectorHeap() {
        cola = new Vector<>();
    }

    /**
     * Constructor que instancia una nueva cola de prioridad ya con elementos
     * @param coll
     */
    public VectorHeap(Vector<E> coll) {
    	cola = new Vector<>(coll);
        buildHeap();
    }

    /**
     * Metodo que reordena el vector interno para que cumpla con los heaps
     */
    protected void buildHeap() {
        for (int i = cola.size() / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    
    /**
     * Metodo que convierte la cola de elementos a una representacion de caracteres
     * @return La cola con los elementos en ese instante
     */
    @Override
    public String toString() {
        return cola.toString();
    }
    
    /**
     * Metodo que devuelve el indice del padre
     * @param i
     * @return indice del padre
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }
    
    /**
     * Metodo que "percola" un elemento hacia arriba del vector para cumplir con los heaps
     * @param leaf
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = cola.get(leaf);
        while (leaf > 0 && (value.compareTo(cola.get(parent)) < 0)) {
            cola.set(leaf, cola.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        cola.set(leaf, value);
    }

    /**
     * Metodo que percola un elemento hacia abajo del vecto para cumplir con los heaps
     * @param root
     */
    protected void percolateDown(int root) {
        E value = cola.get(root);
        while (root < cola.size() / 2) {
            int child = 2 * root + 1;
            if ((child < cola.size() - 1) && (cola.get(child).compareTo(cola.get(child + 1)) > 0)) {
                child++;
            }
            if (value.compareTo(cola.get(child)) <= 0) {
                break;
            }
            cola.set(root, cola.get(child));
            root = child;
        }
        cola.set(root, value);
    }

    /**
     * Metodo que agrega un elemento a la cola de prioridad
     */
    @Override
    public void add(E value) {
        cola.add(value);
        percolateUp(cola.size() - 1);
    }

    /**
     * Metodo que muestra y elimina el elemento de mayor prioridad en la cola
     */
    @Override
    public E remove() {
    	if (cola.isEmpty()) {
            return null;
        }
        E minElement = cola.get(0);
        E lastElement = cola.remove(cola.size() - 1);
        if (!cola.isEmpty()) {
            cola.set(0, lastElement);
            percolateDown(0);
        }
        return minElement;
    }

    /**
     * Metodo que devuelve el elemento de mayor prioridad en la cola
     */
    @Override
    public E getFirst() {
    	if (cola.isEmpty()) {
            return null;
        }
        return cola.get(0);
    }

    /**
     * Metodo que verifica si la cola de prioridad esta vacia
     */
    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    /**
     * Metodo que devuelve el tamaño de la cola de prioridad
     */
    @Override
    public int size() {
        return cola.size();
    }
    
}
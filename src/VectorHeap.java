import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E>{

    protected Vector<E> cola;

    public VectorHeap() {
        cola = new Vector<>();
    }

    public VectorHeap(Vector<E> coll) {
    	cola = new Vector<>(coll);
        buildHeap();
    }

    protected void buildHeap() {
        for (int i = cola.size() / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    
    @Override
    public String toString() {
        return cola.toString();
    }
    
    protected static int parent(int i) {
        return (i - 1) / 2;
    }
    
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

    @Override
    public void add(E value) {
        cola.add(value);
        percolateUp(cola.size() - 1);
    }

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

    @Override
    public E getFirst() {
    	if (cola.isEmpty()) {
            return null;
        }
        return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    @Override
    public int size() {
        return cola.size();
    }
    
}
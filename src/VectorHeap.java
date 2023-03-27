import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E>{

    private Vector<E> cola;

    public VectorHeap() {
        cola = new Vector<>();
    }

    public VectorHeap(Vector<E> v) {
        int i;
        cola = new Vector<>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }

    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = cola.get(leaf);
        while (leaf > 0 && value.compareTo(cola.get(parent)) < 0) {
            cola.set(leaf, cola.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        cola.set(leaf, value);
    }

    private void percolateDown(int root) {
        int heapSize = cola.size();
        E value = cola.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (right(root) < heapSize && cola.get(childpos + 1).compareTo(cola.get(childpos)) < 0) {
                    childpos++;
                }
                if (cola.get(childpos).compareTo(value) < 0) {
                    cola.set(root, cola.get(childpos));
                    root = childpos;
                } else {
                    break;
                }
            } else {
                cola.set(root, value);
                return;
            }
        }
        cola.set(root, value);
    }

    @Override
    public boolean add(E value) {
        cola.add(value);
        percolateUp(cola.size() - 1);
        return true;
    }

    @Override
    public E remove() {
        E minVal = getFirst();
        cola.set(0, cola.get(cola.size() - 1));
        cola.setSize(cola.size() - 1);
        percolateDown(0);
        return minVal;
    }

    @Override
    public E getFirst() {
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
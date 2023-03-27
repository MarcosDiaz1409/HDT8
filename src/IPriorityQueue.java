public interface IPriorityQueue<E>{

    void add(E value);

    E remove();

    boolean isEmpty();

    int size();

    E getFirst();
    
}
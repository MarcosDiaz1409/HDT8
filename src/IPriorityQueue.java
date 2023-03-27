public interface IPriorityQueue<E>{

    boolean add(E value);

    E remove();

    boolean isEmpty();

    int size();

    E getFirst();
    
}
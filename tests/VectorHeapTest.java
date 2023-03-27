import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VectorHeapTest {
	
	VectorHeap<Integer> colaPrioridad = new VectorHeap<Integer>();

    @Test
    public void testAdd() {
        colaPrioridad.add(100);
        colaPrioridad.add(125);
        colaPrioridad.add(130);
        colaPrioridad.add(126);
        assertEquals("[100, 125, 130, 126]", colaPrioridad.toString());
    }
    
    @Test
    public void testRemove() {
        colaPrioridad.add(100);
        colaPrioridad.add(125);
        colaPrioridad.add(130);
        colaPrioridad.add(126);
        int elementoPrioritario = colaPrioridad.remove();
        assertEquals(100, elementoPrioritario);
        assertEquals("[125, 126, 130]", colaPrioridad.toString());
    }

    @Test
    public void getFirstTest() {
        colaPrioridad.add(100);
        colaPrioridad.add(125);
        colaPrioridad.add(130);
        colaPrioridad.add(126);
        int elementoPrioritarioActual = colaPrioridad.getFirst();
        assertEquals(100, elementoPrioritarioActual);
        assertEquals("[100, 125, 130, 126]", colaPrioridad.toString());
    }

    @Test
    public void testSize(){
        colaPrioridad.add(100);
        colaPrioridad.add(125);
        colaPrioridad.add(130);
        colaPrioridad.add(126);
        int tamano = colaPrioridad.size();
        assertEquals(4, tamano);
    }

}

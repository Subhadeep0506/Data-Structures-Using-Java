package data_structures.examples.heap;

public class Heap {
    
    public int heap[];
    public int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    //  This is a maxheap. So, the elements are inserted in such a manner that,
    //  the larger values get placed towards the beginning of the heap
    public void insert(int value) {

        if (isFull()) {
            System.out.println("Heap is full");
            //  Here we could make the compiler throw an IndexOutOfBoundsException
            // throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    //  After inserting a node, we heapify by looking up the tree
    //  Hence the funcyion fixHeapAbove will heapify the tree above current node
    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    //  Returns true if the heap is full
    //  and false if heap is not full
    public boolean isFull() {
        return size == heap.length;
    }

    //  Calculates the position of the parent node of current node
    //  according to the formula parent = floor( i - 1) / 2, where
    //  i is the current index
    public int getParent(int index) {
        return (index - 1) / 2;
    }
}

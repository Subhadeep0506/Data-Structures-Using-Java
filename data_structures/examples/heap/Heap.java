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

    public int delete(int index) {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            //  Here we could make the compiler throw an IndexOutOfBoundsException
            // throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedNode = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedNode;    
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

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } 
            else {
                break;
            }
        }
    }
    
    //  Prints the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    //  Returns true if the heap is full
    //  and false if heap is not full
    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //  Calculates the position of the parent node of current node
    //  according to the formula parent = floor( i - 1) / 2, where
    //  i is the current index
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    //  Calculates the position of the child node of current node
    //  according to the formula leftChild = 2 * i + 1, rightChild = 2 * i + 2 where
    //  i is the current index
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }
}

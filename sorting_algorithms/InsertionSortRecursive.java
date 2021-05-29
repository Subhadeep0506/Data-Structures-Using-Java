package sorting_algorithms;

public class InsertionSortRecursive {
    public static void insertionSort(int[] array, int numItems){
        if(numItems < 2)
            return;

        insertionSort(array, numItems - 1);
        int newElement = array[numItems - 1];
        int i;
        for(i = numItems - 1; i > 0 && array[i - 1] > newElement; i--){
            array[i] = array[i - 1];
        }
        array[i] = newElement;
    }
    public static void main(String[] args) {
        int[] array = {4, 8, 3, 9, 2, -3, 0, -2};

        insertionSort(array, array.length);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}


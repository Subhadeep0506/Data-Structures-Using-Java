package sorting_algorithms;

public class InsertionSortAlternative {

    public static void insertionSort(int[] array){
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++){
            int newElement = array[firstUnsortedIndex];
            int i = firstUnsortedIndex;
            while(i > 0 && newElement < array[i - 1]){
                array[i] = array[i - 1];
                i--;
            }
            array[i] = newElement;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 8, 3, 9, 2, -3, 0, -2};

        insertionSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}

package practice;

public class SelectionSort {
    
    public static void selectionSort(int[] array){

        int lastSortedIndex = array.length - 1;
        int temp;
        
        for(lastSortedIndex = array.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            int largest = 0;
            for(int j = 1; j <= lastSortedIndex; j++){
                if(array[j] > array[largest]){
                    largest = j;
                }
            }
            temp = array[largest];
            array[largest] = array[lastSortedIndex];
            array[lastSortedIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 8, 3, 9, 2, -3, 0, -2};

        selectionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}

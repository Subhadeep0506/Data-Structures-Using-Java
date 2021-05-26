package sorting_algorithms;

public class BubbleSortAlt{
    public static void main(String[] args) {
        int array[] = {20, 35, -15, 7, 55, 1, -22};

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        for(int unsortedPartitionIndex = array.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--){
            for(int i = 0; i < unsortedPartitionIndex; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        System.out.println();
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
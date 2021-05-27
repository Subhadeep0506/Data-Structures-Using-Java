package sorting_algorithms;

// import java.util.Scanner;

public class CountingSort {

    public int[] countingSort(int[] array, int min, int max){
        int countArray[] = new int[(max - min) + 1];
        for(int i = 0; i < array.length; i++){
            countArray[i] = 0;
        }
        for(int i = 0; i < array.length; i++){
            countArray[array[i] - min]++;
        }
        int k = 0;
        for(int i = 0; i < array.length; i++){
            
            while(countArray[i] != 0){
                array[k++] = i + min;
                countArray[i]--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no of elements you want to enter: ");
        // int size = sc.nextInt();
        // int array[] = new int[size];

        // System.out.println("Enter the elements: ");
        // for(int i = 0; i < size; i++){
        //     array[i] = sc.nextInt();
        // }
        int array[] = {6, 4, 2, 3, 8, 9, 4, 2, 10};
        CountingSort obj_1 = new CountingSort();
        array = obj_1.countingSort(array, 2, 10);

        System.out.println("Sorted elements: ");
        for(int i = 0; i < 9; i++){
            System.out.print(array[i] + " ");
        }

        // sc.close();
    }
}

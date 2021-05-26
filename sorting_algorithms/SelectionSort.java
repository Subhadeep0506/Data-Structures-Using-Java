package sorting_algorithms;

import java.util.Scanner;

public class SelectionSort {
    
    public int[] selectionSort(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            int largest = 0;
            for(int j = 1; j <= i; j++){
                if(array[j] > array[largest])
                    largest = j;
            }
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements you want to enter: ");
        int size = sc.nextInt();
        int array[] = new int[size];
        
        System.out.println("Enter the elements: ");
        for(int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }
        SelectionSort obj_1 = new SelectionSort();
        array = obj_1.selectionSort(array);
        System.out.println("Sorted elements: ");
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}

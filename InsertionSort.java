import java.util.Scanner;

public class InsertionSort {

    public int[] insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            int key = array[i];
            while(j >= 0 && key < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
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
        InsertionSort obj_1 = new InsertionSort();
        array = obj_1.insertionSort(array);
        System.out.println("Sorted elements: ");
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}

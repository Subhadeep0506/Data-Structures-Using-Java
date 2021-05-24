import java.util.Scanner;

public class MergeSort {
    
    public static void mergeSort(int[] array, int start, int end){

        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end); 
            merge(array, start, mid, end);
        }  
    }

    public static void merge(int[] array, int start, int mid, int end){
        
        // if(array[mid - 1] <= array[mid]){
        //     return;
        // }

        int[] tempArray = new int[array.length];
        int i = start, j = mid + 1, tempIndex = start;

        while(i <= mid && j <= end){
            tempArray[tempIndex++] = (array[i] <= array[j] ? array[i++] : array[j++]);
        }

        while(i <= mid){
            tempArray[tempIndex++] = array[i++];
        }

        while(j <= end){
            tempArray[tempIndex++] = array[j++];
        }

        for(tempIndex = start; tempIndex <= end; tempIndex++)
            array[tempIndex] = tempArray[tempIndex];
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

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted elements: ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}
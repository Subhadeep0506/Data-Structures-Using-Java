package sorting_algorithms;

import java.util.Scanner;
public class QuickSort {

    int[] array;
    int size;

    public void quickSort(int left, int right){
        int l = left, r = right, pivot = this.array[(left + right) / 2], temp = 0;

        do{
            while(pivot > this.array[left])
                left++;
            while(pivot < this.array[right])
                right--;

            if(left <= right){
                temp = this.array[left];
                this.array[left++] = this.array[right];
                this.array[right--] = temp;
            }    
        }while(left <= right);

        if(left < r)
            quickSort(left, r);
        if(l < right)
            quickSort(l, right);
    }

    public void arrayInitializer(int size){

        Scanner input = new Scanner(System.in);

        for(int i = 0; i < size; i++)
            this.array[i] = input.nextInt();

        input.close();    
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        System.out.println("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        obj.size = sc.nextInt();
        System.out.print("Enter the elements: ");

        obj.array = new int[obj.size];

        obj.arrayInitializer(obj.size);

        obj.quickSort(0, obj.size - 1);

        System.out.print("Sorted array: ");
        for(int i = 0; i < obj.size; i++)
            System.out.print(obj.array[i] + " ");

        sc.close();
    }
}

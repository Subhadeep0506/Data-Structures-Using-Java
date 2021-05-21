import java.util.Scanner;

public class ShellSort {
    
    public int[] shellSort(int[] array) {
        
        for(int gap = array.length / 2; gap > 0; gap /= 2){ 
            for(int i = gap; i < array.length; i++){
                int newElement = array[i];
                int j = i;
                while(j >= gap && array[j - gap] > newElement){
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
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
        ShellSort obj_1 = new ShellSort();
        array = obj_1.shellSort(array);
        System.out.println("Sorted elements: ");
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}
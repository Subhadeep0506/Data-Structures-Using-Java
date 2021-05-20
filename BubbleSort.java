import java.util.Scanner;
public class BubbleSort{

    public int[] bubbleSort(int[] array){
        int temp = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
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

        BubbleSort obj_1 = new BubbleSort();
        array = obj_1.bubbleSort(array);

        System.out.println("Sorted elements: ");
        for(int i = 0; i < 6; i++){
            System.out.print(array[i] + " ");
        }

        sc.close();
    }
}

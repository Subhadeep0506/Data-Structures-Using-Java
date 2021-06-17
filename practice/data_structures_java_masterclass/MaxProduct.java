package practice.data_structures_java_masterclass;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        
        int[] array = {4, 2, 12, 5, 7, 11, 2, 6};
        Arrays.sort(array);

        System.out.println("Max product: " + (array[array.length-1] * array[array.length-2]));

    }
}

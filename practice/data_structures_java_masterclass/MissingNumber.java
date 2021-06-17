// This program prints the missing number in a range of numbers

package practice.data_structures_java_masterclass;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {34, 35, 36, 38, 39, 40};

        System.out.println("Missing number: " + missingNumber(array));
    }

    public static int missingNumber(int[] array){

        int expectedSum = ((array[array.length - 1] * (array[array.length - 1] + 1)) / 2) - ((array[0] * (array[0] - 1)) / 2);

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }

        return expectedSum - sum;
    }
}

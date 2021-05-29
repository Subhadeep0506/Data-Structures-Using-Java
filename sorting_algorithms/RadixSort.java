package sorting_algorithms;

public class RadixSort {
    /**
     * 
     * @param array -> Holds  the input array
     * @param radix -> Radix for a decimal number is 10, for binary it's 2, for alphabets it's 26
     * @param width -> stores the no of digits of the largest element
     *                 example... [4725, 4589, 1330, 8792, 1594, 5729] -> width: 4
     *                            [34, 65, 12, 44, 11, 342, 33] -> width: 3
     */
    public void radixSort(int[] array, int radix, int width){

        for(int i = 0; i < width; i++){
            radixSingleSort(array, i, radix);
        }
    }

    public void radixSingleSort(int[] array, int position, int radix){

        int numItems = array.length; // Stored how many items we will be sorting
        int[] countArray = new int[radix]; // Array to hold all numbers 0-9 (as radix == 10)
        /* For every value in array, 
           how many values have certain digit 
           in whatever position we are looking at */
        for(int value : array){
            /* getDigit will return the digit of the value
               example... value: 4725 -> for position: 1, radix: 10, 
               getDigit() will return 2*/
            countArray[getDigit(position, value, radix)]++; // Here, the occurence of the digit is counted
        }
        for(int j = 1; j < radix; j++){
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }
        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            array[tempIndex] = temp[tempIndex];
        }
    }

    private int getDigit(int position, int value, int radix) {
        /**
         * consider 4725
         * at position: 0, method returns digit at ones position i.e here 5
         * at position: 2, method returns digit at hundreds position i.e here 7
         */
        return value / (int) Math.pow(10, position) % radix;
    }

    public static void main(String[] args) {
        int array[] = {4725, 4589, 1330, 8792, 1594, 5729};

        RadixSort obj = new RadixSort();
        obj.radixSort(array, 10, 4);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }    
}

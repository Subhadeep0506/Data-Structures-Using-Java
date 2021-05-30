package Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BubbleSortSwapCount {

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int swapCount = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = 0; j < a.size() - i - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    Collections.swap(a, j, j + 1);
                    swapCount++;
                }
            }
        }
        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a.get(0) + "\n" +
                           "Last Element: " + a.get(a.size() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list elements(enter non-integer to quit listing): ");
        List<Integer> list = new ArrayList<Integer>();

        while(sc.hasNextInt()){
            int i = sc.nextInt();
            list.add(i);
        }

        countSwaps(list);
        sc.close();
    }
}

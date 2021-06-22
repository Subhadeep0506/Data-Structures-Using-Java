/**
 *  Fibonacci Series using Dynamic programming; Top Down Memorization method.
 *  0 1 1 2 3 5 8 12 20...
 *  1 2 3 4 5 6 7 8  9 ...
 */

package practice.data_structures_java_masterclass;

import java.util.HashMap;
import java.util.Scanner;

public class FibonacciTopDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of fibo: ");
        int n = sc.nextInt();
        System.out.println("Fibo: " + fibonacci(n, new HashMap<Integer, Integer>()));
        sc.close();
    }

    public static int fibonacci(int n, HashMap<Integer, Integer> memo){
        
        if(n == 1)
            return 0;
        if(n == 2) 
            return 1;

        if(!memo.containsKey(n)){
            memo.put(n, fibonacci(n - 1, memo) + fibonacci(n - 2, memo));
        }       
        return memo.get(n);
    }
}

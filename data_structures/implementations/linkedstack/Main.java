/**
 *  Program to implement stack and check whether
 *  a input string is palindrome.
 *  TestCase: input-> "abccba" output: true
 *            input-> "I did, did I?" output-> true
 *            input-> "hello" output-> false
 */

package data_structures.implementations.linkedstack;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
        System.out.println(checkForPalindrome("123454329"));
    }

    public static boolean checkForPalindrome(String string) {
        
        //  To hold the lowercase characters from the string
        LinkedList<Character> stack = new LinkedList<Character>();
        //  To store the input string excluding the punctuations
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        //  convering the entire input string to lowercase
        String lowercaseString = string.toLowerCase();

        for(int i = 0; i < lowercaseString.length(); i++){

            char c = lowercaseString.charAt(i);
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversdString = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            reversdString.append(stack.pop());
        }

        return reversdString.toString().equals(stringNoPunctuation.toString());
    }
}

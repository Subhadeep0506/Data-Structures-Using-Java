// Checks whether a String is palindrome using stack and queue

package data_structures.implementations.arrayqueue;

import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        
        Palindrome input = new Palindrome();
        System.out.println(input.checkPalindrome("dad"));
        System.out.println(input.checkPalindrome("I did, did I?"));
        System.out.println(input.checkPalindrome("Racecar"));
        System.out.println(input.checkPalindrome("hello"));
        System.out.println(input.checkPalindrome("Malayalam"));
        System.out.println(input.checkPalindrome("123454321"));
        System.out.println(input.checkPalindrome("325235325"));

    }

    public boolean checkPalindrome(String input){

        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowercase = input.toLowerCase();

        for (int i = 0; i < lowercase.length(); i++){
            char c = lowercase.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
                stack.push(c);
                queue.addLast(c);
            }
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

        return true;
    }
}

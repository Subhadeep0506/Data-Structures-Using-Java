package practice.data_structures_java_masterclass;

public class LongestPalindromicSubstring {
    
    public static void main(String[] args) {
        
    }

    public String longestPalindrome(String s){
        int start = 0, end = 0, maxLen = 1;
        int n = s.length();
        int length[][] = new int[n][n];

        //  each element is a palindrome
        for(int i = 0; i < n; i++){
            length[i][i] = 1;
            maxLen = 1;
            start = end = i;
        }

        //  checks if pairs are palindrome
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                length[i][i + 1] = 2;
                start = i;
                end = i + 1;
                maxLen = 2;
            }
        }
        int k = 2, j = 0, i = 0;
        for(k = 2; k < n; k++){
            for(j = 0; j < n - k; j++){
                i = j + k;
                if(s.charAt(j) == s.charAt(i) && length[j + 1][i - 1] > 0){
                    length[j][i] = length[j + 1][i - 1] + 2;
                }
                if(length[j][i] > maxLen){
                    maxLen = length[j][i];
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}

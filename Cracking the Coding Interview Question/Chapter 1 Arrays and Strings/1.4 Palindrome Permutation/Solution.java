public class Solution {

    public static void main(String[] args) {
        System.out.println(checkPermutationHavePalindrome("Tact coa"));
    }

    public static boolean checkPermutationHavePalindrome(String s) {
        s = s.toLowerCase();
        int[] charset = new int[26]; // a - z
        int checkOdd = 0; // overall pointer
        for (char character : s.toCharArray()) {
            if (character != ' ') {
                int letter = character - 'a'; // get the index of the character // a = 0, b = 1, c = 2...
                charset[letter]++;
                if (charset[letter] % 2 == 1) {
                    checkOdd++;
                } else {
                    checkOdd--;
                }
            }
        }
        return checkOdd <= 1;
        // check if the overall pointer is less than 1 because
        // there might be a case like this abcdcba where d is in the middle but is a
        // true palindrome
    }
}
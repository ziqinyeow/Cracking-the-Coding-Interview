//Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures
//In this solution, I assume that we are using ASCII characters, which contains 256 characters
//If there's a case where we are using Unicode, we might need to increase the characters
public class Solution {

    public static void main(String[] args) {
        System.out.println(isUnique("sfdafdsafda"));
        System.out.println(isUnique("qwerty"));
    }

    public static boolean isUnique(String str) {
        if (str.length() > 256) {
            return false;
        }
        boolean[] charset = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (charset[value]) {
                return false;
            }
            charset[value] = true;
        }
        return true;
    }
}
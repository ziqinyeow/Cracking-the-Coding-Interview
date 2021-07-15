// Given two strings, write a method to decide if one is a permutation of the other.

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(checkPermutation("dsfa", "afsd"));
        System.out.println(checkPermutation("123", "543"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s) {
        char[] c = s.toCharArray();
        java.util.Arrays.sort(c);
        return new String(c);
    }
}

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(checkPermutation("dsfa", "afsd"));
        System.out.println(checkPermutation("123", "543"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charset = new int[128];

        for (char c : s1.toCharArray()) {
            charset[c]++;
        }

        for (char c : s2.toCharArray()) {
            charset[c]--;
            if (charset[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
public class Solution {
    public static void main(String[] args) {
        System.out.println(check("pale", "ple"));
        System.out.println(check("pales", "pale"));
        System.out.println(check("pale", "bale"));
        System.out.println(check("pales", "bake"));
    }

    public static boolean check(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() > second.length() ? first : second;

        int p1 = 0;
        int p2 = 0;
        boolean foundDiff = false;
        while (p2 < s2.length() && p1 < s1.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
                if (s1.length() == s2.length()) {
                    p1++;
                }
            } else {
                p1++;
            }
            p2++;
        }
        return true;
    }
}

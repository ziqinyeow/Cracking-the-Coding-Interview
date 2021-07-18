public class Solution1 {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String s) {
        String res = "";
        char cache = ' '; // Random Symbol
        int count = 1;
        for (char c : s.toCharArray()) {
            if (c == cache) {
                count++;
            } else if (cache != ' ' && c != cache) {
                res += cache + "" + count;
                cache = c;
                count = 1;
            } else {
                cache = c;
            }
        }
        res += cache + "" + count;
        return s.length() == res.length() ? s : res;
    }
}

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aa"));
    }

    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
}

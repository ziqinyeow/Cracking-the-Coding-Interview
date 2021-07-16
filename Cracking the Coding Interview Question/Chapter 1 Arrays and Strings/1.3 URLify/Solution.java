public class Solution {

    public static void main(String[] args) {
        char[] set = "Mr John Smith    ".toCharArray();
        URLify(set, 13);
        System.out.println(set);
    }

    public static void URLify(char[] set, int length) {
        int space = 0, index, i = 0;
        for (i = 0; i < length; i++) {
            if (set[i] == ' ') {
                space++;
            }
        }
        index = length + space * 2;
        if (length < set.length) {
            set[length] = '\0';
        }
        for (i = length - 1; i >= 0; i--) {
            if (set[i] == ' ') {
                set[index - 1] = '0';
                set[index - 2] = '2';
                set[index - 3] = '%';
                index -= 3;
            } else {
                set[index - 1] = set[i];
                index--;
            }
        }
    }
}
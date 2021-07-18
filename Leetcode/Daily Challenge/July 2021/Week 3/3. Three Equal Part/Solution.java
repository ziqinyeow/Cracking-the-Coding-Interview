public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeEqualParts(new int[] { 1, 0, 1, 0, 1 })));
        System.out.println(Arrays.toString(threeEqualParts(new int[] { 1, 1, 0, 1, 1 })));
        System.out.println(Arrays.toString(threeEqualParts(new int[] { 1, 1, 0, 0, 1 })));
    }

    public static int[] threeEqualParts(int[] arr) {
        int ones = 0;
        for (int i : arr) {
            if (i == 1) {
                ones++;
            }
        }

        if (ones == 0) {
            return new int[] { 0, 2 };
        }

        if (ones % 3 != 0) {
            return new int[] { -1, -1 };
        }

        int p1 = 0, p2 = 0, p3 = 0;
        int unit = ones / 3; // number of one in each part
        int oneCounter = 0;

        // this for loop is to get the first occurance of '1' in each part
        // p1 = first occurence of '1' index in part 1 ... etc
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (oneCounter == 0) {
                    p1 = i;
                } else if (oneCounter == unit) {
                    p2 = i;
                } else if (oneCounter == 2 * unit) {
                    p3 = i;
                }
                oneCounter++;
            }
        }

        // move all the pointer to the right based on the pointer part 3
        while (p3 < arr.length) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3]) {
                return new int[] { -1, -1 };
            }
            p1++;
            p2++;
            p3++;
        }
        return new int[] { p1 - 1, p2 };
    }
}

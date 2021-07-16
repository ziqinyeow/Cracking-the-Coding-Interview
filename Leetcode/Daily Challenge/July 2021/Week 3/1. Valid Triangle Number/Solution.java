
// Approach 1: Linear Scan
public class Solution1 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        java.util.Arrays.sort(nums);

        int res = 0;

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}

// Approach 2: Brute Force
public class Solution2 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        java.util.Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

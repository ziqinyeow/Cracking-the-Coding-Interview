class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMAX = 0, rightMAX = 0;
        int res = 0;
        while (left < right) {
            leftMAX = Math.max(leftMAX, height[left]);
            rightMAX = Math.max(rightMAX, height[right]);
            if (leftMAX < rightMAX) {
                res += leftMAX - height[left];
                left++;
            } else {
                res += rightMAX - height[right];
                right--;
            }
        }
        return res;
    }
}
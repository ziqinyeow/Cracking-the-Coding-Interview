https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/

// A peak element is an element that is strictly greater than its neighbors.

// Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞.

// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

// Example 2:
// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

//Approach 1: Linear Search
class Solution1 {
    public int findPeakElement(int[] nums) {
        int max = nums[0];
        int maxIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}

// Approach 2: Binary Search
class Solution2 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// Approach 3: Two pointer
class Solution3 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] > nums[r]) {
                r--;
            } else {
                l++;
            }
        }
        return l;
    }
}

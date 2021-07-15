// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/
// order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

// order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.

// Return any permutation of str (as a string) that satisfies this property.

// Example:
// Input: 
// order = "cba"
// str = "abcd"
// Output: "cbad"
// Explanation: 
// "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
// Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

public class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray())
            count[c - 'a']++;
        StringBuilder ans = new StringBuilder();

        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}

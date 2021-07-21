public class Solution {

    int[] ori;

    public Solution(int[] nums) {
        this.ori = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return ori;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        int[] change = ori.clone();
        Random r = new Random();
        for (int i = 0; i < change.length; i++) {
            int rand = r.nextInt(change.length);
            int temp = change[rand];
            change[rand] = change[i];
            change[i] = temp;
        }
        return change;
    }
}
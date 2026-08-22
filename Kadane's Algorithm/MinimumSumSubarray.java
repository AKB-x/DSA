/**
 * Minimum Subarray Sum
 *
 * Pattern: Kadane's Algorithm
 *
 * Idea:
 * At every element, decide whether to:
 * 1. Start a new subarray from the current element
 * 2. Continue the previous subarray
 *
 * For minimum subarray sum, we use Math.min()
 * instead of Math.max().
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int minSubArray(int[] nums) {

        int currentSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.min(nums[i], currentSum + nums[i]);

            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }
}

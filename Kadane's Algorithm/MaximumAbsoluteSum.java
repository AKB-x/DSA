/**
 * LeetCode 1749 - Maximum Absolute Sum of Any Subarray
 *
 * Pattern:
 * Kadane's Algorithm - Maximum + Minimum Subarray Sum
 *
 * Idea:
 * The maximum absolute sum can come from either:
 *
 * 1. The maximum positive subarray sum
 * 2. The minimum negative subarray sum
 *
 * Therefore, track both maxSum and minSum using Kadane's
 * Algorithm and take the larger absolute value.
 *
 * maxSum:
 * Maximum subarray sum ending at the current index.
 *
 * minSum:
 * Minimum subarray sum ending at the current index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxAbsoluteSum(int[] nums) {

        int maxSum = nums[0];
        int minSum = nums[0];

        // The answer itself is an absolute value.
        int result = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            // Maximum Kadane
            maxSum = Math.max(nums[i],maxSum + nums[i]);

            // Minimum Kadane
            minSum = Math.min(nums[i],minSum + nums[i]);

            // Keep the best answer found anywhere.
            result = Math.max(result,Math.max(Math.abs(maxSum),Math.abs(minSum)));
        }

        return result;
    }
}

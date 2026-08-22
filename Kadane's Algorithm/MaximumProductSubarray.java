/**
 * LeetCode 152 - Maximum Product Subarray
 *
 * Pattern: Kadane's Algorithm - Product Variation
 *
 * Idea:
 * Unlike maximum sum, we must track both the maximum and minimum
 * product ending at the current index.
 *
 * Why?
 * A negative minimum can become a positive maximum when multiplied
 * by another negative number.
 *
 * At every element, there are three possibilities:
 *
 * 1. Start a new subarray:
 *    nums[i]
 *
 * 2. Extend the previous maximum:
 *    nums[i] * prevMax
 *
 * 3. Extend the previous minimum:
 *    nums[i] * prevMin
 *
 * The maximum of these becomes the new maxProduct.
 * The minimum becomes the new minProduct.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int prevMax = maxProduct;
            int prevMin = minProduct;

            maxProduct = Math.max(
                nums[i],
                Math.max(nums[i] * prevMax, nums[i] * prevMin)
            );

            minProduct = Math.min(
                nums[i],
                Math.min(nums[i] * prevMax, nums[i] * prevMin)
            );

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

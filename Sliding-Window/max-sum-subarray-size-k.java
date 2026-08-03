// Problem: Maximum Sum Subarray of Size k
// Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// Pattern: Sliding Window (Fixed)
// Approach
// --------
// 1. Build the first window.
// 2. Store its sum.
// 3. Slide the window:
//    - Remove outgoing element.
//    - Add incoming element.
// 4. Update the answer.

// Invariant
// ---------
// currentSum always stores the sum of the current window.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxSubarraySum(int[] arr, int k) {

        int sum = 0;
        // Build first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;

        // Slide window
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }
}

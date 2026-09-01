/**
 * LeetCode 974 - Subarray Sums Divisible by K
 *
 * Pattern:
 * Prefix Sum + Modulo + HashMap
 *
 * Idea:
 * A subarray sum can be represented as the difference between
 * two prefix sums:
 *
 *     subarraySum = currentPrefix - previousPrefix
 *
 * For the subarray sum to be divisible by k:
 *
 *     (currentPrefix - previousPrefix) % k == 0
 *
 * This happens when both prefix sums have the same remainder:
 *
 *     currentPrefix % k == previousPrefix % k
 *
 * Therefore, store:
 *
 *     remainder -> frequency
 *
 * If the current remainder has appeared before, every previous
 * occurrence represents a valid subarray.
 *
 * We initialize:
 *
 *     0 -> 1
 *
 * because a prefix sum of 0 exists before the array starts.
 *
 * Java can produce negative remainders, so normalize them by
 * adding k when the remainder is negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int currentSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists before the array starts
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            int remainder = currentSum % k;

            // Normalize negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            // Every previous occurrence forms a valid subarray
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            // Store/update frequency of current remainder
            map.put(
                remainder,
                map.getOrDefault(remainder, 0) + 1
            );
        }

        return count;
    }
}

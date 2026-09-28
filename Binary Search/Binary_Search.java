// Problem: Binary Search
// Link: https://leetcode.com/problems/binary-search/

// Pattern: Binary Search (Exact Search)

// Trigger:
// - Array is sorted
// - Need to find a target element
// - Can eliminate half of the search space using the middle element

// Approach:
// - Initialize low at the beginning and high at the end
// - Calculate the middle index
// - If nums[mid] == target → return mid
// - If target > nums[mid] → search the right half
// - If target < nums[mid] → search the left half
// - If the target is not found, return -1

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Key Insight:
// - Each comparison eliminates half of the remaining search space
// - low = mid + 1 eliminates the left half
// - high = mid - 1 eliminates the right half
// - mid = low + (high - low) / 2 avoids integer overflow

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

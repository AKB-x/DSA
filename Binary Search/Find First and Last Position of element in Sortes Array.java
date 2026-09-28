// Problem: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Pattern: Binary Search (Boundary)

// Trigger:
// - Sorted array
// - Find the first and last occurrence of a target
// - Target may appear multiple times

// Approach:
// - Use Binary Search separately for first and last occurrence
// - For first occurrence, store mid and search left
// - For last occurrence, store mid and search right
// - Return both positions as an array

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Key Insight:
// - First occurrence → nums[mid] == target → move high = mid - 1
// - Last occurrence → nums[mid] == target → move low = mid + 1
// - Do not return immediately when target is found
// - res stores the latest valid boundary position

class Solution {

    public int firstPosition(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return res;
    }

    public int lastPosition(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int ans1 = firstPosition(nums, target);
        int ans2 = lastPosition(nums, target);

        return new int[]{ans1, ans2};
    }
}

// Problem: Peak Index in a Mountain Array
// Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

// Pattern: Binary Search (Peak / Slope)

// Trigger:
// - Mountain array
// - Array first increases and then decreases
// - Need to find the index of the peak element

// Approach:
// - Search only from index 1 to n - 2 because the peak cannot be at the boundaries
// - Check if arr[mid] is greater than both neighbors
// - If arr[mid] < arr[mid + 1], we are going uphill → move right
// - Otherwise, we are going downhill → move left
// - Return -1 if the peak is not found

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Key Insight:
// - Peak → arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]
// - Uphill → peak is on the right
// - Downhill → peak is on the left
// - low = 1 and high = n - 2 keep mid safe for checking both neighbors

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

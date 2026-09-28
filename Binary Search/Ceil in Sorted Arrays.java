// Problem: Find Ceil of an Integer in a Sorted Array
// Link: https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1

// Pattern: Binary Search (Lower Bound)

// Trigger:
// - Sorted array
// - Find the smallest element that is greater than or equal to x
// - Need the first index satisfying arr[i] >= x

// Approach:
// - Initialize low and high to define the search space
// - If arr[mid] >= x, mid is a valid ceil candidate
// - Store mid as the answer and search left for an earlier valid index
// - If arr[mid] < x, search the right half
// - Return the stored answer

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Key Insight:
// - Lower Bound = first index where arr[i] >= x
// - Valid candidate → save answer → move left
// - Invalid candidate → move right
// - The search is for the False → True transition

class Solution {
    public int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}

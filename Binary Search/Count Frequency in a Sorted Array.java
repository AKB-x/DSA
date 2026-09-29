// Problem: Count Frequency in a Sorted Array
// Link: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

// Pattern: Binary Search (First & Last Occurrence)

// Trigger:
// - Sorted array
// - Need to find how many times a target occurs
// - Target may appear multiple times

// Approach:
// - Find the first occurrence of the target using Binary Search
// - When target is found, store mid and search left
// - Find the last occurrence using Binary Search
// - When target is found, store mid and search right
// - If first occurrence is -1, target does not exist → return 0
// - Otherwise, frequency = last - first + 1

// Time Complexity: O(log n)
// Space Complexity: O(1)

// Key Insight:
// - First occurrence gives the left boundary of the target
// - Last occurrence gives the right boundary of the target
// - Number of occurrences = last - first + 1
// - first == -1 means the target was not found
// - Binary Search finds the boundaries instead of counting individual occurrences

class Solution {

    int firstOccur(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int res1 = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                res1 = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return res1;
    }

    int lastOccur(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int res2 = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                res2 = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return res2;
    }

    int countFreq(int[] arr, int target) {
        int first = firstOccur(arr, target);

        if (first == -1) {
            return 0;
        }

        int last = lastOccur(arr, target);

        return last - first + 1;
    }
}

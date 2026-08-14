/**
 * LeetCode 202 - Happy Number
 *
 * Pattern: Fast & Slow Pointers
 *
 * Approach:
 * Treat the sequence of transformed numbers as a virtual linked list.
 *
 * - getNext(n) calculates the sum of squares of the digits.
 * - slow moves one generated number at a time.
 * - fast moves two generated numbers at a time.
 * - If fast reaches 1, the number is happy.
 * - If slow and fast meet before reaching 1, a cycle exists.
 *
 * Time Complexity: O(log n) per transformation
 * Space Complexity: O(1)
 */

class Solution {

    public int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while (true) {

            slow = getNext(slow);
            fast = getNext(getNext(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                return false;
            }
        }
    }
}

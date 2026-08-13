/**
 * LeetCode 141 - Linked List Cycle
 *
 * Pattern: Fast & Slow Pointers
 *
 * Approach:
 * - Slow moves one step at a time.
 * - Fast moves two steps at a time.
 * - If a cycle exists, fast will eventually meet slow.
 * - If fast reaches null, there is no cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

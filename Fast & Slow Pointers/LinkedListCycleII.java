/**
 * LeetCode 142 - Linked List Cycle II
 *
 * Pattern: Fast & Slow Pointers
 *
 * Approach:
 * Phase 1:
 * - Slow moves one step.
 * - Fast moves two steps.
 * - If they meet, a cycle exists.
 *
 * Phase 2:
 * - Reset slow to head.
 * - Keep fast at the meeting point.
 * - Move both one step at a time.
 * - Their next meeting point is the cycle entrance.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Phase 2: Find the cycle entrance
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}

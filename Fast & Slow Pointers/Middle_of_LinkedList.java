/**
 * LeetCode 876 - Middle of the Linked List
 *
 * Pattern: Fast & Slow Pointers
 *
 * Approach:
 * Slow moves one step while fast moves two steps.
 * When fast reaches the end, slow is at the middle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

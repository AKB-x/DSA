/**
 * LeetCode 143 - Reorder List
 *
 * Pattern: Fast & Slow Pointers + Linked List Reversal + Two-Pointer Merge
 *
 * Approach:
 * 1. Find the middle of the linked list using slow and fast pointers.
 * 2. Split the list into two halves.
 * 3. Reverse the second half.
 * 4. Merge the two halves alternately.
 *
 * Example:
 * 1 → 2 → 3 → 4 → 5
 *
 * becomes:
 * 1 → 5 → 2 → 4 → 3
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public void reorderList(ListNode head) {

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the list
        ListNode second = slow.next;
        slow.next = null;

        // 3. Reverse the second half
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // 4. Merge both halves alternately
        ListNode first = head;
        second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}

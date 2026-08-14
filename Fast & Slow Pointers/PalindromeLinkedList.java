/**
 * LeetCode 234 - Palindrome Linked List
 *
 * Pattern: Fast & Slow Pointers + Linked List Reversal
 *
 * Approach:
 * 1. Use slow and fast pointers to find the middle of the list.
 * 2. Reverse the second half of the linked list.
 * 3. Compare the first half with the reversed second half.
 *
 * If any corresponding values are different, the list is not
 * a palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isPalindrome(ListNode head) {

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // 3. Compare both halves
        ListNode left = head;
        ListNode right = prev;

        while (right != null) {

            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}

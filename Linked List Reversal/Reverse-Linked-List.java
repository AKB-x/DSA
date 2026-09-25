// Problem: Reverse Linked List
// Link: https://leetcode.com/problems/reverse-linked-list/

// Pattern: In-Place Pointer Reversal

// Trigger:
// - Linked List problem
// - Need to reverse the direction of links
// - Reverse entire list

// Approach:
// - Use three pointers: prev, curr, next
// - Store curr.next before changing the link
// - Point curr.next to prev to reverse the link
// - Move prev and curr forward
// - Continue until curr becomes null
// - prev becomes the new head

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Always save curr.next before reversing the pointer
// - prev represents the already reversed portion
// - curr represents the remaining portion
// - At the end, prev is the new head

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}

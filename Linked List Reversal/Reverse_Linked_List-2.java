// Problem: Reverse Linked List II
// Link: https://leetcode.com/problems/reverse-linked-list-ii/

// Pattern: In-Place Pointer Reversal (Range)

// Trigger:
// - Linked List problem
// - Reverse only a specific range [left, right]
// - Remaining nodes must stay unchanged

// Approach:
// - Traverse to the left position using t and pos
// - Keep the node before the reversal range
// - Reverse exactly (right - left + 1) nodes
// - Connect the original start node to the node after the reversed range
// - Connect before to the new head of the reversed range
// - If left == 1, prev becomes the new head

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Range reversal uses the same pointer reversal as Reverse Linked List
// - times = right - left + 1 controls how many nodes are reversed
// - before is needed to reconnect the left side
// - t becomes the tail of the reversed portion, so t.next = curr reconnects the right side
// - If before == null, the reversed portion starts at the head and prev is the new head

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        if (head == null || left == right) {
            return head;
        }

        while (t != null) {
            if (pos < left) {
                before = t;
                t = t.next;
                pos++;
                continue;
            }

            ListNode curr = t;
            ListNode prev = null;
            int times = right - left + 1;

            while (times-- > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            t.next = curr;

            if (before != null) {
                before.next = prev;
                return head;
            } else {
                return prev;
            }
        }

        return head;
    }
}

// Problem: Reverse Nodes in K-Group
// Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

// Pattern: In-Place Pointer Reversal (Fixed Size K)

// Trigger:
// - Linked List problem
// - Reverse nodes in groups of k
// - Remaining nodes with less than k nodes stay unchanged

// Approach:
// - Use left as the start of the current group
// - Move right to the kth node
// - If kth node does not exist → keep remaining nodes unchanged
// - Save the node after the current group in nextLeft
// - Reverse exactly k nodes
// - Connect the previous group to the new head of the current group
// - Update prevLeft to the tail of the reversed group
// - Move left to the next group

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - The original left becomes the tail after reversal
// - right becomes the new head of the reversed group
// - prevLeft connects the previous group to the current group
// - nextLeft saves the remaining list before reversal
// - Swap Nodes in Pairs is the same pattern with k = 2

class Solution {
    public void reverse(ListNode head, int size) {
        ListNode prev = null;
        ListNode curr = head;

        while (size > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size--;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left = head;
        ListNode prevLeft = null;
        ListNode nextLeft = null;
        int size = k;
        ListNode right;
        ListNode res = null;

        while (left != null) {
            right = left;

            for (int i = 0; i < size - 1; i++) {
                if (right != null) {
                    right = right.next;
                } else {
                    break;
                }
            }

            if (right != null) {
                nextLeft = right.next;

                reverse(left, size);

                if (prevLeft != null) {
                    prevLeft.next = right;
                }

                if (res == null) {
                    res = right;
                }

                prevLeft = left;
                left = nextLeft;
            } else {
                if (prevLeft != null) {
                    prevLeft.next = left;
                } else {
                    res = left;
                }

                break;
            }
        }

        return res;
    }
}

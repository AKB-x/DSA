// Problem: Rotate List
// Link: https://leetcode.com/problems/rotate-list/

// Pattern: Linked List Rotation (Circular Connection)

// Trigger:
// - Rotate a linked list to the right by k positions
// - Nodes are shifted without changing their relative order
// - Useful to connect the last node to the head and cut at the new tail

// Approach:
// - Traverse the list to find its length and last node
// - Reduce k using k % n
// - If k == 0, return head
// - Find the new tail at position (n - k)
// - Connect the last node to the head to make the list circular
// - Store new head as end.next
// - Break the circular connection using end.next = null

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Rotating right by k means the last k nodes become the first k nodes
// - New tail is at position (n - k)
// - Making the list circular avoids moving nodes individually
// - end.next gives the new head before breaking the circle

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        int n = 1;
        ListNode last = head;

        while(last.next != null){
            n++;
            last = last.next;
        }

        k = k % n;

        if(k == 0){
            return head;
        }

        ListNode end = head;

        for(int i = 1; i < n-k; i++){
            end = end.next;
        }

        last.next = head;

        ListNode res = end.next;

        end.next = null;

        return res;
    }
}

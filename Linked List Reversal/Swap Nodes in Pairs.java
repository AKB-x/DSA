// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/

// Pattern: In-Place Pointer Reversal (Fixed Size = 2)

// Trigger:
// - Linked List problem
// - Swap every two adjacent nodes
// - Last node remains unchanged if the list has odd length

// Approach:
// - Use left as the start of the current pair
// - Move right to the second node of the pair
// - If right is null, one node remains → keep it unchanged
// - Save the node after the pair in nextLeft
// - Reverse exactly 2 nodes
// - Connect the previous pair to the current pair
// - Update prevLeft and left to move to the next pair
// - Store right as the new head of the first reversed pair

// Time Complexity: O(n)
// Space Complexity: O(1)

// Key Insight:
// - Each pair is a fixed-size reversal of 2 nodes
// - right becomes the new head after reversal
// - left becomes the tail of the reversed pair
// - prevLeft connects the previous pair to the current pair
// - If one node remains, connect it without reversing
        


class Solution {
    public void reverse(ListNode head,int size){
        ListNode prev=null;
        ListNode curr=head;
        while(size>0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            size--;
        }
        return;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode prevLeft=null;
        ListNode left=head;
        ListNode right;
        int size=2;
        ListNode nextLeft=null;
        ListNode res=null;
        if(head==null){
            return null;
        }
        while(left!=null){
            // right to be start on the left
            right=left;
            //to find the right until where the reverse had to be done
            for(int i=0;i<size-1;i++){ // right will be always one back the limit
                if(right==null){
                    break;
                }else{
                    right=right.next;
                }
            }
            // we found a valid right
            if(right!=null){
                nextLeft=right.next;
                reverse(left,2);
                if(prevLeft==null){  //first or pair
                    prevLeft=left;
                    left=nextLeft;
                }else{                // other pairs making connection with the prevleft
                    prevLeft.next=right;
                    prevLeft=left;
                    left=nextLeft;
                }
                if(res==null){  // the right becomes head
                    res=right;
                }
            }
            //right not found
            else{
                //first pair or fist node
                if(prevLeft==null){
                    res=left;
                    break;
                }
                //lasat node
                else{
                    prevLeft.next=left; // no reverse for the last node 
                }
            break;
            }
        }
        return res;
    }
}

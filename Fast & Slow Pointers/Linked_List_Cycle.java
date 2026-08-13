# 🔄 Linked List Cycle

## 📌 Problem

Given the head of a linked list, determine whether the linked list contains a cycle.

A cycle exists when a node's `next` pointer points to a previously visited node.

---

## 🧩 Pattern

**Fast & Slow Pointers (Floyd's Cycle Detection)**

---

## 💡 Approach

### Brute Force

Use a `HashSet` to store every visited node.

- If the current node already exists in the set → cycle exists.
- If we reach `null` → no cycle.

**Time:** `O(n)`  
**Space:** `O(n)`

### Optimized — Fast & Slow Pointers

Use two pointers:

- `slow` moves **1 step**
- `fast` moves **2 steps**

If a cycle exists, once both pointers enter the cycle, `fast` gains one position on `slow` every iteration and eventually catches it.

If `fast` reaches `null`, there is no cycle.

---

## 🧠 Algorithm

1. Initialize `slow` and `fast` at `head`.
2. Move `slow` by one node.
3. Move `fast` by two nodes.
4. If `slow == fast`, a cycle exists.
5. If `fast == null` or `fast.next == null`, no cycle exists.

---

## 💻 Java

```java
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

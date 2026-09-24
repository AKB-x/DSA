# 🔄 In-Place Pointer Reversal

## Pattern Overview

**In-Place Pointer Reversal** is a Linked List pattern where we manipulate node pointers directly to reverse the direction of links without using an additional data structure.

The fundamental idea is:

> **Save → Reverse → Move**

Once the basic reversal is understood, the same pointer technique can be extended to:

* Reverse an entire linked list
* Reverse a sublist / range
* Reverse nodes in groups of `k`
* Reverse alternate groups
* Reverse a linked list recursively
* Reorder a linked list
* Find and manipulate palindromic linked-list structures

---

# 🧠 Core Concept

For a singly linked list:

```text
1 → 2 → 3 → 4 → 5 → null
```

Reversal means changing:

```text
1 → 2
```

into:

```text
2 → 1
```

The core pointer relationship is:

```text
prev ← curr → next
```

At every iteration:

```text
1. Save next
2. Reverse curr.next
3. Move prev
4. Move curr
```

---

# 🔑 Master Template

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    // Save
    ListNode next = curr.next;

    // Reverse
    curr.next = prev;

    // Move
    prev = curr;
    curr = next;
}

return prev;
```

### Mental Model

```text
Save → Reverse → Move → Move
```

### Critical Rule

Always save:

```java
ListNode next = curr.next;
```

**before**:

```java
curr.next = prev;
```

Otherwise, the remaining list can be lost.

---

# 1️⃣ Full Linked List Reversal

### Problem

Reverse the entire linked list.

```text
Before:

1 → 2 → 3 → 4 → null

After:

4 → 3 → 2 → 1 → null
```

### Template

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}

return prev;
```

### Complexity

```text
Time:  O(n)
Space: O(1)
```

### Classic Problem

**Reverse Linked List**

---

# 2️⃣ Reverse a Range / Sublist

### Pattern

Reverse only nodes between positions:

```text
left ... right
```

Example:

```text
1 → 2 → 3 → 4 → 5
    └─────────┘
       reverse

1 → 4 → 3 → 2 → 5
```

The important difference from full reversal is that we must reconnect the reversed section with the unchanged parts.

---

## 🧩 Key Pointers

Usually maintain:

```text
dummy
before
curr
prev
next
```

Conceptually:

```text
before → [sublist to reverse] → after
```

After reversal:

```text
before → [reversed sublist] → after
```

---

## Template

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode before = dummy;

// Move before to node before left
for (int i = 1; i < left; i++) {
    before = before.next;
}

ListNode curr = before.next;
ListNode prev = null;

// Reverse left → right
for (int i = 0; i < right - left + 1; i++) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}

// Reconnect the list
ListNode tail = before.next;

before.next = prev;
tail.next = curr;

return dummy.next;
```

### Core Idea

The reversal mechanism is **exactly the same** as full reversal.

The difference is:

> **Reverse only a controlled number of nodes and reconnect both ends.**

### Classic Problem

**Reverse Linked List II**

---

# 3️⃣ Reverse Nodes in Groups of K

### Pattern

Reverse the linked list in groups of `k`.

Example:

```text
Input:

1 → 2 → 3 → 4 → 5 → 6 → 7 → 8

k = 3
```

Output:

```text
3 → 2 → 1 → 6 → 5 → 4 → 7 → 8
```

The last incomplete group remains unchanged.

---

## 🧠 Key Idea

Instead of reversing the entire list:

```text
Reverse → Reverse → Reverse → ...
```

we:

```text
Find k nodes
      ↓
Reverse those k nodes
      ↓
Reconnect
      ↓
Move to next group
```

---

## Conceptual Structure

```text
groupPrev
    ↓
1 → 2 → 3 → 4 → 5 → 6 → 7
    └──────┘
      group
```

After reversal:

```text
groupPrev → 3 → 2 → 1 → 4 → 5 → 6 → 7
```

Then continue with:

```text
                4 → 5 → 6
                └──────┘
```

---

## Template

A common iterative structure:

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode groupPrev = dummy;

while (true) {

    // Find kth node
    ListNode kth = getKthNode(groupPrev, k);

    if (kth == null) {
        break;
    }

    ListNode groupNext = kth.next;

    // Reverse group
    ListNode prev = groupNext;
    ListNode curr = groupPrev.next;

    while (curr != groupNext) {

        ListNode next = curr.next;

        curr.next = prev;

        prev = curr;
        curr = next;
    }

    // Reconnect
    ListNode oldGroupHead = groupPrev.next;

    groupPrev.next = kth;

    groupPrev = oldGroupHead;
}

return dummy.next;
```

### Key Difference

For normal reversal:

```text
reverse until curr == null
```

For k-group reversal:

```text
reverse until curr == groupNext
```

This allows the reversal to be restricted to one segment.

---

# 4️⃣ Recursive Reversal

The same pattern can also be implemented recursively.

### Idea

Reverse the rest of the list first.

```text
1 → 2 → 3 → 4 → null
```

Recursively reach:

```text
4
```

Then while returning:

```text
4 ← 3 ← 2 ← 1
```

### Template

```java
public ListNode reverseList(ListNode head) {

    if (head == null || head.next == null) {
        return head;
    }

    ListNode newHead = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return newHead;
}
```

### Complexity

```text
Time:  O(n)
Space: O(n)
```

The `O(n)` space comes from the recursion stack.

---

# 5️⃣ Reorder List

The In-Place Pointer Reversal pattern is also a major component of **Reorder List**.

Example:

```text
1 → 2 → 3 → 4 → 5
```

becomes:

```text
1 → 5 → 2 → 4 → 3
```

This problem combines multiple Linked List patterns:

```text
Find Middle
     ↓
Reverse Second Half
     ↓
Merge Two Lists
```

The reversal portion uses:

```text
prev → curr → next
```

---

# 6️⃣ Palindrome Linked List

Example:

```text
1 → 2 → 3 → 2 → 1
```

A common `O(1)` extra-space approach:

```text
Find middle
     ↓
Reverse second half
     ↓
Compare both halves
```

Again, the reversal step uses the same:

```text
Save → Reverse → Move
```

pattern.

---

# 🧠 Pattern Recognition

When you see a Linked List problem involving:

### Full reversal

```text
Reverse entire list
```

Think:

> **Basic Pointer Reversal**

---

### Range reversal

```text
Reverse from left to right
```

Think:

> **Bounded Pointer Reversal + Reconnection**

---

### K-group reversal

```text
Reverse every k nodes
```

Think:

> **Segmented Pointer Reversal**

---

### Palindrome

```text
Compare first half with second half
```

Think:

> **Middle + Pointer Reversal**

---

### Reorder List

```text
First + Last + Second + Second Last...
```

Think:

> **Middle + Reverse + Merge**

---

# 🔗 Pattern Family

```text
             IN-PLACE POINTER REVERSAL
                       │
        ┌──────────────┼──────────────┐
        ↓              ↓              ↓
   Full Reverse   Range Reverse   K-Group
        │              │              │
        ↓              ↓              ↓
 Reverse List    Reverse List II   Reverse Nodes
                                  in K-Group
        │
        ├───────────────┐
        ↓               ↓
   Palindrome       Reorder List
        │               │
        └───────┬───────┘
                ↓
        Reverse Second Half
```

---

# ⚠️ Common Mistakes

### 1. Not saving `next`

❌

```java
curr.next = prev;
curr = curr.next;
```

The original next node is lost.

✅

```java
ListNode next = curr.next;
curr.next = prev;
curr = next;
```

---

### 2. Returning the old head

After reversal:

```text
Old head → Tail
New head → prev
```

Therefore:

```java
return prev;
```

---

### 3. Forgetting reconnection

For partial reversals, reversing the pointers is only half the problem.

You must reconnect:

```text
unchanged → reversed section → unchanged
```

---

### 4. Losing the boundary

For range/k-group problems, always identify:

```text
before
start
end
after
```

before modifying links.

---

# 🧪 Complexity Reference

| Variant                   |   Time |      Extra Space |
| ------------------------- | -----: | ---------------: |
| Full reversal             | `O(n)` |           `O(1)` |
| Range reversal            | `O(n)` |           `O(1)` |
| K-group reversal          | `O(n)` | `O(1)` iterative |
| Recursive reversal        | `O(n)` |           `O(n)` |
| Palindrome using reversal | `O(n)` |           `O(1)` |
| Reorder List              | `O(n)` |           `O(1)` |

---

# 🎯 Interview Checklist

Before coding, identify:

```text
1. What portion needs to be reversed?
2. Where does the reversal start?
3. Where does it end?
4. What node comes before the reversed section?
5. What node comes after it?
6. How will I reconnect both sides?
```

For every reversal operation:

```text
        prev
          ↓
null ← previous ← curr → next
                    │
                    └── save first
```

Then:

```text
next = curr.next
curr.next = prev
prev = curr
curr = next
```

---

# 🧠 Ultimate Mental Model

Don't memorize separate solutions for every reversal problem.

Understand this:

```text
             curr
              ↓
prev ← curr → next
```

Then:

```text
1. Save next
2. Point curr backward
3. Move prev
4. Move curr
```

Everything else is about **controlling the boundaries and reconnecting the pieces**.

> **Basic reversal is the building block.
> Range reversal controls the boundaries.
> K-group reversal repeats the same operation on segments.
> Complex Linked List problems combine reversal with other patterns.**

---

# 📚 Core Problems for This Pattern

| Problem                             | Variant           | Difficulty |
| ----------------------------------- | ----------------- | ---------- |
| Reverse Linked List                 | Full reversal     | Easy       |
| Reverse Linked List II              | Range reversal    | Medium     |
| Reverse Nodes in k-Group            | K-group reversal  | Hard       |
| Palindrome Linked List              | Reverse + Compare | Easy       |
| Reorder List                        | Reverse + Merge   | Medium     |
| Swap Nodes in Pairs                 | Local reversal    | Medium     |
| Reverse Nodes in Even Length Groups | Group reversal    | Medium     |

---

## ✅ Pattern Completion Checklist

* [ ] Understand `prev / curr / next`
* [ ] Implement full reversal
* [ ] Understand pointer reconnection
* [ ] Implement range reversal
* [ ] Implement k-group reversal
* [ ] Understand recursive reversal
* [ ] Recognize reversal inside Palindrome Linked List
* [ ] Recognize reversal inside Reorder List
* [ ] Recognize when a dummy node simplifies reconnection

### Pattern Status

**🟢 Core Pattern — Completed**

**Next level:** Apply the pattern to **Reverse Linked List II → Reorder List → Palindrome Linked List → Reverse Nodes in k-Group**.

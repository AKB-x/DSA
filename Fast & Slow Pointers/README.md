# 🐢🐇 Fast & Slow Pointers Pattern

## 📌 Description

Fast & Slow Pointers is a pointer technique where two pointers traverse a data structure at **different speeds**.

Typically:

- `slow` moves **1 step**
- `fast` moves **2 steps**

The difference in their speeds creates a **relative movement** that can reveal structural properties of the data structure.

The pattern is most commonly associated with **Linked Lists**, especially for:

- Cycle detection
- Finding the middle of a linked list
- Finding the beginning of a cycle
- Detecting repeated states
- Problems involving relative positions

---

# 🎯 When to Use

Consider Fast & Slow Pointers when a problem involves:

- Linked Lists
- Cycles / loops
- Circular structures
- Finding the middle
- Finding a cycle's starting point
- Repeated states
- O(1) extra space requirements
- Traversing a structure without storing visited elements

### 🚨 Strong Trigger

> **Linked List + Cycle / Loop / Repetition + O(1) extra space**

→ Immediately consider **Fast & Slow Pointers**.

---

# 🧠 Core Idea

Instead of using extra memory to remember visited nodes or positions, use two pointers moving at different speeds.

```text
slow → 1 step
fast → 2 steps

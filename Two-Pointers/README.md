# 🔥 Two Pointers Pattern

> **"Don't memorize pointer movement. Understand why a pointer is allowed to move."**

---

# 📖 Description

The **Two Pointers** pattern is a family of techniques that uses **two indices (pointers)** to efficiently process arrays, strings, or linked lists.

Instead of checking every possible combination, the pointers move according to well-defined **invariants**, eliminating impossible solutions and often reducing an **O(n²)** brute-force solution to **O(n)**.

> **Key Idea:** Two Pointers is **not one algorithm**. It is a collection of strategies where pointer movement depends entirely on the problem's constraints.

---

# 🎯 When to Use

Look for this pattern when the problem involves:

- Arrays or strings
- Sorted arrays
- Pair, triplet, or target sum
- Palindromes
- In-place modification
- Reverse traversal
- Partitioning elements
- Comparing two sequences
- Eliminating unnecessary comparisons

---

# ⚡ Variations

## 1️⃣ Opposite Direction

Two pointers start from opposite ends and move toward each other.

### Used When

- Sorted arrays
- Palindrome checking
- Pair searching

### Examples

- Valid Palindrome
- Two Sum II
- Squares of a Sorted Array

```text
left --->       <--- right
```

---

## 2️⃣ Same Direction (Fast & Slow)

Both pointers move forward.

One pointer usually scans.

The other builds the answer.

### Used When

- In-place modification
- Stable partitioning
- Filtering elements

### Examples

- Remove Duplicates
- Move Zeroes

```text
slow --->
fast ------->
```

---

## 3️⃣ Greedy Pointer Movement

Move the pointer whose current position can never produce a better answer.

### Used When

- Search space can be safely reduced

### Example

- Container With Most Water

---

## 4️⃣ Reduction Pattern

Reduce a larger problem into a smaller one.

Fix one (or more) element(s).

Solve the remaining problem using Two Pointers.

### Examples

- 3Sum
- 4Sum

---

## 5️⃣ Reverse Traversal

Traverse from right to left.

Maintain additional state.

Usually a Skip Counter.

### Example

- Backspace String Compare

---

## 6️⃣ Bidirectional Boundary Processing

Maintain information from both ends.

Process whichever side is already determined.

### Example

- Trapping Rain Water

---

# 🧩 Templates

## Opposite Direction

```java
int left = 0;
int right = n - 1;

while (left < right) {

    // Process

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

---

## Same Direction (Fast & Slow)

```java
int slow = 0;

for (int fast = 0; fast < n; fast++) {

    if (condition) {

        // Update answer

        slow++;
    }
}
```

---

## Greedy Pointer Movement

```java
while (left < right) {

    updateAnswer();

    if (leftSideCannotImproveAnswer) {
        left++;
    } else {
        right--;
    }
}
```

---

## Reduction Pattern

```java
for (int i = 0; i < n; i++) {

    int left = i + 1;
    int right = n - 1;

    while (left < right) {

        // Process

        // Move pointers
    }
}
```

---

## Reverse Traversal

```java
int i = s.length() - 1;
int j = t.length() - 1;

while (i >= 0 || j >= 0) {

    // Skip invalid characters

    // Compare

    // Move pointers
}
```

---

## Bidirectional Boundary Processing

```java
int left = 0;
int right = n - 1;

int leftMax = 0;
int rightMax = 0;

while (left < right) {

    if (height[left] <= height[right]) {

        leftMax = Math.max(leftMax, height[left]);

        // Process left

        left++;

    } else {

        rightMax = Math.max(rightMax, height[right]);

        // Process right

        right--;
    }
}
```

---

# 🧠 Thinking Process

Before writing a single line of code, answer these questions.

## Step 1

Why is Two Pointers appropriate?

---

## Step 2

Which variation am I using?

- Opposite Direction?
- Fast & Slow?
- Greedy?
- Reduction?
- Reverse Traversal?
- Boundary Processing?

---

## Step 3

What does each pointer represent?

Examples:

- Current candidate
- Search boundary
- Read pointer
- Write pointer
- Window boundary
- Previous valid character

---

## Step 4

What invariant always remains true?

Examples:

- Left side already processed
- Elements before slow are correct
- Water trapped so far is correct
- Characters before pointer are finalized

---

## Step 5

Why can this pointer move safely?

This is the most important question.

Never move a pointer because it "feels right."

Move it only when you can prove its current position cannot contribute to a better answer.

---

## Step 6

When does the algorithm stop?

---

# 📂 Problems Covered

| Problem | Pattern | Key Learning |
|---------|---------|--------------|
| ✅ Valid Palindrome | Opposite Direction | Compare while converging inward |
| ✅ Two Sum II | Opposite Direction (Sorted Search) | Eliminate search space using sorted order |
| ✅ Remove Duplicates from Sorted Array | Fast & Slow | In-place overwrite |
| ✅ Move Zeroes | Fast &Slow | Stable element movement |
| ✅ Squares of a Sorted Array | Opposite Direction | Compare absolute values |
| ✅ Sort Colors | Multi-Pointer Partitioning (Dutch National Flag) | Three-way partitioning |
| ✅ Container With Most Water | Greedy Pointer Movement | Eliminate impossible candidates |
| ✅ Trapping Rain Water | Bidirectional Boundary Processing | Maintain left/right maximums |
| ✅ 3Sum | Reduction + Duplicate Handling | Fix one element, solve Two Sum |
| ✅ 4Sum | Nested Reduction | Extend the reduction pattern |
| ✅ Backspace String Compare | Reverse Traversal + Skip Counter | Traverse backwards while skipping invalid characters |

---

# 📈 Pattern Progression

```
Valid Palindrome
        ↓
Two Sum II
        ↓
Remove Duplicates
        ↓
Move Zeroes
        ↓
Squares of a Sorted Array
        ↓
Sort Colors
        ↓
Container With Most Water
        ↓
Trapping Rain Water
        ↓
3Sum
        ↓
4Sum
        ↓
Backspace String Compare
```

Every new problem should teach a **new variation**, not just another implementation.

---

# ⚠️ Common Mistakes

- Memorizing pointer movement.
- Forgetting the invariant.
- Moving pointers without proof.
- Ignoring edge cases.
- Mixing different variations.
- Trying to force every problem into the same template.

---

# ✅ Revision Checklist

Can I answer these without looking at the solution?

- Why is Two Pointers the correct pattern?
- Which variation is being used?
- What does each pointer represent?
- What invariant is maintained?
- Why is every pointer movement correct?
- Can I derive the solution from scratch?
- Can I explain it in an interview?

---

# 🎤 Interview Questions

- Why is Two Pointers better than brute force?
- What invariant does your algorithm maintain?
- Why is moving this pointer safe?
- Which variation of Two Pointers is this?
- Can this problem be solved without sorting?
- What changes if the array is unsorted?
- Can the same idea be generalized to 3Sum or 4Sum?
- What's the time and space complexity?

---

# 🚀 Key Insight

> **Don't memorize solutions. Master pointer movement.**

Every Two Pointer problem eventually reduces to four questions:

1. What does each pointer represent?
2. What information is maintained?
3. Why can a pointer move safely?
4. What invariant guarantees correctness?

If you can answer these four questions, you won't need to memorize implementations—you'll be able to derive them naturally.

---

## 🔗 Related Patterns

- Sliding Window (extends Fast & Slow with a dynamic range)
- Binary Search (also reduces search space, but differently)
- Prefix Sum (often combined with Two Pointers)
- Monotonic Stack (another way to eliminate unnecessary comparisons)

---

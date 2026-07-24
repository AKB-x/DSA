# 🔥 Two Pointers Pattern

## 📌 Description

Two Pointers is a technique that uses **two indices to process an array or string efficiently**. Instead of checking every possible combination, the pointers move based on a condition, eliminating impossible solutions and often reducing an **O(n²)** brute-force approach to **O(n)**.

---

## 🎯 When to Use

* Array or string problems
* Sorted arrays
* Pair or target sum problems
* Palindrome problems
* In-place array modification
* Need to eliminate unnecessary comparisons
* Reverse traversal or deletion-based string problems

---

## ⚡ Types

### 1. Opposite Direction

* One pointer starts at the beginning.
* One pointer starts at the end.
* Both pointers move toward each other.

**Examples**

* Valid Palindrome
* Two Sum II

```text
left --->       <--- right
```

---

### 2. Same Direction (Fast & Slow)

* Both pointers move in the same direction.
* One pointer usually lags behind.
* Commonly used for filtering or in-place modification.

**Examples**

* Remove Duplicates from Sorted Array
* Move Zeroes

```text
slow --->
fast ------->
```

---

### 3. Greedy Pointer Movement

* Pointer movement is based on eliminating impossible answers.
* Every move is backed by reasoning.

**Example**

* Container With Most Water

---

### 4. Reduction Pattern

* Reduce a larger problem into a smaller one.
* Fix one element and solve the remaining part using Two Pointers.

**Examples**

* 3Sum
* 4Sum

---

### 5. Reverse Traversal

* Traverse from right to left.
* Maintain additional state (Skip Counter).
* Useful when future operations affect previous characters.

**Example**

* Backspace String Compare

---

## 🧠 Template

### Opposite Direction

```java
int left = 0;
int right = n - 1;

while (left < right) {

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

---

## 🧠 Thinking Process

Before writing code, ask yourself:

1. Why do I need two pointers?
2. What does each pointer represent?
3. What invariant should always remain true?
4. When can I safely move a pointer?
5. Why does moving that pointer never discard the correct answer?
6. When should the algorithm stop?

> **Never move a pointer because it "feels right". Move it only when you can prove that its current position can no longer contribute to the optimal answer.**

---

## 📂 Problems Covered

| # | Problem                   | Pattern                          |
| - | ------------------------- | -------------------------------- |
| ✅ | Valid Palindrome          | Opposite Direction               |
| ✅ | Two Sum II                | Sorted Search Space              |
| ✅ | Container With Most Water | Greedy Pointer Movement          |
| ✅ | 3Sum                      | Reduction + Duplicate Handling   |
| ✅ | 4Sum                      | Nested Reduction                 |
| ✅ | Backspace String Compare  | Reverse Traversal + Skip Counter |

---

## 📚 Pattern Progression

```text
Two Sum II
        ↓
Opposite Direction

Container With Most Water
        ↓
Greedy Pointer Movement

3Sum
        ↓
Reduction + Duplicate Handling

4Sum
        ↓
Nested Reduction

Backspace String Compare
        ↓
Reverse Traversal + Skip Counter
```

Each problem introduces a **new variation** of the Two Pointers technique instead of repeating the same idea.

---

## 🚀 Key Insight

> **Two Pointers is not a single algorithm—it is a family of techniques.**

The hardest part is **not writing the code**. The hardest part is identifying:

* What each pointer represents.
* Why a pointer can move.
* What invariant remains true after every move.
* When a pointer's current position can be safely discarded.

Master the reasoning behind pointer movement, and the implementation becomes straightforward.

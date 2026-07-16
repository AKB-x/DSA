# 🔥 Two Pointers Pattern

## 📌 Description

Two Pointers is a technique that uses **two indices to process an array or string efficiently**.

The pointers move based on a condition, allowing us to eliminate unnecessary comparisons and often reduce an `O(n²)` brute-force approach to `O(n)`.

---

## 🎯 When to Use

* Array or string problems
* Comparing elements from both ends
* Sorted arrays
* Pair or target sum problems
* Palindrome problems
* In-place array modification
* Need to eliminate unnecessary comparisons

---

## ⚡ Types

### 1. Opposite Direction

* One pointer starts at the beginning
* One pointer starts at the end
* Both pointers move toward each other

**Example:** Valid Palindrome

```text
left --->       <--- right
```

---

### 2. Same Direction

* Both pointers move in the same direction
* Usually one pointer is slow and the other is fast
* Used for filtering or in-place modification

**Example:** Remove Duplicates from Sorted Array

```text
slow --->
fast ------->
```

---

### 3. Sorted Search Space

* Usually used with sorted arrays
* Pointer movement is decided using the current value or sum
* Moving a pointer eliminates impossible answers

**Example:** Two Sum II

```text
sum < target → left++
sum > target → right--
```

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
## 🧠 Thinking Process

For every Two Pointer problem, ask:

1. What is my current state?
2. What information can I extract from the current state?
3. Should I update the answer before changing the state?
4. Which pointer can be safely discarded?
5. Why is it safe to discard that pointer?
6. Move only that pointer and repeat.

> Never move a pointer because it "feels right". Move it only when you can prove that its current position cannot contribute to a better answer.
---

## 📂 Problems Covered

* Valid Palindrome

---

## 🚀 Key Insight

> A pointer should move only when the current state proves that its position no longer needs to be considered.

> Do not memorize `left++` or `right--`. Understand why moving that pointer eliminates impossible answers.


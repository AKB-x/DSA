# 🔥 Sliding Window Pattern

## 📌 Description

Sliding Window is used for problems involving **contiguous subarrays or substrings**.

---

## 🎯 When to Use

* Subarray / substring problems
* “Longest / shortest / maximum / minimum”
* Fixed or variable window size

---

## ⚡ Types

### 1. Fixed Window

* Window size = constant (k)
* Example: Max sum subarray of size k

### 2. Variable Window

* Window expands & shrinks
* Example: Longest substring without repeating characters

---

## 🧠 Template

```java
int left = 0;

for (int right = 0; right < n; right++) {

    while (condition) {
        left++;
    }

    // update answer
}
```

---

## 📂 Problems Covered

* Maximum Sum Subarray of Size K
* Longest Substring Without Repeating Characters
* Longest Repeating Character Replacement
* Minimum Window Substring

---

## 🚀 Key Insight

> Convert nested loops (O(n²)) → single loop (O(n))

---

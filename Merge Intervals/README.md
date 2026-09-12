# 📦 Merge Intervals Pattern

### 🧠 Core Idea

Merge overlapping intervals by first **sorting them by their starting point** and then processing them from left to right.

Each interval is represented as:

`[start, end]`

After sorting, compare the current interval with the previous/current merged interval.

### 🔑 Main Rule

If:

`currentStart <= currentEnd`

the intervals overlap.

Merge them by extending the end:

`currentEnd = max(currentEnd, nextEnd)`

If:

`currentStart > currentEnd`

there is no overlap, so store the current interval and start a new interval.

### ⭐ Mental Model

Sort by START  
↓  
Process left → right  
↓  
Does current START <= previous END?  
↓  
YES → Overlap → Merge → max END  
NO → Separate → Save → Start new interval

### 🎯 Key Takeaway

> **Sort by start → compare starts with the previous end → merge overlapping intervals → keep non-overlapping intervals separate.**

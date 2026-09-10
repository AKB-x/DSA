# 📦 Insert Interval — LeetCode 57

## 🧩 Pattern
Intervals

## 💡 Approach

The intervals are already sorted and non-overlapping, so we can process them from left to right in three stages:

1. **Before `newInterval`**
   - If `intervals[i][1] < newInterval[0]`, the current interval is completely before `newInterval`.
   - Add it directly to the result.

2. **Overlapping with `newInterval`**
   - If `intervals[i][0] <= newInterval[1]`, the intervals overlap.
   - Merge them by updating:
     - `newInterval[0]` → minimum start
     - `newInterval[1]` → maximum end
   - Continue checking because the newly merged interval may overlap with the next interval too.

3. **After `newInterval`**
   - Once the overlapping intervals are finished, add the remaining intervals directly.

## 🔑 Key Insight

After every merge, `newInterval` can become larger.

For example:

`newInterval = [4,6]`

`[3,5]` → `[3,6]`

`[6,7]` → `[3,7]`

`[7,10]` → `[3,10]`

Therefore, we keep checking the next interval until no more intervals overlap.

## 💻 Java Solution

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;

        // Intervals completely before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        result.add(newInterval);

        // Remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

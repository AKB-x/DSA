<h2><a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a></h2>

<p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;A man, a plan, a canal: Panama&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &quot;amanaplanacanalpanama&quot; is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;race a car&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> &quot;raceacar&quot; is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot; &quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string &quot;&quot; after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>


---

## 🧩 Pattern
**Pattern:** Two Pointers — Opposite Direction
**Variation:** Non-Alphanumeric Character Filtering

## 🎯 Trigger
* Presence of non-alphanumeric characters that need to be ignored during comparison
* Need to compare characters from both ends of a string
* Invariant checking through case-insensitive comparison
* String manipulation with pointer movement

## 💡 Core Idea
The solution utilizes two pointers starting from the beginning and end of the string, moving towards each other while skipping non-alphanumeric characters. It maintains the invariant that the characters at the current positions of the two pointers must be equal when compared case-insensitively for the string to be a palindrome.

## ⚙️ Approach
1. Initialize two pointers, one at the start (`left`) and one at the end (`right`) of the string.
2. Move the `left` pointer to the right until it points to an alphanumeric character.
3. Move the `right` pointer to the left until it points to an alphanumeric character.
4. Compare the characters at the `left` and `right` positions case-insensitively.
5. If the characters match, move both pointers towards each other.
6. Repeat steps 2-5 until `left` meets or crosses `right`.
7. If the loop completes without finding any mismatch, the string is a palindrome.

## 🔑 Key Condition
`Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))`
This condition checks for case-insensitive equality between characters at the current positions of the two pointers, which is crucial for determining if the string is a palindrome.

## ↔️ Pointer / State Movement
The `left` pointer moves to the right when it encounters a non-alphanumeric character or after a successful comparison, allowing it to skip irrelevant characters and move towards the center of the string. Similarly, the `right` pointer moves to the left for the same reasons, effectively narrowing down the comparison space.

## 🗃️ Data Structure
**No extra data structure required.**
Simple variables and pointers are sufficient because the problem only requires tracking the current positions and comparing characters without needing to store additional information.

## ⏱️ Complexity
**Time Complexity:** `O(n)`
The time complexity is linear because in the worst-case scenario, each character in the string is visited once by the two pointers. 
**Space Complexity:** `O(1)`
The space complexity is constant because only a fixed amount of space is used to store the pointers and other variables, regardless of the input size.

## ⚠️ Common Mistakes
* Moving only one pointer when encountering a non-alphanumeric character.
* Forgetting to update the pointers after a successful comparison.
* Not using case-insensitive comparison for characters.
* Incorrectly handling the case when `left` meets or crosses `right`.

## 🧠 Key Insight
When dealing with string problems that require ignoring certain characters, using two pointers that move based on the presence of relevant characters can efficiently solve the problem by only considering the necessary parts of the string.

## 🎤 Interview Explanation
My approach to solving this problem involves using two pointers that start at the beginning and end of the string and move towards each other, skipping non-alphanumeric characters. This allows for an efficient case-insensitive comparison of characters to determine if the string is a palindrome. By moving the pointers based on the relevance of the characters, we can ignore non-alphanumeric characters and focus on the actual content of the string, resulting in a linear time complexity solution.
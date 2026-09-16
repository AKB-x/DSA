# 🗺️ HashMap Pattern

HashMap is a data structure that stores data in **key-value pairs**.

It is useful when a problem requires:
- Fast lookup
- Frequency counting
- Checking whether something exists
- Mapping one value to another
- Storing information associated with a key

---

## 🧠 Core Idea

A HashMap follows:

**Key → Value**

Example:

    'a' → 3
    'b' → 1
    'c' → 4

The key identifies the data, while the value stores the associated information.

HashMap provides **O(1) average-time** lookup, insertion, and removal.

---

## 🔑 Common Operations

### Create

    HashMap<Character, Integer> map = new HashMap<>();

### Insert / Update

    map.put('a', 1);

### Get

    map.get('a');

### Check Key

    map.containsKey('a');

### Remove

    map.remove('a');

### Get with Default

    map.getOrDefault('a', 0);

---

## 📊 Pattern 1 — Frequency Counting

One of the most common uses of HashMap is counting how many times each element appears.

    for(char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

Example:

    "aabbc"

    a → 2
    b → 2
    c → 1

### Recognition

Think **Frequency Counting** when a problem asks:

- How many times does something occur?
- Which elements are repeated?
- Which element occurs once?
- Is there enough of a particular element?
- How many copies can be formed?

---

## 🔍 Pattern 2 — Fast Lookup

Sometimes the problem does not require frequency.

It only asks:

> "Have I seen this before?"

Use:

    map.containsKey(key);

If only existence matters and no additional information is required, a **HashSet** may be more appropriate.

    HashMap → Key → Information
    HashSet → Key

---

## 📦 Pattern 3 — Mapping Information

A HashMap can associate an element with additional information.

Common examples:

    Value → Frequency
    Value → Index
    Value → Position
    Value → Count
    Key → Object / Data

The key should represent the thing you need to **look up quickly**.

---

## ⚖️ Pattern 4 — Requirement vs Availability

Some problems involve comparing:

    Required resources
            vs
    Available resources

Represent the information using frequencies.

Example:

    Need:

    a → 1
    b → 1
    c → 2

    Have:

    a → 3
    b → 2
    c → 4

The general condition is:

    Available Frequency >= Required Frequency

If this condition fails for any required element, the task cannot be completed.

---

## ♻️ Pattern 5 — Consume Resources

Instead of maintaining two maps, sometimes we can maintain only the available resources.

### Process

    1. Count available resources
    2. Traverse what is required
    3. Consume one resource
    4. Fail if no resource remains

Example:

    if(!map.containsKey(ch) || map.get(ch) == 0) {
        return false;
    }

    map.put(ch, map.get(ch) - 1);

### Mental Model

    Build Supply
         ↓
    Consume Demand
         ↓
    Supply Available?
         ↓
    Yes → Continue
    No  → Fail

---

## 📉 Pattern 6 — Limiting Resource

When a problem asks how many complete objects can be created from available resources, each resource can provide a certain number of complete copies.

General idea:

    Available Frequency
    -------------------
    Required Frequency

Calculate this for every required resource.

The **minimum** value determines the final answer because the scarcest resource becomes the bottleneck.

### Mental Model

> The limiting resource determines the maximum possible result.

---

## 🔄 Pattern 7 — Two-Pass HashMap

Some problems are easier when information is collected first and used afterward.

### Pass 1 — Build Information

    for(...) {
        map.put(...);
    }

### Pass 2 — Use Information

    for(...) {
        if(...) {
            ...
        }
    }

### Mental Model

    Pass 1 → Learn
    Pass 2 → Decide

This is useful when the answer depends on information about the entire input.

---

## 🧩 Pattern Recognition

When reading a problem, ask:

### 1. Do I need to count occurrences?

    → Frequency Counting
    → HashMap

### 2. Do I need fast existence checks?

    → HashSet / HashMap

### 3. Do I need to associate information with a value?

    → HashMap

### 4. Do I have required and available resources?

    → Frequency Map

### 5. Can resources be used only once?

    → Frequency Map + Decrement

### 6. Does the answer depend on information from the entire input?

    → Two-Pass HashMap

---

## ⏱️ Complexity

For a HashMap, the average complexity of common operations is:

    put()         → O(1)
    get()         → O(1)
    containsKey() → O(1)
    remove()      → O(1)

Therefore, many HashMap problems have:

    Time  → O(N)
    Space → O(K)

Where:

- N = size of the input
- K = number of distinct elements

---

## ⚠️ Common Mistakes

### 1. Using get() when a key may not exist

    map.get(ch);

may return `null`.

Use:

    map.getOrDefault(ch, 0);

when appropriate.

### 2. Confusing Keys and Values

For:

    'a' → 5

- `'a'` is the **key**
- `5` is the **value**

### 3. Iterating Over the Wrong Collection

If you need to process every unique key, use:

    for(char ch : map.keySet()) {
        ...
    }

rather than repeatedly processing the original input.

### 4. Checking Only Existence When Frequency Matters

This:

    map.containsKey(ch)

only tells you that the key exists.

It does not tell you whether enough copies are available.

When frequency matters, check the stored count.

### 5. Forgetting to Consume Resources

If an element can only be used once, decrease its frequency after using it:

    map.put(ch, map.get(ch) - 1);

---

## 🧠 HashMap Mental Model

When you see:

    Count
    Frequency
    Lookup
    Existence
    Requirement
    Availability
    Mapping
    Previously Seen

Think:

                    HASHMAP
                       │
            ┌──────────┼──────────┐
            ↓          ↓          ↓
       Frequency     Lookup    Mapping
            │
            ↓
       Requirement
            │
            ↓
         Consume
            │
            ↓
        Bottleneck

---

## 🔥 Key Takeaway

> **HashMap lets us trade space for fast access to information.**

The major patterns to recognize are:

1. **Frequency Counting**
2. **Fast Lookup**
3. **Mapping Information**
4. **Requirement vs Availability**
5. **Consume Resources**
6. **Limiting Resource**
7. **Two-Pass HashMap**

The most important question to ask when solving a HashMap problem is:

> **"What information do I need to remember, and what should my key represent?"**

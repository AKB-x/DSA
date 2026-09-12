# Stack

## Pattern
Stack

## What is a Stack?

A Stack is a data structure that follows **LIFO (Last In, First Out)**.

The element that is added last is the first element that can be removed.

A simple example is a stack of plates:

```text
      ┌───────┐
      │   3   │ ← Top
      ├───────┤
      │   2   │
      ├───────┤
      │   1   │
      └───────┘
```

## Core Operations

- **Push** → Add an element to the top.
- **Pop** → Remove the element from the top.
- **Peek / Top** → View the top element without removing it.
- **isEmpty()** → Check whether the stack is empty.

## Java Implementation

In Java, `Deque` with `ArrayDeque` can be used to implement a stack.

```java
Deque<Integer> stack = new ArrayDeque<>();
```

### Push

```java
stack.push(10);
```

### Pop

```java
stack.pop();
```

### Peek

```java
stack.peek();
```

### Check Empty

```java
stack.isEmpty();
```

---

## Stack Pattern

A Stack is useful when we need to remember previous elements and access the **most recently relevant element first**.

Common situations where Stack is useful:

- Previous elements
- Next greater/smaller elements
- Nearest greater/smaller elements
- Matching pairs
- Nested structures
- Removing elements based on previous elements
- Undo operations
- Processing the most recent element first

### How to Recognize a Stack Problem

Ask:

> **Do I need to keep track of previous elements and access the most recent relevant one first?**

If yes, a Stack may be useful.

---

 

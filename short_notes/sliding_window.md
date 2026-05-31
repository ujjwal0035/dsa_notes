# Sliding Window

## When To Think Sliding Window

Use this pattern when the problem contains:

- Contiguous subarray
- Substring
- Maximum or minimum length
- At most `k`
- Exactly `k`
- Continuous range constraints

## Core Idea

Maintain a **valid window** using two pointers:

- `left`
- `right`

Expand the window:

```java
right++;
```

Shrink when invalid:

```java
while (windowInvalid) {
    left++;
}
```

Update the answer only after the window becomes valid.

## Pattern 1: Fixed Size Window

Common questions:

- Maximum sum of size `k`
- Average of size `k`

Template:

```java
// add current element

if (windowSize > k) {
    // remove left element
}

if (windowSize == k) {
    // calculate answer
}
```

## Pattern 2: Dynamic Window

Common questions:

- Longest valid subarray
- Smallest valid subarray

Template:

```java
for (int right = 0; right < n; right++) {
    // include current element

    while (windowInvalid) {
        // remove left element
        left++;
    }

    // update answer
}
```

## Pattern 3: Frequency Map Window

Use when the problem involves:

- Distinct characters
- Duplicates
- Frequency limits

Common data structure:

```java
Map<Character, Integer> freq = new HashMap<>();
```

Important steps:

- Increment frequency while expanding.
- Decrement frequency while shrinking.
- Remove a key if its frequency becomes `0`, when needed.

## Pattern 4: Binary Array Window

Usually used for:

- Flipping `0`s
- At most `k` zeros

Track:

```java
int zeroCount = 0;
```

Template:

```java
if (nums[right] == 0) {
    zeroCount++;
}

while (zeroCount > k) {
    if (nums[left] == 0) {
        zeroCount--;
    }
    left++;
}
```

## Pattern 5: Window With Max/Min Constraint

For constraints like:

```text
max - min <= limit
```

Use a **monotonic deque**:

- `maxDeque`: decreasing order
- `minDeque`: increasing order

## Recognition Checklist

If the question says:

- Contiguous
- Substring
- Longest
- Shortest
- At most `k`
- Continuous

Think **Sliding Window**.

## Common Mistakes

### Special-casing unnecessarily

General window logic should usually handle edge cases.

### Forgetting the invariant

Always ask:

```text
What makes my window valid?
```

### Updating answer before validation

Correct order:

1. Expand.
2. Shrink until valid.
3. Update answer.

## Mental Model

```text
Expand greedily.
Shrink only when invalid.
Maintain a valid window.
```

# Prefix Sum + HashMap

## When To Think Prefix Sum

Use this pattern when the question contains:

- Subarray sum
- Count subarrays
- Longest subarray
- Sum equals `k`
- Divisible by `k`
- Remainder logic

## Core Idea

```java
prefixSum[i] = sum from index 0 to i
```

Subarray sum:

```text
sum(l...r) = prefix[r] - prefix[l - 1]
```

So the current prefix usually needs some previous prefix.

## Pattern 1: Longest Subarray Sum = K

Need to find:

```text
prefixSum - k
```

Use:

```java
Map<Integer, Integer> firstIndex = new HashMap<>();
```

Important initialization:

```java
firstIndex.put(0, -1);
```

Why?

It allows subarrays starting from index `0`.

For longest subarray, store the **first occurrence** of each prefix sum.

## Pattern 2: Count Subarrays Sum = K

Use a frequency map.

Template:

```java
ans += freq.getOrDefault(prefixSum - k, 0);
freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
```

Important initialization:

```java
freq.put(0, 1);
```

Why?

It counts subarrays starting from index `0`.

## Pattern 3: Prefix Remainder

Common questions:

- Subarray sum divisible by `k`
- Count subarrays divisible by `k`
- Same remainder logic

Key property:

```text
If two prefix sums have the same remainder,
the subarray between them is divisible by k.
```

## Important Trick

Handle negative modulo safely:

```java
int rem = ((sum % k) + k) % k;
```

## Recognition Checklist

If the question contains:

- Subarray sum
- Divisible by `k`
- Longest subarray
- Count subarray

Think **Prefix Sum + HashMap**.

## Common Mistakes

### Using latest index instead of first index

For longest subarray, store the **first occurrence**.

### Forgetting the base prefix

For longest subarray:

```java
firstIndex.put(0, -1);
```

For count subarrays:

```java
freq.put(0, 1);
```

## Mental Model

```text
Current prefix wants some previous prefix.
```

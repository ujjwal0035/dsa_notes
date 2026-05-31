# Kadane's Algorithm

## When To Think Kadane

Use this pattern when the problem asks for:

- Maximum subarray sum
- Contiguous subarray
- Best running sum

## Core Idea

If the current sum becomes negative:

```text
It can only hurt the future answer.
```

So reset the running sum and start fresh.

## Template

```java
int sum = 0;
int max = Integer.MIN_VALUE;

for (int num : nums) {
    sum += num;
    max = Math.max(max, sum);

    if (sum < 0) {
        sum = 0;
    }
}
```

## Why Reset Works

A negative prefix decreases future sums.

So if the running sum is negative, any future subarray is better without carrying that negative prefix.

## Important Edge Case

All numbers can be negative.

That is why `max` should start with:

```java
int max = Integer.MIN_VALUE;
```

If you initialize `max = 0`, the answer becomes wrong for arrays like:

```text
[-5, -2, -8]
```

Correct answer is `-2`, not `0`.

## Recognition Checklist

If the question contains:

- Maximum sum
- Contiguous subarray
- Best subarray
- Running sum

Think **Kadane's Algorithm**.

## Mental Model

```text
Keep profitable running sum.
Drop harmful prefix.
```

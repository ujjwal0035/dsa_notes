# Sign / Product Problems

## When To Think Sign Logic

Use this pattern when the problem contains:

- Product
- Positive and negative numbers
- Maximum product
- Negative values flipping the sign
- Zero splitting the array

## Important Properties

```text
positive * positive = positive
negative * negative = positive
positive * negative = negative
any number * 0 = 0
```

## Core Insight

For product problems:

```text
Sign matters as much as the actual value.
```

## Pattern 1: Maximum Product Subarray

Track both:

```java
int maxProduct;
int minProduct;
```

Why?

Because a negative number multiplied by the minimum negative product can become the maximum positive product.

Important trick:

```java
if (num < 0) {
    int temp = maxProduct;
    maxProduct = minProduct;
    minProduct = temp;
}
```

## Pattern 2: Longest Positive Product Subarray

Key insight:

```text
Product is positive when the number of negatives is even.
```

Zero splits the array into independent segments.

For each segment:

- If negatives are even, take the whole segment.
- If negatives are odd, remove either the prefix up to the first negative or the suffix after the last negative.

Take the maximum remaining length.

## DP Sign-State Alternative

Track:

```java
int posLen;
int negLen;
```

At each index:

- `posLen`: longest positive product subarray ending here
- `negLen`: longest negative product subarray ending here

## Recognition Checklist

If the question contains:

- Product
- Sign
- Negative numbers
- Zero reset

Think **Sign Logic / Parity**.

## Mental Model

```text
Count sign changes.
Zero splits segments.
Even negatives give a positive product.
```

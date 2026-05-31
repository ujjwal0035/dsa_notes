# Short Notes

Quick DSA pattern notes for interview revision.

## Pattern Index

| # | Topic | Best used when you see | Notes |
|---|---|---|---|
| 1 | Sliding Window | Contiguous subarray, substring, at most `k`, longest/shortest window | [Open](sliding_window.md) |
| 2 | Prefix Sum + HashMap | Subarray sum, count subarrays, sum equals `k`, divisible by `k` | [Open](prefix_sum_hashmap.md) |
| 3 | Kadane's Algorithm | Maximum contiguous subarray sum | [Open](kadane_algo.md) |
| 4 | Sign / Product Problems | Product, negatives, zero reset, sign flips | [Open](sign_product.md) |
| 5 | Monotonic Stack | Next/previous greater or smaller element, histogram, span | [Open](monotonic_stack.md) |

## Quick Pattern Recognition

| Problem Signal | Think |
|---|---|
| Contiguous + longest/shortest | Sliding Window |
| Subarray sum/count/divisible | Prefix Sum + HashMap |
| Maximum contiguous sum | Kadane's Algorithm |
| Product + negative + zero | Sign / Product Logic |
| Next greater/smaller | Monotonic Stack |
| Max/min inside window | Monotonic Deque |

## Final Interview Reminder

During interviews:

1. First identify the pattern.
2. Define the invariant.
3. Explain why the optimization works.
4. Then code.

Always ask:

```text
What information do I need to carry forward efficiently?
```

That question solves most DSA pattern problems.

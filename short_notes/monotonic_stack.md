# Monotonic Stack - Quick Interview Notes

A **monotonic stack** is a stack that always stays sorted, either increasing or decreasing, as we push and pop elements.

It is used to answer **next/previous greater/smaller element** questions in `O(n)` instead of `O(n^2)`.

## 1. The One Rule To Remember

Just remember these two pairs and you can solve almost everything:

- **Greater element ka jawab chahiye** -> use a **decreasing stack**
- **Smaller element ka jawab chahiye** -> use an **increasing stack**

For direction:

- **Next** / right side -> traverse **right to left**
- **Previous** / left side -> traverse **left to right**

That's the whole core. Everything else is just code on top of this.

## 2. The Master Table

| What you want | Stack type | While loop pops when... | Direction |
|---|---|---|---|
| Next Greater Element | Decreasing | `top <= current` | Right to left |
| Next Smaller Element | Increasing | `top >= current` | Right to left |
| Previous Greater Element | Decreasing | `top <= current` | Left to right |
| Previous Smaller Element | Increasing | `top >= current` | Left to right |

**Memory trick:**

- **Greater** wants to throw out small ones -> decreasing stack
- **Smaller** wants to throw out big ones -> increasing stack

Most of the time, store **indices** in the stack instead of values, because many problems need distances, widths, or positions.

## 3. Code Templates

### Next Greater Element

```python
def next_greater(nums):
    n = len(nums)
    res = [-1] * n
    stack = []  # stores indices, values are decreasing

    for i in range(n - 1, -1, -1):  # right to left
        while stack and nums[stack[-1]] <= nums[i]:
            stack.pop()  # smaller ones cannot be the answer

        if stack:
            res[i] = nums[stack[-1]]

        stack.append(i)

    return res
```

### Next Smaller Element

To get **Next Smaller**, use the same template and flip the comparison:

```python
while stack and nums[stack[-1]] >= nums[i]:
    stack.pop()
```

### Previous Element Variants

To get **Previous** instead of **Next**, flip the direction:

```python
for i in range(n):  # left to right
    ...
```

So all four variations use the same template. Only two things change:

1. `<=` vs `>=` for greater vs smaller
2. Loop direction for next vs previous

## 4. Pattern Recognition

Think **monotonic stack** when you see:

- "Find the next/previous greater/smaller element for each element"
- "For each element, find something to its left/right" and brute force looks like `O(n^2)`
- Histogram or rectangle area problems
- Span problems, like consecutive days
- Temperature or wait-days wording
- Need to keep a running best while comparing with elements behind you
- Building a lexicographically smallest/largest result by removing characters

If the brute force is:

> For each `i`, scan left/right until a condition is met.

Then a monotonic stack can usually turn it into `O(n)`.

## 5. Famous Problems And Patterns

| Problem | Pattern used |
|---|---|
| Daily Temperatures | Next Greater, store index and take difference |
| Next Greater Element I / II | Next Greater. For II, circular array means loop twice |
| Stock Span | Previous Greater |
| Largest Rectangle in Histogram | Previous Smaller + Next Smaller |
| Trapping Rain Water | Next Greater style, or two pointers |
| Sum of Subarray Minimums | Previous Smaller + Next Smaller |
| Remove K Digits / Remove Duplicate Letters | Increasing stack for smallest result |
| Online Stock Span | Previous Greater, merge counts |

## 6. Interview Tips

- **Circular array:** for problems like Next Greater Element II, loop twice and use `i % n`.
- **Strict vs non-strict:** if duplicates should count, use `<` instead of `<=`. Decide based on problem wording.
- **Store indices, not values:** useful for distances in Daily Temperatures or widths in Histogram.
- **Histogram / subarray minimums:** usually need both previous-smaller and next-smaller boundaries.
- **Time complexity:** each element is pushed once and popped once, so the total complexity is `O(n)`.

Say this in the interview:

> Each element enters and leaves the stack at most once, so this is `O(n)`.

## 7. 30-Second Recall Sheet

1. Greater = decreasing stack, smaller = increasing stack.
2. Next = go right to left, previous = go left to right.
3. One template. Only flip comparison sign and loop direction.
4. Store indices in the stack.
5. Each element goes in and out once -> `O(n)`.
6. Triggers: next/previous greater/smaller, histogram, span, temperatures.
7. Circular array? Loop twice with `i % n`.

If you remember points 1 and 2, you can re-derive everything else.

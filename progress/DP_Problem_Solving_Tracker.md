# Dynamic Programming — Problem Solving & Pattern Tracker

**Purpose:** Detailed, interview-oriented DP tracker. This file records not only solved questions, but the reasoning process used to identify the DP pattern, derive the recurrence, convert top-down to bottom-up, and capture special cases.

## Mandatory learning flow for every future DP problem

1. **Question** — read and restate the problem.
2. **Pattern identification** — before coding, identify which DP concept/pattern applies.
3. **Logic discussion** — define the state, meaning of `helper(state)`, choices, recurrence, base cases, and dependencies.
4. **Implementation** — write the solution in Java.
5. **Review** — correctness, edge cases, complexity, mistakes, and cleaner alternatives.
6. **DP conversion** — if top-down is used, explicitly derive bottom-up from dependencies instead of looking up the implementation.
7. **Space optimization** — determine whether the full table is required.
8. **Pattern note** — record the reusable pattern in plain language.
9. **Rating** — rate the problem/pattern and update the overall skill only when enough evidence exists.
10. **Git update** — append the solved problem and update priorities.

---

# Current DP Skill Snapshot

| Skill | Rating | Notes |
|---|---:|---|
| Recognize DP opportunity | 4/5 | Good after recursion practice |
| Define recursive state | 5/5 | Strong |
| Define recurrence | 5/5 | Strong |
| Memoization | 4/5 | Good; watch sentinel/state design |
| Top-down reasoning | 5/5 | Strong |
| Top-down → bottom-up | **2/5** | **Primary weakness** |
| Dependency analysis | 2/5 | Needs deliberate practice |
| Tabulation direction | 2/5 | Need to derive rather than memorize |
| Space optimization | 3/5 | Improving |
| Advanced DP patterns | Not started | Future focus |

---

# Master DP Recognition Framework

When a problem looks like DP, ask:

### 1. Is there a state?
What smaller subproblem completely describes what remains?

### 2. What does `helper(state)` return?
Examples:
- maximum value
- minimum cost/count
- number of ways
- boolean possible/impossible

### 3. What choices exist at this state?
Examples:
- take / skip
- choose a coin
- move right / down
- match / skip
- pick an item / don't pick it

### 4. How are choices combined?
- `max(...)`
- `min(...)`
- `sum(...)`
- `||` / `&&`

### 5. What are the base cases?

### 6. Are the same states repeated?
If yes, memoization/DP is useful.

---

# Top-Down → Bottom-Up Conversion Rule

Do **not** start by guessing loop direction.

First write:

```text
What does dp[state] mean?

What states does dp[state] depend on?

Which states must exist before current state?

Therefore, in what order must states be calculated?
```

### Example: Coin Change

```text
helper(amount)
→ depends on helper(amount - coin)
→ dependencies are smaller amounts
→ calculate 0, 1, 2, ..., target
```

### Example: House Robber

```text
helper(i)
→ depends on helper(i+1), helper(i+2)
→ dependencies are larger indices
→ calculate n-1, n-2, ..., 0
```

### Golden rule
> **Dependency direction determines tabulation direction.**

---

# Solved Problem 1 — Climbing Stairs

**LeetCode:** 70. Climbing Stairs

### 1. Question
You can climb 1 or 2 steps. Find the number of distinct ways to reach step `n`.

### 2. Pattern identification
**DP pattern:** Fibonacci / 1D DP with two previous states.

### 3. Logic discussion
State:
```text
helper(n) = number of ways to reach n
```
Choices:
```text
arrive from n-1
arrive from n-2
```
Recurrence:
```text
f(n) = f(n-1) + f(n-2)
```
Base:
```text
f(1) = 1
f(2) = 2
```

### 4. Implementation learned
- Recursive + memoization
- Iterative bottom-up
- O(1) space optimization

### Special insight
The state depends only on the previous two states, so the full DP table is unnecessary.

### Rating
**5/5**

---

# Solved Problem 2 — House Robber

**LeetCode:** 198. House Robber

### 1. Question
Rob houses to maximize money, but adjacent houses cannot both be robbed.

### 2. Pattern identification
**DP pattern:** 1D take/skip DP.

### 3. Logic discussion
State:
```text
helper(i) = maximum money from house i onward
```
Choices:
```text
Take house i → nums[i] + helper(i+2)
Skip house i → helper(i+1)
```
Recurrence:
```text
f(i) = max(nums[i] + f(i+2), f(i+1))
```
Base:
```text
i >= n → 0
```

### 4. Implementation progression
- Recursive
- Memoized with `dp[i]`
- Bottom-up right-to-left
- O(1) space

### Important correction
An earlier attempt used `dp[nums[idx]][idx]`. This was wrong because the subproblem depends on `idx`, not on the value stored at `nums[idx]`.

### Bottom-up insight
`dp[i]` depends on `dp[i+1]` and `dp[i+2]`, so fill from right to left.

### Rating
**5/5**

---

# Solved Problem 3 — House Robber II

**LeetCode:** 213. House Robber II

### 1. Question
Houses are arranged in a circle, so the first and last houses are adjacent.

### 2. Pattern identification
**DP pattern:** Reduce circular DP to two linear House Robber problems.

### 3. Logic discussion
Because first and last cannot both be selected, every valid solution belongs to one of two cases:
```text
Case 1: houses 0 .. n-2
Case 2: houses 1 .. n-1
```
Answer:
```text
max(case1, case2)
```

### 4. Implementation
Reuse the O(1) House Robber helper over `[left, right]`.

### Special case
If there is exactly one house, return `nums[0]`.

### Rating
**5/5**

---

# Solved Problem 4 — Coin Change

**LeetCode:** 322. Coin Change

### 1. Question
Given coin denominations and an amount, return the minimum number of coins needed to make that amount; return `-1` if impossible.

### 2. Pattern identification
**DP pattern:** 1D minimum DP / unbounded choice.

### 3. Logic discussion
State:
```text
helper(amount) = minimum coins needed to make amount
```
Choices:
```text
Choose any coin c
→ 1 + helper(amount - c)
```
Recurrence:
```text
f(amount) = min over all valid coins [1 + f(amount - coin)]
```
Base:
```text
amount == 0 → 0
amount < 0 → impossible
```

### 4. Implementation progression
- First brute-force recursion with a global minimum path count.
- Then top-down memoization with `dp[amount]`.
- Then bottom-up tabulation.

### Important correction
Using `-1` for both "not computed" and "impossible" makes memoization ambiguous. Better:
```text
-2 = not computed
-1 = impossible
0+ = valid answer
```
Or use a large sentinel for impossible values in bottom-up DP.

### Bottom-up conversion
The top-down state:
```text
helper(amount) → helper(amount - coin)
```
depends only on smaller amounts. Therefore calculate:
```text
0 → target amount
```

### Bottom-up recurrence
```text
dp[0] = 0
for amt = 1..target:
    for coin in coins:
        if amt >= coin:
            dp[amt] = min(dp[amt], 1 + dp[amt-coin])
```

### Main learning gap
The user needed Google help to derive the bottom-up version. This is the current primary DP training target.

### Rating
- Recursion: 5/5
- State/recurrence: 5/5
- Memoization: 4/5
- Tabulation conversion: 2/5

---

# DP Problems To Solve Next

For each problem below, use the mandatory 10-step learning flow.

1. **Min Cost Climbing Stairs** — 1D min DP
2. **Coin Change II** — counting combinations / order matters distinction
3. **Unique Paths** — 2D DP
4. **Minimum Path Sum** — 2D min DP
5. **Partition Equal Subset Sum** — 0/1 knapsack / boolean DP
6. **Longest Increasing Subsequence** — sequence DP
7. **0/1 Knapsack** — take/skip with capacity state
8. **Longest Common Subsequence** — 2D string DP
9. **Edit Distance** — 2D string transformation DP

---

# Future Pattern Catalog

| Pattern | Example problems | Status |
|---|---|---|
| Fibonacci / 1D | Climbing Stairs | Learned |
| Take / Skip | House Robber | Learned |
| Circular reduction | House Robber II | Learned |
| Min over choices | Coin Change | Learned |
| 2D grid DP | Unique Paths, Minimum Path Sum | Next |
| 0/1 Knapsack | Partition Equal Subset Sum | Next |
| Unbounded Knapsack | Coin Change II | Next |
| Sequence DP | LIS | Next |
| String DP | LCS, Edit Distance | Later |
| Advanced DP | Partition DP, interval DP, tree DP | Later |

---

# Per-Problem Record Template

Copy this for every new problem:

```text
## Problem

### 1. Question

### 2. Pattern identification
- Which DP concept applies?
- Why?

### 3. Logic discussion
- State:
- Meaning of helper(state):
- Choices:
- Recurrence:
- Base cases:
- Special cases:
- Dependencies:

### 4. Implementation
- Java approach:
- Time:
- Space:

### 5. Top-down → Bottom-up
- Dependencies:
- Required order:
- Tabulation:
- Space optimization:

### 6. Mistakes / corrections

### 7. Key interview insight

### 8. Pattern to remember

### 9. Rating

### 10. Revision needed
```

**Last updated:** 2026-08-16

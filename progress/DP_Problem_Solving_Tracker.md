# Dynamic Programming — Problem Solving & Pattern Tracker

**Purpose:** Detailed interview tracker. Every DP problem follows: **Question → Pattern Identification → Logic Discussion → Implementation → Review → Top-down→Bottom-up → Space Optimization → Pattern Note → Rating → Git update.**

## Current Skill Snapshot
| Skill | Rating | Notes |
|---|---:|---|
| Recognize DP | 4/5 | Good |
| Recursive state | 5/5 | Strong |
| Recurrence | 5/5 | Strong |
| Memoization | 4/5 | Good; watch sentinel/state design |
| Top-down reasoning | 5/5 | Strong |
| Top-down → bottom-up | **3/5** | Improving after Min Cost Climbing Stairs |
| Dependency analysis | **3/5** | Smaller/larger dependency recognition improving |
| Tabulation direction | **3/5** | Successfully derived right-to-left for latest problem |
| Space optimization | 3/5 | Developing |
| Advanced DP | Not started | Future |

## Master Recognition Framework
1. What is the state?
2. What does `helper(state)` return?
3. What choices exist?
4. How are choices combined: `min`, `max`, count, boolean?
5. What are the base cases?
6. Are states repeated?
7. What states does the current state depend on?
8. Which order makes dependencies available first?

### Golden rule
> **Dependency direction determines tabulation direction.**

Examples:
```text
Coin Change: helper(amount) → helper(amount-coin) → smaller → 0→target
House Robber: helper(i) → helper(i+1), helper(i+2) → larger → n-1→0
Min Cost Climbing Stairs: helper(i) → helper(i+1), helper(i+2) → larger → n-1→0
```

---

# Solved Problems

## 1. Climbing Stairs — LeetCode 70
### Question
Climb 1 or 2 steps; count distinct ways to reach `n`.
### Pattern
**Fibonacci / 1D DP / two previous states.**
### Logic
`helper(n)` = number of ways to reach `n`.
```text
f(n)=f(n-1)+f(n-2)
f(1)=1, f(2)=2
```
### Implementation
Solved recursive/memoized and iterative O(1) space.
### Special insight
Only previous two states are required.
### Rating
**5/5**

---

## 2. House Robber — LeetCode 198
### Question
Maximize robbed money without taking adjacent houses.
### Pattern
**1D Take/Skip DP.**
### Logic
`helper(i)` = maximum money from `i` onward.
```text
take = nums[i] + helper(i+2)
skip = helper(i+1)
f(i)=max(take,skip)
```
Base: `i >= n → 0`.
### Implementation
Recursive → memoized `dp[i]` → bottom-up right-to-left → O(1) space.
### Important correction
`dp[nums[idx]][idx]` was wrong. The subproblem is determined by `idx`, not by `nums[idx]`.
### Rating
**5/5**

---

## 3. House Robber II — LeetCode 213
### Question
Houses are circular; first and last are adjacent.
### Pattern
**Circular DP reduction.**
### Logic
```text
case 1: 0..n-2
case 2: 1..n-1
answer = max(case1, case2)
```
### Implementation
Reused O(1) House Robber helper over `[left,right]`.
### Special case
One house → `nums[0]`.
### Rating
**5/5**

---

## 4. Coin Change — LeetCode 322
### Question
Minimum number of coins to make amount; `-1` if impossible.
### Pattern
**1D minimum DP / unbounded choice.**
### Logic
`helper(amount)` = minimum coins needed.
```text
for each coin c:
    candidate = 1 + helper(amount-c)
f(amount) = min(candidate)
```
Base: `amount=0 → 0`; negative → impossible.
### Implementation progression
Brute-force recursion → top-down `dp[amount]` → bottom-up.
### Special/mistake
Do not use the same sentinel for “not computed” and “impossible”. Example `-2 = not computed`, `-1 = impossible`.
### Tabulation insight
`helper(amount)` depends on smaller amounts, so calculate `0→target`.
### Rating
Recursion **5/5**, state/recurrence **5/5**, memoization **4/5**, tabulation conversion initially **2/5**.
### Learning note
User needed Google help for this top-down→bottom-up conversion. This remains a key training target.

---

## 5. Min Cost Climbing Stairs — LeetCode 746
### 1. Question
Given `cost[i]`, start at stair 0 or 1, move 1 or 2 steps, and reach the top with minimum cost.

### 2. Pattern identification
User correctly identified: **choice + minimum / 1D minimum-cost DP**.

### 3. Logic discussion
State:
```text
helper(i) = minimum cost to reach the top starting from stair i
```
Choices:
```text
1 step → helper(i+1)
2 steps → helper(i+2)
```
Recurrence:
```text
helper(i) = cost[i] + min(helper(i+1), helper(i+2))
```
Base:
```text
i >= n → 0
```
Because starting stair can be 0 or 1:
```text
answer = min(helper(0), helper(1))
```

### 4. Implementation
User independently wrote both top-down memoization and bottom-up tabulation:
```text
dp[n]=0
dp[n+1]=0
for i=n-1..0:
    dp[i] = cost[i] + min(dp[i+1],dp[i+2])
answer=min(dp[0],dp[1])
```

### 5. Top-down → Bottom-up
Dependencies are `i+1` and `i+2` (larger indices), therefore fill **right to left**. This is the exact dependency reasoning we are trying to build.

### 6. Special cases
- Starting point is either 0 or 1.
- `n+2` DP array makes `dp[n]` and `dp[n+1]` naturally zero.

### 7. Complexity
Top-down: `O(n)` time, `O(n)` memo + recursion stack.
Bottom-up: `O(n)` time, `O(n)` DP space.
Can be reduced to `O(1)` because only two future states are needed.

### 8. Pattern to remember
**1D min DP:** pay current cost + choose the cheaper future state.

### 9. Rating
**4/5 for this pattern.** Pattern identification, recurrence, memoization, and tabulation were independently correct. Space optimization remains practice.

---

# Future DP Pattern Roadmap
| Pattern | Problems | Status |
|---|---|---|
| Fibonacci / 1D | Climbing Stairs | Learned |
| Take / Skip | House Robber | Learned |
| Circular reduction | House Robber II | Learned |
| Min over choices | Coin Change | Learned |
| 1D min-cost choice | Min Cost Climbing Stairs | **Learned** |
| Unbounded counting | Coin Change II | Next |
| 2D grid DP | Unique Paths, Minimum Path Sum | Next |
| 0/1 Knapsack | Partition Equal Subset Sum | Next |
| Sequence DP | LIS | Next |
| String DP | LCS, Edit Distance | Later |
| Advanced DP | Interval/partition/tree DP | Later |

# Next Problems
1. Coin Change II
2. Unique Paths
3. Minimum Path Sum
4. Partition Equal Subset Sum
5. Longest Increasing Subsequence
6. 0/1 Knapsack
7. Longest Common Subsequence
8. Edit Distance

# Per-Problem Template
```text
## Problem
### 1. Question
### 2. Pattern identification
- Which DP concept?
- Why?
### 3. Logic discussion
- State
- Meaning of helper(state)
- Choices
- Recurrence
- Base cases
- Special cases
- Dependencies
### 4. Implementation
- Java
- Time
- Space
### 5. Top-down → Bottom-up
- Dependencies
- Required order
- Tabulation
- Space optimization
### 6. Mistakes / corrections
### 7. Key interview insight
### 8. Pattern to remember
### 9. Rating
### 10. Revision needed
```

**Last updated:** 2026-08-16
**Current focus:** Make top-down → bottom-up conversion automatic through dependency analysis.

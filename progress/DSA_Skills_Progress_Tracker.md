# DSA Interview Preparation — Skills & Progress Tracker

**Purpose:** Persistent, agent-readable tracker for DSA interview preparation.
**Primary language:** Java

## CURRENT POSITION — LAST SOLVED PROBLEM

> **LAST SOLVED: Partition Equal Subset Sum — LeetCode 416**
>
> **Status:** Solved successfully in Java using both top-down memoization and bottom-up tabulation.
>
> **Important learning:** The user independently converted the recursive solution into bottom-up DP by identifying dependency directions.
>
> **Top-down state:** `helper(nums, target, idx)` = whether `target` can be formed using elements from `idx` onward.
>
> **Recurrence:**
> `helper(target, idx) = helper(target - nums[idx], idx + 1) || helper(target, idx + 1)`
>
> **Bottom-up dependencies:**
> - `dp[target - nums[idx]][idx + 1]` → smaller target.
> - `dp[target][idx + 1]` → larger index.
>
> **Fill direction:** target from `0 → sum/2`, index from `n-1 → 0`.
>
> **Key result:** User correctly recognized the same dependency pattern as Coin Change II without being given the tabulation solution.
>
> **Minor optimization:** The bottom-up loop can start target at `1` because the `target == 0` row is already initialized; current implementation remains correct.
>
> **Resume rule:** Continue AFTER Partition Equal Subset Sum. Do not repeat it unless revision is requested.

---

## 1. Current Skill Snapshot

| Topic | Rating | Status | Main pattern / skill |
|---|---:|---|---|
| Sliding Window | 4/5 | Strong | Maintain a moving window and state |
| Prefix Sum | 4/5 | Strong | Prefix accumulation / range-sum thinking |
| Kadane | 4/5 | Strong | Running best; discard harmful contribution |
| Product / Array Patterns | 4/5 | Strong | Prefix/suffix accumulation |
| Binary Search | 4/5 | Strong | Search space / binary search on answer |
| Monotonic Stack | 5/5 | Very strong | Increasing/decreasing stack, boundary discovery |
| Greedy | 4/5 | Strong | Sort + locally optimal choice |
| Tree DFS / Recursion | 5/5 | Very strong | Define what recursion returns |
| BST | 5/5 | Very strong | Range constraints / inorder |
| Tree DP | 5/5 | Very strong | Return useful subtree information |
| Tree BFS | 5/5 | Very strong | Level-by-level traversal |
| Tree Construction | 4/5 | Strong | Traversal relationship + index map |
| Tree Serialization | 5/5 | Very strong | Preorder + null markers |
| Graph DFS | 4/5 | Strong | Connected components / grid traversal |
| Graph BFS | 4/5 | Strong | Multi-source BFS |
| Graph cycle handling | 4/5 | Strong | Visited/cache map |
| Advanced Graph Algorithms | Not rated | Not started | Topological sort, shortest paths, DSU |
| Backtracking | 5/5 | Very strong | Base case → choices → choose → explore → undo |
| Backtracking pruning | 5/5 | Very strong | Reject invalid states early |
| DP recursion | 5/5 | Strong | State + choices + recurrence |
| DP memoization | 4/5 | Strong | Correct state + cache |
| DP tabulation | 3/5 | **Developing — primary focus** | Dependency ordering / top-down → bottom-up |
| DP space optimization | 3/5 | Developing | Keep only required previous states |
| Advanced DP | Not rated | Developing | LIS, LCS, knapsack, edit distance, etc. |

## 2. Highest-Priority Focus

### Main weakness: Top-down DP → Bottom-up DP

Required thought process:
1. What is the state?
2. What states does the current state depend on?
3. Are those dependencies smaller or larger?
4. Which states must already be computed?
5. Therefore, in which direction should the table be filled?
6. Can only a few previous states be retained?

### Dependency-direction examples

**Coin Change**
```text
helper(amount) depends on helper(amount - coin)
→ smaller states
→ fill 0 → amount
```

**House Robber**
```text
helper(i) depends on helper(i + 1), helper(i + 2)
→ larger-index states
→ fill n-1 → 0
```

**Coin Change II**
```text
helper(amount, idx)
depends on helper(amount - coin[idx], idx)
             and helper(amount, idx + 1)
→ amount 0 → target
→ idx right → left
```

**Partition Equal Subset Sum**
```text
helper(target, idx)
depends on helper(target - nums[idx], idx + 1)
             and helper(target, idx + 1)
→ target 0 → target
→ idx right → left
```

The user has now successfully applied dependency-direction reasoning across two consecutive 2D DP problems.

## 3. Dynamic Programming Progress

### Solved: Climbing Stairs — 5/5
`f(n) = f(n-1) + f(n-2)`; recursive/memoized and iterative O(1).

### Solved: House Robber — 5/5
`f(i) = max(nums[i] + f(i+2), f(i+1))`; recursion, memoization, bottom-up, and O(1) space.

### Solved: House Robber II — 5/5
Circular houses reduced to two linear cases and reused House Robber logic.

### Solved: Coin Change — 5/5
Minimum coins; top-down, memoization, and bottom-up. Learned sentinel distinction between not-computed and impossible.

### Solved: Coin Change II — 4/5
**LeetCode:** 518

State:
```text
helper(amount, idx)
= number of combinations to make amount using coins from idx onward
```

Recurrence:
```text
take → helper(amount - coins[idx], idx)
skip → helper(amount, idx + 1)
```

Bottom-up dependency:
```text
dp[amount][idx]
= dp[amount - coins[idx]][idx]
+ dp[amount][idx + 1]
```

Fill: amount `0 → target`, idx `n-1 → 0`.

### Solved: Partition Equal Subset Sum — 5/5 for this problem
**LeetCode:** 416

First observation:
```text
if totalSum is odd → false
else target = totalSum / 2
```

Top-down state:
```text
helper(nums, target, idx)
= whether target can be formed using nums[idx...]
```

Choices:
```text
take → helper(target - nums[idx], idx + 1)
skip → helper(target, idx + 1)
```

Base cases:
```text
target == 0 → true
idx == n or target < 0 → false
```

Bottom-up state:
```text
dp[target][idx]
= whether target can be formed using nums[idx...]
```

Dependencies:
```text
dp[target - nums[idx]][idx + 1]
dp[target][idx + 1]
```

Fill direction:
```text
target: 0 → sum/2
idx:    n-1 → 0
```

Complexity:
```text
Time:  O(n * target)
Space: O(n * target)
```

The user independently produced the correct bottom-up implementation.

## 4. Solved Problem Index

### Arrays / Search
- Sliding Window problems
- Prefix Sum problems
- Kadane / Maximum Subarray
- Product of Array Except Self
- Binary Search
- Capacity to Ship Packages Within D Days

### Monotonic Stack
- Largest Rectangle in Histogram
- Daily Temperatures
- Next Greater Element II
- Stock Span
- Trapping Rain Water
- Sum of Subarray Minimums

### Greedy
- Non-overlapping Intervals / Erase Overlap Intervals

### Trees / BST
- Maximum Depth of Binary Tree
- Path Sum
- Lowest Common Ancestor of Binary Tree
- Diameter of Binary Tree
- Balanced Binary Tree
- Binary Tree Maximum Path Sum
- Binary Tree Level Order Traversal
- Binary Tree Paths
- Binary Tree Right Side View
- Validate Binary Search Tree
- Kth Smallest Element in BST
- Construct Binary Tree from Preorder and Inorder Traversal
- Serialize and Deserialize Binary Tree

### Graphs
- Number of Islands
- Rotting Oranges
- Clone Graph

### Backtracking
- Subsets
- Permutations
- Combination Sum
- Generate Parentheses

### Dynamic Programming
- Climbing Stairs
- House Robber
- House Robber II
- Coin Change
- Coin Change II — LeetCode 518
- **Partition Equal Subset Sum — LeetCode 416 — LAST SOLVED**

## 5. What Another AI Agent Should Know

### Teaching style
- User prefers deriving solutions rather than receiving code immediately.
- Ask for the approach first.
- Avoid hints unless requested.
- Focus on pattern recognition, not memorization.
- After solving, give correctness, complexity, key insight, and reusable pattern.

### Current strategy
- Trees, backtracking, and monotonic stack are strong; avoid excessive basic practice.
- Graph problems are temporarily paused while graph concepts are studied.
- DP should receive increased attention, especially top-down → bottom-up conversion.
- **Resume from AFTER Partition Equal Subset Sum.**
- Do not repeat previous DP problems unless revision is requested.

## 6. Current Priority Queue

### Priority 1 — DP Tabulation
Continue testing dependency analysis across different DP structures.

### Priority 2 — Advanced DP
Next suitable problems:
- Longest Increasing Subsequence
- Min Cost Climbing Stairs
- Longest Common Subsequence
- 0/1 Knapsack
- Edit Distance

### Priority 3 — Graph Concepts / Algorithms
- Graph representations
- Cycle detection
- Topological Sort
- Shortest paths
- DSU

### Maintain
- Trees
- Monotonic Stack
- Backtracking
- Binary Search
- Greedy
- Sliding Window / Prefix Sum / Kadane

## 7. Overall Interview Readiness Snapshot

```text
Recursion / Tree Thinking       █████  5/5
Monotonic Stack                 █████  5/5
Backtracking                    █████  5/5
BST                             █████  5/5
Tree DP                         █████  5/5
Arrays / Core Patterns          ████░  4/5
Greedy                          ████░  4/5
Graph Fundamentals              ████░  4/5
DP Recursion                    █████  5/5
DP Memoization                  ████░  4/5
DP Tabulation                   ███░░  3/5  ← PRIMARY FOCUS
DP Space Optimization           ███░░  3/5
Advanced DP                     ░░░░░  Developing
Advanced Graph                  ░░░░░  Not started
```

**Last updated:** 2026-08-18
**Current learning focus:** Dynamic Programming — especially Top-Down → Bottom-Up conversion.
**Last solved problem:** Partition Equal Subset Sum (LeetCode 416).
**Resume point:** Next DP problem after Partition Equal Subset Sum.

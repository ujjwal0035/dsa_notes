# DSA Interview Preparation — Skills & Progress Tracker

**Purpose:** Persistent, agent-readable tracker for DSA interview preparation.
**Primary language:** Java
**Update rule:** Whenever a new problem is solved, a pattern is learned, a rating changes, or a weakness is identified, update this file.

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
| DP tabulation | 2/5 | **Main weakness** | Dependency ordering / top-down → bottom-up |
| DP space optimization | 3/5 | Developing | Keep only required previous states |
| Advanced DP | Not rated | Not started | LIS, LCS, knapsack, edit distance, etc. |

---

## 2. Highest-Priority Focus

### Main weakness: Top-down DP → Bottom-up DP

The user can usually derive:
1. Recursive state
2. Meaning of `helper(state)`
3. Choices
4. Recurrence
5. Memoization

The difficult step is converting that memoized solution into tabulation.

### Required thought process

1. What is the state?
2. What states does the current state depend on?
3. Are those dependencies smaller or larger?
4. Which states must already be computed?
5. Therefore, in which direction should the table be filled?
6. Can only a few previous states be retained?

### Examples already learned

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

This dependency-direction rule should be reinforced repeatedly.

---

## 3. Detailed Topic Progress

## Sliding Window — 4/5
Core pattern: maintain a window `[left, right]`, expand right, shrink left when constraints fail, and maintain only the required state. Good understanding; maintain through mixed problems.

## Prefix Sum — 4/5
Core pattern: cumulative information for fast range/subarray calculations. Good understanding; maintain through mixed problems.

## Kadane / Maximum Subarray — 4/5
Core pattern: track the best subarray ending at the current position and discard harmful negative contribution. Important connection: the same idea appears in tree maximum-path-sum when negative branches are clamped to zero.

## Product / Array Patterns — 4/5
Covered Product Except Self and prefix/suffix accumulation. Core idea: compute independent left/right contributions without division.

## Binary Search — 4/5
Covered standard binary search and binary search on answer/search space, including Capacity to Ship Packages Within D Days. Pattern: identify monotonic answer space, test `mid`, and move toward the feasible optimum.

## Monotonic Stack — 5/5
One of the strongest areas. Core framework: maintain increasing/decreasing order; when current value breaks the order, popped elements reveal boundaries/next greater or smaller relationships.

### Solved
- Largest Rectangle in Histogram — increasing stack, width from boundaries.
- Daily Temperatures — decreasing stack of indices; next greater day.
- Next Greater Element II — circular array, effectively two passes.
- Stock Span — decreasing stack; span from previous greater index.
- Trapping Rain Water — learned prefix/suffix, two-pointer, and stack approaches; contributions are additive per popped middle bar.
- Sum of Subarray Minimums — smaller boundaries and contribution counting: `leftCount * rightCount * arr[i]`.

## Greedy / Intervals — 4/5
Solved Erase Overlap Intervals. Final pattern: sort by end time and keep the earliest-finishing compatible interval. User initially tried merging/list tracking, then recognized the greedy reduction.

## Trees / DFS — 5/5
One of the strongest areas. Core mental model: ask what information the parent needs from each subtree.

### Solved
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

### Important tree patterns
- Height: `1 + max(left, right)`.
- Path problems: carry remaining target/state and enforce leaf conditions when required.
- LCA: if both sides return a node, current node is the LCA; otherwise propagate the non-null result.
- Diameter/Max Path: return one branch upward, but use both branches for the global answer.
- Balanced tree: return `-1` as an unbalanced sentinel to avoid repeated height calculations.
- BST validation: propagate valid ranges to descendants.
- BST inorder traversal is sorted.
- Tree serialization needs null markers to preserve structure.
- Right-side view can be solved with right-first DFS and first node per depth.

## Graph Fundamentals — 4/5 for current basics
The user has intentionally paused heavy graph practice while studying graph concepts.

### Solved
- Number of Islands — grid DFS / connected components.
- Rotting Oranges — multi-source BFS; one BFS level represents one minute; track fresh count.
- Clone Graph — DFS + original-to-clone map; create/store clone before visiting neighbors to handle cycles.

### Later graph topics
Graph representations, cycle detection, topological sort, shortest paths, Dijkstra, Bellman-Ford, Union-Find/DSU, MST.

## Backtracking — 5/5
Strong area. Master framework:
```text
Base Case
↓
Choices
↓
Choose
↓
Explore
↓
Undo
```

### Solved
- Subsets — Take / Skip.
- Permutations — choose any unused element; optimized from `path.contains()` to `visited[]`.
- Combination Sum — choose candidate and reuse it by passing `i`; move forward to avoid duplicate orderings.
- Generate Parentheses — constraint-based pruning; add `(` while `open < n`, add `)` only while `close < open`.

### Backtracking checklist
1. What is the state?
2. What is the base case?
3. What choices exist?
4. Which choices are valid?
5. What changes when I choose?
6. What must be undone after recursion?

## Dynamic Programming — 3/5 overall, developing
Strong top-down reasoning; main weakness is tabulation conversion.

### DP workflow
```text
Problem
→ recursive brute force
→ define helper meaning
→ identify state
→ recurrence
→ memoization
→ dependency analysis
→ tabulation
→ space optimization
```

### Solved: Climbing Stairs — 5/5
`f(n) = f(n-1) + f(n-2)`. Solved recursive/memoized and iterative O(1) versions.

### Solved: House Robber — 5/5
`f(i) = max(nums[i] + f(i+2), f(i+1))`. Solved recursion, memoization, bottom-up, and O(1) space optimization. Key lesson: DP state is `idx`, not `nums[idx]`.

### Solved: House Robber II — 5/5
Circular houses reduced to two linear cases: `0..n-2` and `1..n-1`; take the maximum. Reused House Robber logic.

### Solved: Coin Change — recurrence/memoization strong; tabulation needs practice
Top-down recurrence:
```text
helper(amount) = min over coins (1 + helper(amount - coin))
```
Solved brute-force recursion, memoization, and bottom-up tabulation. Important sentinel lesson: do not use the same value for “not computed” and “impossible”; e.g. `-2 = not computed`, `-1 = impossible`.

Bottom-up pattern:
```text
dp[0] = 0
for amount = 1..target:
    for coin:
        if amount >= coin:
            dp[amount] = min(dp[amount], 1 + dp[amount-coin])
```
The user needed Google help for this top-down → bottom-up conversion, so dependency ordering remains the primary DP focus.

---

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

---

## 5. What Another AI Agent Should Know

### Teaching style
- User prefers deriving solutions rather than receiving code immediately.
- Ask for the approach first when appropriate.
- Avoid giving hints unless requested.
- User learns best through simple examples and pattern recognition.
- Do not encourage memorization of individual solutions.
- Emphasize recursive meaning, state, choices, dependencies, and why the algorithm works.

### Current strategy
- Trees, backtracking, and monotonic stack are strong; avoid spending excessive time on basic versions.
- Graph problems are temporarily paused while graph concepts are studied.
- DP should receive increased attention, especially top-down → bottom-up conversion.

---

## 6. Progress Update Template

Whenever a new problem is solved, update this tracker with:
```text
Problem:
LeetCode:
Topic:
Pattern:
Difficulty:
User's first approach:
Final approach:
Key insight:
Mistakes / corrections:
Complexity:
Rating:
What to revise:
```

Then update topic ratings only when there is enough evidence from multiple problems.

---

## 7. Current Priority Queue

### Priority 1 — DP Tabulation
Practice dependency analysis and conversion from memoization.

### Priority 2 — Advanced DP
After tabulation improves:
- Min Cost Climbing Stairs
- Coin Change II
- Partition Equal Subset Sum
- Longest Increasing Subsequence
- Longest Common Subsequence
- 0/1 Knapsack
- Edit Distance

### Priority 3 — Graph Concepts / Algorithms
Resume graph problem practice after fundamentals are studied:
- Graph representations
- BFS/DFS
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

---

## 8. Overall Interview Readiness Snapshot

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
DP Tabulation                   ██░░░  2/5  ← PRIMARY FOCUS
DP Space Optimization           ███░░  3/5
Advanced DP                     ░░░░░  Not started
Advanced Graph                  ░░░░░  Not started
```

**Last updated:** 2026-08-16
**Current learning focus:** Dynamic Programming — especially Top-Down → Bottom-Up conversion.

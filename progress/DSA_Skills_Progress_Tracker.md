# DSA Interview Preparation — Skills & Progress Tracker

**Purpose:** Persistent, agent-readable tracker for DSA interview preparation.
**Primary language:** Java

## CURRENT POSITION — LAST SOLVED PROBLEM

> **LAST SOLVED: Paint House — LeetCode 256**
>
> **Status:** Solved successfully in Java using recursive state modeling, memoization, and bottom-up tabulation. User also identified the possibility of reducing the 2D DP to constant-space 1D DP, but the first in-place implementation had a dependency-overwrite bug; the correct `newDp` approach was explained but not yet independently re-coded.
>
> **State:** `helper(idx, prevColor)` = minimum cost to paint houses from `idx` onward when the previous house used `prevColor`.
>
> **Color states:** `0 = Red`, `1 = Blue`, `2 = Green`, `3 = no previous color`.
>
> **Transition:** Choose any color different from `prevColor`, add the current house's painting cost, and recurse to `idx + 1` with the chosen color. For the initial state (`prevColor = 3`), all three colors are available.
>
> **Base case:** `idx == n → 0` because no houses remain to paint.
>
> **Memoization:** `dp[idx][prevColor]` caches the minimum remaining cost for each state.
>
> **Bottom-up dependency:** `dp[i][prevColor]` depends only on `dp[i+1][newColor]`, so fill houses from `n-1 → 0`.
>
> **2D tabulation:** User independently converted the recursive solution into correct bottom-up tabulation with four previous-color states and returned `dp[0][3]`.
>
> **Space optimization insight:** Because each row depends only on the next row, the table can be reduced from `O(n)` DP space to `O(1)` using two 1D arrays (`dp` and `newDp`). Directly overwriting one array is incorrect because later states would read already-updated values from the current row.
>
> **Complexity:** 2D DP: O(n) time and O(n) space. Space-optimized version: O(n) time and O(1) auxiliary DP space.
>
> **Key learning:** User successfully recognized a state containing a previous decision, derived the bottom-up direction from the dependency on `idx+1`, and recognized the rolling-array space-optimization pattern.
>
> **Resume rule:** Continue AFTER Paint House. New DP problem next.

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

**LCS**
```text
helper(n, m)
depends on helper(n-1, m-1), helper(n-1, m), helper(n, m-1)
→ fill rows/columns from smaller indices toward larger indices
```

**Word Break**
```text
helper(idx)
depends on helper(end + 1)
→ dependency is at a larger index
→ fill idx n-1 → 0
```

**Paint House**
```text
helper(idx, prevColor)
depends on helper(idx + 1, chosenColor)
→ dependency is at a larger index
→ fill idx n-1 → 0
```

The user has now successfully applied dependency-direction reasoning across multiple different DP structures, including 1D and 2D state spaces.

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

### Solved: Partition Equal Subset Sum — 5/5
**LeetCode:** 416

State:
```text
helper(nums, target, idx)
= whether target can be formed using nums[idx...]
```

Choices:
```text
take → helper(target - nums[idx], idx + 1)
skip → helper(target, idx + 1)
```

Bottom-up fill: target `0 → sum/2`, idx `n-1 → 0`.

The user independently produced the correct bottom-up implementation.

### Solved: Longest Common Subsequence — 5/5
**LeetCode:** 1143

Top-down state:
```text
helper(text1, text2, n, m)
= LCS length for prefixes ending at n and m
```

Recurrence:
```text
if text1[n] == text2[m]:
    1 + helper(n-1, m-1)
else:
    max(helper(n-1, m), helper(n, m-1))
```

Bottom-up state:
```text
dp[i][j]
= LCS length of first i chars of text1 and first j chars of text2
```

Fill direction: `i: 1 → n`, `j: 1 → m`.

Complexity: `O(n*m)` time, `O(n*m)` space.

### Solved: Word Break — 5/5
**LeetCode:** 139

Final top-down state:
```text
helper(s, set, idx)
= whether suffix s[idx...] can be segmented into dictionary words
```

Transition: try every substring starting at `idx`; if it is in the dictionary, recurse on `end + 1`.

Base case: `idx == n → true`.

Bottom-up: `dp[n] = true`; fill `idx = n-1 → 0` and use `dp[end+1]`.

Dictionary was converted to `HashSet` for average O(1) membership lookup. Maximum-word-length and Trie optimizations were discussed.

Complexity of straightforward substring implementation: roughly O(n^3) worst-case due to substring creation/hashing overhead; DP space O(n).

The user independently produced the correct bottom-up implementation.

### Solved: Unique Paths — 5/5
**LeetCode:** 62

State: `dp[i][j]` = number of unique paths from cell `(i,j)` to the bottom-right destination.

Base cases: last row and last column are `1`.

Transition: `dp[i][j] = dp[i+1][j] + dp[i][j+1]`.

Fill direction: bottom-to-top and right-to-left.

Complexity: O(m*n) time and O(m*n) space.

**Key learning:** User independently derived bottom-up DP directly from the problem and correctly identified dependency direction.

### Solved: Target Sum — 5/5
**LeetCode:** 494

State: `helper(nums, idx, target)` where `target` is the remaining sum needed using `nums[0...idx]`.

Choices: `+nums[idx]` makes the remaining target `target - nums[idx]`; `-nums[idx]` makes it `target + nums[idx]`.

Memoization used an offset because target can be negative. Bottom-up used shifted state `j = OFFSET + target`, with transitions `j-nums[i]` and `j+nums[i]`, and filled rows from `n-1` down to `0`.

**Key learning:** User independently converted the offset-based memoized state into correct bottom-up tabulation.

### Solved: Edit Distance — 5/5
**LeetCode:** 72

State: `helper(word1, word2, i, j)` = minimum operations to convert `word1[i...]` into `word2[j...]`.

Base cases handle remaining insertions/deletions. Matching characters advance both indices with no cost. Otherwise choose minimum of replace, delete, and insert.

Important insertion insight: insertion advances `j` but does not advance `i`.

Bottom-up fills `i=n-1→0`, `j=m-1→0` because dependencies use larger indices.

**Key learning:** User successfully derived loop direction from recursive dependencies.

### Solved: Paint House — 5/5
**LeetCode:** 256

State:
```text
helper(idx, prevColor)
= minimum cost to paint houses from idx onward
  when the previous house used prevColor
```

States:
```text
0 → Red
1 → Blue
2 → Green
3 → no previous color
```

Transition: choose a color different from `prevColor`, add `cost[idx][chosenColor]`, and recurse to `idx+1`.

Base case: `idx == n → 0`.

Memoized state: `dp[idx][prevColor]`.

Bottom-up: because each state depends on `idx+1`, fill `idx = n-1 → 0`. The initial answer is `dp[0][3]`.

User independently produced the correct 2D tabulation.

**Space optimization:** Only the next row is required, so the 2D table can be reduced to constant space with `dp` + `newDp`. User attempted in-place 1D updates and correctly understood the intended optimization, but the implementation overwrote dependencies before all current-row states were computed. The `newDp` rolling-array pattern was explained.

Complexity: O(n) time; O(n) space for 2D DP, O(1) auxiliary DP space after rolling-array optimization.

### Solved: Longest Consecutive Sequence — 5/5 (Blind Revision #1)
**LeetCode:** 128

User first produced the sorting solution: O(n log n).

Then independently derived the optimal HashSet solution: insert all numbers into a set, start a sequence only when `num - 1` is absent, then expand forward while consecutive values exist.

Optimal standard complexity: average O(n) time and O(n) space.

**Key pattern:** HashSet existence lookup + sequence-start detection + forward expansion.

This was the first successful blind random revision in the current revision cadence.

### LIS note
The user derived and shared a correct recursive state/choice approach for Longest Increasing Subsequence, but did not complete the tabulation step. Treat LIS as **in progress**, not solved, unless the user explicitly returns to it.

### 0/1 Knapsack note
The user stated that classic 0/1 Knapsack was already solved on August 17, 2026, but the current GitHub repository search did not contain a matching entry. **Do not assume it is unsolved or ask the user to redo it unless they request it.**

## 4. Solved Problem Index

### Arrays / Search
- Sliding Window problems
- Prefix Sum problems
- Kadane / Maximum Subarray
- Product of Array Except Self
- Binary Search
- Capacity to Ship Packages Within D Days
- Longest Consecutive Sequence — LeetCode 128 (Blind Revision #1)

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
- Partition Equal Subset Sum — LeetCode 416
- Longest Common Subsequence — LeetCode 1143
- Word Break — LeetCode 139
- Edit Distance — LeetCode 72
- Target Sum — LeetCode 494
- Unique Paths — LeetCode 62
- Paint House — LeetCode 256
- Longest Increasing Subsequence — in progress
- 0/1 Knapsack — previously solved by user; repository entry not found during verification

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
- DP should receive increased attention, especially top-down → bottom-up conversion and space optimization.
- **Resume from AFTER Paint House.**
- Do not repeat previous DP problems unless revision is requested.
- Current cadence: after two new DP problems, give one blind random revision problem. The latest blind revision was Longest Consecutive Sequence, followed by Paint House as the next new DP problem.
- Remember that 0/1 Knapsack was reported by the user as previously solved, even though it was not found in the current GitHub search.

## 6. Current Priority Queue

### Priority 1 — DP Tabulation
Continue testing dependency analysis across different DP structures.

### Priority 2 — DP Space Optimization
Continue practicing rolling-array / constant-space conversions, especially where current states depend only on the immediately previous/next row.

### Priority 3 — Advanced DP
Next suitable problems:
- Min Cost Climbing Stairs
- Longest Increasing Subsequence — currently in progress
- Stock DP
- Palindrome / interval DP
- Other DP patterns not already solved

### Priority 4 — Graph Concepts / Algorithms
- Graph representations
- Cycle detection
- Topological Sort
- Shortest paths
- DSU

### Maintain
- Trees
- Monotonic Stack
- Backtracking
# DSA Interview Preparation — Skills & Progress Tracker

**Purpose:** Persistent, agent-readable tracker for DSA interview preparation.
**Primary language:** Java

## CURRENT POSITION — LAST SOLVED PROBLEM

> **LATEST PRACTICE: Maximum Product Subarray — LeetCode 152 (blind revision); latest new DP: Min Cost Climbing Stairs — LeetCode 746**
>
> **Status:** Solved successfully in Java through recursive state modeling, 2D memoization, 2D bottom-up tabulation, and 1D O(n²) DP.
>
> **Top-down state:** `helper(idx, prevInd)` = maximum LIS length from `idx) onward when `prevInd` is the previously selected index. `prevInd = -1` means no previous element has been selected.
>
> **2D tabulation:** User correctly mapped the sentinel state `prevInd = -1` to column `0` using `prevInd + 1`, and derived the transition `take = 1 + dp[idx + 1][idx + 1]`, `skip = dp[idx + 1][prevInd + 1]`.
>
> **1D optimization:** User then derived a different equivalent state: `dp[i]) = length of the longest increasing subsequence ending exactly at index `i`. Transition: for every `j < i), if `nums[j] < nums[i]`, then `dp[i] = max(dp[i], dp[j] + 1)`. Final answer is `max(dp)`.
>
> **Complexity:** O(n²) time and O(n) space.
>
> **Key learning:** User successfully converted recursion → memoization → tabulation → changed-state 1D DP, which directly targets the current DP tabulation/space-optimization weakness.
>
> **Resume rule:** Continue after LIS. Do not repeat Coin Change, Coin Change II, Partition Equal Subset Sum, LCS, Word Break, Edit Distance, Target Sum, Unique Paths, Paint House, or LIS unless revision is explicitly requested.

---

## 1. Current Skill Snapshot

| Topic | Rating | Status | Main pattern / skill |
|---|---:|---|---|
| Sliding Window | 4/5 | Strong | Maintain a moving window and state |
| Prefix Sum | 4/5 | Strong | Prefix accumulation / range-sum thinking |
| Kadane | 4/5 | Strong | Running best; discard harmful contribution |
| Product / Array Patterns | 4/5 | Strong | Prefix/suffix accumulation |
| Binary Search | 4/5 | Strong | Search space / binary search on answer |
| Two Pointers | 4/5 | Strong | Sort + converge from both ends |
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
| DP tabulation | 4/5 | **Improving** | Dependency ordering / top-down → bottom-up |
| DP space optimization | 3/5 | Developing | Keep only required previous states |
| Advanced DP | 4/5 | Developing | LIS, LCS, knapsack, edit distance, etc. |

## 2. Highest-Priority Focus

### Main weakness: Top-down DP → Bottom-up DP

Required thought process:
1. What is the state?
2. What states does the current state depend on?
3. Are those dependencies smaller or larger?
4. Which states must already be computed?
5. Therefore, in which direction should the table be filled?
6. Can only a few previous states be retained?
7. Can the state itself be reformulated to reduce dimensions?

The LIS exercise strengthened all seven steps.

### Space optimization
Continue practicing:
- rolling arrays when a row depends only on the next/previous row
- state reformulation when a dimension represents a historical choice that can be encoded differently

---

## 3. Recent Practice / Revision

### Solved: Max Number of K-Sum Pairs — LeetCode 1679
**Pattern:** Sorting + Two Pointers

User independently produced the correct solution:
- sort array
- maintain left/right pointers
- sum == k → count and move both
- sum > k → decrement right
- sum < k → increment left

Complexity: O(n log n) time, O(1) auxiliary space.

User also correctly identified that a HashMap/frequency approach can solve the problem in average O(n) time and O(n) space, including when duplicates exist.

### Solved: Subarray Sum Equals K — LeetCode 560
**Pattern:** Prefix Sum + HashMap frequency

User independently produced the standard optimal solution:
- maintain running prefix sum
- look for `sum - k`
- add the frequency of that prefix sum to the answer
- initialize `map.put(0, 1)`

Complexity: O(n) average time, O(n) space.

### Solved: Product of Array Except Self — LeetCode 238
**Pattern:** Prefix Product + Suffix Product

User considered a zero-aware division approach, then independently implemented the optimal no-division solution:
- first pass stores left products in result
- second pass maintains suffix product and multiplies it into result

Complexity: O(n) time, O(1) auxiliary space excluding output.

### Blind Revision #2: Longest Substring Without Repeating Characters — LeetCode 3
**Pattern:** Sliding Window + HashMap last index

User had already solved it previously and quickly reproduced the correct optimal solution. Important detail correctly explained: only move `left` when the previous occurrence is inside the current window (`map.get(ch) >= left`).

Complexity: O(n) time, O(min(n, charset)) space.

This counts as blind revision #2, not a new problem.

---

### Blind Revision #3: Maximum Product Subarray — LeetCode 152
**Pattern:** Track maximum and minimum product ending at each index.

User independently implemented the correct O(n) one-pass solution. At each element, they preserve the previous minimum and maximum products, then compute the new minimum and maximum from the current element and its products with both previous states. This correctly handles negative values and zero.

**Complexity:** O(n) time, O(1) space.

## 4. Dynamic Programming Progress

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
State `helper(amount, idx)) = number of combinations using coins from `idx` onward. Take keeps the index; skip advances it. Bottom-up amount 0→target and idx right→left.

### Solved: Partition Equal Subset Sum — 5/5
**LeetCode:** 416
State `helper(target, idx)) = whether target can be formed from `idx...`; take/skip; bottom-up target increasing and idx decreasing.

### Solved: Longest Common Subsequence — 5/5
**LeetCode:** 1143
Prefix-based 2D DP; match → diagonal + 1, mismatch → max(up,left).

### Solved: Word Break — 5/5
**LeetCode:** 139
Suffix-state DP with HashSet dictionary membership; bottom-up from n-1 to 0.

### Solved: Unique Paths — 5/5
**LeetCode:** 62
Grid DP; `dp[i][j] = dp[i+1][j] + dp[i][j+1]`; bottom-up from bottom-right dependencies.

### Solved: Target Sum — 5/5
**LeetCode:** 494
Remaining-target state with offset for negative targets; bottom-up translated using shifted indices.

### Solved: Edit Distance — 5/5
**LeetCode:** 72
Suffix-state DP with insert/delete/replace; bottom-up from larger indices downward.

### Solved: Paint House — 5/5
**LeetCode:** 256
State `helper(idx, prevColor)`; 2D tabulation completed. Rolling-array optimization was understood, though the first in-place implementation overwrote dependencies.

### Solved: Min Cost Climbing Stairs — 5/5
**LeetCode:** 746

State: `dp[i]` = minimum cost to reach the top when starting from stair `i`.

Transition: `dp[i] = cost[i] + min(dp[i+1], dp[i+2])`; return `min(dp[0], dp[1])` because starting at stair 0 or stair 1 is allowed.

User independently derived right-to-left tabulation and optimized it to O(1) space using two rolling variables.

**Complexity:** O(n) time, O(1) auxiliary space after optimization.

### Solved: Longest Increasing Subsequence — 5/5
**LeetCode:** 300
Completed recursive state modeling, memoization, 2D tabulation, and 1D O(n²) DP.

1D state:
`dp[i] = LIS length ending at i`.

Transition:
`if nums[j] < nums[i], dp[i] = max(dp[i], dp[j] + 1)`.

Complexity: O(n²) time, O(n) space.

### Previously solved: 0/1 Knapsack
User reported classic 0/1 Knapsack was solved previously; repository entry was not found during verification. Do not assume unsolved unless asked.

---

## 5. Solved Problem Index

### Arrays / Search
- Sliding Window problems
- Prefix Sum problems
- Kadane / Maximum Subarray
- Product of Array Except Self — LeetCode 238
- Maximum Product Subarray — LeetCode 152 (Blind Revision #3)
- Binary Search
- Capacity to Ship Packages Within D Days
- Longest Consecutive Sequence — LeetCode 128 (Blind Revision #1)
- Subarray Sum Equals K — LeetCode 560
- Max Number of K-Sum Pairs — LeetCode 1679
- Longest Substring Without Repeating Characters — LeetCode 3 (Blind Revision #2)

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
- Longest Increasing Subsequence — LeetCode 300
- 0/1 Knapsack — previously solved by user; repository entry not found during verification

---

## 6. Current Practice Cadence

**2 new DP problems → 1 blind revision → repeat.**

Latest blind revision: Maximum Product Subarray (LC 152), completed correctly.

Latest new DP: Min Cost Climbing Stairs (LC 746), completed with O(1) space optimization.

**Next session:** choose a NEW DP problem that is not already in the solved list. Prefer a problem that reinforces tabulation and/or space optimization rather than repeating Coin Change.

### Suggested next NEW DP
**Minimum Falling Path Sum — LeetCode 931**

Reason:
- practices 2D DP state definition and dependency ordering
- reinforces bottom-up tabulation
- offers an opportunity to practice rolling-row space optimization
- do not count the previously suggested House Robber (LC 198), since it is already solved

After two new DP problems, do another blind revision without revealing the pattern beforehand.

---

## 7. What Another AI Agent Should Know

### Teaching style
- User prefers deriving solutions rather than receiving code immediately.
- Ask for the approach first.
- Avoid hints unless requested.
- Focus on pattern recognition, not memorization.
- After solving, give correctness, complexity, key insight, and reusable pattern.
- When converting recursion to tabulation, explicitly map each recursive state to its table indices before discussing loop direction.

### Current strategy
- Trees, backtracking, and monotonic stack are strong; avoid excessive basic practice.
- Graph problems are temporarily paused while graph concepts are studied.
- DP receives increased attention, especially top-down → bottom-up conversion and space optimization.
- Do not repeat previously solved DP problems unless revision is requested.
- Maintain the cadence: 2 new DP → 1 blind revision.
- 0/1 Knapsack was reported by the user as previously solved, even though it was not found in the repository.

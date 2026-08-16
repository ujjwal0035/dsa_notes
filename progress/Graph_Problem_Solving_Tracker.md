# Graphs — Problem Solving & Pattern Tracker

**Purpose:** Detailed, interview-oriented Graph tracker. This file records the question, pattern identification, logic discussion, implementation, special cases, mistakes, complexity, and reusable graph insight for every problem.

## Mandatory learning flow for every future Graph problem

1. **Question** — read and restate the problem.
2. **Pattern identification** — identify the graph concept before coding.
3. **Logic discussion** — define graph/state, traversal, visited rules, invariants, and why the approach works.
4. **Implementation** — write the Java solution.
5. **Review** — correctness, edge cases, complexity, mistakes, and alternatives.
6. **Pattern note** — record the reusable graph pattern.
7. **Special cases** — record disconnected graphs, cycles, duplicate edges, directed/undirected differences, etc.
8. **Rating** — rate the problem/pattern and update overall skill only with enough evidence.
9. **Git update** — append the solved problem and update priorities.

---

# Current Graph Skill Snapshot

| Skill | Rating | Status |
|---|---:|---|
| Graph representation | Not rated | Concepts being studied |
| DFS | 4/5 | Good |
| BFS | 4/5 | Good |
| Grid as graph | 4/5 | Good |
| Multi-source BFS | 4/5 | Good |
| Visited-map cycle handling | 4/5 | Good |
| Undirected cycle detection | Not rated | Not yet deeply practiced |
| Directed cycle detection | Not rated | Not started |
| Topological Sort | Not rated | Not started / concept study |
| Shortest paths | Not rated | Not started deeply |
| Dijkstra | Not rated | Future |
| Bellman-Ford | Not rated | Future |
| 0-1 BFS | Not rated | Future |
| DSU / Union-Find | Not rated | Future |
| MST | Not rated | Future |

**Current strategy:** The user is studying graph concepts separately, so do not rush into advanced graph problem volume until the fundamentals are clear.

---

# Graph Recognition Framework

Before coding, ask:

### 1. What type of graph is this?
- Directed / undirected
- Weighted / unweighted
- Tree / general graph
- Explicit graph / grid / implicit state graph

### 2. What is being asked?
- Reachability?
- Number of components?
- Shortest path?
- Detect a cycle?
- Ordering/dependency?
- Connectivity after unions?
- Minimum total connection cost?

### 3. Which traversal/pattern fits?
- DFS
- BFS
- Multi-source BFS
- Topological sort
- Dijkstra
- Bellman-Ford
- DSU
- MST

### 4. What must be tracked?
- `visited[]`
- parent
- distance
- indegree
- color/state
- priority queue
- DSU parent/rank/size

### 5. What are the special cases?
- Disconnected graph
- Cycle
- Self-loop
- Duplicate edge
- Isolated node
- Empty input
- Directed vs undirected semantics

---

# Solved Problem 1 — Number of Islands

**LeetCode:** 200. Number of Islands

### 1. Question
Count connected groups of land (`1`) in a 2D grid where horizontal and vertical neighbors are connected.

### 2. Pattern identification
**Pattern:** Grid DFS / connected components.

A grid can be treated as an implicit graph where each land cell is a node and its four neighbors are edges.

### 3. Logic discussion
For every unvisited land cell:
1. Start DFS.
2. Visit the entire connected island.
3. Mark visited cells by changing `1 → 0`.
4. Increment island count once per DFS start.

### 4. Implementation
User used recursive DFS with four directions:
```text
up
 down
left
right
```
Boundary checks prevent invalid access.

### Special case
If a cell is already `0`, skip it because it belongs to water or has already been visited.

### Complexity
- Time: `O(rows * cols)`
- Extra space: `O(rows * cols)` worst-case recursion stack.

### Rating
**4/5**

### Pattern to remember
> One DFS/BFS from every unvisited node counts one connected component.

---

# Solved Problem 2 — Rotting Oranges

**LeetCode:** 994. Rotting Oranges

### 1. Question
Every minute, rotten oranges make adjacent fresh oranges rotten. Return the minimum time until all are rotten, or `-1` if impossible.

### 2. Pattern identification
**Pattern:** Multi-source BFS.

All initially rotten oranges are sources that start spreading at time `0` simultaneously.

### 3. Logic discussion
Important insight:
> One BFS level represents one minute.

Steps:
1. Put every rotten orange into the queue initially.
2. Count fresh oranges.
3. Process the current queue level.
4. Turn adjacent fresh oranges rotten and enqueue them.
5. Decrease fresh count.
6. Increment time once after a level actually spreads.
7. If fresh becomes zero, return time.
8. If BFS ends with fresh remaining, return `-1`.

### Important correction from earlier attempt
A simple left-to-right grid scan is incorrect because a newly rotten orange must not spread again in the same minute. BFS levels preserve simultaneous timing.

### Complexity
- Time: `O(rows * cols)`
- Space: `O(rows * cols)` worst-case queue.

### Rating
**4/5**

### Pattern to remember
> Multiple starting points + minimum time in equal-cost steps → think multi-source BFS.

---

# Solved Problem 3 — Clone Graph

**LeetCode:** 133. Clone Graph

### 1. Question
Create a deep copy of a connected graph that may contain cycles.

### 2. Pattern identification
**Pattern:** DFS + original-node → clone-node map.

### 3. Logic discussion
For an original node:
1. If already cloned, return the existing clone.
2. Otherwise create a clone immediately.
3. Put original → clone in the map **before** visiting neighbors.
4. Recursively clone every neighbor.
5. Attach cloned neighbors to the cloned node.

The map prevents infinite recursion on cycles and preserves shared graph structure.

### 4. Implementation
User used:
```text
Map<Node, Node>
```
and recursive DFS.

### Special cases
- Input node is `null` → return `null`.
- Cycles → map prevents repeated cloning.
- A node referenced by multiple neighbors must correspond to one clone object, not multiple clones.

### Complexity
- Time: `O(V + E)`
- Space: `O(V)` for map + recursion stack.

### Rating
**4/5**

### Pattern to remember
> In graph cloning, create and memoize the clone before recursively cloning neighbors.

---

# Graph Concepts To Learn Next

## Phase 1 — Fundamentals
1. Adjacency list vs adjacency matrix
2. Directed vs undirected graph
3. Weighted vs unweighted graph
4. BFS
5. DFS
6. Connected components
7. Visited-array semantics
8. Grid as an implicit graph

## Phase 2 — Cycles & Dependencies
9. Undirected cycle detection
10. Directed cycle detection
11. Topological sort with DFS
12. Kahn's algorithm / BFS topological sort
13. Course Schedule
14. Course Schedule II

## Phase 3 — Shortest Paths
15. BFS shortest path in unweighted graph
16. Dijkstra
17. Bellman-Ford
18. 0-1 BFS
19. Network Delay Time
20. Cheapest Flights Within K Stops

## Phase 4 — DSU / MST
21. DSU / Union-Find
22. Path compression
23. Union by rank/size
24. Kruskal's MST
25. Prim's MST
26. Redundant Connection
27. Number of Provinces
28. Min Cost to Connect All Points

---

# Per-Problem Record Template

Copy this for every new graph problem:

```text
## Problem

### 1. Question

### 2. Pattern identification
- What graph concept applies?
- Why?
- Directed/undirected?
- Weighted/unweighted?

### 3. Logic discussion
- Graph/state representation:
- Traversal/algorithm:
- State to track:
- Invariant:
- Why it works:
- Special cases:

### 4. Implementation
- Java approach:
- Time:
- Space:

### 5. Mistakes / corrections

### 6. Key interview insight

### 7. Pattern to remember

### 8. Rating

### 9. Revision needed
```

**Last updated:** 2026-08-16

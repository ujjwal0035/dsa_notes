# 🌳 TREE CHEAT SHEET (1-PAGE INTERVIEW REVISION)

Purpose: Fast recall of Tree concepts and patterns before interviews.

---

## ✅ TREE TRAVERSALS (CORE)

### Depth First Search (DFS)

- Preorder  → Root → Left → Right  
  Used for copying tree, serialization

- Inorder → Left → Root → Right  
  In BST, this produces sorted order

- Postorder → Left → Right → Root  
  Used for height, diameter, delete logic

All DFS traversals:
- Time complexity: O(n)
- Space complexity: O(h), where h = height of tree

---

### Breadth First Search (BFS)

- Level Order Traversal
- Uses Queue
- Traverses level by level

Time complexity: O(n)  
Space complexity: O(n)

---

## ✅ WHEN TO USE DFS vs BFS

| Problem Type | Preferred Approach |
|--------------|--------------------|
| Height / Depth | DFS (Postorder) |
| Diameter | DFS (Postorder) |
| Tree Views | BFS / DFS with level |
| Vertical Order | BFS |
| Path Problems | DFS |
| Level-wise problems | BFS |

---

## ✅ TREE HEIGHT (VERY IMPORTANT)

Key idea:
- Height is calculated **bottom-up**
- Always think in **Postorder**

Rule:
- Height(node) = 1 + max(left height, right height)

---

## ✅ DIAMETER OF TREE

Meaning:
- Longest path between any two nodes
- Path may or may not pass through root

Key Pattern:
- At each node:
  - Diameter candidate = left height + right height
- Maintain a global maximum
- Compute in single DFS traversal

---

## ✅ TREE VIEWS (INTERVIEW FAVORITE)

### Left View
- First node visible from each level
- Best solved using BFS

### Right View
- Last node visible from each level
- DFS also works if:
  - Right subtree is visited before left
  - Node is added when current level == result size

---

## ✅ TOP VIEW vs BOTTOM VIEW

Both use:
- Horizontal Distance (HD)
- BFS traversal

Difference:

| View | Rule |
|-----|-----|
| Top View | Store first node for each HD |
| Bottom View | Always overwrite node for each HD |

---

## ✅ VERTICAL ORDER TRAVERSAL

Concept:
- Group nodes by vertical lines

Pattern:
- Assign horizontal distance:
  - Root → HD = 0
  - Left child → HD - 1
  - Right child → HD + 1
- Use BFS to maintain order
- Store values grouped by HD

---

## ✅ BALANCED BINARY TREE

Definition:
- For every node, height difference of left and right subtree ≤ 1

Efficient Pattern:
- Check balance and height together
- If any subtree is unbalanced, propagate failure upward

---

## ✅ SYMMETRIC TREE

Meaning:
- Left subtree is mirror image of right subtree

Rule:
- Values must be equal
- Left.left must match Right.right
- Left.right must match Right.left

---

## ✅ LOWEST COMMON ANCESTOR (BINARY TREE)

Logic:
- If current node equals one of the targets → return it
- If targets are found in different subtrees → current node is LCA
- Uses Postorder traversal

---

## ✅ PATH BASED PROBLEMS

Examples:
- Root to Leaf paths
- Path Sum

Common Pattern:
- Use DFS
- Add node to path
- Explore children
- Remove node before returning (backtracking)

---

## ✅ THINKING FRAMEWORK (VERY IMPORTANT)

Before coding, ask:

- Is the problem height based?
- Is level order important?
- Do I need horizontal distance?
- Is it a path problem?
- Can BFS simplify this?

Then decide:
- DFS or BFS
- What extra data to carry (height, level, HD, path)

---

## ✅ COMMON INTERVIEW GOLD RULES

- Height → Postorder DFS
- Views → Level awareness
- Vertical problems → BFS + HD
- Avoid recomputing height
- Use properties of BST where applicable

---

## ✅ LAST 5-MIN INTERVIEW CHECKLIST

- Traversals clear
- Height & Diameter logic clear
- All views clear
- Vertical order logic clear
- LCA & path problems clear

If this is solid, **tree interview confidence = HIGH** ✅

---

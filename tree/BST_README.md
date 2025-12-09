# 🌳 Binary Search Tree (BST) – Complete Revision Notes

> Goal: **Understand property → apply logic → implement cleanly**

---

## 1️⃣ What is a BST?

A **Binary Search Tree** is a binary tree with a specific ordering property:

* Left subtree values are **strictly less than** the root's value.
* Right subtree values are **strictly greater than** the root's value.
* This property holds **recursively** for every node in the tree.



✅ Enables efficient search, insertion, and deletion.
⏱ Average Time Complexity: `O(log n)`
❌ Worst-Case Time Complexity: `O(n)` (if the tree is skewed)

---

## 2️⃣ BST vs Binary Tree

| Feature | Binary Tree | BST |
| :--- | :--- | :--- |
| **Ordering** | ❌ No inherent ordering rule | ✅ Strict ordering property (Left < Root < Right) |
| **Search Time** | `O(n)` (must check all nodes) | `O(log n)` average (pruning branches) |
| **Inorder Traversal** | Random order of values | ✅ **Sorted order** of values |

---

## 3️⃣ Inorder Traversal (MOST IMPORTANT) 🔑

### Key Property
✅ **Inorder traversal of any BST always yields the values in sorted, ascending order.**

The traversal order is: **Left → Root → Right**

> 📌 **This single property is the foundation for solving multiple complex BST problems.**

---

## 4️⃣ Search in BST 🔍

The property allows for immediate pruning of one subtree at each step.

* If `value < root` → Traverse **Left**
* If `value > root` → Traverse **Right**

⏱ Time: `O(h)` (where $h$ is the height of the tree)
📦 Space: `O(h)` (for recursive call stack)

---

## 5️⃣ Insert into BST ➕

**Rules:**
1.  **Maintain the BST property** at all times.
2.  Insertion always occurs at the correct **leaf position**.

✅ Typically implemented recursively or iteratively by traversing until a null position is found.

⏱ Time: `O(h)`

---

## 6️⃣ Delete from BST ⭐⭐⭐

This is the most complex operation, involving three crucial cases:



### 3 Cases (VERY IMPORTANT)
1.  **Leaf Node (Zero Children):**
    * Simply delete the node.
2.  **Node with One Child:**
    * Replace the node with its single child.
3.  **Node with Two Children:**
    * Replace the node's value with its **Inorder Successor**.
    * The **Inorder Successor** is the **smallest value in the right subtree** (the leftmost node of the right subtree).
    * Delete the Inorder Successor from its original position (this case reduces to Case 1 or 2).

> 📌 **Case 3 is the most common point of failure and is frequently asked in interviews.**

---

## 7️⃣ Validate BST ⭐⭐⭐

A **local check** (only checking `left < root < right`) is **incorrect** ❌. A node's value must be constrained by the global maximum/minimum defined by its ancestors.

### Correct Approaches
1.  **✅ Range Validation (Min/Max Constraint):**
    * Pass a `min` and `max` bound with each recursive call.
    * For the **Left** subtree, the range becomes $(\text{min}, \text{root})$.
    * For the **Right** subtree, the range becomes $(\text{root}, \text{max})$.
2.  **✅ Inorder Traversal Check:**
    * Perform an Inorder traversal and ensure that the previous value seen is **strictly less than** the current value.

⏱ Time: `O(n)`

---

## 8️⃣ Lowest Common Ancestor (LCA) in BST ⭐⭐⭐

The BST property allows for a much faster and cleaner LCA solution than a generic Binary Tree.

### Logic (Very Elegant)
Start at the root and compare the target nodes ($p$ and $q$) to the current node:

```text
If p & q are BOTH LESS than root → go LEFT
If p & q are BOTH GREATER than root → go RIGHT
Else (one is less/equal, one is greater/equal) → root is the LCA


---

## 9️⃣ Kth Smallest / Largest Element ⭐⭐⭐

### Trick
Leverage the **Inorder Traversal** property, which visits nodes in sorted order.

* **Kth smallest** $\rightarrow$ Standard **Inorder** Traversal (Left $\rightarrow$ Root $\rightarrow$ Right). Use a counter or a list to track the visited nodes. Stop and return when the $K$-th element is reached.
* **Kth largest** $\rightarrow$ **Reverse Inorder** Traversal (Right $\rightarrow$ Root $\rightarrow$ Left). Stop and return when the $K$-th element is reached.

[Image of a BST showing the sequence of nodes visited during an Inorder Traversal]

⏱ Time: $O(h + k)$ (Optimal when $k$ is small, though $O(n)$ worst-case)
📦 Space: $O(h)$ (for the recursion stack)

---

## 🔟 Range Sum in BST

The BST property allows for efficient **pruning** of unnecessary subtrees, improving performance over a generic Binary Tree traversal.

### Observation (Pruning Logic)
* If `node.val < low` $\rightarrow$ Skip the **Left** subtree (all values there will be even smaller than `node.val`).
* If `node.val > high` $\rightarrow$ Skip the **Right** subtree (all values there will be even larger than `node.val`).
* If $low \le node.val \le high$ $\rightarrow$ Include `node.val` in the sum and explore **both** subtrees.

✅ This is an example of an **optimized traversal**.
⏱ Time: Better than $O(n)$ in most cases (closer to $O(k + h)$, where $k$ is the number of nodes in the range).

---

## 1️⃣1️⃣ Floor & Ceil in BST

These are often solved with a simple search, keeping track of the best candidate found so far.

* **Floor** $\rightarrow$ The **largest value** in the BST that is $\le \text{key}$.
* **Ceiling** $\rightarrow$ The **smallest value** in the BST that is $\ge \text{key}$.

> 📌 **Implementation Idea:** Use iterative traversal.
> * For **Floor**: If the current node's value is $\le \text{key}$, store it as a potential answer and continue searching in the **Right** subtree for an even closer/larger candidate (since we want the largest $\le \text{key}$).
> * For **Ceiling**: If the current node's value is $\ge \text{key}$, store it as a potential answer and continue searching in the **Left** subtree for an even closer/smaller candidate (since we want the smallest $\ge \text{key}$).

---

## 1️⃣2️⃣ Balanced vs Skewed BST

The height of the tree ($h$) dictates the performance of core operations (search, insert, delete).

| Type | Structure | Height ($h$) | Time Complexity (Avg) | Time Complexity (Worst) |
| :--- | :--- | :--- | :--- | :--- |
| **Balanced BST** | Nearly equal depth in both subtrees | $h \approx O(\log n)$ | $O(\log n)$ | $O(\log n)$ |
| **Skewed BST** | Only
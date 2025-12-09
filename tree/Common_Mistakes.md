# 🌳 BST & Tree – Common Mistakes Patterns (Interview Focused)

---

## 1️⃣ Confusing Binary Tree vs BST Logic

### Mistake
- Applying normal Binary Tree logic to BST problems
- Ignoring the ordering property of BST

### Correct Pattern
- If key is smaller than current node → move LEFT
- If key is greater than current node → move RIGHT
- Never traverse both subtrees when BST property is available

---

## 2️⃣ Wrong BST Validation (Local Check Bug)

### Mistake
- Checking only immediate children  
  (left child < root AND right child > root)

### Why Wrong
- This verifies only local relationship
- A deeper node can violate BST rules

### Correct Pattern
- Validate using global range (min, max)
- OR ensure inorder traversal is strictly increasing

---

## 3️⃣ Using Binary Tree LCA Logic for BST

### Mistake
- Using full recursion on both sides like a normal binary tree

### Correct Pattern
- If both target nodes are smaller than root → go LEFT
- If both are greater than root → go RIGHT
- Otherwise → current node is the LCA

---

## 4️⃣ Forgetting Inorder = Sorted in BST

### Mistake
- Solving by storing values and sorting later

### Correct Pattern
- Kth smallest → inorder traversal
- Kth largest → reverse inorder traversal
- Validate BST → inorder values strictly increasing

---

## 5️⃣ Ignoring Skewed BST Case

### Mistake
- Claiming time complexity is always O(log n)

### Reality
- Skewed BST behaves like a linked list
- Worst-case time complexity becomes O(n)

### Correct Interview Answer
- Time complexity is O(h), where h is the tree height

---

## 6️⃣ Incomplete Delete Logic in BST

### Mistake
- Handling only leaf or single-child cases

### Correct Pattern
- Case 1: Node has no children → remove node
- Case 2: Node has one child → replace node with child
- Case 3: Node has two children → replace with inorder successor

---

## 7️⃣ Forgetting Backtracking in Path Problems

### Mistake
- Adding nodes to path but never removing them

### Result
- Incorrect paths and extra values

### Correct Pattern
- Add node to path
- Recurse
- Remove node before returning

---

## 8️⃣ Overusing Extra Data Structures in BST

### Mistake
- Converting BST into array / list for every operation

### Correct Pattern
- Use BST properties:
  - Direction-based traversal
  - Inorder traversal
  - Range pruning

---

## 9️⃣ Missing Null Checks

### Mistake
- Assuming nodes and children always exist

### Correct Pattern
- Always check if the current node is null before processing

---

## 🔟 Not Mentioning Balanced Trees in Discussion

### Mistake
- Ignoring worst-case behavior of normal BST

### Correct Interview Explanation
- Normal BST can degrade to O(n)
- Balanced trees (AVL, Red-Black) guarantee O(log n)

---

## ✅ FINAL QUICK RECALL

- BST power comes from ordering
- Validate using global constraints, not local checks
- LCA uses direction, not recursion on both sides
- Inorder traversal gives sorted output
- Always mention worst-case complexity

---

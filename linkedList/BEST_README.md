# 🔗 Linked List – Complete Revision Notes (Interview Ready)

Yeh file Linked List ke saare important concepts, patterns aur interview tricks cover karti hai.

---

## 1️⃣ What is a Linked List?

- Linear data structure
- Nodes connected via pointers (or references)
- Each node generally contains:
  - Data
  - Pointer to next node

### Types of Linked Lists

- Singly Linked List  
  Each node → data + next

- Doubly Linked List  
  Each node → data + prev + next

- Circular Linked List  
  Last node ka next → head node

---

## 2️⃣ Linked List vs Array

| Feature        | Array                    | Linked List                        |
|----------------|--------------------------|------------------------------------|
| Access by index | O(1)                     | O(n)                              |
| Insert/delete at middle | O(n)           | O(1) (if node reference known)    |
| Memory         | Contiguous               | Non-contiguous                    |
| Cache friendly | High                     | Low                               |

---

## 3️⃣ Common Operations (Concept)

- Insert at head  
  New node ka next → current head, then head update

- Insert at tail  
  Traverse to last node, last.next → new node

- Delete node  
  Previous node ka next → node.next

- Search  
  Traverse from head until data found or null

---

## 4️⃣ Two-pointer (Fast/Slow) Pattern (VERY IMPORTANT)

Fast–slow pointer se ye problems solve hote hain:

- Middle of Linked List
- Detect cycle
- Cycle starting node
- Palindrome check (with reverse)
- Detect intersection point (with variation)

---

## 5️⃣ Find Middle of Linked List

Pattern:

- Slow pointer → 1 step
- Fast pointer → 2 steps
- Jab fast end pe pahunchta hai:
  - Slow = middle

Odd length → exact middle  
Even length → lower/upper middle depending on condition

---

## 6️⃣ Reverse Linked List (Singly)

Concept:

- Teen pointers socho: prev, curr, next
- Har step:
  - next = curr.next
  - curr.next ko prev ki taraf point kar do
  - prev = curr, curr = next

End mein new head = prev

---

## 7️⃣ Detect Cycle in Linked List (Floyd’s Algorithm)

Concept:

- Slow → 1 step
- Fast → 2 steps
- Agar kabhi slow == fast ho jaye → cycle present
- Agar fast ya fast.next null ho jaye → no cycle

---

## 8️⃣ Start Node of Cycle

Steps:

1. Floyd algorithm se meeting point nikaalo
2. Ek pointer head pe, ek meeting point pe
3. Dono ko 1–1 step move karo
4. Jahan meet karenge → cycle ka starting node

---

## 9️⃣ Merge Two Sorted Linked Lists

Concept:

- Dono list ke head compare karo
- Chhota wala node result list mein attach karo
- Pointer aage badhao usi list ka
- End tak repeat

---

## 🔟 Remove N-th Node From End

Concept:

- Two pointers: fast aur slow
- Fast ko N steps aage le jao
- Fir fast aur slow dono ko sath move karo jab tak fast end pe na pahunch jaye
- Slow ab Nth from end ke ek pehle node pe hoga → uska next update karo

---

## 1️⃣1️⃣ Linked List Palindrome

Common Pattern:

1. Middle find karo (fast–slow pointer)
2. Second half reverse karo
3. First half aur reversed second half ke values compare karo
4. Optional: second half wapas reverse karke list restore

---

## 1️⃣2️⃣ Doubly Linked List – Extra Power

- Har node ke paas prev aur next dono pointer
- Reverse traversal easy
- Delete node without previous pointer easily (agar node reference hai)
- Thoda extra memory cost and pointer maintenance complexity

---

## 1️⃣3️⃣ Common Use Cases

- LRU Cache implementation (Doubly Linked List + HashMap)
- Stack/Queue (Linked implementation)
- Music playlists, navigation history

---

## ✅ Revision Checklist

- Singly vs Doubly vs Circular clear
- Fast–slow pointer pattern clear
- Reverse list logic clear
- Cycle detect + cycle start clear
- Merge two sorted lists clear
- Remove Nth from end clear
- Palindrome logic clear

Agar yeh sab clear hai → Linked List interview kaafi strong hai ✅

---

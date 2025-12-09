# 🔗 LINKED LIST CHEAT SHEET (1-PAGE)

Yeh sheet interview se pehle fast revision ke liye hai.

---

## ✅ BASIC CONCEPTS

- Node = data + pointer(s)
- Types:
  - Singly
  - Doubly
  - Circular

---

## ✅ TIME COMPLEXITIES (Generic)

- Traverse → O(n)
- Search by value → O(n)
- Insert at head (given head) → O(1)
- Insert at tail (without tail pointer) → O(n)
- Insert after given node → O(1)
- Delete after given node → O(1)

---

## ✅ TWO-POINTER PATTERN (FAST–SLOW)

Use fast–slow pointer for:

- Middle of list
- Detect cycle
- Find cycle start
- Palindrome (with reverse)
- Remove Nth from end (variation: lead distance approach)

Rule of thumb:

- Slow → 1 step
- Fast → 2 steps

---

## ✅ MIDDLE OF LINKED LIST

- Start slow = head, fast = head
- While fast and fast.next exist:
  - slow moves 1
  - fast moves 2
- End:
  - slow = middle node

---

## ✅ REVERSE LINKED LIST (MENTAL MODEL)

Socho:

- prev → initially null
- curr → head
- next → temporary store

Loop idea:

- next = curr.next
- curr.next ko prev ki taraf point karo
- prev = curr
- curr = next

End:
- New head = prev

---

## ✅ CYCLE DETECTION (FLOYD)

Idea:

- Slow = 1 step
- Fast = 2 steps
- Agar kabhi slow == fast:
  - Cycle exists
- Agar fast ya fast.next null:
  - No cycle

---

## ✅ START OF CYCLE

Steps:

1. Floyd se meeting point nikaalo
2. Pointer1 = head
3. Pointer2 = meeting point
4. Dono ko 1 step move karo
5. Jahan milenge → cycle start

---

## ✅ MERGE TWO SORTED LINKED LISTS

High-level steps:

- Result list ka starting node choose based on smaller value
- Always chhoti value wala node result mein attach karo
- Pointer same list ka aage badhao
- Jab koi list khatam, doosri list ka remaining part attach kar do

---

## ✅ REMOVE N-TH NODE FROM END

Pattern:

- Fast aur slow dono head se start
- Fast ko N steps aage le jao
- Then fast and slow both move together
- Jab fast last node pe aata hai:
  - Slow ke next ko skip karke delete handle karo

Edge case:
- Agar N equals length of list:
  - Head remove karna padega

---

## ✅ PALINDROME LINKED LIST

Steps:

1. Middle find karo (fast–slow)
2. Second half ko reverse karo
3. First half aur reversed second half ka data compare karo
4. Optionally reverse back to restore list

---

## ✅ DOUBLY LINKED LIST QUICK POINTS

- prev + next pointers
- Reverse traversal possible
- Node delete easier if node reference given
- More memory usage, more pointer updates

---

## ✅ CIRCULAR LINKED LIST QUICK POINTS

- Last node ka next → head
- Useful in:
  - Round-robin scheduling
  - Circular buffer type logic

---

## ✅ LAST MINUTE INTERVIEW CHECK

- Fast–slow pointer strongly clear?
- Reverse logic strongly clear?
- Cycle + cycle start clear?
- Merge + Nth from end clear?
- Palindrome steps clear?

Agar haan → Linked List ready for interview ✅

---

# 🔗 Linked List – Common Mistakes & Patterns (Interview Saver)

Yeh file un mistakes ka list hai jo log frequently Linked List problems mein karte hain.

---

## 1️⃣ Not Handling Empty List or Single Node

Mistake:
- Directly head.next access karna bina null check ke

Correct Pattern:
- Initially hi check karo:
  - Agar head null hai
  - Agar head.next null hai

---

## 2️⃣ Losing Reference to Head or Next Node

Mistake:
- Reverse ya deletion ke time next node ka reference lose kar dena

Correct Pattern:
- Jab bhi link change karein:
  - Pehle next ko store karo
  - Fir pointer update karo

---

## 3️⃣ Infinite Loops in Traversal

Mistake:
- Condition galat likhna:
  - For example: circular list mein kab stop karna hai define nahi kiya

Correct Pattern:
- Singly list:
  - Traverse while current != null
- Circular list:
  - Traverse while current != head (with proper handling) or extra visited-flag logic

---

## 4️⃣ Fast–Slow Pointer Wrong Condition

Mistake:
- fast.next ya fast.next.next access karte waqt null check skip karna

Correct Pattern:
- Loop condition mein fast aur fast.next dono check karo

---

## 5️⃣ Wrong Middle Node in Even Length Lists

Mistake:
- Logic clear nahi hota: first middle chahiye ya second middle?

Correct Pattern:
- Define clearly:
  - If you want second middle: condition with fast != null and fast.next != null
  - If you want first middle: slightly adjust condition

---

## 6️⃣ Reverse Logic mein Links Galat Order se Change Karna

Mistake:
- curr.next ko prev se pehle safely store na karna

Result:
- List ka aage ka part lost ho jata hai

Correct Pattern:
- Pehle next store karo
- Fir link reverse karo
- Fir pointers move karo

---

## 7️⃣ Not Restoring List After Modification

Mistake:
- Palindrome check ke baad second half reverse karke wapas original nahi banaya

Impact:
- Interviewer agar list print kare to structure change dikhega

Correct Pattern:
- Jaise hi kaam khatam ho:
  - Reverse second half again to restore original list

---

## 8️⃣ Cycle Detection Mein Galat Termination

Mistake:
- While loop mein sirf fast != null check karna

Correct Pattern:
- Floyd algorithm mein:
  - Condition: fast != null and fast.next != null

---

## 9️⃣ Removing N-th Node From End – Edge Cases

Mistake:
- Jab n list length ke barabar ho, head removal handle nahi karte

Correct Pattern:
- Agar fast pointer n steps ke baad null ho jaye:
  - Means Nth from end is head
  - Head ko next par shift karo

---

## 🔟 Not Considering Dummy Node Technique

Mistake:
- Head deletion ke cases mein extra if-else se code messy ho jata hai

Correct Pattern:
- Starting mein ek dummy node lo jo head ko point kare
- Operations dummy ke through karo
- Return dummy.next as new head

---

## ✅ FINAL INTERVIEW PATTERN

- Always handle null and single node cases
- Pehle next store karo, fir links change karo
- Fast–slow pointer conditions carefully likho
- Dummy node trick use karke edge cases simple banao
- Diagram bana ke socho (paper pe) jab doubt ho

Agar yeh mistakes avoid karoge → Linked List questions kaafi smooth ho jayenge ✅

---

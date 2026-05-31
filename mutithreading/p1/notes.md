## Problems
Here the issue is multiple thread trying to withdraw the amount parallely and make the amount negative.

We can solve this issue in three ways
- Making amount atomic 
- Making withdraw method synchronized 
- Fix using Lock
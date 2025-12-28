package tree.practice;

import java.util.Stack;


// store left nbode of the bst in smalleststack and right for largest stack
// when next is called pop the top node and push all left node of its right child
public class BSTIterator {
    private Stack<TreeNode> smallestStack;
    private Stack<TreeNode> largestStack;

    // helper method to push all left children of a node onto the stack
    private void pushLeftToStack(TreeNode node, String stackType) {
        while (node != null) {
            if (stackType.equals("smallest")) {
                smallestStack.push(node);
            } else {
                largestStack.push(node);
            }
            node = node.left;
        }
    }
    // constructor
    public BSTIterator(TreeNode root) {
        smallestStack = new Stack<>();
        largestStack = new Stack<>();
        this.pushLeftToStack(root, "smallest");
        this.pushLeftToStack(root, "largest");

    }

    
    public int next() {
        TreeNode topNode = smallestStack.pop();
        this.pushLeftToStack(topNode.right, "smallest");
        this.pushLeftToStack(topNode, "largest");
        return topNode.val;
    }
    
    public boolean hasNext() {
        return !smallestStack.isEmpty() || !largestStack.isEmpty();
    }
}

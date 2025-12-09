package tree.practice;

public class MaxPathSum {
    static int maxValue;
    public int helper(TreeNode root) {
        if(root == null) return 0;
        
        int leftSum = Math.max(0,helper(root.left)); // here pick only positive value else 0
        int rightSum = Math.max(0,helper(root.right)); // here pick only positive value else 0

        int maxCurSum = root.val + leftSum + rightSum; 
        maxValue = Math.max(maxValue, maxCurSum); // as of this node store max sum in gloabal variable
        
        return root.val + Math.max(leftSum, rightSum); // Here return only one path either left or right
    }
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        int lastSum = helper(root);
        return Math.max(maxValue, lastSum);
    }
}

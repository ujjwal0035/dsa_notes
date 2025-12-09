package tree.practice;

//Definition for a binary tree node.
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base conditions
        if(root == null) return null; // return null if node null
        if(root == p || root == q) return root; // return node if that node itself p or q

        TreeNode left = lowestCommonAncestor(root.left, p, q); // traverse left 
        TreeNode right = lowestCommonAncestor(root.right, p, q); // traverse right

        if(left != null && right != null) return root; // Here menas p and q found in the node

        return left != null ? left : right; // here if p or q found in left or right which node return
    }
}
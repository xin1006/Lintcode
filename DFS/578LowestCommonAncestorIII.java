/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode res = dc(root, A, B);
        if (foundA && foundB) {
            return res;
        }else {
            return null;
        }
    }
    private boolean foundA = false, foundB = false;
    private TreeNode dc(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return root;
        }
        TreeNode left = dc(root.left, A, B);
        TreeNode right = dc(root.right, A, B);
        
        if (root == A || root == B) {
            foundA = (root == A) || foundA;
            foundB = (root == B) || foundB;
            
            return root;
        }
        
        if (left != null && right != null) {
            return root;
        }else if (left != null) {
            return left;
        }else if (right != null) {
            return right;
        }else {
            return null;
        }
        
        
        
    }
    
}

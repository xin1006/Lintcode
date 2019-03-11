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
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        
        TreeNode cand = null;
        
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            }else {
                cand = root;
                root = root.right;
            }
        }
        
        return cand;
    }
}

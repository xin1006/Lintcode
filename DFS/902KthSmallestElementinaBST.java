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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        HashMap<TreeNode , Integer> mapping = new HashMap<>();
        countNum(root, mapping);
        return quickSelect(root, k, mapping);
    }
    
    private int countNum(TreeNode root, HashMap<TreeNode, Integer> mapping) {
        if (root == null) {
            return 0;
        }
        int left = countNum(root.left, mapping);
        int right = countNum(root.right, mapping);
        
        mapping.put(root, left + right + 1);
        return left + right + 1;
        
    }
    
    private int quickSelect(TreeNode root, int k, HashMap<TreeNode, Integer> mapping) {
        if (root == null) {
            return -1;
        }
        
        int left = root.left == null ? 0 : mapping.get(root.left);
        if (left >= k) {
            return quickSelect(root.left, k, mapping);
        }
        if (left + 1 == k) {
            return root.val;
        }else {
            return quickSelect(root.right, k - left - 1, mapping);
        }
    }
    
    
}
























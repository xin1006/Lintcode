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
//O(h)
public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return 0;
        }
        TreeNode upper = upperBound(root,target);
        TreeNode lower = lowerBound(root,target);

        if (upper == null) {
            return lower.val;
        }
        if (lower == null) {
            return upper.val;
        }
        if (target -lower.val <= upper.val - target) {
            return lower.val;
        } else {
            return upper.val;
        }



    }

    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target <= root.val) {
            return lowerBound(root.left, target);
        }

        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        return root;
    }
    private TreeNode upperBound(TreeNode root , double target) {
        if (root == null) {
            return null;
        }
        if (target >= root.val) {
            return upperBound(root.right, target);
        }

        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        return root;
    }
}

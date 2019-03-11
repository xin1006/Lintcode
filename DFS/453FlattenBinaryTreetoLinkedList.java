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
*traversal

*用右左根的思路做, 题目中的例子的遍历结果为 6, 5, 4, 3, 2, 1
*假设已经得到了right和left的结果, 现在正在处理root节点, 假设现在的root是4, 则我们需要把root.right置为5, root.left置为null
*如何记录5 --> 用一个全局lastNode记录上一次遇到的点, 每次处理完当前root后将lastNode置为root, 然后去遍历下一个点
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = lastNode;
        root.left = null;
        lastNode = root;
    }
}

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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> ss = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        while (root != null) {
            ss.push(root);
            root = root.left;
        }
        while (!ss.isEmpty()) {
            TreeNode node = ss.pop();
            res.add(node.val);
            if (node.right != null) {
                TreeNode cur = node.right;
                while(cur != null) {
                    ss.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}

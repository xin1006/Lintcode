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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }

        List<Integer> cur = new ArrayList<Integer>();
        cur.add(root.val);
        dfs(res, cur, root);
        return res;
    }

    private void dfs(List<String> res, List<Integer> cur, TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.size();i++) {
                sb.append(cur.get(i) + "->");
            }
            res.add(sb.substring(0,sb.length() - 2).toString());
            return;
        }
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(res,cur,root.left);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(res,cur,root.right);
            cur.remove(cur.size() - 1);
        }
    }
}

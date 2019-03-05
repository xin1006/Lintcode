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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List res = new ArrayList();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean xx = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            if (xx) {
                res.add(level);
                xx = false;
            }else {
                Collections.reverse(level);
                res.add(level);
                xx = true;
            }

        }
        return res;
    }
}


//Arrays.fill（）函数

用法1：接受2个参数
Arrays.fill（ a1, value ）;
注：a1是一个数组变量，value是一个a1中元素数据类型的值，作用：填充a1数组中的每个元素都是value
例如：
boolean[] a1 = new boolean[5];
Arrays.fill( a1,true );
结果 a1[] = {true,true,true,true,true};

用法2：接受4个参数
例如：
String[] a9 = new String[6];
Arrays.fill(a9, "Hello");
Arrays.fill(a9, 3, 5,"World");
结果是 a9[] = {Hello,Hello,Hello,World,World,Hello};
第一个参数指操作的数组，第二个和第三个指在该数组的某个区域插入第四个参数，第二个参数指起始元素下标（包含该下标），第三个参数指结束下标（不包含该下标），注意：java的数组下标从0开始
---------------------
作者：蜗牛蜗牛慢慢爬
来源：CSDN
原文：https://blog.csdn.net/u014665013/article/details/39992179
版权声明：本文为博主原创文章，转载请附上博文链接！

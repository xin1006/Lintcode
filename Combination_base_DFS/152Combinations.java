public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        helper(n,k,path,res,1);
        return res;
    }
    private void helper(int n, int k, List<Integer> path, List<List<Integer>> res, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            helper(n,k,path,res,i+1);
            path.remove(path.size()-1);
        }
    }
}

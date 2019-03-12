public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> path = new ArrayList<Integer>();
        helper(num, target, 0, path, res);
        return res;
    }
    
    private void helper(int[] num, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i-1]) {
                continue;
            }
            if (num[i] > target) {
                break;
            }
            
            path.add(num[i]);
            helper(num, target - num[i],i+1,path,res);
            path.remove(path.size()-1);
        }
    }
}

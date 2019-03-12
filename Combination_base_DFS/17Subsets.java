public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            //res.add(subset); 这个是输出错误答案的语句
            return;
        }
        
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        
        subset.remove(nums[subset.size() - 1]);
        dfs(nums, index + 1, subset, res);
    }
}

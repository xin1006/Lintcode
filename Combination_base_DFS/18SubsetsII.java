public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);//要整理数组
        
        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, 0, subset, res);
        return res;
    }
    
    private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);//这里要用i
            subset.remove(subset.size() - 1);
        }
    }
}   

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> level  = new ArrayList<Integer>();
        helper(nums, 0, level, res, target);
        return res;
    }
    
    private void helper(int[] nums, int start, List<Integer> level, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(level));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > target) {
                return;
            }
            level.add(nums[i]);
            helper(nums,i,level,res,target - nums[i]);// this is i not i + 1 在II中才会使用i+ 1
            level.remove(level.size() - 1);
        }
    }
}

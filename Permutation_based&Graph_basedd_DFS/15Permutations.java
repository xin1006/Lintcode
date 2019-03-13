

//Backtrack解法，每次循环都要回溯。时间复杂度：O(2^n)
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            helper(res, path, nums);
            path.remove(path.size() - 1);
        }
    }
}

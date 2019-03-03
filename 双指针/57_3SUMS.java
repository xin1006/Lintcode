//统计所有的和为 0 的三元组 (Triples)
//利用twosum 来做这道题 时间 O(n^2) 空间O(n)
//


public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//当当前的元素和前一个元素数值相同的情况下跳出当前元素直接进入下次循环， 这次操作还要在twosum中进行一次
            }
            int start = i + 1;
            int end = nums.length - 1;
            int target = -nums[i];
            twoSum(nums, target, res, start, end);
        }
        return res;
    }

    public void twoSum(int[] nums, int target, List<List<Integer>> res, int start, int end) {
        int begin = start;//这个begin容易忘
        while(start < end) {
            if (start > begin && nums[start] == nums[start - 1]) {//这个判断条件要记牢
                start++;
                continue;
            }
            if (nums[start] + nums[end] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[start]);
                list.add(nums[end]);

                res.add(list);
                start++;
                end--;
                continue;
            }

            if(nums[start] + nums[end] > target) {
                end--;
            }else{
                start++;
            }
        }
    }
}

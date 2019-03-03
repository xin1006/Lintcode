//暴力解法
public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                diff = Math.min(Math.abs(target - nums[i] - nums[j]) , diff);
            }
        }
        return diff;
    }
}

//双指针

public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return 0;
            }else if (nums[left] + nums[right] > target) {
                diff = Math.min(Math.abs(target - nums[left] - nums[right]) , diff);
                right--;
            }else{
                diff = Math.min(Math.abs(target - nums[left] - nums[right]) , diff);
                left++;
            }
        }
        return diff;
    }
}

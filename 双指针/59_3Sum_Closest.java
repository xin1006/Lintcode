//暴力解法

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int x = nums.length;
        int sum = nums[0]+nums[1]+nums[2];
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < x-2; i++) {
            for (int j = i + 1; j < x-1; j++) {
                for (int k = j + 1; k < x; k++){
                   if(Math.abs(target - (nums[i]+nums[j]+nums[k])) < diff) {
                       diff = Math.abs(target - (nums[i]+nums[j]+nums[k]));
                       sum = nums[i]+nums[j]+nums[k];
                   }

                }
            }
        }
       return sum;
    }
}


//双指针
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int x = nums.length;
        int best_sum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < x; i++) {
            int left = i + 1;
            int right = x - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - best_sum)) {
                    best_sum = sum;
                }else if (sum < target) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return best_sum;
    }
}

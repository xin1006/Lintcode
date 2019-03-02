public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}
//0 多 vs 0 少 算法有什么区别?
//不需要维持相对顺序 vs 需要维持相对顺序 算法有什么区别？
//如果需要保证最少修改次数如何做？
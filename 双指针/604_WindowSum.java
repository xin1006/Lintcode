public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        int ll = nums.length;
        if (nums == null || ll == 0 || k > ll || k <= 0) {
            return new int[]{};//这个输出的格式要记住
        }
        int[] res = new int[ll - k + 1];
        int sum = 0;
        //这里的for循环应该是k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res[0] = sum;
        
        int left = 0;
        int right = k;//这里是k
        int i = 1;
        
        while (right < ll) {
            sum = sum + nums[right] - nums[left];
            res[i++] = sum;
            left++;
            right++;
        }
        return res;
        
    }
}
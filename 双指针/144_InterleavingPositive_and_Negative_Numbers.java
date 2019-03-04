public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
             if (nums[start] < 0) {
                 start++;
                 continue;
             }
             if (nums[end] > 0) {
                 end--;
                 continue;
             }
             int temp = nums[start];
             nums[start] = nums[end];
             nums[end] = temp;

             end--;
             start++;
        }
        if (start > nums.length - start) {
            interleave(nums, 1, nums.length - 1);
        } else if (start < nums.length - start) {
            interleave(nums, 0, nums.length - 2);
        } else {
            interleave(nums, 0, nums.length - 1);
        }
    }
     private void interleave(int[] A, int start, int end) {
        while (start < end) {
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start += 2;
            end -= 2;
        }
    }
}

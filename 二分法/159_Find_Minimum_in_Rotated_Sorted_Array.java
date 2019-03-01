public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] <= target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        if (nums[start] < target){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}

//这道题只有两种情况一种是升序一种是升再升 把数组里最后一个元素作为衡量元素 来解决问题
//
//Follow up : 如果有重复的数？无法在logn的时间复杂度内解决 试想一下【1,1,1,1】中藏着一个0 我们只能挨个找


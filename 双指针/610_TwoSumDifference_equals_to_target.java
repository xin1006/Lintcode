//这道题要考虑会有重复数字的情况 最后要得到的是index 所以一旦sort后顺序就会打乱 永远都需要O(n) 的额外空间 需要用hashmap

//我的错误版本

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int[] res = new int[2];
        while (right < nums.length) {
            if (nums[right] - nums[left] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if (nums[right] - nums[left] > target) {
                if(left + 1 < right) {
                    left++;
                }else {
                    left++;
                    right++;
                }
            }else {
                right++;
            }
        }
        return new int[] {};
    }
}

//正确版本

//双指针 O(n^3)

// 最后的for循环 改成while 失败
public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int l = j + 1, r = n - 1; l < r; ++l) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    while (r > l && nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    }
                    if (l >= r) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }
}


//暴力

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
          return res;
        }
        int x = nums.length;
        for (int i = 0; i < x - 3; i++) {
          for (int j = i + 1; j < x-2; j++) {
            for (int m = j + 1; m < x - 1; m++) {
              for (int n = m + 1; n < x; n++) {
                if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                  List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[m]);
                        item.add(nums[n]);
                        res.add(item);
                }
              }
            }
          }
        }
        return res;
    }
}

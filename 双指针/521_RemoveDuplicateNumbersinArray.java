//space O(n) Time O(n)
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}

//Time log(n) Space n
//
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length - 1];
        return j+1;
        
    }
}
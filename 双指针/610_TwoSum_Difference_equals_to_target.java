//时间复杂度 O(n)O(n)，空间复杂度也是 O(n)O(n)

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target + nums[i];
            if (map.containsKey(sum)) {
                int index = map.get(sum);
                int[] pair = new int[2];
                pair[0] = index + 1;
                pair[1] = i + 1;
                return pair;
            }

            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                int[] pair = new int[2];
                pair[0] = index + 1;
                pair[1] = i + 1;
                return pair;
            }
            map.put(nums[i], i);
        }
        return null;

    }
}

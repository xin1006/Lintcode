public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        int left = 0;
        int right = S.length - 1;
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;//这里要重新赋值
            while (left < right) {
                if (S[left] +S[right] > S[i]) {
                    res += right - left;//只要两边之和大于S[i] 那么之间的数都能作为left 和right，nus[i] 组成三角形
                    right--;
                }else {
                    left++;
                }
            }

        }
        return res;
    }
}
//对于求 2 个变量如何组合的问题可以循环其中一个变量，然后研究另外一个变量如何变化

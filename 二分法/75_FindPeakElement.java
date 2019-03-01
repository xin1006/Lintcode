public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 0;
        int end = A.length - 2;
        
        while (start + 1 < end) {
            int mid = start + (end - start)/2;

            //如果中间的数比后一位数大的话，peek点肯定在mid左边或是mid。
            //如果中间的数比前一位数小的话，peek点肯定在mid右边或是mid。
            if (A[mid] > A[mid + 1]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if (A[end] > A[start]) {
            return end;
        }else {
            return start;
        }
    }
}
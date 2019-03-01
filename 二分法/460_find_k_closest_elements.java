public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int left = findLowerClosest(A,target);
        int right = left + 1;
        int res[] = new int[k];
        
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                res[i] = A[left];
                left--;
            }else{
                res[i] = A[right];
                right++;
            }
        }
        return res;
    }
    private int findLowerClosest(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[end] < target) {
            return end;
        }else if (A[start] < target) {
            return start;
        }else {
            return -1;
        }
    }
    
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }
        //这里是右边小于等于长度 不然会报错 因为当left是数组的最后一个因子的话A【right】 是不存在的
        if (right >= A.length) {
            return true;
        }
        if (target - A[left] != A[right] - target) {
            return target - A[left] < A[right] - target;
        }
        return true;
    }
}
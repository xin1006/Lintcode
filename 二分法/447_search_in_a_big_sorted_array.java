/**
 * Definition of ArrayReader:
 * 
 * public class ArrayReader {
 * public int get(int index) {
 *          // return the number on given index, 
 *          // return 2147483647 if the index is invalid.
 *     }
 * };
 */
public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int k = 1;
        while (reader.get(k) < target) {
            k = k*2;
        }
        
        int start = 0;
        int end = k;//这里是k 如果是k - 1的话当A[1] == target 的情况下会报错
        
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (reader.get(mid) == target) {
                end = mid;//题目要求第一次出现的索引 注意题目要求再做题
            }else if (reader.get(mid) < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(reader.get(start) == target) {
            return start;
        }else if (reader.get(end) == target) {
            return end;
        }else {
            return -1;
        }
    }
   
}
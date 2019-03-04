/**
* 本参考程序来自九章算法，由 @Roger 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/


//共给出四种解法：

//方法	Time	Space
//快速排序（暴力无视k）	O(nlogn)	O(logn)
//计数排序	O(n)	O(k)
//k次partition，每次划分出一种颜色	O(nk)	O(1)
//分治法，logk次 partition（最优）	O(nlogk)	O(logk)




// 快速排序（暴力无视k）
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        Arrays.sort(colors);
    }
}


// 计数排序
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] count = new int[k + 1];

        for (int color : colors) {
            count[color]++;
        }

        int idx = 0;
        for (int color = 1; color <= k; color++) {
            for (int t = 0; t < count[color]; t++) {
                colors[idx++] = color;
            }
        }
    }
}


// k次partition，每次划分出一种颜色
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int start = 0;
        for (int c = 1; c <= k; c++) {
            start = partition(colors, start, colors.length - 1, c);
        }
    }

    private int partition(int[] colors, int start, int end, int c) {
        int tmp = colors[start];

        int left = start, right = end;
        while (left < right) {
            while (left < right && colors[right] != c) {
                right--;
            }
            if (left < right) {
                colors[left++] = colors[right];
            }

            while (left < right && colors[left] == c) {
                left++;
            }
            if (left < right) {
                colors[right--] = colors[left];
            }
        }
        colors[left] = tmp;

        if (tmp == c) {
            return left + 1;
        } else {
            return left;
        }
    }
}

// 分治法，logk次 partition
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length <= 1) {
            return;
        }

        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int minColor, int maxColor) {
        if (start >= end || minColor == maxColor) {
            return;
        }

        int tmp = colors[start];

        int midColor = minColor + (maxColor - minColor) / 2;
        int left = start, right = end;
        while (left < right) {
            while (left < right && colors[right] > midColor) {
                right--;
            }
            if (left < right) {
                colors[left++] = colors[right];
            }

            while (left < right && colors[left] <= midColor) {
                left++;
            }
            if (left < right) {
                colors[right--] = colors[left];
            }
        }

        colors[left] = tmp;
        int partition = tmp <= midColor ? left : left - 1;

        rainbowSort(colors, start, partition, minColor, midColor);
        rainbowSort(colors, partition + 1, end, midColor + 1, maxColor);
    }
}

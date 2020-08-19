package leetcode.lc;

/**
 * Created by Edwin Xu on 8/3/2020 10:41 PM
 *
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 */
public class LC_11 {
    /*
    * 找高度乘以距离最大的
    *
    * 暴力 O(N2)可以找
    * 优化：
    * 一层遍历：
    *   第二层从右往左找，直到第一个高度>=自己的，在这途中计算水量并和最大值比较
    * */
    public int maxArea_1(int[] height) {
        if (height.length==0)return 0;
        int max = 0;
        for (int i = 0; i <height.length ; i++) {
            boolean over = false;
            for (int j=height.length-1;j>i;j--){
                if (over)break;;
                if (height[j]>=height[i])over=true;
                int rain = (j-i)*Math.min(height[j],height[i]);
                if (rain>max)max=rain;
            }
        }
        return max;
    }

    /*
    * 上面的可以优化下：
    *   如果当前是最高的，那么第一层循环后面的都不用再比较了
    *
    *   果然：从击败25%到90%
    * */
    public int maxArea_2(int[] height) {
        if (height.length==0)return 0;
        int highest = height[0];
        for (int i = 1; i <height.length ; i++) {
            if (height[i]>highest)highest=height[i];
        }
        int max = 0;
        for (int i = 0; i <height.length ; i++) {
            boolean over = false;
            for (int j=height.length-1;j>i;j--){
                if (over)break;;
                if (height[j]>=height[i])over=true;
                int rain = (j-i)*Math.min(height[j],height[i]);
                if (rain>max)max=rain;
            }
            if (height[i]==highest)break;
        }
        return max;
    }



    /*
    * 最优解：双指针
    *本题是一道经典的面试题，最优的做法是使用「双指针」。如果读者第一次看到这题，不一定能想出双指针的做法。
    * [1, 8, 6, 2, 5, 4, 8, 3, 7]
 ^                       ^
在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 \min(1, 7) * 8 = 8min(1,7)∗8=8。

此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由

两个指针指向的数字中较小值 * 指针之间的距离
两个指针指向的数字中较小值∗指针之间的距离

    *
    * */

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int [] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new LC_11().maxArea(arr));

    }
}

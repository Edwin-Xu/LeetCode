package leetcode.lc;

/*
* 88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
* */
public class LC_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length;
        int len2 = n;
        //把nums1的前m位移动到后面
        for (int i = 0; i < m; i++) {
            nums1[len1 - i - 1] = nums1[m - i - 1];
        }
        //然后从nums1的m-1~len1-1位和nums2中取最小的放到nums1前面
        int index = 0;
        int i = len1 - m;
        int j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                nums1[index++] = nums2[j++];
            } else {
                nums1[index++] = nums1[i++];
            }
        }
        while (i < len1) {
            nums1[index++] = nums1[i++];
        }
        while (j < len2) {
            nums1[index++] = nums2[j++];
        }
    }
}

package leetcode.lc;

/**
 * Created by Edwin Xu on 8/4/2020 5:12 PM
 *
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class LC_4 {

    /*
    * 得到总长度len后:
    * len odd: 取中间一个数
    * len even: 取中间两个数
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count =0;
        int len = nums1.length+nums2.length;
        int half = len/2;
        int x =0; //nums1
        int y =0; //nums2

        if ((len&1)==1){
            //odd
            while (x<nums1.length && y<nums2.length){
                if(nums1[x]<nums2[y]){
                    if (count==half)return nums1[x];
                    x++;
                }
                else {
                    if (count==half)return nums2[y];
                    y++;
                }
                count++;
            }

            if (x==nums1.length){
                return nums2[half-nums1.length];
            }else{
                return nums1[half-nums2.length];
            }
        }else{
            //even
            int pre =0;
            while (x<nums1.length && y<nums2.length){
                if(nums1[x]<nums2[y]){
                    System.out.println("x: "+nums1[x]+" - "+count+" - "+x);
                    if (count==half-1)pre = nums1[x];
                    if (count==half)return (nums1[x]+pre)/2.0;
                    x++;
                }
                else {
                    System.out.println("y: "+nums2[y]+" - "+count+" - "+y);
                    if (count==half-1)pre = nums2[y];
                    if (count==half)return (nums2[y]+pre)/2.0;
                    y++;
                }
                count++;
            }
            //如果其中一个数组遍历完了，且还没有找到中位数，还需要继续
            //如果二者长度相同：一边一个
            //否则:

            if (x==nums1.length){
                if (nums1.length==nums2.length)return (nums2[0]+nums1[x-1])/2.0;
                int ind = half-1-nums1.length;
                System.out.println(ind);
                return (Math.max(nums2[ind],nums1.length==0?0:nums1[nums1.length-1])+nums2[ind+1])/2.0;
            }else{
                if (nums1.length==nums2.length)return (nums1[0]+nums2[y-1])/2.0;
                int ind = half-1-nums2.length;
                return (Math.max(nums1[ind],nums2.length==0?0:nums2[nums2.length-1])+nums1[ind+1])/2.0;
            }
        }
    }


    /*
    * 其他办法
    * */


    /*方法二：划分数组*/
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;
            int left = 0, right = m, ansi = -1;
            // median1：前一部分的最大值
            // median2：后一部分的最小值
            int median1 = 0, median2 = 0;

            while (left <= right) {
                // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
                // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
                int i = (left + right) / 2;
                int j = (m + n + 1) / 2 - i;

                // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
                int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
                int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
                int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
                int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

                if (nums_im1 <= nums_j) {
                    ansi = i;
                    median1 = Math.max(nums_im1, nums_jm1);
                    median2 = Math.min(nums_i, nums_j);
                    left = i + 1;
                }
                else {
                    right = i - 1;
                }
            }

            return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
        }
    }



    /*方法一：二分查找*/
    class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public int getKthElement(int[] nums1, int[] nums2, int k) {
            /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * 这里的 "/" 表示整除
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;

            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        LC_4 lc_4 = new LC_4();
        int a[] = {3,4};
        int b[] = {};
        System.out.println(lc_4.findMedianSortedArrays(a,b));
    }
}

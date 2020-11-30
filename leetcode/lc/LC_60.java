package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/5/2020 7:17 PM
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 */
public class LC_60 {
    public String getPermutation(int n, int k) {
        int nums[] = new int[n];
        for(int i=1;i<=n;i++)nums[i-1]=i;
        perm(nums,0,n-1,k);
        return res;
    }
    private int cnt =0;
    private String res = "";
    private void perm(int[] nums,int start,int end,int k){
//        if(cnt>=k)return;
        if(start==end){

            for(int a:nums)System.out.print(a);
            System.out.println();

            if(++cnt == k){
                StringBuilder sb = new StringBuilder();
                for(int n: nums)sb.append(n);
                res = sb.toString();
            }
        }else{
            for(int i=start;i<=end;i++){
                swap(nums, start,i);
                //难以保证输出是按字典序的，？？？？？？？

                perm(nums,start+1,end,k);
                swap(nums, start,i);
            }

        }
    }

    private void swap(int[]nums, int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] =tmp;
    }

    public static void main(String[] args) {
        LC_60 lc_60 = new LC_60();
        System.out.println(lc_60.getPermutation(3,6));
    }
}

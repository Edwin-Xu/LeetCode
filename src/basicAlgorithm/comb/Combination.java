package basicAlgorithm.comb;

import leetcode.lc.LC_77;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/1/2020 1:36 PM
 *
 * 组合数
 * 可以使用递归实现
 * N中选择M个数:
 *  对于每一位：
 *    可以选择选：从后面中只需要少选择一个
 *    可以选择不选：从后面选择和现在相同的个数
 *
 *
 */
public class Combination {

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    /**
     * C(N,M)
     * @param startIndex 开始的位置；
     * @param foundNum 已经找到的个数
     * @param n 组合数的总个数:M
     * @param list 当前选择过程中存储的组合数
     *
     *
     * */
    public static void comb_recur(int nums[], int startIndex, int foundNum, int n,ArrayList<Integer> list){
        if (foundNum>n || nums.length - startIndex+1<n) {
            if(list.size()==n) res.add(list);
            return;
        }
        comb_recur(nums,startIndex+1,foundNum,n,list);
        ArrayList<Integer> newList = new ArrayList<>(list);
        newList.add(nums[startIndex]);
        comb_recur(nums,startIndex+1,foundNum+1,n,newList);
    }


    public static void main(String[] args) {
        int []nums = {
                1,2,3,4,5
        };
        Combination.comb_recur(nums,0,0,3,new ArrayList<>());
        for (ArrayList<Integer> arrayList:res){
            for (int a: arrayList){
                System.out.print(a);
            }
            System.out.println();
        }

        System.out.println(Combination.gcd(120,1500));
    }

    public class LC_77 {
        /**
         * 我的解法:首先是使用递归
         */
        private java.util.List<java.util.List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            int nums[] = new int[n];
            for (int i = 1; i <= n; i++) nums[i - 1] = i;
            comb_recur(nums, 0, 0, k, new ArrayList());
            return res;
        }

        public void comb_recur(int nums[], int startIndex, int foundNum, int n, ArrayList<Integer> list) {

            if (foundNum > n || nums.length - startIndex < n - foundNum || startIndex >= nums.length) { //如果K个已经找到了，或者剩余的不足，或者下标越界了
                if (list.size() == n) res.add(list);
                return;
            }
            comb_recur(nums, startIndex + 1, foundNum, n, list);
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(nums[startIndex]);
            comb_recur(nums, startIndex + 1, foundNum + 1, n, newList);
        }
    }

    /*
    * 编辑距离？？？
    *
    * */






    public static int gcd(int a,int b){
        System.out.println(a+"-"+b);
        int c = a%b;
        return c==0?b:gcd(b,c);
    }



}
































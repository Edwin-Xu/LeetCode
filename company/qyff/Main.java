package company.qyff;

import leetcode.util.ArrOpsUtil;
import leetcode.util.Print;

import java.util.*;

/**
 * Created by Edwin Xu on 10/14/2020 2:01 PM.
 *
 * 青颖飞帆面试
 * 一women面试官
 * 素质有限
 *
 *
 * 给出一个数组，然后和一个目标值target，求和为target的子数组，不要求连续
 * int[]    target
 * 和相等的子数组
 *
 */

public class Main {

/*
* 写了冒泡排序
* 使用 boolean isSorted = true;提前返回
* 她不懂这个意思，还给她解释，无语了
*
* 子数组这个，我的暴力就是递归，每一个有两种选择，
* 它理解为我一个个组合枚举吗？
*
*
* */



    public static void bubbleSort(int [] nums){
        if (nums==null)return;

        for (int i = 0; i <nums.length-1 ; i++) {
            boolean isSorted = true;

            for (int j = 1; j <nums.length-i ; j++) {
                if (nums[j]<nums[j-1]){
                    isSorted = false;

                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }
            if (isSorted)break;
        }
    }





    /*
    *
    * dp[n][target]
    *  1 2 3 4 5
    *  6
    *
    * 我在面试过程中是考虑的是动态规划
    *
    * 这题能使用动态规划吗？
    *
    * */

//    public void func(int nums[] ,int target){
//        int [][] dp = new int[nums.length][target];
//        dp[0][0] =
//        for (int i = 0; i < ; i++) {
//            for (int j = 0; j < ; j++) {
//
//            }
//        }
//    }







    public static void main(String[] args) {
        Main m = new Main();
        int arr[] = {1,2,3,4,5};

        ArrayList<ArrayList<Integer>> list = m.combinationSum2(arr,5);
        for (ArrayList<Integer > arrayList:list){
            Print.printList(arrayList);
        }
    }


    /*
    * 下面是暴力解法
    * 利用DFS递归
    *
    * 这个复杂度是
    * 最坏 O(2^N) 吧
    * 她为什么说不是 O(2^N)；
    *
    * */


    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (num == null || num.length == 0) return list;
//        Arrays.sort(num);
        dfs(num, 0, target, ls);
        return list;
    }

    private void dfs(int[] arr, int index, int sum, ArrayList<Integer> ls) {
        if (sum < 0) return;
        if (sum == 0) {
            if (!list.contains(ls)) list.add(new ArrayList<>(ls));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            ls.add(arr[i]);
            //此处从i+1开始
            dfs(arr, i + 1, sum - arr[i], ls);
            ls.remove(ls.size() - 1);
        }
    }
}

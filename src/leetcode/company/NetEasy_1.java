package leetcode.company;

import java.util.*;

/**
 * Created by Edwin Xu on 10/21/2020 9:59 PM.
 *
 * 网易-1. 分割环
 * 小易有 n 个数字排成一个环，你能否将它们分成连续的两个部分(即在环上必须连续)，使得两部分的和相等？
 *
 * 输入描述：
 * 第一行数据组数 T ，对于每组数据
 *
 * 第一行数字 n ，表示数字个数
 *
 * 接下来一行 n 个数，按顺序给出环上的数字。
 *
 * 2 <= n <= 100000, 1 <= Ai <= 10 ^ 9
 *
 * 输出描述：
 * 对于每组数据，一行输出YES/NO
 *
 * 示例1:
 * 输入
 *
 * 1
 * 6
 * 1 2 3 4 5 6
 * 输出
 *
 * NO
 */

public class NetEasy_1 {
    public static boolean canSpilt(int[]arr){
        int sum = 0;
        for(int n: arr)sum+=n;
        if(sum%2==1)return false;

        int target = sum/2;

        for(int i= 1;i<arr.length;i++){
            arr[i]+=arr[i-1];
//            System.out.print(arr[i]+" ");
            for(int j=0;j<i;j++){
                if(arr[i] - arr[j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ;i <T; i++){
            int n = sc.nextInt();
            int arr [] = new int[n];
            for(int j = 0 ;j <n;j++)arr[j] = sc.nextInt();
//            System.out.println(canSpilt(arr)?"YES":"NO");
            System.out.println(splitCycle(arr));
        }
    }

    /*
    * 上面是O(N2)的前缀和
    * 没有问题，不知道为什么过不了全部用例
    *
    *
    * 然后没有注意到本题中数是正整数
    * 所以可以使用双指针。
    *
    * 如下
    * */

    private static String splitCycle(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum % 2) == 1) {
            return "NO";
        }

        long target = sum / 2;
        int i = 0;
        int j = 0;
        sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (sum == target) {
                return "YES";
            }
            while (sum > target) {
                sum -= nums[i++];
                if (sum == target) {
                    return "YES";
                }
            }
            j++;
        }
        return "NO";
    }
}

/*
1
5
1 5 5 3 -2

1
5
10 5 5 1 1


* */
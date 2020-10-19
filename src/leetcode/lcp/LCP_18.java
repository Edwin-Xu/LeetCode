package leetcode.lcp;

import java.util.*;

/**
 * Created by Edwin Xu on 10/18/2020 8:44 PM.
 *
 * LCP 18. 早餐组合
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 *
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * 示例 1：
 *
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 *
 * 输出：6
 *
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 */

public class LCP_18 {
    public int breakfastNumber_timeout(int[] staple, int[] drinks, int x) {
        int res = 0;
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] >= x) continue;
            int left = x - staple[i];
            for (int j = 0; j < drinks.length; j++) {
                if (left >= drinks[j]) res++;
            }
        }
        return res;
    }

    /*
    先对两个数组进行排序。
    然后遍历其中一个数组：
        使用另一个指针p指向另一个数组末尾
        p向前移动直到 和小于 x
        然后计算数量
    时间复杂度：Max ( O(NlogN), O(MlogM) )
    空间复杂度: O(1)
    */
    public int breakfastNumber_sort(int[] staple, int[] drinks, int x) {
        int res = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int p = drinks.length - 1;
        for (int s : staple) { //staple从前往后移动
            while (p >= 0 && s + drinks[p] > x) p--; //drinks从后往前
            if (p < 0) break;
            res += p + 1;
            res %= 1000000007;
        }
        return res;
    }

    /*
    借助上面这个的思想，使用一个数组arr,arr[i]表示小于i的数量
    arr可以表示其中一个，如食物

    然后遍历饮料，对每一个d，由arr[x-d]就知道有多少种食物是可以组合的
    空间复杂度 ： O(X)
    时间复杂度 ： O(N+M)
    */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int[] arr = new int[x];
        for (int s : staple) {
            if (s < x) arr[s]++;//将每一种staple填入对应的数组位置中
        }
        for (int i = 1; i < x; i++) {
            arr[i] += arr[i - 1];//然后从前往后累加。
        }
        int sum = 0;
        for (int d : drinks) {
            if (x - d >= 0 && x - d < x) sum += arr[x - d];
            sum %= 1000000007;
        }
        return sum;
    }
}

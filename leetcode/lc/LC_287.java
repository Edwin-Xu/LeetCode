package leetcode.lc;

/**
 * Created by Edwin Xu on 5/28/2020 3:56 PM
 *
 *
 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 */
public class LC_287 {

    /*
    * 数据记录法
    * 原地置换法
    * 最好：快慢指针
    * */

//    先回忆一下原地置换法：
    public static int findDuplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int tmp;
            System.out.println(i);
            while (i!=nums[i]){
                System.out.println(nums[nums[i]]+" "+nums[i]);
                if (nums[nums[i]]==nums[i])return nums[i];
                tmp = nums[i];
                nums[i] = nums[tmp]; //这个地方需要注意，
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    /*
    * 快慢指针：
    * 分析：
    * 这个可以看做链表：下标是next
    * 那么有一个数重复，就代表有一个环————问题变成链表中找环。准确说是：环的入口
    *
    *   快F 满S
    *   F比S多走1步：S每次一步，F每次2步
    *   SF相遇时：F比S在环上多跑了N圈：N>=1
    *       S= X， F= NK + X
    *
    *
    * 注意：这里是从1开始的，若是从0开始就有问题，如0,1：死循环
    *
    *
    *
    * 这就是龟兔赛跑算法：Flody算法
    * 用于判断链表中是否存在环：环的大小、起点
    * */
    public static  int findDuplicate_fast_slow_pointers(int nums[]){
        int s = 0;
        int f = 0;
        do {
            s = nums[s];
            f = nums[nums[f]];
        }while (f!=s);
        System.out.println(s+" "+f);

        s = 0;
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }

    public static void main(String[] args) {
//        System.out.println(LC_287.findDuplicate(new int[]{0,1,3,4,2,2}));
        System.out.println(LC_287.findDuplicate_fast_slow_pointers(new int[]{1,5,3,4,2,2}));

    }
}

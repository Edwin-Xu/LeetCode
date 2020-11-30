package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/27/2020 2:15 PM
 *
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class LC_26 {
    //一种方式：从前往后，对于一个数X，如果有Y个，则把后面的向前移动Y-1位
    //这种方式移动量太大了，且细节容易出错
    public int removeDuplicates___1(int[] nums) {
        int deleteCnt = 0;
        for(int i = 0;i<nums.length-deleteCnt;i++){
            int cnt = 1;
            while(i+cnt<nums.length && nums[i+cnt] == nums[i])cnt++;
            System.out.println(nums[i]+"--" +cnt);
            if(cnt==1) continue; //没有重复的

            //cnt-1个是重复的
            //后面的往前移动cnt-1位
            for(int j = i+1;j<nums.length - deleteCnt-cnt+1;j++){
                nums[j] = nums[j+cnt-1];
            }
            //i+=cnt-2;
            deleteCnt+=cnt-1;
            for(int n: nums)System.out.print(n+" ");
            System.out.println();

        }
        return nums.length-deleteCnt;
    }




    /**
     方式2：
     设置两个指针i，j
     i:指向前半部分已经有序无重非末尾。
     j：指向后半部分，待判断的头部
     */
    public int removeDuplicates(int[] nums) {
        int p =0;
        int q = 1;
        int len = nums.length;
        while(q<len){
            int tmp= q;
            while(q<len && nums[q]==nums[q-1])q++;

            if (tmp==q)q++;
            else{
                nums[p++] = nums[q-1];
            }

        }
        return p;

    }

    /*
    * 官方：
    * 思路是在是太清晰了
    * 和上面一个的区别是：上面是从后面重复中找出一个
    * 这里直接和前面的比较久可以了
    *
    * 还是太菜
    * */
    public int removeDuplicates_off(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int num [] = {1,1,2};
        LC_26 lc_26 = new LC_26();
        int n =  lc_26.removeDuplicates(num);

        int [] copy = new int[n];
        System.arraycopy(num,0,copy,0,n);
        Print.printArr(copy);


    }
}

package leetcode.interview.offer;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 6/27/2020 7:27 PM
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 * 分析：
 * 双指针
 * 不需要使用额外空间。
 * 用指针p，q指向数组头部尾部。
 * 从前开始遍历，如果是奇数，p+1,
 *  如果是偶数：从q往前找到第一个奇数，交换，p+1
 */
public class Offer_21 {

    public int[] exchange(int[] nums) {
        int p = 0;
        int q = nums.length-1;
        int tmp;
        while (p<q){
            while (p<q&&(nums[p]&1)==1)p++;//找到偶数
            while (p<q&&(nums[q]&1)==0)q--;//找到奇数
//            tmp = nums[p];
//            nums[p++] = nums[q];
//            nums[q--] = tmp;
            nums[p]^=nums[q];
            nums[q]^=nums[p];
            nums[p++]^=nums[q--];
        }
        return nums;
    }

    /*
    * 快慢指针实现
第三种方式使用的是快慢指针，和上一种解决方式有一点区别，上一种是
一前一后扫描。我们这里使用的快慢指针都是从头开始扫描。我们使用两个指
针，一个快指针fast，一个慢指针slow。慢指针slow存放下一个奇数应该存
放的位置，快指针fast往前搜索奇数，搜索到之后然后就和slow指向的值交换
，我们还以上面的数据为例画个图来分析下

    * */

    public int[] exchange_slowfastpointer(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {//奇数
                if (slow != fast) {
                    nums[slow] ^= nums[fast];
                    nums[fast] ^= nums[slow];
                    nums[slow] ^= nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return nums;
    }

    /*
    * 自己写一下双指针，从前到后
    * */

    public int [] f(int nums[]){
        int slow =0;
        int fast = 0;
        while (fast< nums.length){
            if ((nums[fast]&1)==1){
                if (slow!=fast){//不要这个if也行
                    nums[fast] ^= nums[slow];
                    nums[slow] ^= nums[fast];
                    nums[fast] ^= nums[slow];
                }
                slow++;
            }
            fast++;

        }
        return nums;
    }


    public static void main(String[] args) {
        int a= 0;
//        System.out.println(a++);
//        System.out.println(++a);

//        exchange two value

        int x = 100;
        int y = 200;

        //方式1：临时变量
        int size = Integer.MAX_VALUE;
        long s = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int z= x;
            x = y;
            y =z;
        }
        System.out.println(System.currentTimeMillis()-s);

        //方式2：不用临时变量
        s = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            x = x+y;
            y = x-y;
            x = x-y;
        }
        System.out.println(System.currentTimeMillis()-s);


        //方式3：异或。原理：a^b^b = a, 即b^b=0,a^0=a;
        s = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            x^=y;
            y^=x;
            x^=y;
        }
        System.out.println(System.currentTimeMillis()-s);




    }
}

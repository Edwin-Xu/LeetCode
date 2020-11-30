package leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 5/15/2020 11:35 PM
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的
 * 连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7,
 * 1e7]。
 * 通过次数46,594提交次
 *
 *
 */
public class LC_560 {
    //暴力法
    public int subarraySum_1(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int res = 0;
            for (int j=i;j<len;j++){
                res+=nums[j];
                if (res==k){
                    cnt++;
                    //break;
                }
                //if(res>k)break;
            }
        }
        return cnt;
    }



    /*暴力法优化：在内层循环中
    * 如果当前和>k而后面的没有负数
    * 或者当前和小于k但是后面没有正数
    * 都直接结束滑动窗口
    *
    * 但是性能似乎不佳:
    * 比暴力法还差：
    * 原因：很少出现上面的情况，一个数后面大多是正负皆有*/
    public int subarraySum_2(int[] nums, int k) {
        int len = nums.length;
        int[][] mem = new int[len][2]; //+ -

        for (int i = len-2; i >=0 ; i--) {
            if (nums[i+1]>0)mem[i][0]=1+mem[i+1][0];
            else mem[i][0]=mem[i+1][0];
            if (nums[i+1]<0)mem[i][1]=1+mem[i+1][1];
            else mem[i][1]=mem[i+1][1];
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int res = 0;
            for (int j=i;j<len;j++){
                res+=nums[j];
                if (res==k)cnt++;
                else if (res<k && mem[j][0]==0)break;
                else if (res>k && mem[j][1]==0)break;
            }
        }
        return cnt;
    }

    /*
    * 再次优化：
    * 上面使用辅助数组记录a[i]后面的正负数情况
    * 为什么不记录后面的正负数和？
    *
    * 这样如果当前和res>k而后面的负数和绝对值小于res-k
    * 如果res<k，且后面的正数和<k-res
    * 都可以直接结束滑动窗口
    *
    * 性能又变差了，
    * 还是这个原因，数据正负、大小分布均匀，省出来的时间还不够初始化辅助数组和判断
    * */
    public int subarraySum_3(int[] nums, int k) {
        int len = nums.length;
        int[][] mem = new int[len][2]; //+和 -和绝对值

        for (int i = len-2; i >=0 ; i--) {
            if (nums[i+1]>0)mem[i][0]=nums[i+1]+mem[i+1][0];
            else mem[i][0]=mem[i+1][0];
            if (nums[i+1]<0)mem[i][1]=mem[i+1][1]-nums[i+1];
            else mem[i][1]=mem[i+1][1];
        }

        for (int [] i : mem){
            System.out.println(i[0]+" "+i[1]);
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int res = 0;
            for (int j=i;j<len;j++){
                res+=nums[j];
                if (res==k)cnt++;
                else if (res<k && mem[j][0]<k-res)break;
                else if (res>k && mem[j][1]<res-k)break;
            }
        }
        return cnt;
    }


    /*
    * 再次优化，借助以前做过的工作：和
    * 思路不错，减少了很多不必要的求和计算
    * 但是没有本质上减少复杂度。
    * */
    public int subarraySum_4(int[] nums, int k) {
        int len = nums.length;
        int[] mem = new int[len];//用于存放nums[i]及前面的和

        int cnt = 0;

        //初始化数组
        for (int j=0;j<len;j++){
            mem[j]=j==0?nums[0]:mem[j-1]+ nums[j];
            if (mem[j]==k)cnt++;
        }
        System.out.println(cnt);

        for (int i = 1; i < len; i++) {
            for (int j=i;j<len;j++){
                if (mem[j]-mem[i-1]==k)cnt++;
            }
        }
        return cnt;
    }




    /*
    * 上面的这些优化都不好
    *
    * 应该在前缀和的基础上优化第二层循环
    * */

    /*
    * 优化前缀和
    *
    * 利用hash表
    *
    * 我们知道内层循环的目的是：找出mem[j]-mem[i]=k的个数
    * 我们可以使用hash表，记录men[j]和men[i]-k他们二者
    *
    * */
    public int subarraySum_stipid(int[] nums, int k) {
        int len = nums.length;
        int[] mem = new int[len];//用于存放nums[i]及前面的和
        int cnt = 0;//计数
        //初始化数组
        for (int j=0;j<len;j++){
            mem[j]=j==0?nums[0]:mem[j-1]+ nums[j];
        }
        for (int i :mem) System.out.print(i);
        System.out.println();

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < len; i++) {
//            map.put()
            int x = mem[i]-k;

            if (map.containsKey(x)){
                System.out.print("cnt = "+cnt+" + "+map.get(x)+"(map("+x+")) = ");
                cnt+=map.get(x);
                System.out.println(cnt);
            }
            map.put(mem[i],map.getOrDefault(mem[i],0)+1);
        }
        return cnt;
    }

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;//计数
        //初始化数组
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum+=nums[i];
            cnt+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }



    public static void main(String[] args) {
//        int []a = {-92,-63,75,-86,-58,22,31,-16,-66,-67,420};
        int a[] = {1,1,1};
        System.out.println(new LC_560().subarraySum(a,2));
    }
}

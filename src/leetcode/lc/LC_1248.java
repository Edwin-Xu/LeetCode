package leetcode.lc;

/**
 * 没写完
 *
 * Created by Edwin Xu on 4/21/2020 7:57 PM
 *
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 本质：0/1数组
 * 和为k的子数组数量
 */
public class LC_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int count=0;
        for(int i=0;i<=len-k;i++){
            int c = 0;
            for(int j=i;j<len;j++){
               if ((nums[j]&1)==1){
                   c++;
                   if (c==k){
                       count++;
                       for (int m=j+1;m<len;m++){
                           if ((nums[m]&1)==0)count++;
                           else break;
                       }
                       break;
                   }
               }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] a = {1,1,2,1,1};
        System.out.println(new LC_1248().numberOfSubarrays(a,1));
    }
}

package leetcode.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Edwin Xu on 3/18/2020 12:08 AM
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *
 *
 *
 * 除了利用hash，还有一种方式：
 * 排序+双指针
 */
public class LC_1 {

//    public int[] twoSum(int[] nums, int target) {
//        int [] res= new int[2];
//        for (int i=0;i<nums.length-1;i++){
//            for (int j=i+1;j<nums.length;j++){
//                if (nums[i]+nums[j]==target){
//                    res[0]=i;
//                    res[1]=j;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

//    public int[] twoSum(int[] nums, int target) {
//        int [] res= new int[2];
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<nums.length;i++){//构造<值，下标>的Map，用于快速检索
//            map.put(nums[i],i);
//            //注意：
//            //这里会对重复值进行覆盖，取最后一个。
//            //由于题目说明结果唯一，而下面的遍历是从前到后的，故这个覆盖不影响结果.
//        }
//        for (int i=0;i<nums.length;i++){
//            if (map.get(target-nums[i])!=null){ //对于一个值a，判断target-a存不存在
//                res[1] =map.get(target-nums[i]);//如果存在，还需要排除自身。
//                if (res[1]!=i){
//                    res[0]=i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // key:补数，value：下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }



    public int[] sort_twopointers_solution(int [] nums,int target){
        Arrays.sort(nums);
        int l =0;
        int r = nums.length-1;
        while (l<r){
            int sum = nums[l]+nums[r];
            if (sum>target)r--;
            else if (sum<target)l++;
            else {
                //只是找到排序后的下标，还需要找原数组的下标
                //此外还需要把原数组备份一次，有点麻烦啊
                int res[] = new int[2];
                return res;
//                for(int i=0;i<)

            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int [] a = {2,11,5,7,0,0};
        int [] res =  new LC_1().twoSum(a,0);
        System.out.println(res[0]+" "+res[1]);

//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(1,2);
//        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

    }
}

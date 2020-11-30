package leetcode.lc;

/**
 * Created by Edwin Xu on 3/14/2020 12:05 AM
 */
public class LC_169 {
    public int majorityElement(int[] nums) {
        //Way 1:
//        Map<Integer,Integer> map =new  HashMap<>();
//        for(int n: nums){
//            if (map.containsKey(n)){
//                map.put(n,map.get(n)+1);
//            }
//            else{
//                map.put(n,1);
//            }
//        }
//        int size = nums.length/2;
//        for (Map.Entry<Integer,Integer> e: map.entrySet()){
//            if (e.getValue()>size){
//                return e.getKey();
//            }
//        }
//        return -1;



        //方式2：摩尔投票法
        int res = nums[0];
        int count = 0;
        for (int i : nums){
            if (res==i) count++;
            else{
                count--;
                if (count==0){
                    res= i;
                    count=1;
                }
            }
        }
        return res;



    }



    public static void main(String[] args) {
        int [] n = {1,2,1,1,3,3,4,4,5,6,3};
        System.out.println( new LC_169().majorityElement(n));
    }


}

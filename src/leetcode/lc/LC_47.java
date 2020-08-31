package leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 8/8/2020 5:28 PM
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

public class LC_47 {
    /*
    * 这里只是借用46的思想，加一个去重的判断
    * */

    private List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n:nums)list.add(n);
        perm(list,0,nums.length-1);
        return res;
    }
    private void perm(List<Integer> list, int start,int end){
        if (start==end){
            //要想不重复，这里判断一下？
            for (List<Integer> arrayList:res){
                if (compareList(arrayList,list))return;
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <=end ; i++) {
            swap(list,i,start);
            perm(list,start+1,end);
            swap(list,i,start);
        }
    }
    private void swap(List<Integer> list,int i,int j){
        int tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }
    private boolean compareList(List<Integer> a,List<Integer> b){
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i)))return false;
        }
        return true;
    }




    /*
    *
    * 肯定有更好的方法：回溯+剪枝

 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    */
}

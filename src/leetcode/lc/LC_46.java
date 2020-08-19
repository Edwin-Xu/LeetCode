package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 8/8/2020 5:28 PM
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

//回溯算法
//
// result = []
//def backtrack(路径, 选择列表):
//    if 满足结束条件:
//        result.add(路径)
//        return
//
//    for 选择 in 选择列表:
//        做选择
//        backtrack(路径, 选择列表)
//        撤销选择
//
// */
public class LC_46 {
    /*
    * 递归求解，每次选择一个数，然后求解剩下的组合。
    *
    * 实际上是一个回溯，不过复制数组花了过多时间
    *
    * */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sourceList = new LinkedList<>();
        for (int i:nums)sourceList.add(i);
        return getSubList(sourceList);
    }
    private List<List<Integer>>  getSubList(List<Integer> sourceList){
        List<List<Integer>> res = new ArrayList<>();
        if (sourceList.size()==0)return res;
        else if (sourceList.size()==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sourceList.get(0));
            res.add(list);
        }
        else{
            for (int i:sourceList){ //每次选中一个，递归下去
                List<Integer> source = new LinkedList<>();
                source.addAll(sourceList);
                source.remove((Integer) i);

                List<List<Integer>> subRes = getSubList(source);
                for (List<Integer> arrayList: subRes){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.addAll(arrayList);
                    res.add(list);
                }
            }

        }
        return res;
    }


    /*
    * 上面回溯的优化
    *
    * 性能也不咋地，比上面要好一些
    * */
    class realBack{
        List<List<Integer>> res = new LinkedList<>();

        /* 主函数，输入一组不重复的数字，返回它们的全排列 */
        List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
        void backtrack(int[] nums, LinkedList<Integer> track) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i]))
                    continue;
                // 做选择
                track.add(nums[i]);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择
                track.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        LC_46 lc_46 = new LC_46();
        int a[] = {1,2,3};
        List<List<Integer>> res = lc_46.permute(a);
        for (List<Integer> x: res){
            System.out.println(x);
        }
    }
}

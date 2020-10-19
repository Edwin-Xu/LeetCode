package basic_algorithm.permutation_and_combination.comb;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/13/2020 1:48 PM
 */
public class CombTemplate {

    /*
    * C(n,k)
    * */
    private List<List<Integer>> output = new LinkedList();
    private int k;
    private int n;
    public List<List<Integer>> comb(int[] nums, int k) {
        n = nums.length;
        this.k = k;
        comb(nums, 0, new LinkedList<>());
        return output;
    }

    private void comb(int[] nums, int start, LinkedList<Integer> list) {
        if (list.size() == k) {
            output.add(new LinkedList<>(list));
            return;
        }
        //剪枝：如果剩余的不足，直接跳出
        if (n - start < k - list.size()) return;

        for (int i = start; i < n; i++) {
            list.add(nums[i]);
            comb(nums, i + 1, list);
            list.removeLast();
        }
    }

}

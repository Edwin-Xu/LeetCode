package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/7/2020 9:03 PM.
 *
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 */

public class LC_119 {

    //直接利用前面一题：LC118
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>(i);

            rowList.add(1); //添加第一个
            if (i == 1) { //第一行只有一个
                res.add(rowList);
                continue;
            }

            for (int j = 1; j < i - 1; j++) {
                rowList.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));//添加第1~n-1个
            }
            rowList.add(1);//添加尾部
            res.add(rowList);
        }
        return res.get(rowIndex);
    }
    //空间复杂度可以优化，只需要关心上一一行即可。
}

package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * Created by Edwin Xu on 10/7/2020 8:18 PM.
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */

public class LC_118 {
    public List<List<Integer>> generate(int numRows) {
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
        return res;
    }

    public static void main(String[] args) {
        // List接口的实现类，比如ArrayList，其中的size是已经使用的元素数量，和容量不相关
        // 所以设置初始容量不管为多少，创建时size=0。
//        List<Integer> rowList = new ArrayList<>(10);
//        System.out.println(rowList.size());//0
//        rowList.add(1);
//        System.out.println(rowList.size());//1
//


        LC_118 lc_118 = new LC_118();
        List<List<Integer>> res = lc_118.generate(5);
        for (List<Integer> list : res) {
            for (int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

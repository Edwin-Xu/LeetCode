package company.zte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 7/22/2020 4:59 PM
 * 求整数1~N范围和为M的所有组合
 *
 *
 *
 * 递归：
 * 1-N：
 *  和为M组合：
 *      包含N的： 1~N-1和为M-N
 *      不包含N：1~N-1和为M
 */
public class From_To_1_Sum_is_M {
    //这里使用递归，实质接近于暴力解法，答应的是所有可能，需要判断
    public static void f(int n,int m,List<Integer> list){
        if (n == 0)
        {
            int res = 0;
            for (int i: list)res+=i;
            if(res==10) System.out.println(list);
            return;
        }
        if (n<0 || m<=0)return;
        List list1 = new ArrayList<>(list);
        f(n-1,m,list1);
        list1.add(n);
        f(n-1,m-1,list1);
    }
    //上面：使用一个额外数组记录，避免重复子问题。  不行，这个子问题都不是重复的。





    public static void main(String[] args) {
        From_To_1_Sum_is_M.f(5,10,new ArrayList<Integer>());
    }
}

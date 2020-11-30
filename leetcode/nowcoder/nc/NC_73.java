package leetcode.nowcoder.nc;

/**
 * Created by Edwin Xu on 9/19/2020 12:08 AM
 * <p>
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度
 * 为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 */
public class NC_73 {
    public int MoreThanHalfNum_Solution(int[] array) {
        // 摩尔投票法
        int cnt = 1;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (num == array[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    if (i + 1 < array.length) num = array[i + 1];
                }
            }
        }
        //判断是否超过了一半
        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) cnt++;
        }
        return cnt <= array.length / 2 ? 0 : num;
    }
}

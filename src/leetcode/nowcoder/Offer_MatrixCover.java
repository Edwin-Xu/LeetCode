package leetcode.nowcoder;

/**
 * Created by Edwin Xu on 6/24/2020 4:27 PM
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 *
 *
 * analysis:
 * 动态规划：
 *类似Fibonacci
 */
public class Offer_MatrixCover {
    public int RectCover(int len) {
        if(len<0)return 0;
        if (len==1)return 1;
        if (len==2)return 2;
        return RectCover(len-1)+RectCover(len-2);
    }
}

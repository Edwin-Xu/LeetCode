package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/1/2020 2:45 PM.
 * 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 */

public class LC_1518 {
    /*
贪心：只要可以换，就不断换，直到没有酒，空瓶也不足以换
*/
    public int numWaterBottles(int numBottles, int numExchange) {
        int ret = 0;
        int emptyBottoles = 0;
        //当酒+空瓶数量始终大于numExchange时，表明可以一直兑换
        while (numBottles + emptyBottoles >= numExchange) {
            //将所有的酒都喝掉，得到numBottles个空瓶
            ret += numBottles; //喝到了numBottles瓶
            emptyBottoles += numBottles;//空瓶多了numBottles个
            numBottles = 0;//没有酒了

            //空瓶兑换
            //兑换exchangeBottoles瓶酒
            int exchangeBottoles = emptyBottoles / numExchange;
            //花掉了exchangeBottoles*numExchange个空瓶
            emptyBottoles -= exchangeBottoles * numExchange;
            //现在有了exchangeBottoles瓶
            numBottles = exchangeBottoles;
        }
        return ret + numBottles; // numBottles也可以喝了，喝了之后不能再兑换。
    }
}

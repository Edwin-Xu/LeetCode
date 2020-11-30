package leetcode.lc;

/**
 * Created by Edwin Xu on 9/22/2020 9:00 PM
 */
public class LC_1486 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0;i<n;i++){
            res ^= start+2*i;
        }
        return res;
    }

    /*
    * O(1)算法
    *
1) 0 ^ x = x
2) x ^ x = 0
3) 2x ^ (2x+1) = 1

将数列转为以偶数开头，以1为步长的数列，根据异或性质进行计算，得到结果后*2
然后再对最终的结果最后一位补上,最后一位单独做运算

1）当前的数列步长为2，但是目标的步长为1，这就需要我们对整个数列/2，即start/2，步长为1
    start为奇数的时候，那么根据公式2，可以添加2个 (start-1)进行异或，转为开头为偶数进行计算
        array(start, n) = (start-1) ^ array(start-1， n+1)，此时n=n+1
    start为偶数
        n为奇数，根据公式3，最终一共有 n/2个1 和 一个start+num-1 进行异或,即 res = (n/2)^1 & (start+num-1)
        n为偶数，根据公式3，最终一共有 n/2个1进行异或，即 res = (n/2)^1
    返回 res

2）对于1的处理，每个数/2，即把二进制数的最后一位去掉，统统向右挪动一位
    现在要恢复，需要向左挪动1位,即res = res * 2
    然后对最开始的数组进行最后一位的计算
        当且仅当start为奇数、n为奇数的时候，最后一位的异或计算为1，其余为零，
        if (start&1 && n&1)
            res += 1
最终的res即为最终结果

class Solution {
public:
    int xorOperation(int n, int start) {
        int ans = 2 * myxor(n, start/2);
        if (n & start & 1)
            ans += 1;
        return ans;
    }

    int myxor(int n, int start)
    {
        if (start & 1)
            return (start-1) ^ myxor(n+1, start-1);
        else
        {
            if (n & 1)
                return (start+n-1) ^ ((n/2) & 1);
            else
                return (n/2) & 1;
        }
    }
};



    * */
}

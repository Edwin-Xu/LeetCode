package leetcode.lc;

/**
 * Created by Edwin Xu on 9/5/2020 7:00 PM
 *
 * NC_49
 */
public class LC_32 {
    //也算是动态规划的经典案例了

    public int longestValidParentheses (String s) {
        //动态规划
        int [] dp = new int[s.length()]; // 以s[i]结尾的规范串长度
        int max = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==')'){
                int prev = i-dp[i-1]-1; //以上一个字符结尾的规范串的开头的上一个，看这个字符是不是和当前字符匹配
                if(prev>=0 && s.charAt(prev)=='('){
                    dp[i]+=2+dp[i-1]; //匹配，前后两个字符组成一个(),包含中间的规范串
                    if(prev>=1) dp[i]+=dp[prev-1]; //如果整个规范串前面还是规范串，也需要加上，比如前面是()，需要加到当前规范串上
                }
            }else{
                //当前为(, 必然不能是某个规范串的末尾
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /*
    * 栈
    * */
}

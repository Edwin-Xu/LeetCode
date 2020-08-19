package leetcode.lc;

/**
 * Created by Edwin Xu on 4/4/2020 3:15 PM
 *
 * Trapping Rain Water
 *
 * 从第一个柱子开始，寻找第一个比它高的，即可组成一个槽,
 * 如果没有更高的，就找到后面最高的，这时也可以组成一个槽
 */
public class LC_42 {
    public int trap(int[] height) {
        int len = height.length;
        int rainCount = 0;//雨量
        for (int i=0;i<len-1;i++){
            if (height[i+1]>height[i])continue;//如果这个柱子比下一个低，跳过。
            int highter = height[i];//后面更高的柱子高度
            int highterIndex = i;//后面更高的柱子索引
            int max = height[i+1];//后面的最高柱子
            int maxIndex = i+1;
            boolean hasHighter = false;//后面是否存在比当前柱子更高的柱子
            for (int j=i+1;j<len;j++){
                if (height[j]>=highter){//找到不低于当前柱子的柱子
                    highterIndex = j;
                    hasHighter = true;
                    break;
                }
                if (height[j]>max){//计算后面最高的
                    max = height[j];
                    maxIndex = j;
                }
            }
            if (!hasHighter) {//如果后面没有更高的柱子，就是用后面的最高柱子
                highterIndex = maxIndex;
                highter = max;
            }
            for (int j=i+1;j<highterIndex;j++){//计算这个槽可以几类的雨量
                rainCount+=highter-height[j];
            }
            i=highterIndex-1;//跳到这个槽的右边柱子
        }
        return rainCount;
    }

    public static void main(String[] args) {
        int [] a = {1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new LC_42().trap(a));
    }
}

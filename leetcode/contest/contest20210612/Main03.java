package leetcode.contest.contest20210612;

/**
 * @author Edwin Xu
 * @date 6/12/2021 11:56 PM.
 *
 * 5768. 找到需要补充粉笔的学生编号 显示英文描述
 * 题目难度Medium
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 *
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 *
 * 请你返回需要 补充 粉笔的学生 编号 。
 */

public class Main03 {
    /**
     * 常规解法：轮询
     * */
    public int chalkReplacer(int[] chalk, int k) {
        // 由于粉笔数可能够所有人回答一轮，所有为了避免重复的轮询，先求和，取余，保证只会轮询一遍。
        // 这里需要注意：和可能会超出2^31-1，所以必须转换为long
        long chalkSum = k;

        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum+=chalk[i];
            // 如果在求和过程中就发现和>k了，那就可以直接返回了
            if (sum>k) {
                return i;
            }
        }
        chalkSum =  chalkSum%sum;

        int index = 0;
        while (true){
            if(chalkSum>=chalk[index]) {
                chalkSum-=chalk[index];
            } else{
                break;
            }
            // 求和后需要要循环了
            // index++;
            // if (index==chalk.length){
            //     index=0;
            // }
        }
        return index;
    }
}

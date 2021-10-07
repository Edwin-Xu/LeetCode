package leetcode.lc;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * 650. 只有两个键的键盘
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * @author taoxu.xu
 * @date 9/20/2021 3:25 PM
 *
 * TODO todo
 */
public class LC_650 {
    class Node{
        /**
         * 经过的操作数量
         * */
        int opNum;
        /**
         * 粘贴板的字符数量
         * */
        int pasteNum;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node){
                Node node = (Node) obj;
                return opNum == node.opNum && pasteNum == node.pasteNum;
            }
            return false;
        }

        public Node(int opNum, int pasteNum) {
            this.opNum = opNum;
            this.pasteNum = pasteNum;
        }
    }


    public int minSteps(int n) {
        if (n < 2){
            return 0;
        }

        final List[] lists = new ArrayList[n+1];

        lists[1] = new ArrayList(){
            {add(new Node(0, 0));}
        } ;
        for (int i = 1; i < n; i++) {

        }
        return 0;
    }
}

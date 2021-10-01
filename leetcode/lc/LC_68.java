package leetcode.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * @author taoxu.xu
 * @date 9/9/2021 6:23 PM
 */
public class LC_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        final ArrayList<String> res = new ArrayList<>();

        final StringBuilder builder = new StringBuilder();

        int lengthCount = 0;
        int count = 0;
        final LinkedList<Object> queue = new LinkedList<>();
        for (int i = 0; i< words.length; i++) {
            int len = words[i].length();
            if (lengthCount +len + count  > maxWidth){
                // 之前积累长度 + 当前Word长度 + 空格 达到最大长度
                int spaceNum = maxWidth - lengthCount ;

                int blankNum = count <2?1: spaceNum/(count-1);
                int spaceLeft = count <2?spaceNum: spaceNum % (count-1);

                //System.out.println(lengthCount+" "+count+" "+ spaceNum +" "+blankNum+ " "+spaceLeft);

                boolean onlyOne = queue.size()==1;
                while (!queue.isEmpty()){
                    builder.append(queue.removeFirst());
                    if (queue.size()>0 || onlyOne){
                        builder.append(generateSpace(onlyOne?spaceLeft: blankNum + (spaceLeft-->0?1:0)));
                    }
                }
                res.add(builder.toString());
                builder.delete(0,builder.length());
                count = 0;
                lengthCount = 0;
                i--;
                continue;
            }
            count++;
            lengthCount += len;
            queue.add(words[i]);

            if (i == words.length-1 && !queue.isEmpty()){
                int cnt = 0;
                while (!queue.isEmpty()){
                    final String s = (String) queue.removeFirst();
                    builder.append(s);
                    cnt+=s.length();
                    if (cnt < maxWidth){
                        builder.append(" ");
                    }
                    cnt++;
                }
                builder.append(generateSpace(maxWidth-lengthCount - count));
                res.add(builder.toString());
            }
        }

        return res;
    }
    private String generateSpace(int size){
        String res = "";
        for (int i = 0; i < size; i++) {
            res +=" ";
        }
        return res;
    }


    public static void main(String[] args) {
        String []strs = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        final LC_68 lc_68 = new LC_68();
        final List<String> strings = lc_68.fullJustify(strs, 16);
        for (String string : strings) {
            System.out.println(string+"|");
        }
    }
}

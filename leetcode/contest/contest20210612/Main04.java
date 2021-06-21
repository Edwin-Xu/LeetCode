package leetcode.contest.contest20210612;

/**
 * @author Edwin Xu
 * @date 6/13/2021 2:16 PM.
 *
 * 5770. 反转表达式值的最少操作次数
 *
 * 给你一个 有效的 布尔表达式，用字符串 expression 表示。这个字符串包含字符 '1'，'0'，'&'（按位 与 运算），'|'（按位 或 运算），'(' 和 ')' 。
 *
 * 比方说，"()1|1" 和 "(1)&()" 不是有效 布尔表达式。而 "1"， "(((1))|(0))" 和 "1|(0&(1))" 是 有效 布尔表达式。
 * 你的目标是将布尔表达式的 值 反转 （也就是将 0 变为 1 ，或者将 1 变为 0），请你返回达成目标需要的 最少操作 次数。
 *
 * 比方说，如果表达式 expression = "1|1|(0&0)&1" ，它的 值 为 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1 。我们想要执行操作将 新的 表达式的值变成 0 。
 * 可执行的 操作 如下：
 *
 * 将一个 '1' 变成一个 '0' 。
 * 将一个 '0' 变成一个 '1' 。
 * 将一个 '&' 变成一个 '|' 。
 * 将一个 '|' 变成一个 '&' 。
 * 注意：'&' 的 运算优先级 与 '|' 相同 。计算表达式时，括号优先级 最高 ，然后按照 从左到右 的顺序运算。
 *
 *
 * 示例 1：
 *
 * 输入：expression = "1&(0|1)"
 * 输出：1
 * 解释：我们可以将 "1&(0|1)" 变成 "1&(0&1)" ，执行的操作为将一个 '|' 变成一个 '&' ，执行了 1 次操作。
 * 新表达式的值为 0 。
 * 示例 2：
 *
 * 输入：expression = "(0&0)&(0&0&0)"
 * 输出：3
 * 解释：我们可以将 "(0&0)&(0&0&0)" 变成 "(0|1)|(0&0&0)" ，执行了 3 次操作。
 * 新表达式的值为 1 。
 * 示例 3：
 *
 * 输入：expression = "(0|(1|0&1))"
 * 输出：1
 * 解释：我们可以将 "(0|(1|0&1))" 变成 "(0|(0|0&1))" ，执行了 1 次操作。
 * 新表达式的值为 0 。
 *
 *
 * 提示：
 *
 * 1 <= expression.length <= 105
 * expression 只包含 '1'，'0'，'&'，'|'，'(' 和 ')'
 * 所有括号都有与之匹配的对应括号。
 * 不会有空的括号（也就是说 "()" 不是 expression 的子字符串）。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * ---------------------------------------------------
 * 这里有难度
 * https://blog.csdn.net/zml66666/article/details/117858799
 *
 *
 * 原来这些题都是力扣的原题，如果做过，那么直接复制原来的即可，是不是有人直接复制题解？？？
 *
 *
 */

public class Main04 {
    public int minOperationsToFlip(String expression) {


        return -1;
    }
}
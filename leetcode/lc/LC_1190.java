package leetcode.lc;

import leetcode.util.Print;

import java.util.LinkedList;

/**
 * @author Edwin Xu
 * @date 5/27/2021 12:05 AM.
 * <p>
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 */

public class LC_1190 {

    /**
     * 不能使用数组来记录 (、)的下标
     */
    public String reverseParenthesesWrong(String s) {
        char[] chs = s.toCharArray();
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') left.add(i);
            else if (chs[i] == ')') right.addFirst(i);
        }

        int size = left.size();
        for (int i = 0; i < size; i++) {
            // 从内到外，找到匹配的括号
            int L = left.removeLast();
            int R = right.removeLast();
            chs[L++] = ' ';
            chs[R--] = ' ';
            while (L < R) {
                char tmp = chs[L];
                chs[L] = chs[R];
                chs[R] = tmp;
                L++;
                R--;
            }
        }
        int L = 0, R = 0;
        while (R < chs.length) {
            while (R < chs.length && chs[R] == ' ') R++;
            while (R < chs.length && chs[R] != ' ') chs[L++] = chs[R++];
        }
        return String.valueOf(chs, 0, L);
    }


    public String reverseParentheses(String s) {
        char[] chs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (ch == ')') {
                sb = new StringBuilder();
                while (stack.getLast() != '(') {
                    sb.append(stack.removeLast());
                }
                stack.removeLast();

                for (int i = 0; i < sb.length(); i++) {
                    stack.addLast(sb.charAt(i));
                }
            } else {
                stack.add(ch);
            }
        }

        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_1190 lc_1190 = new LC_1190();
        String s = "ta()usw((((a))))";



        /*
         * LinkedList 中pop peek的问题
         *
         * addLast 和 add 功能一样，addLast返回空，add返回Boolean
         * peek返回第一个, 注意不是第一个
         * poll移除第一个，注意是第一个，不抛异常
         *
         *
         **/
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.addLast(3);

        Print.printList(stack);

        System.out.println(stack.peek());
        System.out.println(stack.getFirst());

        System.out.println(stack.poll());

        Print.printList(stack);
    }
}

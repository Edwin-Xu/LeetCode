package company.sogou;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/5/2020 11:22 PM
 *
 * 在搜索引擎后端服务中，需要对恶意的抓取进行限制，其中的一个环节即对访问IP进行限制。请设计一个IP过滤器，实现对访问的IP限制的功能。对IP的限制数据有三种格式：
 * 1.全IP：如222.205.58.16
 * 2.前面带 *：如 *.58.16
 * 3.后面带 *：如 222.205.58.*
 * 带 * 的表示匹配到任意的IP段均可，且 * 可以代表多个ip段，且 * 只能出现在开头或者结尾。
 * 现给出若干条需要过滤的规则，以及若干输入的IP，你需要输出这若干条IP是否会被过滤
 *
 * 输入描述:
 * 输入的第一行是过滤规则的条数N和需要过滤的IP数量M，之后的N行为IP的过滤规则且均合法，再之后的M行为需要进行判断是否被过滤的IP。其中N<100，M<50。
 *
 * 输出描述:
 * 0：该条IP不会被过滤
 * 1：该条IP会被过滤
 * 总共M条需要判断的IP需要以空格作为区分
 *
 * 输入例子1:
 * 5 3
 * 222.205.58.16
 * *.58.16
 * 222.205.58.*
 * *.16
 * 224.*
 * 222.205.58.17
 * 222.205.59.19
 * 223.205.59.16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.nextLine();

        ArrayList<String > rules = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            String r = scanner.nextLine();
            if (r.charAt(0)=='*')r = "."+r;
            rules.add(r);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++) {
            String s = scanner.nextLine();
            boolean filter = false;
            for (String r: rules){
                if (s.matches(r)){
                    sb.append(1);
                    sb.append(" ");
                    filter = true;
                    break;
                }
            }
            if (!filter){
                sb.append(0);
                sb.append(" ");
            }

        }
        System.out.println(sb.toString());

    }

}

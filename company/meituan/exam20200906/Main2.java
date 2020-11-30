package company.meituan.exam20200906;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/6/2020 10:13 AM
 * <p>
 * 一个字符串，只包含大小写字母
 * 大写和小写可以转换
 * 求：经过多少次转换可以使大小写字母数量相同。
 */
public class Main2 {
    public Main2() {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        char[] chs = inp.toCharArray();
        int num = 0;//小写
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'a') {
                num++;
            }
        }
        int res = Math.abs(num - (chs.length - num)) / 2; // (小写-大写)/2
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Main2();
    }
}

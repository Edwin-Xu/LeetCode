package company.jd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
    public Main1() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = scanner.nextLine();
        sb.append(s);
        char[] chs = sb.toString().toCharArray();
        sb.delete(0, sb.length());
        for (int i = 0; i < chs.length - 4; i++) {
            if (isDigit123(chs[i]) && isDigit(chs[i + 1]) && isDigit(chs[i + 2]) && isDigit(chs[i + 3]) &&
                    (chs[i + 4] == ' ' || !isDigit(chs[i + 4])) &&
                    (i > 0 && chs[i - 1] == ' ')) {
                int integer = getInt(chs[i], chs[i + 1], chs[i + 2], chs[i + 3]);
                if (integer == -1) continue;
                sb.append(integer);
                i += 3;
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isDigit123(char c) {
        return c >= '1' && c <= '3';
    }

    private int getInt(char a, char b, char c, char d) {
        int res = (a - '0') * 1000 + (b - '0') * 100 + (c - '0') * 10 + (d - '0');
        if (res >= 1000 && res <= 3999) {
            return res;
        }
        return -1;
    }

    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = s.replaceAll("\\p{LC}+", "-") //字母
                .replaceAll("\\p{Punct}+", "-") //标点
                .replaceAll("\\p{Space}+", "-") //空格
                .replaceAll("-+", "-");
//        System.out.println(res);
        String[] arr = res.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : arr) {
            if (str.length() == 4) {
                int n = Integer.valueOf(str);
                if (n >= 1000 && n <= 3999) {
                    stringBuilder.append(n);
                    stringBuilder.append(" ");
                }
            }
        }
        if (stringBuilder.length() > 0) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());


        String x = "weew 2020 sldn";
        Matcher matcher = Pattern.compile(".*[1-3][0-9][0-9][0-9].*").matcher(x);
        System.out.println(matcher.group());
        for (int i = 0; i <matcher.groupCount() ; i++) {
            System.out.println(matcher.group(i));
        }

    }
}

/*
And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.

2300 3400 0210000 343433333

sdsd2020sdsdsd3030 sdsd sdsd2021sd100sd120000nksjdbhbsdj

ssd2020

如果是343433333，还可能是年份吗？
年份前应该是 空格|第一个
年份后应该是 空格|标点

201003abc2020输出2020
所说不考虑前面必须是标点或者是空格

is 1111.2021 这个算吗？？？ 按理解来说应该是一个小数


* */
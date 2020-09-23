package company.bytedance.exam20200920;

import java.util.Scanner;

/*
* 不让使用本地IDE
* 1. 判断一个字符串是不是有循环字符串
*    若是，如abcabcabc，返回最小的循环子串，abc
*    若不是返回原串
* 2. 大数+-*^
* 3. 火车站选址、人地址。 使人到火车站的路径和最短
* 4. 无根树，节点有正反、反转一个节点导致该节点及周围节点反转，求一棵树反转后能不能全部是正/反
*
*
*
* 复盘
*
*
* 考得太差
*
*
*
*
*
* */
public class Main {
    public Main(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println((2*i )^(2*i+1) );
        }
//        new Main();
    }
}

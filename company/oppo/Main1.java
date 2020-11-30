package company.oppo;

/*
* 打印所有回文子串
*
* */
public class Main1 {


    public void printPlalindromeSubStr(String str) {
        //添加#，改造字符串，避免奇偶问题
        char[] chs = new char[str.length() * 2 - 1];
        for (int i = 0; i < str.length() - 1; i++) {
            chs[i * 2] = str.charAt(i);
            chs[i * 2 + 1] = '#';
        }
        chs[str.length() * 2 - 2] = str.charAt(str.length() - 1);

        //中心扩展法
        for (int i = 0; i < chs.length; i++) {
            int x = i - 1, y = i + 1;
            StringBuilder sb = new StringBuilder();
            if (chs[i]!='#')sb.append(chs[i]); //对于一个中心
            while (x >= 0 && y < chs.length) {//向两边扩展
                if (chs[x] != chs[y]) break;//扩展到边界
                if (chs[x]!='#'){// 如果不是#，添加到头尾
                    sb.insert(0,chs[x]);  // 其实这个插入的复杂度挺高的：底层是通过复制数组实现的。
                    sb.insert(sb.length(),chs[y]);
                    if (sb.length()>1) System.out.println(sb.toString());
                }
                x--;
                y++;
            }
        }
    }

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(1);
//        sb.append(2);
//        System.out.println(sb.toString());
//        sb.insert(0,0);
//        System.out.println(sb.toString());
//        sb.insert(sb.length(),3);
//        System.out.println(sb.toString());
//        sb.delete(0,sb.length());
//        System.out.println(sb.toString());

        new Main1().printPlalindromeSubStr ("woppocom");


    }
}


package company.mi;

import java.util.Scanner;
public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        String pws[] = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String pw: pws) {
            sb.append(checkPw(pw));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }

    private int checkPw(String pw) {
        int len = pw.length();
        if (len<8 || len>120)return 1;
        boolean num = false;
        boolean A = false;
        boolean a = false;
        int numAndAplha = 0;
        for (char c: pw.toCharArray()) {
            if (c>='0' && c<='9'){
                numAndAplha++;
                num =true;
            }else if (c>='A' && c<='Z'){
                numAndAplha++;
                A =true;
            }else if (c>='a' && c<='z'){
                numAndAplha++;
                a = true;
            }
        }
        if (numAndAplha==len)return 2; //没有符号
        if (num && A &&a )return 0;
        else return 2;

    }

    public static void main(String[] args) {
        new Main1();
    }

}

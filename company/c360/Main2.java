package company.c360;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/11/2020 8:30 PM
 */
public class Main2 {
    public Main2(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String ok = "Ok\n";
        String notOk = "Irregular password\n";

        while (scanner.hasNextLine()){
            String pw = scanner.nextLine();
            sb.append(checkPw(pw)?ok:notOk);
        }
        scanner.close();
        System.out.println(sb.toString());


    }

    private boolean checkPw(String pw){
        if (pw.length()<8)return false;

        boolean num = false;
        boolean A = false;
        boolean a = false;
        int cnt = 0;
        for (int i = 0; i <pw.length() ; i++) {
            char c = pw.charAt(i);
            if (c>='0' && c<='9'){
                cnt++;
                num = true;
            }else if( c>='a' && c<='z'){
                cnt++;
                a = true;
            }else if (c>='A' && c<='Z'){
                cnt++;
                A = true;
            }
        }
        return num && A && a &&(cnt!=pw.length());
    }

    public static void main(String[] args) {
        new Main2();
    }
}

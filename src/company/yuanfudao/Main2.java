package company.yuanfudao;

/*
*
*
* 40%
*
*
表达式求值
2
(+ (* (- 10 3) 20) 2)
- 2 3

(+ A B)
+和后面的值间空格可以省去

如果表达式格式不合法
输出invalid


- 可以使用栈来求值
- 或者复杂点：每次找出一对(),计算值后替换回去，知道没有()


* */
import java.util.Scanner;

public class Main2 {
    public Main2(){
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            try {
                int res = calc(s);
                sb.append(res==-1?"invalid":res);
            }catch (Exception e){
                sb.append("invalid");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public int calc(String s){
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c  = s.charAt(i);
//            if (c=='('){
//                stack.push(c);
//            }
//            else if ()
//        }


        //
        while (s.contains("(")){
            int L = -1;
            int R = -1;
            for (int i = 0; i <s.length() ; i++) {
                char c = s.charAt(i);
                if (c=='('){
                    L = i;
                }
                if (L!=-1 && c==')'){
                    R = i;
                    break;
                }
            }
            if (L==-1||R==-1)return -1;


            String str= s.substring(L+1,R);
            str = str.substring(0,1)+" "+str.substring(1);

            String arr [] = str.split(" ");
            if (arr.length<3)return -1;
            int num1 = Integer.valueOf(arr[1]);
            int num2 = Integer.valueOf(arr[2]);
            int res = 0;
            if (arr[0].equals("+"))res = num1+num2;
            else if (arr[0].equals("-"))res = num1-num2;
            else if (arr[0].equals("*"))res = num1*num2;
            s = s.substring(0,L)+res+s.substring(R+1);

        }
        return (Integer.valueOf(s)%10000000+10000000)%10000000;
    }

    public static void main(String[] args) {
        new Main2();
    }
}

/*
2
(+ (* (- 10 3) 20) 2)
- 2 3


* */
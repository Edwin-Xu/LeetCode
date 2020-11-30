package company.meituan.other;

/**
 * Created by Edwin Xu on 4/3/2020 6:28 PM
 * 给出一个布尔表达式的字符串，比如：true or false and false，
 * 表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值，
 * 计算结果为真时输出true、为假时输出false，不合法的表达时输出error
 * （比如：true true）。表达式求值是注意and 的优先级比 or 要高，
 * 比如：true or false and false，等价于 true or (false and false)，
 * 计算结果是 true。
 */

import java.util.Scanner;
public class expression2bool {
    public static void main(String[] args) {
       int res = expression2bool.better();
       if (res==0) System.out.println("error");
       else if (res==1) System.out.println("true");
       else System.out.println("false");
    }

    public void solution1(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        String []expArr = inp.split(" ");

        String last = expArr[expArr.length-1];
        if (expArr.length%2==0 || !last.equals("false")&&!last.equals("true")){
            System.out.println("error");
            return;
        }

        for (int i=0;i<expArr.length-1;i++){
            String exp = expArr[i];
            if (i%2==0){//True False
                if (!exp.equals("false") && !exp.equals("true")) {
                    System.out.println("error");
                    return;
                }
            }
            else{
                if (exp.equals("and")) {
                    String exp2 = expArr[i+1];
                    if (exp2.equals("false")) {
                        expArr[i+1]="false";
                        expArr[i]="";
                        expArr[i-1]="";
                    }
                    else if (exp2.equals("true")){
                        expArr[i+1]= expArr[i-1].equals("true")?"true": "false";
                        expArr[i]="";
                        expArr[i-1]="";
                    }else{
                        System.out.println("error");
                        return;
                    }
                }else if (!exp.equals("or")){
                    System.out.println("error");
                    return;
                }
            }
        }

        for (String s:expArr){
            if (s.equals("true")){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }


    public static int better(){//0:error  1:true  2:false
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        String []expArr = inp.split(" ");
        int len = expArr.length;
        int arr [] = new int[len];//字符串比较太麻烦，转整数。  0:false,1:true, 2:and, 3: or
        if (len%2==0) return 0;
        String exp ;
        char c;
        for (int i=0;i<len;i++){
            exp= expArr[i];
            c = exp.charAt(0);
            if (i%2==0){
                if (c=='t')arr[i]=1;
                else if (c=='f')arr[i]=0;
                else return 0;
            }else{
                if (c=='o')arr[i]=3;
                else if (c=='a')arr[i]=2;
                else return 0;
            }
        }
        if (len==1) return arr[0]==1?1:2;
        //处理and
        for (int i=1;i<len-1;i+=2){
            if (arr[i]==2){//and
                if (arr[i-1]+arr[i+1]<2){
                    arr[i-1]=0;
                    arr[i+1]=0;
                }
            }
        }
        for (int i=0;i<len;i+=2){
            if (arr[i]==1)return 1;
        }
        return 2;
    }
}

package company.huawei.huaweitest;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class Register {

    private Scanner sc ;

    class Reg{
        String a;
        String b;
        String c;
        Reg(String a,String b,String c){
          this.a = a;
          this.b=b;
          this.c=c;
        }
        void print(){
            System.out.print(a+" "+b+" "+c+"\r\n");
        }
    }


    public Register(){
        sc = new Scanner(System.in);

        String inp[] = sc.nextLine().split(" ");
        sc.close();
        String pat = inp[0].toLowerCase();
        String strs[] = inp[1].split("],");
        strs[strs.length-1] = strs[strs.length-1].substring(0,strs[strs.length-1].length()-1);


        ArrayList<Reg> list = new ArrayList<>();

        for (String s: strs){
            System.out.println(s);
            String p[] = s.split("\\[");
            if (!p[0].toLowerCase().equals(pat))continue;
            String arr[] = p[1].split(",");
            if (!arr[0].substring(0,7).equals("addr=0x") && !arr[0].substring(0,7).equals("addr=0X"))continue;
            if (!arr[1].substring(0,7).equals("mask=0x") && !arr[1].substring(0,7).equals("mask=0X"))continue;
            if (!arr[2].substring(0,6).equals("val=0x") && !arr[2].substring(0,6).equals("val=0X"))continue;

            String addr = arr[0].split("=")[1];
            String mask = arr[1].split("=")[1];
            String val = arr[2].split("=")[1];

            boolean isOk = true;
            for (char c: addr.toCharArray()){
                if ((c>'0'&&c<'9') || (c>'a' && c<'f') || (c>'A'&&c<'F')){

                }else{
                    isOk =false;
                    break;
                }
            }
            if (isOk==false)continue;
            isOk = true;
            for (char c: mask.toCharArray()){
                if ((c>'0'&&c<'9') || (c>'a' && c<'f') || (c>'A'&&c<'F')){

                }else{
                    isOk =false;
                    break;
                }
            }
            if (isOk==false)continue;
            isOk = true;
            for (char c: val.toCharArray()){
                if ((c>'0'&&c<'9') || (c>'a' && c<'f') || (c>'A'&&c<'F')){

                }else{
                    isOk =false;
                    break;
                }
            }
            if (isOk==false)continue;


            //判断值

            list.add(new Reg(arr[0].split("=")[1],arr[1].split("=")[1],arr[2].split("=")[1]));


        }

        for (Reg r: list){
            r.print();
        }



    }



    public static void main(String[] args) {

        new Register();
    }
}

/*

read read[addr=0xff,mask=0x45,val=0x7],read[addr=0xff,mask=0x45,val=0x7]

 */
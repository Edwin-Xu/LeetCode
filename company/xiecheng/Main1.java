package company.xiecheng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String sentence = scanner.nextLine();
        String target = scanner.nextLine();
        scanner.close();



        comb(word.toCharArray(),0,word.length());


        StringBuilder stringBuilder= new StringBuilder();

//        Queue<Character> queue= new LinkedList<>();
//        for (int i = 0; i <sentence.length() ; i++) {
//            char c =sentence.charAt(i);
//            if ((c>='a'&& c<='z') || (c>='A'&& c<='Z')){
//                queue.add(c);
//            }
//            else{
//                String s = ((LinkedList<Character>) queue).getFirst();
//            }
//        }


        /*
        * 不能把单词中的敏感子单词去掉
        * 使用上面的方式把单词提取出来替换
        *
        * */

        for (String s: allDirtyWords){
//            while (!sentence.equals( sentence.replace(s,target))){
//                sentence= sentence.replace(s,target);
//            }
            sentence = sentence.replaceAll(" "+s,target);
        }





//        sentence  =sentence.replaceAll("#%&",target);

        System.out.println(sentence);


    }



    ArrayList<String> allDirtyWords = new ArrayList<>();

    private void comb(char[] chs, int start,int n){
        if (start==n){
            allDirtyWords.add(String.valueOf(chs));
            return;
        }
        for (int i = start; i <n ; i++) {
            swap(chs,start,i);
            comb(chs,start+1,n);
            swap(chs,start,i);
        }
    }
    private void swap(char[] chs,int i,int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void main(String[] args) {

        new Main1();
    }
}


/*
*
Fuck
Fuck you, ckFuFuckuFc!!!Fuck
F*
*/
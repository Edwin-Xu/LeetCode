package company.huawei;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/14/2020 11:02 PM
 *
 *
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 *
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 *     文件路径为windows格式
 *
 *     如：E:\V1R2\product\fpgadrive.c 1325
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *
 *     结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *
 *     如果超过8条记录，则只输出前8条记录.
 *
 *     如果文件名的长度超过16个字符，则只输出后16个字符
 */
public class ErrorLog {

    class Log implements Comparable{
        String name;//fullname
        int lineNum;
        int errNum;
        Log(String name,int ln){
            this.name = name;
            this.lineNum = ln;
        }
        void errNumPlus(){
            errNum++;
        }
        void print(){
            String n = this.name.length()<=16?this.name: this.name.substring(this.name.length()-16);
            System.out.println(n+" "+lineNum+" "+errNum);
        }

        @Override
        public int compareTo(Object log) {
            return Double.compare(errNum,((Log)log).errNum);
        }
    }

    private Scanner sc;
    private ArrayList<Log> logs ;

    public ErrorLog(){
        sc = new Scanner(System.in);
        logs = new ArrayList<>();

        String inp[];
        String name;
        int ln;
        Log log;
        while (sc.hasNext()){
            String s  = sc.nextLine();
            System.out.println(s);
            if (s.trim().length()==0)break;
            inp = s.split(" ");
            name = inp[0].substring(inp[0].lastIndexOf(92));
            ln = Integer.valueOf(inp[1]);

            int index=-1;
            for (int i=0;i<logs.size();i++){
                log = logs.get(i);
                if (log.name.equals(name) && log.lineNum==ln){
                    index = i;
                    break;
                }
            }

//            if (index>-1){
//                logs.get(index).errNumPlus();
//            }else{
//                logs.add(new Log(name,ln));
//            }


        }


        for (int i=0;i<logs.size();i++){
            if (i==8)break;
            logs.get(i).print();
        }


        sc.close();
    }


    public static void main(String[] args) {
        new ErrorLog();
    }

}

/*
E:\V1R2\product\fpgadrive.c 1325
E:\V1R2\product\fpgadrive.c 1325
E:\V1R2\product\fpgadrive.c 1325


 */
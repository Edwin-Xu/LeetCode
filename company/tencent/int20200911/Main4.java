package company.tencent.int20200911;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/11/2020 10:59 PM
 */
public class Main4 {

    public static void deleteChars(String sourceStr,String delStr){
        Map<Character,Integer> map = new HashMap<>();
        for(int i =  0 ;i <delStr.length();i++){
            map.put(delStr.charAt(i),0);

        }
        StringBuilder sb = new StringBuilder(sourceStr);
        int delCnt = 0;
        for(int i = 0 ; i < sourceStr.length();i++){
            char c = sourceStr.charAt(i);
            if(map.containsKey(c)){
                //删除
                sb.deleteCharAt(i-delCnt);
                delCnt++;
            }

        }
        System.out.println( sb.toString());
    }

    public static void main(String[] args) {
        Main4.deleteChars("sdfsdfsd","s");
    }

}

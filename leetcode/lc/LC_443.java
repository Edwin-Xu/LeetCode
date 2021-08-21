package leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 *
 * @author taoxu.xu
 * @date 8/21/2021 6:08 PM
 */
public class LC_443 {
    public int compress(char[] chars) {
        int res = 0;
        int len = chars.length;
        if (len < 2){
            return len;
        }

        List<Character> list = new ArrayList<>();

        char c = chars[0];
        int index = 0;

        while (index < len){
            int cnt = 0;
            while (index < len && chars[index] == c){
                index++;
                cnt++;
            }

            list.add(c);
            res++;
            final int bitCount = lengthCount(cnt);

            if(cnt > 1){
                res+=bitCount;
                char tmp[]= new char[bitCount];
                for (int i =0;i<bitCount;i++) {
                    tmp[bitCount-1-i] = (char)('0'+cnt%10) ;
                    cnt/=10;
                }
                for(char cc: tmp){
                    list.add(cc);
                }

            }


            if (index == len){
                break;
            }
            c = chars[index];
        }
        for(int i = 0;i<list.size();i++){
            chars[i] = list.get(i);
        }
        return list.size();
    }
    public int lengthCount(int num){
        if (num<0){
            num = -num;
        }
        int res = 0;
        while (num > 0){
            num/=10;
            res++;
        }
        return res;
    }
}

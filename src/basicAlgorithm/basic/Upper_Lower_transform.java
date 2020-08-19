package basicAlgorithm.basic;

/**
 * Created by Edwin Xu on 6/19/2020 1:45
 *
 * 32  = 0b 100000
 *
 *
 * A-Z: 65~90
 * a-z: 97~122
 *
 * 我们知道，在ASCII中：
 * >A-Z对应65-90
 * >a-z对应97-122
 * 大小写转换可以通过+-32进行
 *
 *
 * 有一种更好的方法：基于位运算的转换
 *
 * >统一转成大写：ch & 0b11011111 简写：ch & 0xDF
 * >统一转成小写：ch | 0b00100000 简写：ch | 0x20
 *
 * 分析一下原理：
 * 对于与 0b11011111 转大写
 * >一个字符与上 **0b11011111** 的本质是:
 * >- 如果二进制第6位是1，与完变0，就是原数-32 （0b00100000=32）
 * >- 如果二进制第6位是0，与完不变，就是原数
 * > 由于65-90二进制第6位均为0，故不变。+32，转换为97-122，即大写变小写。
 * > 由于97-122二进制第6位本来就是1，故
 */
public class Upper_Lower_transform {
    public static void main(String[] args) {
        char [] c = {'c','d','e','X'};
        for (char x: Upper_Lower_transform.toUpper(c)){
            System.out.println(x);
        }
    }
    public static char[] toUpper(char [] cs){
//        for (char c:cs){
//            c = (char)(c&0xDF);
//        }
        for (int i = 0; i < cs.length; i++) {
            cs[i] = (char)(cs[i]&0xDF);
        }
        return cs;
    }
}



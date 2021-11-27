package basic_algorithm.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 求一个整数的因数
 * <p>
 * 1.输入一个整数n，求它的所有因子，则从2开始逐个查找。
 * <p>
 * 2.找到一个因子x就将其保存并将n除以x直到新的n'中不包含因子x，然后对n'重复 1 操作。
 * <p>
 * 例：n=2*3*5*7*11*13
 * <p>
 * 每次从n中找最小因子，找到2后，n'=3*5*7*11*13,再找n'中最小因子3，依次类推。
 * <p>
 * 可知最后n'就等于n的最大因子，直接保存。
 *
 *
 * 这样和一直找到 sqrt(n)似乎没区别啊
 * @author taoxu.xu
 * @date 11/27/2021 7:11 PM
 */
public class CalcFactor {
    public static Set<Integer> findFactors(int n){
        Set<Integer> factors = new HashSet<>();
        if (n <= 0) return factors;
        factors.add(1);
        if (n == 1){
            return factors;
        }
        int lastFactor = 2;
        while (n > 1){
            int i = lastFactor;
            for (; i < n; i++) {
                if (n%i == 0)break;
            }
            factors.add(i);
            factors.add(n/i);
            n/=i;
            lastFactor = i;
        }
        return factors;
    }

    public static void main(String[] args) {
        for (Integer factor : findFactors(99)) {
            System.out.println(factor);
        }
    }
}

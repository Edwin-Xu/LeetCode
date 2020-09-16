package math;

/**
 * Created by Edwin Xu on 9/15/2020 11:24 PM
 *
 * 立方根
 * 同样的 牛顿迭代法？？？
 *
 */
public class CubeRoot {
    public static int cubeRoot(int n){
        double res = n/2;
        for (int i = 0; i <50; i++) {
            res = res - (res*res*res-n)/(3*res*res);
        }
        return (int)res;
    }

    public static void main(String[] args) {

        System.out.println(CubeRoot.cubeRoot(501*501*-501));
    }
}

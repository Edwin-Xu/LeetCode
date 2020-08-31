package company.alibaba.other;

/**
 * Created by Edwin Xu on 7/25/2020 12:50 PM
 *
 * 给出数组，找出三个数，使(a+b)^c 最大
 *
 *
 *
 * 暴力解法 O(N3)复杂度
 *
 *
 * 动态规划
 * ？？？？怎么搞
 *
 *
 * a+b 和 c的关系：
 * 相近的话，异或越小
 * 所以说固定a+b之后，选择和a+b差最大的
 *
 * 那a，b选择最大的2个，c选择最小的一个不就行了吗？
 *
 * a+b和c一定要同号:所以说吧正负分开，两次计算，取最大
 * -------------------- 这样算有问题。 比如a+b末尾有0，这时候c取0反而不是最大
 *
 *
 * top2问题：存储max,submax,
 */
public class XOR_Max {
    //暴力
    public static int vaild(int arr[]){
        int max = Integer.MIN_VALUE;
        int x=0,y=0,z=0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j=i+1;j<arr.length-1;j++){
                for (int k = j+1;k<arr.length;k++){
                    int tmp= Math.max((arr[i]+arr[j])^arr[k],Math.max((arr[i]+arr[k])^arr[j],(arr[j]+arr[k])^arr[i]));
                    if(tmp>max){
                        max= tmp;
                        x = i;
                        y=j;
                        z= k;
                    }
                }
            }
        }
        System.out.println("实际： "+arr[x]+" "+arr[y]+" "+arr[z]);
        return max;
    }


    public static int maxXOR(int []arr){
        if (arr.length<=3)return -1;
        int max,sec,min;
        max = Math.max(arr[0],Math.max(arr[1],arr[2]));
        min = Math.min(arr[0],Math.min(arr[1],arr[2]));
        sec= arr[0]+arr[1]+arr[2]-max-min;

        for (int i = 3; i < arr.length; i++) {
            if (arr[i]>=max){
                sec = max;
                max = arr[i];
            }else if (arr[i]>=sec){
                sec = arr[i];
            }else if (arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("我的："+max+" "+sec+" "+min);
        return (max+sec)^min;
    }


    public static void main(String[] args) {
        System.out.println(11^12);
        System.out.println(111^120);
        System.out.println(-1^-120);
        System.out.println(-100^-120);

        System.out.println("---------------");
        int arr[] ={1,4,5,0};
        System.out.println(XOR_Max.maxXOR(arr)+" " +XOR_Max.vaild(arr));

        System.out.println("---------------");
        int arr1[] ={1,4,5,0,100,100000,3};
        System.out.println(XOR_Max.maxXOR(arr1)+" " +XOR_Max.vaild(arr1));
        /*
        * 我的：100000 100 0
实际： 100 100000 3
100100 100103
有问题的
        * */
    }

}

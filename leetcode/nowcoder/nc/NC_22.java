package leetcode.nowcoder.nc;

import leetcode.util.Print;

import javax.print.attribute.standard.PrinterURI;

/**
 * Created by Edwin Xu on 8/26/2020 11:21 PM
 *
 *
 * 把B整合到A中，A中空余的元素正好为B的长度
 */
public class NC_22 {
    public void merge(int A[], int m, int B[], int n) {
        //合并到A. A从后往前(m+n-1处开始)，从m-1,n-1比较元素，往后移动

        int a = m-1;
        int b = n-1;
        int index = m+n-1;


        for(;index>=0;){
            Print.print(a,b,index);

            if(b<0)return;

            if(a<0){
                A[index--] = B[b--];
            }
            else{
                if(A[a]>B[b]){
                    A[index--] = A[a];
                    a--;
                }else{
                    A[index--] = B[b];
                    b--;
                }
            }
        }
    }

    public static void main(String[] args) {
        NC_22 nc_22 = new NC_22();
        int A []= {0};
        int B []={1};
        nc_22.merge(A,0,B,B.length);
        Print.printArr(A);

    }
}

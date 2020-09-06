package company.meituan.exam20200906;

import java.util.*;

/**
 * Created by Edwin Xu on 9/6/2020 11:24 AM
 *
 * 点名，排队
 *
 * 初始时队为空，给出m个id，如果这个id不在队列中，加入队头
 * 如果在队中，移动到队头。
 *
 * 输出点名完毕后的队列
 *
 */
public class Main5 {
    public Main5() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        LinkedList<Integer> queue = new LinkedList<>();

        Map<Integer,Integer> map= new HashMap<>(); //队列中的存在性。不能用来存储下标，因为下标是变化的

        for (int i = 0; i <m ; i++) {
            int a = scanner.nextInt();
            if (map.containsKey(a)){ //map 查询快
                queue.remove(new Integer(a));  //但是这里删除太慢了，基本被这里拖累了
                queue.addFirst(a);
            }else{
                queue.addFirst(a);
                map.put(a,0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a: queue){
            sb.append(a);
            sb.append("\n");
        }
        System.out.println(sb.toString());



        /*
        * ---------------------------------------------------------------------
        * 有另外一种办法：
        * 自己编写Node，形成双链表
        * 使用一个Map记录节点 <id,index>
        * 这样的话：移除很快：根据id查到Node，把Node删除，然后在头部加入。
        * ---------------------------------------------------------------------
        * */


        //换一种方式： LinkedHashMap  不行，插入的时候是网尾部插

//        LinkedHashMap<Integer,Integer> map1 = new LinkedHashMap<>();
//
//        for (int i = 0; i <m ; i++) {
//            int a = scanner.nextInt();
//            if (map1.containsKey(a)){
//                map1.remove(a);
//                map1.put(a,0);
//            }else{
//                map1.put(a,0);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for (Map.Entry<Integer,Integer> entry: map1.entrySet()){
//            sb.append(entry.getKey());
//            sb.append("\n");
//        }
//        sb.deleteCharAt(sb.length()-1);
//        sb.reverse();
//
//        System.out.println(sb.toString());

    }


    public static void main(String[] args) {

        new Main5();
    }
}

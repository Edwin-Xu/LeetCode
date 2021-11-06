package company.qunar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author taoxu.xu
 * @date 10/18/2021 10:26 AM
 */
public class CodeReviewContest {

//    public void method(short cnt){
//        short num =  cnt + 10;
//
//    }

//    public void func(Consumer<String> c){
//        c.accept("");
//    }
//    public void func2(){
//        int a = 0;
//        func(s -> a++);
//    }

    public void f(){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        List<Integer> integers1 = integers.subList(1, 5);
        Iterator<Integer> iterator = integers1.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        integers.forEach(System.out::print);

        integers.stream().max(Comparator.comparingInt(o -> o));
    }

    public static void main(String[] args) {
        new CodeReviewContest().f();
    }
}

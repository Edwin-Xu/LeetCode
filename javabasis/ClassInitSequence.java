package javabasis;

/**
 * Created by Edwin Xu on 4/27/2020 1:48 PM
 */

class A{
    public A(int a){
        System.out.println("A is initializing: "+a);
    }
}

public class ClassInitSequence {

    private A a1 =new A(0);
    {
        System.out.println("code");
    }

    static {
        System.out.println("static code ");
    }
    private static A a2 = new A(1);

    private A a3;

    public ClassInitSequence(){
        System.out.println("ClassInitSequence initialize begin!");
        a3 = new A(2);
        System.out.println("ClassInitSequence initialize end!");
    }




    public static void main(String[] args) {
        ClassInitSequence cis = new ClassInitSequence();

        InitialOrderTest iot =  new InitialOrderTest();
        iot= new InitialOrderTest();//静态变量只会被初始化一次
    }


}

class InitialOrderTest {
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 变量 */
    public String field = "变量";
    /* 静态初始化块 */
    static {
        System.out.println( staticField );
        System.out.println( "静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( field );
        System.out.println( "初始化块" );
    }
    /* 构造器 */
    public InitialOrderTest()
    {
        System.out.println( "构造器" );
    }
}
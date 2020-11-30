package company.huawei.huaweitest;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Election {

    private Scanner sc ;
    private HashMap<String ,Integer> map;

    public Election(){
        map = new HashMap<>();

        sc = new Scanner(System.in);

        String [] arr = sc.nextLine().split(",");
        sc.close();

//        Pattern p = Pattern.compile("\p");

        for (String s: arr){
            char [] c =s.toCharArray();
            if (c.length==0){
                System.out.println("error.0001");
                return;
            }
            if (c[0]>'Z' ||c[0]<'A'){
                System.out.println("error.0001");
                return;
            }
            for (int i=1;i<c.length;i++){
                if (c[i]>'z'||c[i]<'a'){
                    System.out.println("error.0001");
                    return;
                }
            }

            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }

        String top="";
        int max=0;

        for (Map.Entry<String,Integer> en : map.entrySet()){
            if (en.getValue()>max){
                max= en.getValue();
                top = en.getKey();
            }
            else{
                if (en.getValue()==max){
                    if (top.compareTo(en.getKey())==1){
                        max= en.getValue();
                        top = en.getKey();
                    }
                }
            }
        }
        System.out.println(top);

    }



    public static void main(String[] args) {
        String s = "Tom";
        System.out.println(s.compareTo("Lucy"));
        new Election();
    }
}

/*


 */
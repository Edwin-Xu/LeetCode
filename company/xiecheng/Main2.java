package company.xiecheng;

import java.util.*;

public class Main2 {
    String nodeStr[];
    public Main2(){
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        nodeStr= inp.split(" ");

        workStream(0,new StringBuilder());

        Collections.sort(res,Comparator.naturalOrder());

        for (String s:res){
            System.out.println(s);
        }

    }

    ArrayList<String> res = new ArrayList<>();

    private void workStream(int index,StringBuilder sb){
        if (index==nodeStr.length){
            String s = sb.toString();
//            if (s.contains("#")){
//                s = s.replaceAll("#","");
//                s +="--circular dependency";
//            }

            HashSet<Character> set = new HashSet<>(s.length());
            for (char c:s.toCharArray()){
                if (set.contains(c)){
                    res.add(s+"--circular dependency");
                }else{
                    set.add(c);
                }
            }
            if (set.size()==s.length())
                res.add(s);
            return;
        }
        for (char c: nodeStr[index].toCharArray()){
            if (sb.toString().contains(String.valueOf(c))){
//                sb.append('#');
            }
            sb.append(c);
            workStream(index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}

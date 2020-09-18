package company.jd;

import java.util.Scanner;

public class Main2 {
    public Main2() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] map = new char[n][m];
            scanner.nextLine();

            int startI = 0 ,startJ=0;
            for (int k = 0; k < n; k++) {
                char[] line = scanner.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    map[k][j] = line[j];
                    if (map[k][j]=='S'){
                        startI = k;
                        startJ = j;
                    }

                }
            }
            if (dfs(map,startI,startJ)){
                System.out.println("YES\n");
            }else{
                System.out.println("NO\n");
            }
        }

    }

    private boolean dfs(char[][]map,int startI,int stratJ){
        if (startI<0||startI>=map.length || stratJ<0 || stratJ>=map[0].length || map[startI][stratJ]==0 || map[startI][stratJ]=='#')return false;
        if (map[startI][stratJ]=='E')return true;
        map[startI][stratJ] = 0;
        return dfs(map,startI+1,stratJ)
                || dfs(map,startI-1,stratJ)
                || dfs(map,startI,stratJ+1)
                || dfs(map,startI,stratJ-1);
    }

    public static void main(String[] args) {
        new Main2();
    }
}

/*

2
2 2
.E
S.
2 2
#E
S#

* */
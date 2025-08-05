package datasturcture.dfs.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class 연구소 {

    static int[][] arr;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};

    static  int a;

    static  int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        arr=new int[a][b];
        for (int i = 0; i < a ; i++) {
            int[] split = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o->Integer.valueOf(o)).toArray();
            for (int j = 0; j <b; j++) {
                arr[i][j]=split[j];
            }
        }
    }
}

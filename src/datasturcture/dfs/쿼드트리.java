package datasturcture.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 쿼드트리 {

    static  int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();
        arr=new int[a][a];
        for (int i = 0; i < a; i++) {
            int[] split= Arrays.stream(sc.nextLine().split("")).mapToInt(o -> Integer.valueOf(o)).toArray();

            for (int j = 0; j < split.length; j++) {
                arr[i][j]=split[j];
            }
        }
    }
}

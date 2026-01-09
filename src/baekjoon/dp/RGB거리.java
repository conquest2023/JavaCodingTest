package datasturcture.dp;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class RGB거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        int[][] array = new int[a][a];
        int[][] dp=new int[1000][2];
        for (int i = 0; i < a; i++) {
            int[] split = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < a; j++) {
                array[i][j]=split[j];
            }
        }
        for (int i = 0; i < a; i++) {
            int asInt = Arrays.stream(array[i]).min().getAsInt();

        }


    }

}

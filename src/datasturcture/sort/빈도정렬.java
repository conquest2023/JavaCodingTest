package datasturcture.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 빈도정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
        int[][] idx=new int[a][2];
        for (int i = 0; i < array.length; i++) {
            idx[i]= new int[]{i, array[i]};
        }

        Arrays.sort(idx, (x, y) -> Integer.compare(x[1], y[1]));

        for (int i = 0; i < a ; i++) {
            System.out.print(idx[i][0]+" ");
            System.out.print(idx[i][1]+" ");

        }

        for (int i = 0; i < a; i++) {

        }
    }
}

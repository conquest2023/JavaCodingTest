package datasturcture.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}

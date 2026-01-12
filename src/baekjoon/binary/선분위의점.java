package baekjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class 선분위의점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < m; i++) {
            String[] split = sc.nextLine().split(" ");
            int count=0;
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            for (int j = start; j <= end; j++) {
                for (int value : array) {
                    if (value == j) {
                        count += 1;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

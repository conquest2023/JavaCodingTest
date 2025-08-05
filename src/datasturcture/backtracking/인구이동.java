package datasturcture.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class 인구이동 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < a; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();

        }
    }
}

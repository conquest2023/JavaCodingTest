package datasturcture.realization;

import java.util.Scanner;

public class 사과담기게임 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        sc.nextLine();
        for (int i = 0; i < c; i++) {
            int apple = sc.nextInt();
            arr[apple - 1] = 1;
            if (max < apple) {
                max = apple;
            }
        }
    }
}

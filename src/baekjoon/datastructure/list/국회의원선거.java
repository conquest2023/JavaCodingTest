package baekjoon.list;

import java.util.Arrays;
import java.util.Scanner;

public class 국회의원선거 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.valueOf(sc.nextLine());

        int[] arr = new int[num];
        int target = Integer.valueOf(sc.nextLine());

        for (int i = 1; i < num; i++) {
            int j = Integer.valueOf(sc.nextLine());
            arr[i] = j;
        }
        int count = 0;
        if (arr.length == 1) {
            System.out.println(0);
        } else {
            while (true) {
                int max = Arrays.stream(arr).max().getAsInt();
                int idx = 0;
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] == max) {
                        idx = i;
                        break;
                    }
                }

                if (target > max) {
                    System.out.println(count);
                    return;
                } else {
                    arr[idx] -= 1;
                    target += 1;
                    count += 1;
                }
            }
        }
    }
}

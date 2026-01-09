package datasturcture.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();            // 원소 개수
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}

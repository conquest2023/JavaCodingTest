package datasturcture.dp;

import java.awt.*;
import java.util.Scanner;

public class 쉬운계단수 {

        static final int MOD = 1_000_000_000;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            long[][] dp = new long[N + 1][10];

            // 길이가 1일 때 초기화 (1~9)
            for (int i = 1; i <= 9; i++) {
                dp[1][i] = 1;
            }

            // 점화식 적용
            for (int i = 2; i <= N; i++) {
                for (int d = 0; d <= 9; d++) {
                    if (d > 0)
                        dp[i][d] += dp[i - 1][d - 1];
                    if (d < 9)
                        dp[i][d] += dp[i - 1][d + 1];
                    dp[i][d] %= MOD;
                }
            }

            long ans = 0;
            for (int d = 0; d <= 9; d++) {
                ans = (ans + dp[N][d]) % MOD;
            }

            System.out.println(ans);
        }
    }
package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 더하기8 {
    static final int MAX = 100000;
    static final int MOD = 1000000009;
    static long[][] dp = new long[MAX + 1][2]; // [n][0]: 짝수, [n][1]: 홀수

    public static void main(String[] args) throws IOException {
        // 1. DP 테이블 미리 채우기
        precompute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1]).append(" ").append(dp[n][0]).append("\n");
        }
        System.out.print(sb);
    }

    static void precompute() {
        // 초기값 설정
        dp[1][1] = 1; // 1 (홀수 1개)
        dp[1][0] = 0;

        dp[2][1] = 1; // 2 (홀수: 2)
        dp[2][0] = 1; // 1+1 (짝수: 2개)

        dp[3][1] = 2; // 3, 1+1+1 (홀수: 1개, 3개)
        dp[3][0] = 2; // 1+2, 2+1 (짝수: 2개)

        for (int i = 4; i <= MAX; i++) {
            // 홀수 개수 = 이전 단계들의 짝수 개수 합
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % MOD;
            // 짝수 개수 = 이전 단계들의 홀수 개수 합
            dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
        }
    }
}
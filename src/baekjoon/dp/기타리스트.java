package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 기타리스트 {


    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt(); // 곡의 개수
            int s = sc.nextInt(); // 시작 볼륨
            int m = sc.nextInt(); // 최대 볼륨

            int[] volumes = new int[n];
            for (int i = 0; i < n; i++) {
                volumes[i] = sc.nextInt();
            }

            // dp[i][j]: i번째 곡에서 볼륨 j가 가능한지 여부
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][s] = true;

            for (int i = 1; i <= n; i++) {
                int currentDiff = volumes[i - 1];
                boolean possible = false;

                for (int v = 0; v <= m; v++) {
                    if (dp[i - 1][v]) {
                        // 볼륨 키우기
                        if (v + currentDiff <= m) {
                            dp[i][v + currentDiff] = true;
                            possible = true;
                        }
                        // 볼륨 줄이기
                        if (v - currentDiff >= 0) {
                            dp[i][v - currentDiff] = true;
                            possible = true;
                        }
                    }
                }

                // 만약 이번 곡에서 가능한 볼륨이 하나도 없다면 중간에 중단 가능
                if (!possible) {
                    System.out.println(-1);
                    return;
                }
            }

            // 마지막 곡에서 가능한 최대 볼륨 찾기
            int result = -1;
            for (int v = m; v >= 0; v--) {
                if (dp[n][v]) {
                    result = v;
                    break;
                }
            }
            System.out.println(result);
    }
}
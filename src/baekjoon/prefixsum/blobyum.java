package baekjoon.prefixsum;

import java.util.Scanner;

public class blobyum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 전체 개수
        int K = sc.nextInt(); // 연속된 구간 개수

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        // 1. 누적합 배열 크기를 2*N + 1로 잡아서 원형(순환) 대응
        int[] sum = new int[2 * N + 1];
        for (int i = 1; i <= 2 * N; i++) {
            // N 이후부터는 다시 array[0]부터 더함
            sum[i] = sum[i - 1] + array[(i - 1) % N];
        }

        // 2. 모든 구간(K개) 중 최댓값 찾기
        int maxResult = 0;
        for (int i = K; i <= N + K - 1; i++) {
            // i번째까지의 누적합 - (i-K)번째까지의 누적합 = K개의 구간 합
            int currentSum = sum[i] - sum[i - K];
            maxResult = Math.max(maxResult, currentSum);
        }

        System.out.println(maxResult);
    }
}
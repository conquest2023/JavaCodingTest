package baekjoon.math;

import java.util.Scanner;

public class K세준수 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // maxFactor[i]는 숫자 i의 소인수 중 가장 큰 값을 저장함
        int[] maxFactor = new int[n + 1];

        // 에라토스테네스의 체 응용
        for (int i = 2; i <= n; i++) {
            // i가 소수라면 (아직 처리되지 않았다면)
            if (maxFactor[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    maxFactor[j] = i;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (maxFactor[i] <= k) {
                count++;
            }
        }

        System.out.println(count);
    }
}
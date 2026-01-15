package baekjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class 조화평균 {



    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        long[] arr = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        // 1) LCM 구하기
        long L = arr[0];
        for (int i = 1; i < n; i++) {
            L = lcm(L, arr[i]);
        }

        // 2) sum(L / ai)
        long den = 0;
        for (long a : arr) {
            den += L / a;
        }

        // 3) H = L / den, 기약분수
        long num = L;
        long g = gcd(num, den);
        num /= g;
        den /= g;

        System.out.println(num + "/" + den);
    }
}
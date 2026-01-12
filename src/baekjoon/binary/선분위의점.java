package baekjoon.binary;

import java.util.Arrays;
import java.util.Scanner;

public class 선분위의점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] points = new int[n];
        for (int i = 0; i < n; i++) points[i] = sc.nextInt();

        // 이분 탐색을 위해 반드시 정렬!
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // start 이상의 값이 처음 나오는 인덱스
            int leftIdx = getLowerBound(points, start);
            // end 이하의 값이 마지막으로 나오는 인덱스 (혹은 end 초과 값이 처음 나오는 인덱스)
            int rightIdx = getUpperBound(points, end);

            sb.append(rightIdx - leftIdx).append("\n");
        }
        System.out.print(sb);
    }

    // target 이상의 값이 처음 나오는 위치
    private static int getLowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target)
                right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // target 초과 값이 처음 나오는 위치
    private static int getUpperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target)
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
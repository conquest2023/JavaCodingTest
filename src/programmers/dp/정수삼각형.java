package programmers.dp;

import java.util.Arrays;
import java.util.Map;

public class 정수삼각형 {

    static int[][] dp= new int[10][10];
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int result = solution(triangle);
    }

//      System.out.print(triangle[i][j+1]+" ");
//    dp[i][j]=Math.max(dp[i])
    public static int solution(int[][] triangle) {
        // 1. 두 번째 줄(index 1)부터 마지막 줄까지 내려가며 계산
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) {
                    // 맨 왼쪽: 위 줄의 0번째에서만 내려옴
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    // 맨 오른쪽: 위 줄의 마지막에서만 내려옴
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    // 가운데: 위 줄의 j-1과 j 중 큰 값을 선택 (핵심!)
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        // 2. 마지막 줄에서 가장 큰 값을 찾으면 정답
        int answer = 0;
        for (int value : triangle[triangle.length - 1]) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}

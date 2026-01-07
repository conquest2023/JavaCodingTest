package programmers.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {

        int solution = solution(3, new int[]{1,2,3}, new int[]{2});
        System.out.println(solution);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;     // 본인이 입음
                    lost[i] = -1; // 더 이상 처리되지 않게 마킹
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 3. 빌려줄 수 있는 학생 처리 (그리디)
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1)
                continue;

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1)
                    continue;

                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

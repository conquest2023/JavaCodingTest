package baekjoon.math;

import java.util.*;

public class 큰수구성하기 {

    static int maxAnswer = 0; // 최댓값만 저장하면 되므로 리스트가 굳이 필요 없습니다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = sc.nextInt();
        }

        // 정렬은 필수는 아니지만, 탐색 효율을 위해 오름차순 정렬
        Arrays.sort(array);

        combine(array, 0, num);
        System.out.println(maxAnswer);
    }

    private static void combine(int[] arr, int current, int target) {
        // 현재 숫자가 타겟보다 크면 탐색 중단
        if (current > target)
            return;

        // 타겟보다 작거나 같은 경우 중 최댓값 갱신
        maxAnswer = Math.max(maxAnswer, current);

        // 자릿수가 타겟의 자릿수를 넘어가면 중단 (무한 루프 방지)
        if (current >= 100000000)
            return; // 문제 조건에 따라 조절

        for (int i = 0; i < arr.length; i++) {
            // 새로운 숫자를 만드는 로직: (현재 숫자 * 10) + 추가할 숫자
            int next = current * 10 + arr[i];

            // next가 target보다 커지는 게 확실하면 더 깊이 들어가지 않음
            if (next <= target) {
                combine(arr, next, target);
            }
        }
    }
}

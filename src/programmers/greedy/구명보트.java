package programmers.greedy;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        int solution = solution(new int[]{40, 50, 150, 160}, 200);
        System.out.println(solution);
    }


    public  static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0; // 제일 가벼운 사람 index
        int right = people.length - 1; // 제일 무거운 사람 index

        while (left <= right) {
            // 가장 가벼운 놈 + 가장 무거운 놈 합이 limit 이하면 같이 보낸다
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람 태웠으니 다음 가벼운 사람으로
            }
            right--;
            answer++; // 보트 한 대 보냄
        }
        return answer;
    }
}

package programmers.greedy;

import datasturcture.stack.좋은단어;

public class 조이스틱 {

    public static void main(String[] args) {
        int solution = solution("BBAAAAAY");
        System.out.println(solution);
    }

    public static int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1; // 기본 좌우 이동 횟수 (오른쪽으로 쭉)

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 좌우 이동 (A를 만났을 때의 최적 경로 계산)
            int next = i + 1;
            // 연속된 'A'가 어디까지 이어지는지 확인
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // i: 현재까지 온 거리
            // length - next: 뒤에서부터 'A'가 끝나는 지점까지의 거리

            // (i * 2) + (length - next): 앞으로 갔다가 다시 뒤로 가는 경우
            // (length - next) * 2 + i: 뒤로 먼저 갔다가 다시 앞으로 오는 경우
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }

        return answer + move;
    }
}

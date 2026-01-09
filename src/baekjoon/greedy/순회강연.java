package datasturcture.greedy;

import java.util.*;

import java.util.*;

public class 순회강연 {
    static class Lecture {
        int money, day;
        Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            lectures.add(new Lecture(money, day));
            maxDay = Math.max(maxDay, day);
        }

        // 마감일 기준 오름차순 정렬
        lectures.sort((a, b) -> b.day - a.day);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int idx = 0;

        // 마지막 날부터 1일까지 거꾸로 탐색
        for (int day = maxDay; day >= 1; day--) {
            // 현재 날짜에 할 수 있는 강연들 PQ에 넣기
            while (idx < lectures.size() && lectures.get(idx).day >= day) {
                pq.add(lectures.get(idx).money);
                idx++;
            }
            // 가장 돈이 큰 강연 선택
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}

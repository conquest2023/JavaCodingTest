package programmers.greedy;

import javax.swing.*;
import java.util.*;

public class 귤고르기 {

    public static void main(String[] args) {

        int solution = solution(4, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
        System.out.println(solution);
    }



    public static  int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        Arrays.sort(tangerine);
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0)
                break;
        }
        return answer;
    }
}

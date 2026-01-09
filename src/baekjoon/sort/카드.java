package datasturcture.sort;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;

public class 카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> cnt = new HashMap<>(Math.max(16, (int)(n / 0.75f) + 1));

        long answer = 0L;
        int best = 0;
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            int c = cnt.merge(x, 1, Integer::sum); // +=1 하고 새 카운트 반환
            if (c > best || (c == best && x < answer)) { // 동률이면 더 작은 수
                best = c;
                answer = x;
            }
        }
        System.out.println(answer);
    }
}

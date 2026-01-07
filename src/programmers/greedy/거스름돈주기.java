package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class 거스름돈주기 {


    public static void main(String[] args) {
        List<Integer> greedy = greedy(350);
        for (int i = 0; i < greedy.size(); i++) {
            System.out.print(greedy.get(i) +" ");
        }
    }

    public static List<Integer> greedy(int money) {
        List<Integer> list = new ArrayList<>();
        // 1. 동전 단위를 큰 순서대로 배열에 담습니다.
        int[] coins = {100, 50, 10, 1};

        for (int coin : coins) {

            int count = money / coin;

            for (int i = 0; i < count; i++) {
                list.add(coin);
            }

            money %= coin;
        }

        return list;
    }
}

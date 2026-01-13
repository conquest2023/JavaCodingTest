package baekjoon.datastructure.map;

import java.util.*;

public class 배부른마라토너 {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine()) * 2-1;
        while (num != 0) {
            num -= 1;
            String s = sc.nextLine();
            set.add(s);
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                Integer i = map.get(s);
                map.put(s, i + 1);

            }
        }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    System.out.println(entry.getKey());
                }
            }

    }
}

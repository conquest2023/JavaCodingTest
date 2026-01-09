package datasturcture.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 신입사원 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            List<int[]> list =new ArrayList<>();
            int people = sc.nextInt();
            sc.nextLine();
            int result=people;
            for (int j = 0; j < people; j++) {
                int[] score = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                list.add(score);
            }
            list.sort((a, b) -> {
                // 1순위: 0번 인덱스 비교
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            int[] target=list.get(0);
            for (int j = 1; j < list.size() ; j++){
                int[] idx = list.get(j);
                if (target[0] >idx[0] && target[1] > idx[1])
                {
                    result-=1;
                }
            }
            System.out.println(result);
        }
    }
}

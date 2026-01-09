package datasturcture.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 시리얼번호 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        sc.nextLine();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            String s = sc.nextLine();
            list.add(s);
        }

        List<String> collect = list.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        Map<String, Integer> map=new HashMap<>();
        int sequence=0;
        for (String s : collect) {
            int result=0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122))) {
                    result += c -48;
                }
            }
            sequence+=1;
            map.put(s,result + sequence);
        }

        List<Map.Entry<String, Integer>> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : sortedByValue) {
            System.out.println(entry.getKey());
        }
    }
}
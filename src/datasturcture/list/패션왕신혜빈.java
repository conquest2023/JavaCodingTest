package datasturcture.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 패션왕신혜빈 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();
            sc.nextLine();
            Map<String,Integer> map=new HashMap<>();
            int result=1;
            for (int j = 0; j < b; j++) {
                String[] s = sc.nextLine().split(" ");
                if (map.containsKey(s[1])){
                    Integer i1 = map.get(s[1]);
                    map.put(s[1],++i1);
                }else {
                    map.put(s[1], 1);
                }
            }
            for (Integer value : map.values()) {
                result*=(value+1);
            }
            System.out.println(result-1);
        }
    }
}

package baekjoon.list;

import java.util.*;

public class 카드놓기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Integer num = Integer.valueOf(sc.nextLine());

        Integer index = Integer.valueOf(sc.nextLine());
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();

        for (int i = 0; i < num; i++) {
            list.add(Integer.valueOf(sc.nextLine()));
        }
        for (int i = 0; i < list.size(); i++) {
            String  s=String.valueOf(list.get(i));
            int count=0;

            for (int j = 0; j < list.size(); j++) {
                String  b=String.valueOf(list.get(j));
                if(i==j){
                    continue;
                }
                s+=b;
                b+=s;
                count+=1;
                if (index-1==count){
                    set.add(Integer.valueOf(s));
                    set.add(Integer.valueOf(b));

                    count=0;
                    s=String.valueOf(list.get(i));
                    b=String.valueOf(list.get(j));

                }
                }

            }

        for (int i = list.size(); i > 0; i--) {
            String  s=String.valueOf(list.get(i-1));
            int count=0;

            for (int j = list.size(); j>0; j--) {
                String  b=String.valueOf(list.get(j-1));
                if(i==j){
                    continue;
                }
                s+=b;
                b+=s;
                count+=1;
                if (index-1==count){
                    set.add(Integer.valueOf(s));
                    set.add(Integer.valueOf(b));

                    count=0;
                    s=String.valueOf(list.get(i-1));
                    b=String.valueOf(list.get(j-1));
                }
            }

        }
        System.out.println(set.size());
    }
}

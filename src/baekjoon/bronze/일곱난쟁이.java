package datasturcture.bronze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 일곱난쟁이 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int people = sc.nextInt();
            list.add(people);
        }
        list.sort(null);

        int result =0;
        for (Integer i : list) {
            result+=i;
        }

        for (int i = 0; i <list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                 if (result-(list.get(i)+list.get(j))==100){
                     list.remove(i);
                     list.remove(j-1);
                     for (Integer z : list) {
                         System.out.println(z);
                     }
                     return;
                 }
            }
        }
    }
}

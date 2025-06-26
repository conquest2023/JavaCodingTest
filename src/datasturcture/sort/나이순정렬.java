package datasturcture.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 나이순정렬 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num= sc.nextInt();

        String[][] strings=new String[num][2];

        for (int i = 0; i < num; i++) {
            strings[i][0]= sc.next();
            strings[i][1]= sc.next();
        }

        Arrays.sort(strings, Comparator.comparingInt(a -> Integer.valueOf(a[0])));

        for (String[] string : strings) {
            System.out.print(string[0]+" ");
            System.out.print(string[1]);
            System.out.println();
        }
        sc.close();
    }
}

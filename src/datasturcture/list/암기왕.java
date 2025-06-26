package datasturcture.list;

import java.util.Arrays;
import java.util.Scanner;

public class 암기왕 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        int num = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            int num1 = Integer.valueOf(sc.nextLine());
            int[] array = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            Arrays.sort(array);
            int num2 = Integer.valueOf(sc.nextLine());
            int[] target = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            binarySearch(array, target, sb);
            System.out.print(sb);
        }
        sc.close();

    }


    public static void binarySearch(int[] num1, int[] num2, StringBuilder sb) {

        for (int i = 0; i < num2.length; i++) {
            int mid;
            int start = 0;
            int end = num1.length - 1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (num1[mid] == num2[i]) {
                    sb.append('1').append("\n");
                    return;
                }
                if (num1[mid] < num2[i]) {
                    start = mid + 1;
                    continue;
                }
                if (num1[mid] > num2[i]) {
                    end = mid - 1;
                }
            }
            sb.append('0').append("\n");
        }

    }
}

package datasturcture.recursion;

import java.util.Scanner;

public class 문제1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int mod = 1 % n;
            int length = 1;

            while (mod != 0) {
                mod = (mod * 10 + 1) % n;
                length++;
            }

            System.out.println(length);
        }
    }
}
package datasturcture.realization;

import java.util.Scanner;

public class 교수가된현우 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            int n2=0; int n5=0;
            int num = sc.nextInt();
            sc.nextLine();
            for (int j = 2; j <=num; j*=2) {
                n2+=num/j;
            }
            for (int j = 5; j <=num ; j*=5) {
                n5+=num/j;
            }
            System.out.println(n5);
            }
        }
    }

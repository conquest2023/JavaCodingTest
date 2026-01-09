package datasturcture.realization;

import java.util.Scanner;

public class 영화감독숌 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        int a = sc.nextInt();
        sc.nextLine();
        while (true){
            for (int i = 666; i < 1000000004; i++) {
                if(String.valueOf(i).contains("666")){
                    count+=1;
                }
                if (count==a){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}

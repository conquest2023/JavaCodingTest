package datasturcture.realization;

import java.util.Arrays;
import java.util.Scanner;

public class NBA농구 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int team1 = 0;
        int team2 = 0;
        int[][] idx1=new int[1][1];
        int[][] idx2=new int[1][1];
        int end=48;
        for (int i = 0; i < a; i++) {
            int s = sc.nextInt();
            String[] split=sc.nextLine().split("");
            if (s==1){
                team1+=1;
            }else {
                team2+=1;
            }
            if(team1>team2){
                idx1[0][0]=Integer.valueOf(split[0]);
                idx1[0][1]=Integer.valueOf(split[1]);
            }else{

            }
        }
    }
}

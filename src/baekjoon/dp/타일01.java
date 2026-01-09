package datasturcture.dp;

import java.util.Scanner;

public class 타일01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        sc.nextLine();
        int[] dp = new int[1000001];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i = 4; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2]-dp[i-4];
        }
        System.out.println(dp[s]%15746);
    }
}

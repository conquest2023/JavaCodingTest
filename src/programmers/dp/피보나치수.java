package programmers.dp;

public class 피보나치수 {

    static int dp[]=new int[100001];

    public static void main(String[] args) {
        int solution = solution(100000);
        System.out.println(solution);
    }


    public static int solution(int n) {
        dp[0]=0;
        dp[1]=1;
        for (int i = 2 ; i <= n ; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}

package programmers.dp;

public class 타일링 {


    static int[] dp=new int[60000];
    public static void main(String[] args) {

        int solution = solution(4);
        System.out.println(solution);
    }


    public static int solution(int n) {
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=(dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}

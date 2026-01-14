package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수익 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int num = Integer.valueOf(br.readLine());
            int[] dp = new int[num];
            int[] array = new int[num];
            if (num==0){
                break;
            }
            for (int i = 0; i < num ; i++) {
                int p = Integer.valueOf(br.readLine());
                array[i]=p;
            }
            dp[0]=array[0];
            for (int i = 1; i <dp.length ; i++) {
                dp[i]=Math.max(array[i],dp[i-1]+array[i]);
            }
            System.out.println(Arrays.stream(dp).max().getAsInt());
        }
    }
}

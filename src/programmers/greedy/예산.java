package programmers.greedy;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        int solution = solution(new int[]{2,2,3,3}, 10);
        System.out.println(solution);

    }


    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            if (budget - d[i]< 0){
                break;
            }else{
                budget-=d[i];
                answer+=1;
            }
        }
        return answer;
    }
}

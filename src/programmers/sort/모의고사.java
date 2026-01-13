package programmers.sort;

import java.util.*;

public class 모의고사 {



    public static void main(String[] args) {

        int[] solution = solution(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(solution));
    }


    public static int[] solution(int[] answers) {
        int[] people1=  {1,2,3,4,5};
        int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] result=new int[3][2];
        result[0][0]=1;
        result[1][0]=2;
        result[2][0]=3;
        for (int i = 0; i < answers.length; i++) {
            int collect = answers[i];
            if (people1[i%5]==collect){
                result[0][1]+=1;
            }
            if (people2[i%8]==collect){
                result[1][1]+=1;
            }
            if (people3[i%10]==collect){
                result[2][1]+=1;
            }
        }
        int[] array = Arrays.stream(result).mapToInt(o -> Integer.valueOf(o[1])).sorted().toArray();
        int max = Arrays.stream(array).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (result[i][1] == max && result[i][1]!=0) {
                     list.add(result[i][0]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

package programmers.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

    public static void main(String[] args) {

        int[] solution = solution(new int[]{99,94,96}, new int[]{1,1,1});

        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
               int result=100-progresses[i];
               int count=0;
               while(result>0){
                   result-=speeds[i];
                   count+=1;
               }
               elements.add(count);
        }
        int result=1;
        int start= elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if(start<elements.get(i)){
                     list.add(result);
                     start=elements.get(i);
                     result=1;
                 }else{
                     result+=1;
                 }
        }
        list.add(result);
        return list.stream().mapToInt(o->Integer.valueOf(o)).toArray();
    }
}

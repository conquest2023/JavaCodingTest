package programmers.stack;

import java.util.Stack;

public class 올바른괄호 {


    public static void main(String[] args) {

        boolean solution = solution("())");
        System.out.println(String.valueOf(solution));
    }

    static boolean solution(String s) {


        if (s.charAt(0)==')') {
            return false;
        }
        int count=0;
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)==')'){
                 if (count==0){
                     return false;
                 }
                 count-=1;
                 continue;
             }
             count+=1;
        }
        if (count!=0){
            return false;
        }
         return true;
    }

}

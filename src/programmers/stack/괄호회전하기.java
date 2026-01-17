package programmers.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class 괄호회전하기 {


    public static void main(String[] args) {
        int solution = solution("[](){}");
        System.out.println(solution);

    }


    public static int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // 1. 문자열 회전 (substring 활용이 더 간편합니다)
            String rotated = s.substring(i) + s.substring(0, i);

            if (isValid(rotated)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

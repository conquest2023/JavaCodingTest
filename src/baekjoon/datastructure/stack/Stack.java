package baekjoon.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int num=sc.nextInt();

        while (num!=0){
            Deque<String> stack =new ArrayDeque<>();
            String[] s=sc.next().split("");
            for (String string : s) {
                if (string.equals(")")&&!stack.isEmpty()){
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    }
                    continue;
                }
                stack.push(string);
            }
            if (!stack.isEmpty()){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
            num--;
        }

    }
}

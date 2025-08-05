package datasturcture.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class 괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < a; i++) {
            Deque<String> stack = new ArrayDeque<>();
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("("))
                    stack.add(split[j]);
                else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


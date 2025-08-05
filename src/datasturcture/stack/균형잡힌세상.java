package datasturcture.stack;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] s = sc.nextLine().split("");
            boolean result=true;
            Stack<String> stack=new Stack<>();
            if (s[0].equals(".")) {
                return;
            }
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("(") || s[i].equals("[") || s[i].equals(")") || s[i].equals("]")) {
                    if (s[i].equals("(") || s[i].equals("[")) {
                        stack.add(s[i]);
                    } else {
                        if (!stack.isEmpty() && ((stack.peek().equals("(") && s[i].equals(")")) || ((stack.peek().equals("[") && s[i].equals("]"))))) {
                            stack.pop();
                        }else {
                            result = false;
                            break;
                        }
                    }
                }
            }
            if (result && stack.isEmpty()){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}

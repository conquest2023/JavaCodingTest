package datasturcture.stack.answer;

import java.util.Scanner;

public class 좋은단어 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < a ; i++) {
            String[] s=sc.next().split("");
            if (s.length%2==0) {
                String start=s[0];
                for (int j = 1; j < s.length; j++) {
                        if (!start.equals(s[i+1])){
                            start=s[i+1];
                        }else {

                        }
                }
            }
        }
    }
}

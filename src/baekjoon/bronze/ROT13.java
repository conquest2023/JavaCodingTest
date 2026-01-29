package baekjoon.bronze;

import java.util.Scanner;

public class ROT13 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        for (String s : split) {
            if(s.charAt(0)>=65 && s.charAt(0)<97) {
                if ((s.charAt(0) + 13) > 'Z') {
                    System.out.print((char) (s.charAt(0) + 12 - 'Z' + 65));
                    continue;
                } else {
                    System.out.print((char) (s.charAt(0) + 13));
                    continue;
                }
            }
            if(s.charAt(0)>=97){
                if ((s.charAt(0)+13) >'z'){
                    System.out.print((char) (s.charAt(0)+ 12 -'z'+97));
                    continue;
                }else {
                    System.out.print((char) (s.charAt(0) + 13));
                    continue;
                }
            }
            System.out.print(s);
        }
    }
}

package datasturcture.greedy;

import java.util.Scanner;

public class 문자열폭발 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder words = new StringBuilder(sc.nextLine());
        String s = sc.nextLine();
        StringBuilder ret=new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            ret.append(words.charAt(i));
            if (ret.length()>=s.length() &&
                    ret.substring(ret.length()-s.length(),ret.length()).equals(s)){
                ret.delete(ret.length()-s.length(),ret.length());
            }
        }
        System.out.println(ret.length() == 0 ? "FRULA" : ret.toString());
    }
}

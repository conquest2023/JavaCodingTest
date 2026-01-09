package datasturcture.realization;

import java.util.Scanner;

public class 폴리오미노 {

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        s = s.replaceAll("XXXX", "AAAA");
        s = s.replaceAll("XX", "BB");
        System.out.println(s.contains("X") ? -1 : s);
    }
}

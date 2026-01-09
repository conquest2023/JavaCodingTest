package datasturcture.realization;

import java.util.Scanner;

public class 문서검색 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();

        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i <target.length(); i++) {
            sb.append(target.charAt(i));
            if (sb.toString().contains(word)){
                 count+=1;
                 sb=new StringBuilder();
             }
        }
        System.out.println(count);
    }

}

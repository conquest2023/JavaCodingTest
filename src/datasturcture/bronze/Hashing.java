package datasturcture.bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(String.valueOf(ch), ch - 'a' + 1);
        }

        int num=Integer.valueOf(sc.nextLine());
        
        String[] s=sc.next().split("");
        int result=0;
        for (int i = 0; i < num; i++) {
            result+=(int)(map.get(s[i])*Math.pow(31,i))%1234567891;
        }

        System.out.println(result);
    }
}

package string;

import java.util.*;

public class word {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text = sc.next();
        char[] chars=text.toCharArray();
        int[] numbers= new int[26];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=0;
        }
        for (char i : chars)
            if(i>='A'&& i<='Z'){
                numbers[i-'A']+=1;
            }else {
                numbers[i-'a']+=1;
            }

        int max=0;
        char s='?';
        for (int i = 0; i < numbers.length; i++) {
            if(max==numbers[i]){
                s='?';
            }
            if(max<numbers[i]) {
                max = numbers[i];
                s=(char) (i+65);
            }
        }
        System.out.println(s);
        sc.close();
    }

}

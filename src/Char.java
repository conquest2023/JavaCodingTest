import java.util.Scanner;

public class Char {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);


        String s=sc.next();

        int[] num=new int[26];
        for (int i = 0; i < s.length(); i++) {
            if('A'<=s.charAt(i) && s.charAt(i)<='Z'){
                num[s.charAt(i)-'A']++;
            }
            else {
                num[s.charAt(i)-'a']++;
            }
        }
        int max= -1;
        char ch='?';
        for (int i = 0; i < num.length; i++) {
            if(num[i]>max){
                max=num[i];
                ch=(char) (i+65);
            }else if (num[i]==max) {
                ch='?';
            }
        }

        System.out.print(ch);
    }
}

package datasturcture.bronze;

import java.util.Scanner;

public class 농구경기 {


    public static void main(String[] args) {

        int[] arr=new int[26];
        Scanner sc = new Scanner(System.in);

        int s =  Integer.valueOf(sc.nextLine());

        for (int i = 0; i < s; i++) {
            char[] sb = sc.nextLine().toCharArray();
            arr[sb[0]-'a']+=1;
        }
        boolean result=false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=5){
                result=true;
                System.out.print((char) (i+97));
            }
        }

        if (!result){
            System.out.println("PREDAJA");

        }

    }
}

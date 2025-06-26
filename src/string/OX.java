package string;

import java.util.Arrays;
import java.util.Scanner;

public class OX {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num=sc.nextInt();

        while (num!=0){
            int result=0;
            int next=1;
            int[] arr = new int[80];
            String[] s= sc.next().split("");
            for (String string : s) {
                if(string.equals("O")){
                    arr[next]+=next;
                    next++;
                }else {
                    next=1;
                }
            }
            num--;
            for (int i : arr) {
                result+=i;
            }
            System.out.println(result);

        }
    }

}

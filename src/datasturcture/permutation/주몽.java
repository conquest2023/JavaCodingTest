package datasturcture.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(i->Integer.valueOf(i)).sorted().toArray();
        int start=0;
        int end=a-1;
        int count=0;
        while (true){
            if(start>=end){
                break;
            }
            if(s[start]+s[end]<b){
                start++;
                continue;
            }
            if(s[start]+s[end]==b){
                count++;
                end--;
                continue;
            }
            if(s[start]+s[end]>b){
                end--;
            }

        }
        System.out.println(count);
    }
}

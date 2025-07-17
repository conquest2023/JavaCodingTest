package datasturcture.permutation;

import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class 수열 {


//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        sc.nextLine(); //
//
//
//        String[]  s = sc.nextLine().split(" ");
//        int Max=0;
//        for (int i = 0; i < a-b; i++) {
//            int result=0;
//            for (int j = i+1; j < b+i ; j++) {
//                result+= Integer.valueOf(s[i])+Integer.valueOf(s[j]);
//            }
//            if(Max<result){
//                Max=result;
//            }
//        }
//        System.out.println(Max);
//    }


    //    public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int a = Integer.parseInt(line1[0]);
        int b = Integer.parseInt(line1[1]);
        int[] arr = new int[a+1];

        String[] s = br.readLine().split(" ");

        int max = -1000000004;
        arr[0]=Integer.valueOf(s[0]);
        for (int i = 1; i < a; i++) {
            arr[i] = arr[i - 1] + Integer.valueOf(s[i]);
        }
        for (int i=0; i<= a-b ;i++){
            int result= arr[i+b]-arr[i];

            if(max<result){
                max=result;
            }
        }
        System.out.println(max);
    }

}
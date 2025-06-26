package datasturcture.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class 수찾기 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num1=sc.nextInt();
        sc.nextLine();
        int[] target = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(target);
        int num2=sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index=0;
        for (int i = 0; i < arr.length; i++) {
            boolean result=false;
            for (int j = 0; j < target.length; j++) {
                if (index==arr[i]){
                    result=true;
                    break;

                }
                if (target[j]>arr[i]){
                    result=false;
                    break;
                }
                if(target[j]==arr[i]){
                    index=arr[i];
                    result=true;
                    break;
                }
            }
            if (result){
                System.out.println(1);
            }else {
                System.out.println(0);
            }

        }

        sc.close();
    }
}

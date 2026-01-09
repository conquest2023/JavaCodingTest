package datasturcture.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N과M2 {

    static int count;

    static int n;

    static int r;

    static List<Integer> list;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();

        n=array[0];
        r=array[1];
        list=new ArrayList<>();
        combination(0,list);
    }

    static void  combination(int num,List<Integer> integerList){
        if (integerList.size()==r){
            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for (int i = num+1; i < n+1; i++) {
            integerList.add(i);
            combination(i,integerList);
            integerList.remove(integerList.size()-1);
        }

    }
}

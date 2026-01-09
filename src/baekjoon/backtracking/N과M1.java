package datasturcture.backtracking;

import java.util.*;

public class N과M1 {
    static Set<Integer>[] card;
    static boolean[] visit;
    static  int[] arr;
    static int M,k;



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();

        k = Integer.valueOf(sc.next());
        arr=new int[k];
        visit=new boolean[M+1];

//
//        for (int i = 0; i < num1; i++) {
//            arr[i] = i + 1;
//        }

        backTracking(0);
    }
       static void backTracking(int depth){
            if (depth == k) {
                for (int i = 0; i < k; i++) {
                    System.out.print(arr[i]+ " ");
                }
                System.out.println();
                return;
            }
            for (int i = 1; i <=M ; i++) {
                if (!visit[i]) {
                    visit[i]=true;
                    arr[depth]=i;
                    backTracking(depth+1);
                    visit[i]=false;
                }
            }
        }
}

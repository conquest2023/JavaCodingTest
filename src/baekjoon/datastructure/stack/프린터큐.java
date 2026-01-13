package baekjoon.stack;

import java.util.*;

public class 프린터큐 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num= Integer.valueOf(sc.nextLine());
        while (num!=0){
//            String[] s = sc.nextLine().split(" ");
            int N=Integer.valueOf(sc.next());
            int M=Integer.valueOf(sc.next());
            Deque<int[]> queue=new ArrayDeque<>();

            int[]  arr= Arrays.stream(sc.nextLine().split(" ")).mapToInt(o->Integer.valueOf(o)).toArray();
            for (int i = 0; i < N; i++) {
                queue.add(new int[] {i,arr[i]});
            }
            int cnt=0;
            while(true){
                int[] cur= queue.poll();
                boolean chk=true;

                for(int[] arrs:queue){
                    if(arrs[1]>cur[1]){
                        chk=false;
                        break;
                    }

                    if (chk){
                        cnt++;
                        if(cur[0]==M){
                           break;
                        }{
                            queue.addLast(cur);
                        }
                    }
                    System.out.println(cnt);
                }
                num--;

            }
        }


    }
}

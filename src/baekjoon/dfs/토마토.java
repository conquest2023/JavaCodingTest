package datasturcture.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class 토마토 {


    static  int a;

    static  int b;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};

    static int count;
    static int[][] arr;


    static int[][] dist;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        arr=new int[b][a];
        dist=new int[b][a];
        count=0;
        Deque<int[]> queue=new ArrayDeque<>();
        for (int i = 0; i < b; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            for (int j = 0; j < array.length; j++) {
                arr[i][j]=array[j];
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < b; i++) {
            for (int j = 0; j <a ; j++) {
                if (arr[i][j]==1) {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            count+=1;
            int[] poll = queue.pop();
            for (int k = 0; k < 4; k++) {
                int ny = dy[k] + poll[0];
                int nx = dx[k] + poll[1];
                if (nx<0 || ny <0|| ny>=b ||nx >=a)
                    continue;
                if (dist[ny][nx] != -1) continue;
                if (arr[ny][nx]!=-1) {
                    dist[ny][nx]=dist[poll[0]][poll[1]]+ 1;
                    arr[ny][nx]=1;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if (arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                if (dist[i][j] > answer)
                    answer = dist[i][j];
            }
        }
        System.out.println(answer);
    }
}

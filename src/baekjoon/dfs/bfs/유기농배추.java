package datasturcture.dfs.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {


    static  int[][] arr;
    static  int[][] visited;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};

    static  int width;

    static int height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
        width=sc.nextInt();
        height=sc.nextInt();
        int size=sc.nextInt();
        sc.nextLine();
        arr = new int[height][width];
        visited = new int[height][width];
        int count=0;

            for (int j = 0; j < size; j++) {
              int[] s= Arrays.stream(sc.nextLine().split(" ")).mapToInt(o->Integer.valueOf(o)).toArray();
                arr[s[1]][s[0]] = 1;
            }
            for (int s = 0; s <height; s++) {
                for (int k = 0; k < width; k++) {
                    if(arr[s][k]==1 && visited[s][k]==0){
                        bfs(s,k);
                        count+=1;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int s,int k) {
        visited[s][k]=1;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{s,k});
        while(!queue.isEmpty()){
            int[] e = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = e[0] + dy[i];
                int nx = e[1] + dx[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visited[ny][nx] == 0 && arr[ny][nx]==1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = 1;
                }
            }
        }
    }
}

package datasturcture.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class 쉬운최단거리 {

    static  int a;

    static  int b;
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};


    static int[][] visited;

    static  int[][] arr;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         a = sc.nextInt();
         b = sc.nextInt();
        sc.nextLine();
        visited=new int[a][b];
        arr=new int[a][b];
        for (int i = 0; i < a; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            for (int j = 0; j < array.length; j++) {
                arr[i][j]=array[j];
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <b; j++) {
                if (arr[i][j]==2){
                    bfs(i,j);
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <b; j++) {
                if (arr[i][j]==1 && visited[i][j]==0){
                    visited[i][j]=-1;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b ; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }

    static  void bfs(int i,int j){
        Deque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{i,j});
        while (!deque.isEmpty()) {
            int[] poll = deque.pop();
            for (int k = 0; k < 4; k++) {
                int ny = poll[0]+ dy[k];
                int nx= poll[1] +dx[k];
                if (ny<0 || nx<0 || ny>=a|| nx>=b)
                    continue;
                if (visited[ny][nx]!=0) {
                    continue;
                }
                if (arr[ny][nx]==1) {
                    visited[ny][nx]=visited[poll[0]][poll[1]]+1;
                    deque.add(new int[]{ny, nx});
                }
            }
        }
    }
}
